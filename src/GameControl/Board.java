package GameControl;
import Entity.Player.Player;
import Entity.Tile.Tile;

import java.util.LinkedList;
import java.util.List;

public class Board {
    private Tile[][] boardArray;
    private int sizeX;
    private int sizeY;

    public Board(){
    }
    public String display(){
        StringBuilder output=new StringBuilder();
        for (int i=0; i<sizeX;i++){
            for (int j=0; j<sizeY; j++){
                output.append(boardArray[i][j].toString());}
            output.append("\n");
        }
        return output.toString();
    }
    public void setPos(LinkedList<Tile> tiles) {
        for (Tile tile : tiles) {
            boardArray[tile.getPosX()][tile.getPosY()] = tile;
        }
    }
    public Tile moveTo(Tile tile,char c){
        if (c=='a' && tile.getPosY()>0)
            return boardArray[tile.getPosX()][tile.getPosY()-1];
        if (c=='d' && tile.getPosY()<sizeY-1)
            return boardArray[tile.getPosX()][tile.getPosY()+1];
        if (c=='w' && tile.getPosX()>0)
            return boardArray[tile.getPosX()-1][tile.getPosY()];
        if (c=='s' && tile.getPosX()<sizeX-1)
            return boardArray[tile.getPosX()+1][tile.getPosY()];
        return null;
    }
    public void Load(List<String> lines, Player player){
        boardArray=new Tile[lines.size()][lines.get(0).length()];
        for (int i=0; i<lines.size();i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {
                boardArray[i][j] = Utils.getTile(lines.get(i).charAt(j), i, j);
                if (boardArray[i][j]==null) {boardArray[i][j]=player;
                player.setPos(i,j);}
            }
        }
        sizeX=lines.size();
        sizeY=lines.get(0).length();
    }
}
