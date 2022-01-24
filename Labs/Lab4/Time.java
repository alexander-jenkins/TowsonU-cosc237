public class Time {

    // initialize the default fields
    private int hrs;
    private int mins;
    private int secs;

    // default constructor -- init the time to 0
    public Time() {
        hrs =  0;
        mins = 0;
        secs = 0;
    }

    // alternate constructor -- pass vars the constructor
    public Time(int h, int m, int s) {
        hrs = h;
        mins = m;
        secs = s;
    }

    // set time method -- if the time is invalid for the given parameter, set that parameter to 0
    public void set(int h, int m, int s) {
        hrs = (h >= 0 && h < 24)? h : 0;
        mins = (m >= 0 && m < 60)? m : 0;
        secs = (s >= 0 && s < 60)? s : 0;
    }

    // getter methods -- return hours, minutes, and seconds
    public int getHrs() {
        return hrs;
    }
    public int getMins() {
        return mins;
    }
    public int getSecs() {
        return secs;
    }

    // print methods, one for returning the time in military time and one for returning the time in standard form
    // print -- return in standard form
    public void printStandard() {
        System.out.print((hrs == 0 || hrs == 12? 12: hrs % 12) + ":");
        System.out.print((mins < 10? "0": "") + mins + ":");
        System.out.print((secs < 10? "0": "") + secs + " ");
        System.out.print((hrs < 12? "AM": "PM"));
    }
    // print -- return in military form
    public void printMilitary() {
        System.out.print((hrs < 10? "0": "") + hrs + ":");
        System.out.print((mins < 10? "0": "") + mins + ":");
        System.out.print((secs < 10? "0": "") + secs);
    }

    // to string method
    public String toString() {
        return hrs + ":" + mins + ":" + secs;
    }

    // determine if one time is equal to another
    public boolean equals(Time t) {
        return (hrs == t.hrs && mins == t.mins && secs == t.secs);
    }

    // make a copy of a time
    public void copy(Time t) {
        hrs = t.hrs;
        mins = t.mins;
        secs = t.secs;
    }

    // determine if one time is less than another
    public boolean lessThan(Time t) {
        return (hrs < t.hrs || hrs == t.hrs && mins < t.mins || hrs == t.hrs && mins == t.mins && secs < t.secs);
    }

    // methods for Lab4_3 part 1

    // check if one time is not equal to another time
    public boolean notEquals(Time t) {
        return (hrs != t.hrs && mins != t.mins && secs != t.secs);
    }

    // check if one time is less than or equal to another time
    public boolean lessOrEquals(Time t) {
        return (hrs <= t.hrs && mins <= t.mins && secs <= t.secs);
    }

    // check if one time is greater than another time
    public boolean greaterThan(Time t) {
        return (hrs > t.hrs && mins > t.mins && secs > t.secs);
    }

    // check if one time is greater than or equal to another time
    public boolean greaterOrEquals(Time t) {
        return (hrs >= t.hrs && mins >= t.mins && secs >= t.secs);
    }

    // end part 1

    // methods for Lab4_3 part 2

    // advance the seconds of a time, increment and reset minutes/hours if necessary
    public void advanceSecs() {
        secs++;
        if (secs > 59) {
            secs = 0;
            advanceMins();
        }
    }

    // advance the mins of a time
    public void advanceMins() {
        mins++;
        if (mins > 59) {
            mins = 0;
            advanceHrs();
        }
    }

    //advance the hours
    public void advanceHrs() {
        hrs++;
        if (hrs > 23) hrs = 0;
    }

    // end part 2

    // methods for Lab4_3 part 3

    // get a copy of the time -- unsure of how to make it only a single return statement
    public Time getCopy() {
        Time t = new Time();
        t.hrs = hrs;
        t.mins = mins;
        t.secs = secs;
        return t;
    }

    // end part 3

    // methods for Lab4_3 part 4

    // return a time as a string in standard format'
    public String toStandard() {
        return (hrs == 0 || hrs == 12? 12: hrs % 12) + ":" + (mins < 10? "0": "") + mins + ":" + (secs < 10? "0": "") + secs + " " + (hrs < 12? "AM": "PM");
    }

    // return a time as a string in military time
    public String toMilitary() {
        return (hrs < 10? "0": "") + hrs + ":" + (mins < 10? "0": "") + mins + ":" + (secs < 10? "0": "") + secs;
    }

    // end part 4

}