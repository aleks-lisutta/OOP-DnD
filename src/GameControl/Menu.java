package GameControl;
import Entity.Player.Player;

import java.util.LinkedList;

public class Menu {

    public LinkedList<String> playerList;

    public Menu(){
        playerList=new LinkedList<String>();
        playerList.add("Jon Snow");
        playerList.add("The Hound");
        playerList.add("Melisandre");
        playerList.add("Thoros of Myr");
        playerList.add("Arya Stark");
        playerList.add("Bronn");
        playerList.add("Ygritte");

    }
    public String options() {
        StringBuilder output=new StringBuilder();
        for(String p: playerList){
            output.append(p).append("\n");
        }
        output.append("choose your player (enter name):");
        return output.toString();
    }

    public Player getPlayer(String nextLine) {
        int a=playerList.indexOf(nextLine);
        if(a==-1) throw new IllegalArgumentException(nextLine+" is name does not exist in the System.");
        Player output = Utils.getPlayer(a);
        return output;
    }
}
