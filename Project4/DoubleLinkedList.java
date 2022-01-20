public class DoubleLinkedList<T> implements DoubleLinkedListADT<T> {
    //Double linked list node class
    public class DoubleLinkedListNode<T> {
        T info;
        DoubleLinkedListNode<T> next;
        DoubleLinkedListNode<T> back;

        public DoubleLinkedListNode() {
            info = null;
            next = null;
            back = null;
        }

        public String toString() {
            return info.toString();
        }
    }

    protected int count; //number of nodes
    protected DoubleLinkedListNode<T> first; //reference to first node
    protected DoubleLinkedListNode<T> last; //reference to last node

    // initialize the list
    public void initializeList() {
        first = null;
        last = null;
        count = 0;
    }

    // determine if the list is empty
    public boolean isEmptyList() {
        return (first == null);
    }

    // retrieve the first element
    public T front() {
        return first.info;
    }

    // retrieve the last element
    public T back() {
        return last.info;
    }

    // find the length of the list
    public int length() {
        return count;
    }

    // display the list
    public void print() {
        // prints the list with each name separated bv a dash
        DoubleLinkedListNode current = first;
        for (int i = 0; i < count; i++) {
            System.out.print(current.info);
            if (current.next != null) System.out.print(" - ");
            current = current.next;
        }
    }

    // reverse print the list
    public void reversePrint() {
        // prints the list with each name separated bv a dash
        DoubleLinkedListNode current = last;
        for (int i = 0; i < count; i++) {
            System.out.print(current.info);
            if (current.back != null) System.out.print(" - ");
            current = current.back;
        }
    }

    // search the list for a given item
    public boolean search(T flag) {
        DoubleLinkedListNode<T> current = first;
        boolean found = false;
        while (current != null && !found) {
            Comparable<T> temp = (Comparable<T>) current.info;
            if (temp.compareTo(flag) == 0)
                found = true;
            current = current.next;
        }
        return found;
    }

    // insert a node -- provided by Prof. Zimand
    public void insertNode(T insertItem){
        boolean found;
        DoubleLinkedListNode<T> current;//moving reference
        DoubleLinkedListNode<T> trailCurrent = null; //just before current
        // Set up node to be inserted
        DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>();
        newNode.info = insertItem;
        newNode.next = null;
        newNode.back = null;
        //if the list is empty, newNode is the only node
        if (first == null) {
            first = newNode;
            last = newNode;
            count++;
        }
        else {
            found = false;
            current = first;
            //search the list
            while (current != null && !found) {
                Comparable<T> temp = (Comparable<T>) current.info;
                if (temp.compareTo(insertItem) >= 0)
                    found = true;
                else {
                    trailCurrent = current;
                    current = current.next;
                }
            }
            //insert new node before first
            if (current == first) {
                first.back = newNode;
                newNode.next = first;
                first = newNode;
                count++;
            }
            else {
                //insert newNode between trailCurrent and current
                if (current != null) {
                    trailCurrent.next = newNode;
                    newNode.back = trailCurrent;
                    newNode.next = current;
                    current.back = newNode;
                }
                else {
                    //insert new node after last
                    trailCurrent.next = newNode;
                    newNode.back = trailCurrent;
                    last = newNode;
                }
                count++;
            }
        }
    }

    // delete a node - provided by Prof. Zimand
    public void deleteNode(T deleteItem) {
        DoubleLinkedListNode<T> current; //moving reference
        DoubleLinkedListNode<T> trailCurrent;//just before current
        boolean found;
        if (first == null)
            System.err.println("Cannot delete from an empty list.");
            //if node to be deleted is the first node
        else if (first.info.equals(deleteItem)) {
            current = first;
            first = first.next;
            if (first != null)
                first.back = null;
            else
                last = null;
            count--;
        }
        else {
            found = false;
            current = first;
            //search the list
            while (current != null && !found) {
                Comparable<T> temp = (Comparable<T>) current.info;
                if (temp.compareTo(deleteItem) >= 0)
                    found = true;
                else
                    current = current.next;
            }
            if (current == null)
                System.out.println("The item to be deleted is not in the list.");
            else if (current.info.equals(deleteItem)) {
                trailCurrent = current.back;
                trailCurrent.next = current.next;
                if (current.next != null)
                    current.next.back = trailCurrent;
                if (current == last)
                    last = trailCurrent;
                count--;
            }
            else
                System.out.println("The item to be deleted is not in list.");
        }
    }

    // convert list to string - in order
    public String toString() {
        String the_list = "";
        DoubleLinkedListNode current = first;
        for (int i = 0; i < count; i++) {
            the_list += current.info;
            if (current.next != null) the_list += " - ";
            current = current.next;
        }
        return the_list;
    }

    // convert list to string - in order - recursive
    // publicly called method
    public String recursiveToString() {
        return recursiveToString(first);
    }
    // helper method that calls itself and makes sure the string is formatted properly
    private String recursiveToString(DoubleLinkedListNode<T> current) {
        if (current == null) return " ";
        else if (current.next != null) return current.info.toString() + " - " + recursiveToString(current.next);
        else return current.info.toString() + recursiveToString(current.next);
    }

    // convert to backwards string
    public String backwardsString() {
        String the_list = "";
        DoubleLinkedListNode current = last;
        for (int i = 0; i < count; i++) {
            the_list += current.info;
            if (current.back != null) the_list += " - ";
            current = current.back;
        }
        return the_list;
    }

    // convert to backwards string - recursive
    // publicly called method
    public String recursiveBackwardsString() {
        return recursiveBackwardsString(last);
    }
    // helper method that calls itself and makes sure the string is formatted properly
    private String recursiveBackwardsString(DoubleLinkedListNode<T> current) {
        if (current == null) return " ";
        else if (current.back != null) return current.info.toString() + " - " + recursiveBackwardsString(current.back);
        else return current.info.toString() + recursiveToString(current.back);
    }

    // determine if two lists are equal
    public boolean equals(Object o) {
        return o.toString().equals(toString());
    }

    // copy the list
    public void copy(DoubleLinkedList<T> otherList) {
        initializeList();
        DoubleLinkedListNode<T> current = otherList.last;
        for (int i = 0; i < otherList.count; i++) {
            DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>();
            newNode.info = current.info;
            newNode.next = null;
            newNode.back = null;
            if (first == null) {
                first = newNode;
                last = newNode;
            }
            else {
                first.back = newNode;
                newNode.next = first;
                first = newNode;
            }
            count++;
            current = current.back;
        }
    }

    // create a reversed copy
    public void reversedCopy(DoubleLinkedList<T> otherList) {
        initializeList();
        DoubleLinkedListNode<T> current = otherList.first;
        for (int i = 0; i < otherList.count; i++) {
            DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>();
            newNode.info = current.info;
            newNode.next = null;
            newNode.back = null;
            if (first == null) {
                first = newNode;
                last = newNode;
            }
            else {
                first.back = newNode;
                newNode.next = first;
                first = newNode;
            }
            count++;
            current = current.next;
        }
    }
}