public abstract class MediaItem extends Item {
    // private data
    private int runTime;

    // constructor
    public MediaItem() {
        super();
        runTime = 0;
    }
    public MediaItem(int newId, int newCopies, String newTitle, int newRunTime) {
        super(newId, newCopies, newTitle);
        runTime = newRunTime;
    }

    // getter
    public int getRunTime() {
        return runTime;
    }

    // setter
    public void setRunTime(int newRunTime) {
        runTime = newRunTime;
    }

    // test for equality
    public boolean equals(MediaItem other) {
        return (super.equals(other)) && (runTime == other.runTime);
    }

    // return as a string
    public String toString() {
        return String.format("%sRUN TIME: %d", super.toString(), runTime);
    }

    // print
    public void print(){
        System.out.printf("%sRUN TIME: %d", super.toString(), runTime);
    }
}
