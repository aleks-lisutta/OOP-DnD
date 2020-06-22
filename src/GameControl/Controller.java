package GameControl;

import Entity.Enemy.Enemy;
import Entity.Player.Player;
import Entity.Tile.Empty;
import Entity.Tile.Tile;
import Entity.Tile.TileFrame;
import GameControl.Utils;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Dictionary;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller {
    public Player player;
    public int curBoard;
    public List<Board> levels;
    public List<List<Enemy>> enemyList;

    public Controller(Player p){
        levels=new LinkedList<>();
        player=p;
        enemyList=new LinkedList<>();
        loadBoards();
        curBoard=0;
        player.setFrame(levels.get(0).getPlayerFrame());
    }

    public void loadBoards() {

        String cwd = System.getProperty("user.dir");
        List<String> result=new LinkedList<>();
        cwd=cwd+"\\levels";
        try (Stream<Path> walk = Files.walk(Paths.get(cwd))) {
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

    public void setPlayer(Player player) {
        this.player=player;
    }

    public boolean finish(){
        if (player.isDead || enemyList.size()<curBoard )
            return true;
        return false;
    }

    public String endLevel(){
        if (enemyList.get(curBoard).size()==0){
            curBoard++;
            if (!finish()) {
                levels.get(curBoard).setPlayerFrame(player);
            }
            return "you finished level:"+curBoard;
        }
        return "";
    }

    public String display() {
        return levels.get(curBoard).display();
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
