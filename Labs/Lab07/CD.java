public class CD extends MediaItem {
    // private data
    private String artist;
    private String genre;

    // constructors
    public CD() {
        super();
        artist = "Default";
        genre = "Default";
    }
    public CD(int newId, int newCopies, String newTitle, int newRunTime, String newArtist, String newGenre) {
        super(newId, newCopies, newTitle, newRunTime);
        artist = newArtist;
        genre = newGenre;
    }

    // getters
    public String getArtist() {
        return artist;
    }
    public String getGenre() {
        return genre;
    }

    // setters
    public void setArtist(String newArtist) {
        artist = newArtist;
    }
    public void setGenre(String newGenre) {
        genre = newGenre;
    }

    // test for equality
    public boolean equals(CD other) {
        return (super.equals(other)) && (artist.equals(other.artist)) && (genre.equals(other.genre));
    }

    // return as a string
    public String toString() {
        return String.format("%s%nARTIST: %s%nGENRE: %s%", super.toString(), artist, genre);
    }

    // print
    public void print(){
        System.out.printf("%s%nARTIST: %s%nGENRE: %s%n", super.toString(), artist, genre);
    }
}
