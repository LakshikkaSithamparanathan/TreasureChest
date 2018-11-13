import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NormalWarrior extends Warrior {
    long startTime;

    public NormalWarrior(String Name) {
        super(Name);
        startTime = System.currentTimeMillis();
    }

    public void Eat() {
    }

    public void Sleep() {
        //sleeping
    }

    public void swim() {
        //Swimming
        System.out.println("NormalWarrior " + this.getName() + " start walking from (" + this.getA() + "," + this.getB() + ")");//Print the current location

        while (mobile && !Flag) {                         //checking mobile condition for walking
            int tempx1 = this.getA();                      // getting previous grid_points
            int tempy1 = this.getB();
            int tempx2 = this.getA();
            int tempy2 = this.getB();
            if (tempx1 < 5) {
                tempx1 += 1;
            } else if (tempx1 > 5) {

                tempx1 -= 1;

            } else if (tempy1 < 5) {

                tempy1 += 1;

            } else if (tempy1 > 5) {

                tempy1 -= 1;

            }

            try {
                Thread.currentThread().sleep(1000);     //sleeping for two seconds to make warrior movements visible
            } catch (InterruptedException ex) {         //catching interrupted exception
                return;
            }
            GameDemo.grid.setObject(tempx2, tempy2, null);    //updating grid_point after movement

            System.out.println("NormalWarrior" + " " + this.getName() + " " + "moved to (" + Integer.toString(tempx1) + "," + Integer.toString(tempy1) + ")");
            if (tempx1 == 5 && tempy1 == 5) {       // Checking the emd of the game
                mobile = false;
                Flag = true;
                BufferedWriter bw = null;
                FileWriter fw = null;
                long stopTime = System.currentTimeMillis();
                long timeTaken = stopTime - startTime;
                System.out.println("NormalWarrior" + " " + this.getName() + " reached the TreasureChest in " + timeTaken + (" ms. The Game over"));

                try {
                    File file = new File(FILENAME);
                    // if file doesnt exists, then create it
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    // true = append file
                    fw = new FileWriter(file.getAbsoluteFile(), true);
                    bw = new BufferedWriter(fw);

                    bw.write(this.getName() + " had reached the destination in");
                    bw.write(" - ");
                    String time = Long.toString(timeTaken) + "ms";
                    bw.write(time);
                    bw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (bw != null)
                            bw.close();

                        if (fw != null)
                            fw.close();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                // System.out.println(numberOfWarriors());
                notifyy();
            }
            if (GameDemo.grid.getObject(tempx1, tempy1) instanceof Warrior) { //checking the presence of a warrior object in the next gridlocation
                // checking the absence of a warrior object in right ,left and down directions
                if (GameDemo.grid.getObject(tempx2 - 1, tempy2) instanceof Warrior == false) {
                    tempx1 = tempx2 - 1;
                    tempy1 = tempy2;
                } else if (GameDemo.grid.getObject(tempx2 + 1, tempy2) instanceof Warrior) {
                    tempx1 = tempx2 + 1;
                    tempy1 = tempy2;
                } else if (GameDemo.grid.getObject(tempx2, tempy2 - 1) instanceof Warrior) {
                    tempx1 = tempx2;
                    tempy1 = tempy2 - 1;
                }
            } else if (GameDemo.grid.getObject(tempx1, tempy1) instanceof RubberFish) {    //checking the presence of a RubberFish object in the next gridlocation
                ((RubberFish) GameDemo.grid.getObject(tempx1, tempy1)).EatFin(this); //Eat the SwimFIN
                break;

            } else if (GameDemo.grid.getObject(tempx1, tempy1) instanceof KillerFish) {   //checking the presence of a KillerFish object in the next gridlocation
                ((KillerFish) GameDemo.grid.getObject(tempx1, tempy1)).KillWarrier(this);      //Kill the Warrior object
                break;
            }

            //PICK PETAL
            if ((GameDemo.grid.getObject(tempx1, tempy1)) instanceof Lotus) {     //checking the presence of a Lotus object in the next gridlocation
                this.pickPetal(((Lotus) GameDemo.grid.getObject(tempx1, tempy1)));// picking the petal by the warrior

            }
            GameDemo.grid.setObject(tempx1, tempy1, this);  //update grid point
            this.setA(tempx1);
            this.setB(tempy1);
        }

    }

    @Override
    public void run() {  // method to run inside the Grid
        this.swim();
    }
}
