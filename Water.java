import javafx.scene.paint.Color;

public class Water extends Material implements Liquid{
    public Water(SimArea sim, int x, int y){
        super(sim, "Water", Color.SKYBLUE, 3, 0, 1, x, y, false, 3);
    }
    @Override
    public void level(){
        if(fallLiquid())
            ;
        else
            levelV();
    }
    public void levelV(){
        if(getcurLayer(getName()) == 1){
            if(getRight() == null && getLeft() == null){
            if(Math.random()>0.5){
                moveLeft();
             
             }
            else{
                moveRight();
            }
        }
        }
        else if (getBelow().getRight() == null && getBelow().getLeft() == null){
            if(Math.random()>0.5){
                moveLeft();
             
             }
            else{
                moveRight();
            }
        }
    }
}