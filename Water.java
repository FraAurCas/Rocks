import javafx.scene.paint.Color;

public class Water extends Material implements Liquid{
    public Water(SimArea sim, int x, int y){
        super(sim, "Water", Color.SKYBLUE, 3, 0, 0, x, y, false, 3);
    }
    @Override
    public void level(){
        if(fall())
            ;
        else
            levelV();
    }
    public void levelV(){
        levelV(this, super.getmaxLayers(), super.getcurLayer(getName()), this, super.getspikeHeight(), 1);
    }

    public void levelV(Material movingPixel, int getmaxLayers, int getcurLayers, Material currentPixel, int spikeHeight, int curSpikeHeight){
        
        if(currentPixel.getcurLayer(getName()) == 1)
            {}
        else if(currentPixel.getLeft() == null || currentPixel.getRight() == null){
            //System.out.println("\n\ncurspikeheight: "+ curSpikeHeight+"\nspikeHeight: "+spikeHeight+"\ncurpixellayer: "+currentPixel.getcurLayer());
            if(getcurLayer(getName()) >= getmaxLayers){
                // try{
                //     Thread.sleep(getvSpeed());
                // }
                // catch(InterruptedException ex){
                //     //why does it make me do this, we don't need it >:((((
                // }
                if(currentPixel.getLeft() == null && currentPixel.getRight() == null){
                    if(Math.random()>0.5){
                       moveLeft();
                    
                    }
                   else{
                       moveRight();
                   }
                }
                else{
                    if(currentPixel.getLeft()== null){
                        moveLeft();
                    }
                    else if (currentPixel.getRight()== null){
                        moveRight();
                    }
                }
            }
            else{
                if(currentPixel.getBelow() != null){
                    levelV(movingPixel, super.getmaxLayers(), currentPixel.getcurLayer(getName()), currentPixel.getBelow(), spikeHeight, curSpikeHeight+1);
                }
            }
        }
        else{
            if(currentPixel.getBelow() != null){
            levelV(movingPixel, super.getmaxLayers(), currentPixel.getcurLayer(getName()), currentPixel.getBelow(), spikeHeight, curSpikeHeight+1);
            }
        }
    }
}