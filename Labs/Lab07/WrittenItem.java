public abstract class WrittenItem extends Item {
    // private data
    private String author;

   // constructors
   public WrittenItem() {
       super();
       author = "Default";
   }
   public WrittenItem(int newId, int newCopies, String newTitle, String newAuthor) {
       super(newId, newCopies, newTitle);
       author = newAuthor;
   }

   // getter
   public String getAuthor() {
       return author;
   }

   // setter
    public void setAuthor(String newAuthor) {
       author = newAuthor;
    }

    // test for equality
    public boolean equals(WrittenItem other) {
       return (super.equals(other)) && (author.equals(other.author));
    }

    // return as a string
    public String toString() {
        return String.format("ID: %d%nTITLE: %s%nAUTHOR: %s%nNUMBER OF COPIES: %d%n", super.getId(), super.getTitle(), author, super.getNumCopies());
    }

    // print
    public void print(){
        System.out.printf("ID: %d%nTITLE: %s%nAUTHOR: %s%nNUMBER OF COPIES: %d%n", super.getId(), super.getTitle(), author, super.getNumCopies());
    }

}
