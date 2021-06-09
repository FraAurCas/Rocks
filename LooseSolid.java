import javafx.scene.paint.Color;
public class LooseSolid extends Material{
    public LooseSolid(SimArea sim, String name, Color color, int maxLayers, long vSpeed, int spikeHeight, int x, int y, int density){
      super(sim, name, color, maxLayers, vSpeed, spikeHeight, x, y, density);
    }

    public void levelV(){
        levelV(this, super.getmaxLayers(), super.getcurLayer(getName()), this, super.getspikeHeight(), 1);
    }

    public void attemtMoveLeftRight(Material currentPixel, int curSpikeHeight, int spikeHeight) {
        if (currentPixel.getLeft() == null && currentPixel.getRight() == null) {
            if(Math.random() > 0.5) {
                moveLeft();
            } else {
                moveRight();
            }
        }
        else if (currentPixel.getLeft()== null) {
            moveLeft();
        }
        else if (currentPixel.getRight() == null) {
            moveRight();
        }
    }

    public void levelV(Material movingPixel, int getmaxLayers, int getcurLayers, Material currentPixel, int spikeHeight, int curSpikeHeight){

        if(currentPixel.getcurLayer(currentPixel.getName()) == 1)
            {}
        else if(currentPixel.getLeft() == null || currentPixel.getRight() == null){
            //System.out.println("\n\ncurspikeheight: "+ curSpikeHeight+"\nspikeHeight: "+spikeHeight+"\ncurpixellayer: "+currentPixel.getcurLayer());
            if(curSpikeHeight >= spikeHeight) {
                attemtMoveLeftRight(currentPixel, curSpikeHeight, spikeHeight);
            }

            else if(currentPixel.getBelow() != null){
                levelV(movingPixel, super.getmaxLayers(), currentPixel.getcurLayer(getName()), currentPixel.getBelow(), spikeHeight, curSpikeHeight+1); //Call levelV on the pixel below
            }
        }

        else if(currentPixel.getLeft().getDensity()<getDensity() || currentPixel.getRight().getDensity()<getDensity())  {
            //System.out.println("\n\ncurspikeheight: "+ curSpikeHeight+"\nspikeHeight: "+spikeHeight+"\ncurpixellayer: "+currentPixel.getcurLayer());
            if(curSpikeHeight >= spikeHeight){

                if(currentPixel.getLeft().getDensity()<getDensity() && currentPixel.getRight().getDensity()<getDensity()){
                    if(Math.random()>0.5){
                       moveLeft();

                    }
                   else{
                        moveRight();
                   }
                }
                else{
                    if(currentPixel.getLeft().getDensity()<getDensity()){
                        moveLeft();
                    }
                    else if (currentPixel.getRight().getDensity()<getDensity()){
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
