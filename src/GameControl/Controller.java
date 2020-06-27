package GameControl;

import Entity.Enemy.Enemy;
import Entity.Player.Player;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller {
    public static final char LEFT='a';
    public static final char RIGHT='d';
    public static final char UP='w';
    public static final char DOWN='s';
    public static final char WAIT='q';
    public static final char ABILITY='e';

    public Player player;
    public int curBoard;
    public List<Board> levels;
    public List<List<Enemy>> enemyList;

    public Controller(Player p,String path){
        levels=new LinkedList<>();
        player=p;
        enemyList=new LinkedList<>();
        loadBoards(path);
        curBoard=0;
        player.setFrame(levels.get(curBoard).getPlayerFrame());
    }

    public void loadBoards(String path) {
        List<String> result=new LinkedList<>();
        try (Stream<Path> walk = Files.walk(Paths.get(path))) {
            result = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : result) {
            Board b=new Board();
            enemyList.add(b.Load(LoadBoard(s),player));
            levels.add(b);
        }
    }

    public List<String> LoadBoard(String path){
        List<String> output=new LinkedList<>();
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
               String data = myReader.nextLine();
               output.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return output;
    }

    public String stats(){
        return player.stats();
    }

    public void setPlayer(Player player) {
        this.player=player;
    }

    public boolean finish(){
        if (player.isDead() || enemyList.size()<=curBoard )
            return true;
        return false;
    }

    public String endLevel(){
        if (player.isDead())
            return "\n-------------------------------- Game Over --------------------------------\n";
        if (enemyList.get(curBoard).size()==0){
            curBoard++;
            if (!finish()) {
                levels.get(curBoard).setPlayerFrame(player);
                player.setFrame(levels.get(curBoard).getPlayerFrame());
                return "you finished level:"+curBoard+"\n";
            }
            return "\n--------------------------------\nCongratulations, you won the game!\n--------------------------------\n";
        }
        return "";
    }

    public String display() {
        if(!finish()) {
            return levels.get(curBoard).display();
        }
        return "";
    }

    public String action(String actionChar){
        if (actionChar==null|| actionChar.length()!=1){
            throw new IllegalArgumentException("the action is illegal.");
        }
        StringBuilder log=new StringBuilder();
        log.append(player.action(actionChar.charAt(0),enemyList.get(curBoard)));
        return log.toString();
    }

    public String enemyTurn() {
        String out="";
        for(int i=0; i<enemyList.get(curBoard).size();i++){
            Enemy temp=enemyList.get(curBoard).get(i);
            if(!temp.isDead()) {
                out+=temp.Turn(player);
            }
            else {enemyList.get(curBoard).remove(temp);}
        }
        return out;
    }
}
