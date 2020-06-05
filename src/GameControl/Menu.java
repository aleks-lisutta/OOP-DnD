package GameControl;
import Entity.Player.Hunter.Ygritte;
import Entity.Player.Mages.Melisandre;
import Entity.Player.Mages.ThorosOfMyr;
import Entity.Player.Player;
import Entity.Player.Rogues.AryaStark;
import Entity.Player.Rogues.Bronn;
import Entity.Player.Warrior.JonSnow;
import Entity.Player.Warrior.TheHound;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Menu {

    public LinkedList<Player> playerList;

    public Menu(){
        playerList=new LinkedList<Player>();
        playerList.add(new JonSnow());
        playerList.add(new TheHound());
        playerList.add(new Melisandre());
        playerList.add(new ThorosOfMyr());
        playerList.add(new AryaStark());
        playerList.add(new Bronn());
        playerList.add(new Ygritte());
    }
    public String options() {
        StringBuilder output=new StringBuilder();
        for(Player p: playerList){
            output.append(p.name).append("\n");
        }
        output.append("choose your player(enter name):");
        return output.toString();
    }

    public Player getPlayer(String nextLine) {
        List<Player> output = playerList.stream().filter(x-> x.name.equals(nextLine)).collect(Collectors.toList());
        if (output.size()==0)
            throw new IllegalArgumentException(nextLine+" is name does not exist in the System.");
        else if(output.size()>1)
            throw new IllegalArgumentException("the system found 2 or more Players with the name "+nextLine);
        return output.get(0);
    }
}
