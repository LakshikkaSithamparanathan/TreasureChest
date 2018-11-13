


import java.util.ArrayList;
/**
 * @author laksh
 */


public class GameDemo  {

    public static ArrayList<Warrior> observers = new ArrayList<Warrior>();
    public static volatile boolean gameEnd = false;
    static Grid grid;
    static ArrayList<Inhabitant> inhabitant;

    public static void main(String[] args) {
        GameDemo gameDemo = new GameDemo();
        System.out.println("---------------Welcome to Nozama Quest Simulation----------------------");
        System.out.println("This is an interesting Questwhich contains 04 Warriors ,06 Fishes and 05 Lotuses");
        System.out.println("I made this quest more exciting by adding Three SuperWarriors and a NormalWarrior.\nPLAY AND ENJOY GUYS!!!!!!!!!!!!");

        grid = new Grid();//Initializing a grid in the Game
        inhabitant = new ArrayList<Inhabitant>();//Initializing the arraylist//Create an arraylist to keep track of the inhabitants in the Game


        Inhabitant I1 = new InnocentFish("Innocent 01");    //creating 06 Fishes and upcasting it to Habitant
        Inhabitant I2 = new InnocentFish("Innocent 02");
        Inhabitant R1 = new RubberFish("Rubber 01");
        Inhabitant R2 = new RubberFish("Rubber 02");
        Inhabitant K1 = new KillerFish("Killer 01");
        Inhabitant K2 = new KillerFish("Killer 02");

        Inhabitant SW1 = new SuperWarrior("Lakshi s");  //creating 04 Warriors and upcasting it to Habitant
        Inhabitant SW2 = new SuperWarrior("Theepa s");
        Inhabitant SW3 = new SuperWarrior("vidya s");
        Inhabitant NW1 = new NormalWarrior("arnlod n");

        Inhabitant L1 = new Lotus("L1");                //creating 05 Lotuses and upcasting it to Habitant
        Inhabitant L2 = new Lotus("L2");
        Inhabitant L3 = new Lotus("L3");
        Inhabitant L4 = new Lotus("L4");
        Inhabitant L5 = new Lotus("L5");

        inhabitant.add(I1);
        inhabitant.add(I2);
        inhabitant.add(R1);
        inhabitant.add(R2);
        inhabitant.add(K1);
        inhabitant.add(K2);
        inhabitant.add(SW1);
        inhabitant.add(SW2);
        inhabitant.add(SW3);
        inhabitant.add(NW1);
        inhabitant.add(L1);
        inhabitant.add(L2);
        inhabitant.add(L3);
        inhabitant.add(L4);
        inhabitant.add(L5);

        SuperWarrior s1 = (SuperWarrior) SW1;       // DownCasting to SuperWarrior and NormalWarrior
        SuperWarrior s2 = (SuperWarrior) SW2;
        SuperWarrior s3 = (SuperWarrior) SW3;
        NormalWarrior n1 = (NormalWarrior) NW1;

        InnocentFish i1 = (InnocentFish) I1;        //  DownCasting to InnocentFish, KillerFish and RubberFish
        InnocentFish i2 = (InnocentFish) I2;
        RubberFish r1 = (RubberFish) R1;
        RubberFish r2 = (RubberFish) R2;
        KillerFish k1 = (KillerFish) K1;
        KillerFish k2 = (KillerFish) K2;

        Lotus l1 = (Lotus) L1;                      //DownCasting to Lotus
        Lotus l2 = (Lotus) L2;
        Lotus l3 = (Lotus) L3;
        Lotus l4 = (Lotus) L4;
        Lotus l5 = (Lotus) L5;
        grid.setLocation(inhabitant);
        gameDemo.attach(s1);                                                    //attaching warriors to the mountdoom
        gameDemo.attach(s2);
        gameDemo.attach(s3);
        gameDemo.attach(n1);

        Thread p1 = new Thread(s1);
        Thread p2 = new Thread(s2);
        Thread p3 = new Thread(s3);
        Thread nw = new Thread(n1);

        System.out.println(" ");


        p1.start();
        p2.start();
        p3.start();
        nw.start();
        gameDemo.finish();

    }

    public synchronized void attach(Warrior w) {                                //attching to the list
        observers.add(w);
    }

    public void detach(Warrior w) {                                             //removing from the list
        if (w == null) {
            observers.remove(w);
        }
    }

    public synchronized void notifyAllWarriors() {                               //notifying all warriors soon one warrior reached mountdoom
        for (Warrior w : observers) {
            if (w != null) {
                w.update();
            }
        }
    }

    public void finish() {                                                      //
        synchronized (this) {

            while (!gameEnd) {
                try {
                    // System.out.println("waiting");
                    wait(100);
                } catch (InterruptedException ex) {
                }
            }
            System.out.println("one warrior has reached the destination");
            notifyAllWarriors();
        }
    }


}








