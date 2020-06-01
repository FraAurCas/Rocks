import java.lang.Math.*;
public class Material {
    private String name;
    private String color;
    private int maxLayers; //maxLayers is replacing vHeight. It will only be used for liquids 
    private int curLayer;  //so you don't get huge stacks of water or something. curLayer tracks the layer.
    private int vSpeed; //should be the amount of frames between movements
    private int spikeHeight;
    private int curSpikeHeight;
    private Material left = null;
    private Material right = null;
    private Material below = null;

    public Material(String name, String color, int maxLayers, int vSpeed, int spikeHeight){
        this.name = name;
        this.color = color;
        this.maxLayers = maxLayers;
        this.vSpeed = vSpeed;
        this.spikeHeight = spikeHeight;
    }

    public int getmaxLayers(){
        return maxLayers;
    }

    public int getcurLayer(){
        return curLayer;
    }

    public double getvSpeed(){
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
}