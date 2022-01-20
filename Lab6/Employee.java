public class Employee extends Person {

    // declare the private information
    private double payRate;
    private double hoursWorked;
    private String department;

    public final int HOURS = 40;
    public final double OVERTIME = 1.5;

    // default constructor
    public Employee() {
        super();
        payRate = 0;
        hoursWorked = 0;
        department = "Default";
    }
    // add an alternate constructor with parameters
    public Employee(String first, String last, double pR, double hW, String d) {
        super(first, last);
        payRate = pR;
        hoursWorked = hW;
        department = d;
    }

    // to string method -- overrides the default
    public String toString() {
        //should return a String like this:
        //The wages for <employee> from the <department> department are: $<pay>>"
        return String.format("The wages for %s from the %s department are: $%.2f\n", super.toString(), department, calculatePay());
    }
    public void print() {
        //Should print output like this (same line):
        //The employee <employee> from the <department> department worked <hours> hours
        //with a pay rate of $<pay-rate>. The wages for this employee are <pay>
        System.out.printf("The employee %s from the %s department worked %.1f hours with a pay-rate of $%.2f. The wages for this employee are $%.2f\n", super.toString(), department, hoursWorked, payRate, calculatePay());
    }

    public double calculatePay() {
        //Method to calculate and return the wages
        //handle both regular and overtime pay
        if (hoursWorked <= 40) return hoursWorked * payRate;
        else return ((hoursWorked - HOURS) * (payRate * OVERTIME)) + (HOURS * payRate);
    }

    public void setAll(String first, String last, double rate, double hours, String dep){
        super.setName(first, last);
        payRate = rate;
        hoursWorked = hours;
        department = dep;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public String getDepartment() {
        return department;
    }

    public boolean equals(Employee e) {
        return (payRate == e.payRate) && (hoursWorked == e.hoursWorked) && (department.equals(e.department)) && (getFirstName().equals(e.getFirstName())) && (getLastName().equals(e.getLastName()));
    }

    public Employee getCopy() {
        return new Employee(super.getFirstName(), super.getLastName(), payRate, hoursWorked, department);
    }

    public void copy(Employee e) {
        payRate = e.payRate;
        hoursWorked = e.hoursWorked;
        department = e.department;
    }

}
