import java.lang.Math.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;

public class Material {
    private SimArea sim;
    private String name;
    private Color color;
    private boolean isSolid;
    private int maxLayers; //maxLayers is replacing vHeight. It will only be used for liquids 
    private int curLayer;  //so you don't get huge stacks of water or something. curLayer tracks the layer.
    private long vSpeed; //should be the amount of milliseconds between movements
    private int spikeHeight;
    private int curSpikeHeight;
    private int mass; //controls the fall speed of the material
    private int density; //*will* determine which material goes above another
    private int x; //Both sim area and the material need to keep track of this independently
    private int y; //Otherwise, the bad stuff will happen
    private Material left = null; //These will need to actually have ways to be found later.
    private Material right = null;//It might work just by checking what's in a spot x or y in the next direction,
    private Material below = null;//otherwise, we might be able to just check what an edge touches.
    private boolean moved;

    public Material(SimArea sim, String name, Color color, int maxLayers, long vSpeed, int spikeHeight, int x, int y, boolean isSolid){
        this.sim = sim;
        this.name = name;
        this.color = color;
        this.maxLayers = maxLayers;
        this.vSpeed = vSpeed;
        this.spikeHeight = spikeHeight;
        this.x = x;
        this.y = y;
        this.isSolid = isSolid;
        this.moved = false;
    }
    public void level(){
        
    }
    //TODO: Work on this
    public boolean fall(){
        if (y < sim.getYLen() -1 && (sim.getMaterial(x, y+1) == null || !sim.getMaterial(x, y+1).isSolid())){//second part will need to be refined to be
            setY(y+1);                                 //not solid.
            return true;
            //System.out.println(y);
        }
        else{
            //System.out.println("Layer: " + getcurLayer() + "\nSpike: " + getcurSpikeHeight());
            return false;
        }
    }

    public boolean isSolid(){
        return isSolid;
    }

    public int getmaxLayers(){
        return maxLayers;
    }

    public int getcurLayer(){
        if(getY()==sim.getYLen()-1)
            return 1;
        else{
            return (getBelow().getcurLayer()+1);
        }
    }

    public long getvSpeed(){
        return vSpeed;
    }

    public Material getLeft(){
        return sim.getMaterial(getX()-1, getY());
    }

    public Material getRight(){
        return sim.getMaterial(getX()+1, getY());
    }

    public Material getBelow(){
        return sim.getMaterial(getX(), getY()+1);
    }

    public int getspikeHeight(){
        return spikeHeight;
    }

    public int getcurSpikeHeight(){//TODO make actually find spike height
        // if(getY()==sim.getYLen()-1 && getRight()==null&&getLeft()==null)
        //     return 1;
        // else if(getBelow()!=null && getBelow().getRight()!=null && getBelow().getLeft()!=null && getRight()==null && getLeft()==null)
        //     return 1;
        // else if (getRight()==null||getLeft()==null)
        //     return (getBelow().getcurSpikeHeight()+1);
        // else{
        //     return 0;
        // }
        return curSpikeHeight;
    }

    public int getY(){
        return y;
    }

    public int getX(){
        return x;
    }

    public void setY(int d){
        sim.changeMatPos(this, x, y, x, d);
        y=d;
    }

    public void setX(int d){
        sim.changeMatPos(this, x, y, d, y);
        x=d;
    }

    public void moveRight(){
        setX(x+1);    
    }
    public void moveLeft(){
        setX(x-1);    
    }
    public void moveDown(){
        setX(y+1);    
    }
    public void moveUp(){
        setX(y-1);    
    }

    public Color getColor() {
        return color;
    }

    public boolean moved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }
}