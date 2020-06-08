import java.lang.Math.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.*;

public class Material {
    private SimArea sim;
    private String name;
    private String color;
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

    public Material(SimArea sim, String name, String color, int maxLayers, long vSpeed, int spikeHeight, int x, int y, boolean isSolid){
        this.sim = sim;
        this.name = name;
        this.color = color;
        this.maxLayers = maxLayers;
        this.vSpeed = vSpeed;
        this.spikeHeight = spikeHeight;
        this.x = x;
        this.y = y;
        this.isSolid = isSolid;
    }

    //TODO: Work on this
    public void fall(){
        while(getY()<720 && sim.getMaterial(x, y+1) == null && !sim.getMaterial(x, y+1).isSolid()){//second part will need to be refined to be
            setY(y+1);                                        //not solid.
        }
    }

    public boolean isSolid(){
        return isSolid;
    }

    public int getmaxLayers(){
        return maxLayers;
    }

    public int getcurLayer(){
        if(getY()==720)
            return 1;
        else{
            return sim.getMaterial(x, y+1).getcurLayer()+1;
        }
    }

    public long getvSpeed(){
        return vSpeed;
    }

    public Material getLeft(){
        return left;
    }

    public Material getRight(){
        return right;
    }

    public Material getBelow(){
        return below;
    }

    public int getspikeHeight(){
        return spikeHeight;
    }

    public int getcurSpikeHeight(){
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
}