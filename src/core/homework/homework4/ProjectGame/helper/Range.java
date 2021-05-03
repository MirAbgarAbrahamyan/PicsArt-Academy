package core.homework.homework4.ProjectGame.helper;

public class Range {
    private int left;
    private int right;

    public Range(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    @Override
    public String toString() {
        return left + "," + right;
    }
}
