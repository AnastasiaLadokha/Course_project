package ua.stu.store;

public class Supermarket {
    private int maxSize;
    private volatile int size = 0;

    public Supermarket(int maxSize) {
        super();
        this.maxSize = maxSize;
    }

    public Supermarket() {
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getSize() {
        return size;
    }
}
