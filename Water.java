import javafx.scene.paint.Color;

public class Water extends Material implements Liquid{
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
    public void levelV(){
        if(getBelow()==null)
            fall();
        else if(getY()==getYBounds()-1){
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
        else if (getBelow().getLeft() == null)
            moveLeft();
        else if (getBelow().getRight()==null)
            moveRight();
 
        else if (getBelow().getRight().getRight() == null && getBelow().getLeft().getLeft() == null){
            if(Math.random()>0.5){
                moveLeft();
                moveLeft();
             
            }
        else{
            moveRight();
            moveRight();
            }
        }
        else if (getBelow().getLeft().getLeft() == null)
{            moveLeft();
            moveLeft();}
              else if (getBelow().getRight().getRight()==null){
            moveRight();
            moveRight();}
        // else if(getRight() == null && getLeft() == null){
        //     if(Math.random()>0.5){
        //         moveLeft();
             
        //      }
        //     else{
        //         moveRight();
        //     }
        // }
    }
}