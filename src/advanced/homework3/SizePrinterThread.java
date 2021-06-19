package advanced.homework3;

public class SizePrinterThread extends Thread {
    private long size;
    private boolean isDone;

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public void run() {
        while (!isDone) {
            System.out.println(size);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
