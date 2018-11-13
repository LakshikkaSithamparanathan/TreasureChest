public class RubberFish extends Fish {
    public RubberFish(String Name) {         // Creating the constructor of a RubberFish
        super(Name);
    }

    public void EatFin(Warrior w1) {     //method to eat the fin of the Warrior
        if (w1.immortal == false) {         //Checking the condition to eat the fin of the Warrior if he is immortal or not
            w1.looseFin(w1);
        } else {
            System.out.println("Though there is a Rubberfish " + this.getName() + " since the Warrior " + w1.getName() + " is already immortal, so he is safe");
        }

    }
}