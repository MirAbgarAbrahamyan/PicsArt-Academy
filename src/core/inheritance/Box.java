package core.inheritance;

public class Box {
    private double length;
    private double height;
    private double width;

    public Box(double length, double height, double width) {
        this.length = length;
        this.height = height;
        this.width = width;
    }

    public Box(Box ob) {
        length = ob.length;
        height = ob.height;
        width = ob.width;
    }

    public Box() {
        length = -1;
        height = -1;
        width = -1;
    }

    public Box(double len) {
        length = len;
        height = len;
        width = len;
    }

    public double volume() {
        return length * height * width;
    }
}
