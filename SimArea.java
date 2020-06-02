public class SimArea {
    private Material[][] world;
    private final int X_LEN;
    private final int Y_LEN;

    public SimArea(int x, int y) {
        X_LEN = x;
        Y_LEN = y;
        world = new Material[x][y];
    }

    public void simulate() { //Looped code

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

    public int getXLen() {
        return X_LEN;
    }

    public int getYLen() {
        return Y_LEN;
    }
}