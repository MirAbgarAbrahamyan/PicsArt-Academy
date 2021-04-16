package core.inheritance;

public class Shipment extends BoxWeight {
    private double cost;

    public Shipment(Shipment ob) {
        super(ob);
        cost = ob.cost;
    }

    public Shipment(double length, double height, double width, double weight, double cost) {
        super(length, height, width, weight);
        this.cost = cost;
    }

    public Shipment() {
        super();
        cost = -1;
    }

    public Shipment(double len, double weight, double cost) {
        super(len, weight);
        this.cost = cost;
    }
}
