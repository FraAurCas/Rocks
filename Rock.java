import javafx.scene.paint.Color;

public class Rock extends FirmSolid{
    public Rock(SimArea sim, int x, int y) {
        super(sim, "Rock", Color.GRAY, 1440, 0, 1440, x, y, 10);

    }
    @Override
    public void level(){
        if(fall()){
            ;}
        else{
            levelV();}
    }
  }
