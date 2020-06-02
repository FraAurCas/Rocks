public class Dirt extends Material implements LooseSolid{
    public Dirt(int x, int y) {
        super("Dirt", "Brown", 3, 30, 3, x, y);

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
                if(Math.random()>0.5){
                    //move left
                }
                else{
                //move right
               }
            }
            else{
                levelV(movingPixel, super.getmaxLayers(), super.getcurLayer(), currentPixel.getBelow(), spikeHeight, ++curSpikeHeight);
            }
        }
        else if(currentPixel.getLeft()== null){
            //move left
        }
        else{
            //move right
        }
    }
    
}