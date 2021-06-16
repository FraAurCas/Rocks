import javafx.scene.paint.Color;
public class FirmSolid extends Material{

  public FirmSolid(SimArea sim, String name, Color color, int maxLayers, long vSpeed, int spikeHeight, int x, int y, int density){
    super(sim, name, color, maxLayers, vSpeed, spikeHeight, x, y, density);
  }
  @Override
  public boolean fall(){
    System.out.println('2');
    if(((getLeft()!=null)&&(getLeft().getName().equals(getName()))&&(getLeft().getcurLayer(getName()) != -1)) || ((getRight()!=null)&&(getRight().getName().equals(getName()))&&(getRight().getcurLayer(getName()) != -1)) || ((getAbove()!=null)&&(getAbove().getName().equals(getName()))&&(getAbove().getcurLayer(getName()) != -1)) || ((getBelow()!=null)&&(getBelow().getName().equals(getName()))&&(getBelow().getcurLayer(getName()) != -1))){
        return true;
      }
      else if (getY() < sim.getYLen() -1 && (getBelow() == null)){//second part will need to be refined to be
          moveDown();                                 //not solid.
          return true;
          //System.out.println(y);
      }
      else if(getY() < sim.getYLen()-1 && getBelow().getDensity()<getDensity()){
          sim.swap(this, getBelow());
          return true;
      }
      else{
          //System.out.println("Layer: " + getcurLayer() + "\nSpike: " + getcurSpikeHeight());
          return false;
      }
  }
  public void levelV(){
    System.out.println('1');
      levelV(this, super.getmaxLayers(), super.getcurLayer(getName()), this, super.getspikeHeight(), 1);
  }

  public void levelV(Material movingPixel, int getmaxLayers, int getcurLayers, Material currentPixel, int spikeHeight, int curSpikeHeight){
    System.out.println('3');
      if(currentPixel.getcurLayer(currentPixel.getName()) == 1)
          {}
            //if touching any of the same material and on the ground somehow


              if(currentPixel.getBelow() != null){
                  levelV(movingPixel, super.getmaxLayers(), currentPixel.getcurLayer(getName()), currentPixel.getBelow(), spikeHeight, curSpikeHeight+1);
              }


      else{
          if(currentPixel.getBelow() != null){
          levelV(movingPixel, super.getmaxLayers(), currentPixel.getcurLayer(getName()), currentPixel.getBelow(), spikeHeight, curSpikeHeight+1);
          }
      }
  }
}
