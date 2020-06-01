public class Dirt extends Material implements LooseSolid{
    public Dirt() {
        super("Dirt", "Brown", 3, 30, 3);

    }

    public void levelV(){
        levelV(super.getmaxLayers(), super.getcurLayer(), this, super.getspikeHeight(), 0);
    }

    public void levelV(int getmaxLayers, int getcurLayers, Material currentPixel, int spikeHeight, int curSpikeHeight){
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
                levelV(super.getmaxLayers(), super.getcurLayer(), currentPixel.getBelow(), spikeHeight, ++curSpikeHeight);
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