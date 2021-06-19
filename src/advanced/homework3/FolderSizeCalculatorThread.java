package advanced.homework3;

import java.io.File;
import java.io.FileNotFoundException;

public class FolderSizeCalculatorThread extends Thread {
    private String folderPath;
    SizePrinterThread thread;

    public FolderSizeCalculatorThread(String folderPath) {
        this.folderPath = folderPath;
    }

    private long calculate(File dir) {
        long size = 0;
        File[] files = dir.listFiles();
        int numOfFilesFolders  = 0;
        if (files != null) {
            numOfFilesFolders = files.length;
        }
        else {
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < numOfFilesFolders; i++) {
            if (files[i].isFile()) {
                thread.setSize(thread.getSize() + files[i].length());
                size += files[i].length();
            }
            else {
                size += calculate(files[i]);
            }
        }
        return size;
    }

    @Override
    public void run() {
        File dir = new File(folderPath);
        thread = new SizePrinterThread();
        thread.start();
        System.out.println(calculate(dir));
        thread.setDone(true);
    }
}
