package GameControl;
import Entity.Player.Player;
import Entity.Player.TestPlayer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {

    public LinkedList<Player> playerList;

    public Menu(){
        playerList=new LinkedList<Player>();
        playerList.add(new TestPlayer(0,0));
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
