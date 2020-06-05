package GameControl;
import Entity.Player.Player;
import Entity.Tile.Pos;
import Entity.Tile.Tile;
import Entity.Tile.TileFrame;

import java.util.LinkedList;
import java.util.List;

public class Board {
    private TileFrame[][] boardArray;
    private int sizeX;
    private int sizeY;
    private TileFrame playerFrame;

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
//    public void setPos(List<Tile> tiles) {
//        for (Tile tile : tiles) {
//            boardArray[tile.getPosX()][tile.getPosY()] = tile;
//        }
//    }
    public List<TileFrame> action(Tile tile,char c){
        List<TileFrame> out=new LinkedList<>();
        if (c=='a' && tile.getPosY()>0)
            out.add(boardArray[tile.getPosX()][tile.getPosY()-1]);
        if (c=='d' && tile.getPosY()<sizeY-1)
            out.add( boardArray[tile.getPosX()][tile.getPosY()+1]);
        if (c=='w' && tile.getPosX()>0)
            out.add( boardArray[tile.getPosX()-1][tile.getPosY()]);
        if (c=='s' && tile.getPosX()<sizeX-1)
            out.add( boardArray[tile.getPosX()+1][tile.getPosY()]);
        return out;
    }
    public void Load(List<String> lines, Player player){
        boardArray=new TileFrame[lines.size()][lines.get(0).length()];
        for (int i=0; i<lines.size();i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {
                boardArray[i][j] = new TileFrame(Utils.getTile(lines.get(i).charAt(j), i, j),new Pos(i,j));
                if (boardArray[i][j].tile==null)
                {
                    boardArray[i][j].tile=player;
                    playerFrame=boardArray[i][j];
                }
            }
        }
        sizeX=lines.size();
        sizeY=lines.get(0).length();
    }
    public TileFrame getPlayerFrame(){
        return playerFrame;
    }

    public void setPlayerFrame(TileFrame playerFrame) {
        this.playerFrame = playerFrame;
    }
}
