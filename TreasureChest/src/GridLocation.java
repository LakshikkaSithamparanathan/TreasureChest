public class GridLocation {

    Object obj;
    private int x;
    private int y;
    private int[] points;

    public GridLocation(int x, int y) {
        points = new int[2];
        points[0] = x;
        points[1] = y;
        obj = null;

    }

    protected Object getObj() {
        return this.obj;
    }

    //set Object c to a gridlocation
    protected void setObj(Object c) {
        this.obj = c;
    }


}