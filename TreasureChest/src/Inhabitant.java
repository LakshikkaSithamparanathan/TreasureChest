abstract class Inhabitant {
    private String Name = null;
    private int a;
    private int b;

    public Inhabitant(String Name) {
        this.Name = Name;
        this.a = a;
        this.b = b;
    }

    public String getName() {           // returning the Name
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;

    }

    public int getA() {
        return a;
    }

    // Setters and Getters of a and b
    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

}