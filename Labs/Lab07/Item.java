public abstract class Item {
    // private data
    private int id;
    private int numCopies;
    private String title;

    // constructors
    public Item() {
        id = 0;
        numCopies = 0;
        title = "Default";
    }
    public Item(int newId, int newCopies, String newTitle) {
        id = newId;
        numCopies = newCopies;
        title = newTitle;
    }

    // getters
    public int getId() {
        return id;
    }
    public int getNumCopies() {
        return numCopies;
    }
    public String getTitle() {
        return title;
    }

    // setters
    public void setId(int newId) {
        id = newId;
    }
    public void setNumCopies(int newCopies) {
        numCopies = newCopies;
    }
    public void setTitle(String newTitle) {
        title = newTitle;
    }

    // test if equal
    public boolean equals(Item other) {
        return (id == other.id) && (numCopies == other.numCopies) && (title.equals(other.title));
    }

    // return as a string
    public String toString() {
        return String.format("ID: %d%nTITLE: %s%nNUMBER OF COPIES: %d%n", id, title, numCopies);
    }

    // print item
    public void print(){
        System.out.printf("ID: %d%nTITLE: %s%nNUMBER OF COPIES: %d%n", id, title, numCopies);
    }

    // check in item
    public void checkIn() {
        numCopies += 1;
    }

    // check out item
    public void checkOut() {
        if (numCopies <= 0) System.out.println("Error. Not enough copies.");
        else numCopies -= 1;
    }

    // add item
    public void addItem() {
        numCopies += 1;
    }
}
