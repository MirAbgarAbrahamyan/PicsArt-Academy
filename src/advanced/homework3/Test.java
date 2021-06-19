package advanced.homework3;

public class Test {
    public static void main(String[] args) {
        String folderPath = "D:\\New folder";
        FolderSizeCalculatorThread folderSizeThread = new FolderSizeCalculatorThread(folderPath);
        folderSizeThread.start();
    }
}
