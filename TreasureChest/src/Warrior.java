abstract class Warrior extends Inhabitant implements Runnable {


    static boolean Flag;                //Creating a boolean variable to check the end of the game
    protected boolean mobile;           //Creating a boolean variable to check mobility
    protected boolean immortal;         //Creating a boolean variable to check whether a warrior immortal or not
    protected Fin[] SwimFin;
    protected volatile boolean End = true;
    protected static final String FILENAME = "WINNER'S_LIST.txt";

    public Warrior(String Name) {       //  Creating the constructor of a Warrior
        super(Name);
        SwimFin = new Fin[2];
        SwimFin[0] = new Fin();
        SwimFin[1] = new Fin();
        mobile = true;
        immortal = false;
        Flag = false;

    }

    public abstract void Sleep();

    public void looseFin(Warrior w) {        // Method to loose fin when Rubberfish eats it
        SwimFin[0] = null;
        SwimFin[1] = null;
        mobile = false;
        w = null; // Remove the Warrior object when he is immobie
        System.out.println("Warrior " + this.getName() + " lost his fins. he became immobile");
    }

    public void pickPetal(Lotus l) {    //Method to pick Petal of a lotus
        if (this.immortal == false) {   //check the immortality of the warrior and if it is not , make it as true
            this.immortal = true;
            l.AllowpickPetal();
            System.out.println("Warrior " + this.getName() + " became immortal");
        }
    }

    protected void update() {
        End = false;

    }

    protected void notifyy() {
        synchronized (this) {
            GameDemo.gameEnd = true;
            System.out.println("notified, there's a winner ");
        }
    }


}
