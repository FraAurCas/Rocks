import javafx.scene.paint.Color;
public class FirmSolid extends Material{

  public FirmSolid(SimArea sim, String name, Color color, int maxLayers, long vSpeed, int spikeHeight, int x, int y, int density){
    super(sim, name, color, maxLayers, vSpeed, spikeHeight, x, y, density);
  }
  @Override
  public boolean fall(){
    if(((getLeft()!=null)&&(getLeft().getName().equals(getName()))&&(getLeft().getcurLayer(getName()) > 0)) || ((getRight()!=null)&&(getRight().getName().equals(getName()))&&(getRight().getcurLayer(getName()) > 0)) || ((getAbove()!=null)&&(getAbove().getName().equals(getName()))&&(getAbove().getcurLayer(getName()) >0)) || ((getBelow()!=null)&&(getBelow().getName().equals(getName()))&&(getBelow().getcurLayer(getName()) > 0))){
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

      levelV(this, super.getmaxLayers(), super.getcurLayer(getName()), this, super.getspikeHeight(), 1);
  }

  public void levelV(Material movingPixel, int getmaxLayers, int getcurLayers, Material currentPixel, int spikeHeight, int curSpikeHeight){

      if(currentPixel.getcurLayer(currentPixel.getName()) >=1)
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
  public int getcurLayer(String name){
      if(getY()==sim.getYLen()-1){
          return 1;}
      else if(getY() == sim.getYLen()-1){
        return 1;
      }
      else if(getBelow() == null){
        if(getLeft()!=null && getLeft().getName().equals(getName())){
          return 1;
        }
        else if(getRight()!=null && getRight().getName().equals(getName())){
          return 1;
        }
        else{
          return -10000;
        }
      }
      else if (getBelow().getName() == name){
          return (getBelow().getcurLayer(name)+1);
      }
      else {
          return 1;
      }

  }
}
