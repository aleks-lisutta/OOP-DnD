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
        con=new Controller();
        con.loadBoards();
        scan=new Scanner(System.in);
        choosePlayer();

    }
    public void choosePlayer(){
        System.out.println(menu.options());
        con.setPlayer(menu.getPlayer(scan.nextLine()));
    }
    
    public void startGame(){
        while(!con.player.isDead() & !con.finish()){
            System.out.println(con.display());
            con.action(scan.nextLine());
            con.enemyTurn();
        }
    }
}
