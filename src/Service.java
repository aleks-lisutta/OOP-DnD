import Entity.Player.Player;
import GameControl.Controller;
import GameControl.Menu;

import java.util.Scanner;

public class Service {
    public Menu menu;
    public Controller con;
    public Scanner scan;

    public Service(){
        menu= new Menu();
        scan=new Scanner(System.in);
        choosePlayer();
        startGame();
    }
    public void choosePlayer(){
        System.out.println(menu.options());
        con=new Controller(menu.getPlayer(scan.nextLine()));
    }
    
    public void startGame(){
        String output="";
        while(!con.finish()){
            System.out.println(con.display());
            output=con.action(scan.nextLine());
            con.enemyTurn();
            System.out.println(output);/////////////////////////////////////
        }
    }
}
