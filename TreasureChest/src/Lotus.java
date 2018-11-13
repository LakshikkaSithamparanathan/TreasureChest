public class Lotus extends Inhabitant {

    private static int numOfPetals = 100;   // set the number of petals to static
    private int a;
    private int b;


    public Lotus(String Name) {
        super(Name);
    }

    public void AllowpickPetal() {      // this method allows the warrior to pick petal
        numOfPetals = numOfPetals - 1;  // decrementing by 1 if warrior pluck the petal
    }

}