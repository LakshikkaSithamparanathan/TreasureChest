public class KillerFish extends Fish {

    public KillerFish(String Name) {        // Creating the constructor of a KillerFish
        super(Name);
    }

    public void KillWarrier(Warrior w1) {   //method to kill Warrior
        if (w1.immortal == false) {         //Checking the condition to kill the warrior if he is immortal or not
            w1 = null;
        } else {
            System.out.println("Though there is a Killerfish " + this.getName() + " since the Warrior " + w1.getName() + " is already immortal, so he is safe");
        }
    }
}