import GameControl.Controller;
import GameControl.Menu;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Service {
    public Menu menu;
    public Controller con;
    public Scanner scan;
    public String path;

    public Service(String path){
        menu= new Menu();
        scan=new Scanner(System.in);
        this.path=path;
    }
    public void Start(){
        choosePlayer();
        startGame();
    }
    public void choosePlayer(){
        boolean chosen=false;
        while(!chosen) {
            System.out.println(menu.options());
            try {
                con = new Controller(menu.getPlayer(scan.nextLine()),path);
                chosen=true;
            }
            catch(Exception e){
                e.printStackTrace();
                System.out.println("invalid player name, please try again.\n");
            }
        }
    }
    
    public void startGame(){
        String output="";
        while(!con.finish()){
            System.out.println(con.display());
            try {
                output=con.action(scan.nextLine());
            } catch (Exception e) {
                System.out.print("invalid move entered, please try again.\n");
            }
            output+="\n";
            output+=con.enemyTurn();
            output+=con.stats();
            output+=con.endLevel();

            System.out.println(output);
            output="";
        }
        System.out.println();

    }
}
