public class Person {

    // declare the private info
    private String firstName;
    private String lastName;

    // default and alternate constructors
    // default
    public Person() {
        firstName = "First";
        lastName = "Last";
    }
    // alternate
    public Person(String first, String last) {
        firstName = first;
        lastName = last;
    }

    // getter methods for returning the first and last names
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    // setter method
    public void setName(String first, String last) {
        firstName = first;
        lastName = last;
    }

    // print methods
    // last, first
    public void printLastFirst() {
        System.out.printf("%s, %s\n", lastName, firstName);
    }
    // first last
    public void print() {
        System.out.printf("%s %s\n", firstName, lastName);
    }

    // toString method
    public String toString() {
        return firstName + " " + lastName;
    }

    // equals method for determining if two people have the same name
    public Boolean equals(Person p) {
        return (p.firstName == firstName) && (p.lastName == lastName);
    }

    // copier methods -- copy and getCopy
    // copy another person
    public void copy(Person p) {
        firstName = p.firstName;
        lastName = p.lastName;
    }
    // return a copy of a person
    public Person getCopy() {
        return new Person(firstName, lastName);
    }

}
