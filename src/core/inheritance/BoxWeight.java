package core.inheritance;

public class BoxWeight extends Box {
    private double weight;

    public BoxWeight(double length, double height, double width, double weight) {
        super(length, height, width);
        this.weight = weight;
    }

    public BoxWeight(BoxWeight ob) {
        super(ob);
        weight = ob.weight;
    }

    public BoxWeight() {
        super();
        weight = -1;
    }

    public BoxWeight(double len, double weight) {
        super(len);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
