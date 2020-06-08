package GameControl;
import Entity.Enemy.Enemy;
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
    public List<TileFrame> action(TileFrame frame,char c){
        List<TileFrame> out=new LinkedList<>();
        if (c=='a' && frame.gety()>0)
            out.add(boardArray[frame.getx()][frame.gety()-1]);
        if (c=='d' && frame.gety()<sizeY-1)
            out.add( boardArray[frame.getx()][frame.gety()+1]);
        if (c=='w' && frame.getx()>0)
            out.add( boardArray[frame.getx()-1][frame.gety()]);
        if (c=='s' && frame.getx()<sizeX-1)
            out.add( boardArray[frame.getx()+1][frame.gety()]);
        return out;
    }
    public List<Enemy> Load(List<String> lines, Player player){
        boardArray=new TileFrame[lines.size()][lines.get(0).length()];
        List<Enemy> out=new LinkedList<>();

        for (int i=0; i<lines.size();i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {
                Tuple tup=Utils.getTile(lines.get(i).charAt(j));
                Enemy e=tup.enemy;
                if(e!=null) {
                    out.add(e);
                    boardArray[i][j] = new TileFrame(e,new Pos(i,j),this);
                    e.setFrame(boardArray[i][j]);
                }
                else {
                    Tile t = tup.tile;
                    boardArray[i][j] = new TileFrame(t, new Pos(i, j), this);
                    if (t != null) t.setFrame(boardArray[i][j]);
                    else {
                        boardArray[i][j].tile = player;
                        playerFrame = boardArray[i][j];
                        player.setFrame(playerFrame);
                    }
                }
            }
        }
        sizeX=lines.size();
        sizeY=lines.get(0).length();
        return out;
    }
    public TileFrame getPlayerFrame(){
        return playerFrame;
    }

    public void setPlayerFrame(Player p) {
        playerFrame.tile = p;
    }
}
