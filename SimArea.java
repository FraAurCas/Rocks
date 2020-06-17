import org.omg.CORBA.PUBLIC_MEMBER;

public class SimArea {
    private Material[][] world;
    private final int X_LEN;
    private final int Y_LEN;

    public SimArea(int x, int y) {
        X_LEN = x;
        Y_LEN = y;
        world = new Material[x+1][y+1];
    }

    public void simulate() { //Looped code
        for (int x = 0; x < X_LEN; x++) {
            for (int y = 0; y < Y_LEN; y++) {
                Material m = world[x][y];
                if (m != null && !m.moved()) {
                    m.level();
                    m.setMoved(true);
                }
            }
        }
        
        for (int x = 0; x < X_LEN; x++) {
            for (int y = 0; y < Y_LEN; y++) {
                if (world[x][y] != null) {
                    world[x][y].setMoved(false);
                }
            }
        }
    }

    /**
     * Returns the material at the given location. Throws ArrayIndexOutOfBoundsException if x or y are to large for 
     * the game board.
     * @param x
     * @param y
     * @return
     */
    public Material getMaterial(int x, int y) {
        if (x >= X_LEN || y >= Y_LEN)
            throw new ArrayIndexOutOfBoundsException(x + ", " + y + " does not exist within the game board");
        return world[x][y];
    }
    
    /**
     * Puts a new material on the board a the specified location. Returns the material formerly there. Throws 
     * ArrayIndexOutOfBoundsException if x or y are to large for the game board.
     * @param m
     * @param x
     * @param y
     * @return
     */
    public Material add(Material m, int x, int y) {
        if (x >= X_LEN || y >= Y_LEN)
            throw new ArrayIndexOutOfBoundsException(x + ", " + y + " does not exist within the game board");
        Material temp = world[x][y];
        world[x][y] = m;
        return temp;
    }

    public void swap(Material m, Material n){
        int mx = m.getX();
        int my = m.getY();
        int nx = n.getX();
        int ny = n.getY();
        world[getXLen()][getYLen()] = m;
        m.setX(getXLen());
        m.setY(getYLen());
        world[mx][my] = n;
        n.setX(mx);
        n.setY(my);
        world[n.getX()][n.getY()] = n;
        m.setX(nx);
        m.setY(ny);
        m.setMoved(true);
        n.setMoved(true);
    }

    public int getXLen() {
        return X_LEN;
    }

    public int getYLen() {
        return Y_LEN;
    }

    public void changeMatPos(Material m, int firstX, int firstY, int secondX, int secondY){
        world[secondX][secondY] = m;
        world[firstX][firstY] = null;
    }
}