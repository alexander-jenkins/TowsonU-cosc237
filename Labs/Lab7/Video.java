public class Video extends MediaItem {
    // private data
    private String director;
    private String genre;
    private int yearReleased;

    // constructors
    public Video() {
        super();
        director = "Default";
        genre = "Default";
        yearReleased = 0;
    }
    public Video(int newId, int newCopies, String newTitle, int newRunTime, String newDirector, String newGenre, int newYearReleased) {
        super(newId, newCopies, newTitle, newRunTime);
        director = newDirector;
        genre = newGenre;
        yearReleased = newYearReleased;
    }

    // getters
    public String getDirector() {
        return director;
    }
    public String getGenre() {
        return genre;
    }
    public int getYearReleased() {
        return yearReleased;
    }

    // setters
    public void setDirector(String newDirector) {
        director = newDirector;
    }
    public void setGenre(String newGenre) {
        genre = newGenre;
    }
    public void setYearReleased(int newYearReleased) {
        yearReleased = newYearReleased;
    }

    // test equality
    public boolean equals(Video other) {
        return (super.equals(other)) && (director.equals(other.director)) && (genre.equals(other.genre)) && (yearReleased == other.yearReleased);
    }

    // return as a string
    public String toString() {
        return String.format("%s%nDIRECTOR: %s%nGENRE: %s%nYEAR RELEASED: %d", super.toString(), director, genre, yearReleased);
    }

    // print
    public void print(){
        System.out.printf("%s%nDIRECTOR: %s%nGENRE: %s%nYEAR RELEASED: %d%n", super.toString(), director, genre, yearReleased);
    }
}
