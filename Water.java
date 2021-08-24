import javafx.scene.paint.Color;

public class Water extends Liquid{
    public Water(SimArea sim, int x, int y){
        super(sim, "Water", Color.SKYBLUE, 3, 0, 1, x, y, 3);
    }
    @Override
    public void level(){
        // if(fallLiquid())
        //     ;
        // else
            levelV();
    }





}
