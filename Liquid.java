import javafx.scene.paint.Color;
public class Liquid extends Material{

  public Liquid(SimArea sim, String name, Color color, int maxLayers, long vSpeed, int spikeHeight, int x, int y, int density){
    super(sim, name, color, maxLayers, vSpeed, spikeHeight, x, y, density);
  }

  
}

//Restructure program to make Liquid and LooseSolid classes instead of interfaces
//Pass distinct values for each material into the appropriate supers
//Make liquid not teleport (perhaps push other blocks down the row); ensure no movements are more than one pixel
//Fix crash when a material is added in the pixel of a pixel that is moving
//Add custom materials
//Gasses?
