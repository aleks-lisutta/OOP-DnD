package GameControl;

import Entity.Player.Player;
import Entity.Tile.Empty;
import Entity.Tile.Tile;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller {
    public Player player;
    public Board curBoard;
    public List<Board> levels;

    public Controller(Player p){
        levels=new LinkedList<>();
        player=p;
        loadBoards();
        curBoard=levels.get(0);
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
            b.Load(LoadBoard(s),player);
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
        if (player.isDead)
            return true;
        return false;
    }

    public String display() {
        return curBoard.display();
    }

    public String action(String actionChar){
        if (actionChar.length()>1){
            try {
                throw new Exception("the action is illegal.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Tile move=curBoard.moveTo(player,actionChar.charAt(0));
        StringBuilder chenge=new StringBuilder();
        LinkedList<Tile> newPos=new LinkedList<>();
        chenge.append(player.move(move));
        //////////////////////////////chenge.append(enemyTurn();
        newPos.add(player);
        newPos.add(move);

       ////// newpos.add(EnemyMove)
        curBoard.setPos(newPos);
        //curBoard.setPos(DeathLoop());
        //deadEnemy
        return chenge.toString();
    }
    public List<Tile> DeathLoop(){
        ///////////////////////////////////////////////////////////////////
        return null;
    }

    public String enemyTurn() {
        return "";
    }
}
