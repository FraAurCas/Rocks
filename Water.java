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

                if (checkLen > getXBounds())
                    break;
                checkLen++;
            }
        }
    }



//         if(getBelow()==null)
//             fall();
//         else if(getY()==getYBounds()-1){
//             if(getRight() == null && getLeft() == null){
//             if(Math.random()>0.5){
//                 moveLeft();

//              }
//             else{
//                 moveRight();
//             }
//         }
//         }
//         else if (getBelow().getRight() == null && getBelow().getLeft() == null){
//             if(Math.random()>0.5){
//                 moveLeft();

//              }
//             else{
//                 moveRight();
//             }
//         }
//         else if (getBelow().getLeft() == null)
//             moveLeft();
//         else if (getBelow().getRight()==null)
//             moveRight();

//         else if (getBelow().getRight().getRight() == null && getBelow().getLeft().getLeft() == null){
//             if(Math.random()>0.5){
//                 moveLeft();
//                 moveLeft();

//             }
//         else{
//             moveRight();
//             moveRight();
//             }
//         }
//         else if (getBelow().getLeft().getLeft() == null)
// {            moveLeft();
//             moveLeft();}
//               else if (getBelow().getRight().getRight()==null){
//             moveRight();
//             moveRight();}
//         // else if(getRight() == null && getLeft() == null){
//         //     if(Math.random()>0.5){
//         //         moveLeft();

//         //      }
//         //     else{
//         //         moveRight();
//         //     }
//         // }
//     }
}
