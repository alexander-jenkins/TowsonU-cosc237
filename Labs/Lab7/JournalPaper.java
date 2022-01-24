public class JournalPaper extends WrittenItem{
    // private data
    private int yearPublished;

    // constructors
    public JournalPaper() {
        super();
        yearPublished = 0;
    }
    public JournalPaper(int newId, int newCopies, String newTitle, String newAuthor, int newYear) {
        super(newId, newCopies, newTitle, newAuthor);
        yearPublished = newYear;
    }

    // getter
    public int getYearPublished() {
        return yearPublished;
    }

    // setter
    public void setYearPublished(int newYear) {
        yearPublished = newYear;
    }

    // test for equality
    public boolean equals(JournalPaper other) {
        return (super.equals(other)) && (yearPublished == other.yearPublished);
    }

    // return as a string
    public String toString() {
        return String.format("%sYEAR PUBLISHED: %d", super.toString(), yearPublished);
    }

    // print
    public void print(){
        System.out.printf("%sYEAR PUBLISHED: %d%n", super.toString(), yearPublished);
    }

}
