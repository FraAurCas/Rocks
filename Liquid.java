import javafx.scene.paint.Color;
public class Liquid extends Material{

  public Liquid(SimArea sim, String name, Color color, int maxLayers, long vSpeed, int spikeHeight, int x, int y, int density){
    super(sim, name, color, maxLayers, vSpeed, spikeHeight, x, y, density);
  }
  public void levelV(){
      if (getY() >= getYBounds())
          return;
      if(getBelow() == null) {
          fall();
      }
      else {
          int checkLen = 1;
          boolean isBoundedLeft = false;
          boolean isBoundedRight = false;
          while (true) {
              Material m;
              if((getX() - checkLen >= 0 && !isBoundedLeft)&&(getX() + checkLen < getXBounds() && !isBoundedRight)){
                if(Math.random() > 0.5) {
                  if (sim.getMaterial(getX() - checkLen, getY()) != null) {
                      isBoundedLeft = true;
                      continue;
                  }
                  m = sim.getMaterial(getX() - checkLen, getY() + 1);
                  if (m == null) {
                      for (int i = 0; i < checkLen; i++)
                          moveLeft();
                      levelV();
                      return;
                  }
                } else {
                  if (sim.getMaterial(getX() + checkLen, getY()) != null) {
                      isBoundedRight = true;
                      continue;
                  }
                  m = sim.getMaterial(getX() + checkLen, getY() + 1);
                  if (m == null) {
                      for (int i = 0; i < checkLen; i++)
                          moveRight();
                      levelV();
                      return;
                  }
                }
              }


              if (getX() + checkLen < getXBounds() && !isBoundedRight) {
                  if (sim.getMaterial(getX() + checkLen, getY()) != null) {
                      isBoundedRight = true;
                      continue;
                  }
                  m = sim.getMaterial(getX() + checkLen, getY() + 1);
                  if (m == null) {
                      for (int i = 0; i < checkLen; i++)
                          moveRight();
                      levelV();
                      return;
                  }
              }
              if (getX() - checkLen >= 0 && !isBoundedLeft) {
                  if (sim.getMaterial(getX() - checkLen, getY()) != null) {
                      isBoundedLeft = true;
                      continue;
                  }
                  m = sim.getMaterial(getX() - checkLen, getY() + 1);
                  if (m == null) {
                      for (int i = 0; i < checkLen; i++)
                          moveLeft();
                      levelV();
                      return;
                  }
              }

              if (checkLen > getXBounds())
                  break;
              checkLen++;
          }
      }
  }

}
