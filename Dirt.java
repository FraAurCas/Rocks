import java.sql.Time;
import java.util.concurrent.TimeUnit;
import javafx.scene.paint.Color;

public class Dirt extends Material implements LooseSolid{
    public Dirt(SimArea sim, int x, int y) {
        super(sim, "Dirt", Color.BROWN, 3, 30, 3, x, y, true);

    }

    public void levelV(){
        Material thisPixel = this;
        levelV(thisPixel, super.getmaxLayers(), super.getcurLayer(), this, super.getspikeHeight(), 0);
    }

    public void levelV(Material movingPixel, int getmaxLayers, int getcurLayers, Material currentPixel, int spikeHeight, int curSpikeHeight){
        if(currentPixel.getcurLayer() == 1)
            {}
        else if(currentPixel.getLeft() == null && currentPixel.getRight() == null){
            if(curSpikeHeight >=spikeHeight){
                try{
                    Thread.sleep(getvSpeed());
                }
                catch(InterruptedException ex){
                    //why does it make me do this, we don't need it >:((((
                }
                if(Math.random()>0.5){
                    setX(getX()-1);
                    super.fall();
                    levelV(movingPixel, super.getmaxLayers(), currentPixel.getcurLayer(), currentPixel.getBelow(), spikeHeight, 0);
                }
                else{
                    setX(getX()+1);
                    super.fall();
                    levelV(movingPixel, super.getmaxLayers(), currentPixel.getcurLayer(), currentPixel.getBelow(), spikeHeight, 0);
               }
            }
            else{
                levelV(movingPixel, super.getmaxLayers(), currentPixel.getcurLayer(), currentPixel.getBelow(), spikeHeight, ++curSpikeHeight);
            }
        }
        else if(currentPixel.getLeft()== null){
            setX(getX()-1);
            super.fall();
            levelV(movingPixel, super.getmaxLayers(), currentPixel.getcurLayer(), currentPixel.getBelow(), spikeHeight, 0);
        }
        else{
            setX(getX()+1);
            super.fall();
            levelV(movingPixel, super.getmaxLayers(), currentPixel.getcurLayer(), currentPixel.getBelow(), spikeHeight, 0);
        }
    }
    
}