import java.util.ArrayList;
import java.util.Random;

public class Grid {

    GridLocation Gridlocation;  // creating a gridlocation
    GridLocation[] Total_Grids = new GridLocation[121];       //an array contains all grid points created....
    int a = 0;
    int b = 0;
    Random rand = new Random();

    public Grid() {                 // create a 11*11 grid
        int k = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {

                Gridlocation = new GridLocation(i, j);
                Total_Grids[k++] = Gridlocation;
            }
        }
    }

    public GridLocation getPoint(int x, int y) {
        return Total_Grids[FindPosition(x, y)];              //method for get particular grid_points
    }

    public int FindPosition(int x, int y) {
        return (11 * x + y);                      //return the index of particular coordinate
    }


    public void setObject(int x, int y, Object c) {
        Total_Grids[FindPosition(x, y)].setObj(c);     //set the character for particular index
    }

    //to get the object type from a specified gridlocation
    public Object getObject(int x, int y) {
        return Total_Grids[FindPosition(x, y)].getObj();  //get the character from particular gridpoint
    }

    public void setLocation(ArrayList<Inhabitant> inhabitant) {
        for (int j = 0; j < inhabitant.size(); j++) {

            if (inhabitant.get(j) instanceof Warrior == true) {
                do {
                    do {
                        a = rand.nextInt(11);
                        b = rand.nextInt(11);

                    } while (a != 0 && b != 0 && a != 10 && b != 10);
                }
                while (getObject(a, b) instanceof Warrior || getObject(a, b) instanceof Lotus || getObject(a, b) instanceof Fish);
                //  checking for the presence of any other objects in the selected Grid location including any other warrior object
                if (a == 0 || b == 0) {  //checking the condition for setting the warriors into the grid and putting them in it
                    setObject(a, b, inhabitant.get(j));
                    inhabitant.get(j).setA(a);
                    inhabitant.get(j).setB(b);
                } else if (a == 10 && b == 10) {
                    setObject(a, b, inhabitant.get(j));
                    inhabitant.get(j).setA(a);
                    inhabitant.get(j).setB(b);
                }
                System.out.println("A Warrior " + inhabitant.get(j).getName() + " is in " + a + " " + b);    // print the current location

            } else if (inhabitant.get(j) instanceof Fish == true) {
                do {
                    a = rand.nextInt(11);
                    b = rand.nextInt(11);

                }
                while (getObject(a, b) instanceof Warrior || getObject(a, b) instanceof Lotus || getObject(a, b) instanceof TreasureChest);
                //  checking for the presence of any other objects in the selected Grid location excluding fish object
                setObject(a, b, inhabitant.get(j));  //setting the fish into the grid
                inhabitant.get(j).setA(a);
                inhabitant.get(j).setB(b);
                System.out.println("Fish " + inhabitant.get(j).getName() + " is in " + a + " " + b); // print the Current gridLocation

            } else if (inhabitant.get(j) instanceof Lotus == true) {

                do {
                    a = rand.nextInt(11);
                    b = rand.nextInt(11);

                }
                while (getObject(a, b) instanceof Lotus || getObject(a, b) instanceof Warrior || getObject(a, b) instanceof TreasureChest || getObject(a, b) instanceof Fish);
                //  checking for the presence of any other objects in the selected Grid location including any other Lotus object
                System.out.println("Lotus " + inhabitant.get(j).getName() + " is in " + a + " " + b);    // print the current location

                setObject(a, b, inhabitant.get(j));  // set the lotus object into grid
                inhabitant.get(j).setA(a);
                inhabitant.get(j).setB(b);
            }
        }

    }
}