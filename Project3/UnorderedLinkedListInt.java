//Class: UnorderedLinkedListInt extends
//Class: LinkedListIntClass
public class UnorderedLinkedListInt extends LinkedListIntClass {
    //Default constructor
    public UnorderedLinkedListInt() {
        super();
    }

    public boolean search(int searchItem)  {
        LinkedListNode current; //variable to traverse the list
        current = first;
        while (current != null)
            if (current.info == searchItem)
                return true;
            else
                current = current.link;
        return false;
    }

    public void insertFirst(int newItem) {
        LinkedListNode newNode;  //variable to create the new node
        //create and insert newNode before first
        newNode = new LinkedListNode(newItem, first);
        first = newNode;
        if (last == null)
            last = newNode;
        count++;
    }

    public void insertLast(int newItem)  {
        LinkedListNode newNode; //variable to create the new node
        //create newNode
        newNode = new LinkedListNode(newItem, null);
        if (first == null) {
            first = newNode;
            last = newNode;
        }
        else {
            last.link = newNode;
            last = newNode;

        }
        count++;
    }

    public void deleteNode(int deleteItem) {
        LinkedListNode current; //variable to traverse the list
        LinkedListNode trailCurrent; //variable just before current
        boolean found;
        //Case 1; the list is empty
        if ( first == null)
            System.err.println("Cannot delete from an empty list.");
        else {
            //Case 2: the node to be deleted is first
            if (first.info == deleteItem) {
                first = first.link;
                if (first == null)  //the list had only one node
                    last = null;
                count--;
            }
            else {  //search the list for the given info
                found = false;
                trailCurrent = first; //trailCurrent points to first node
                current = first.link; //current points to second node
                while (current != null && !found) {
                    if (current.info == deleteItem)
                        found = true;
                    else {
                        trailCurrent = current;
                        current = current.link;
                    }
                }
                //Case 3; if found, delete the node
                if (found) {
                    count--;
                    trailCurrent.link = current.link;
                    if (last == current)  //node to be deleted was the last node
                        last = trailCurrent;
                }
                else
                    System.out.println("Item to be deleted is not in the list.");
            }
        }
    }

    public void merge1 (UnorderedLinkedListInt list) {
        // setup the node to traverse list
        LinkedListNode current = list.first;

        // append the linked list
        while (current.link != null) {
            insertLast(current.info);
            current = current.link;
            length();
        }
        insertLast(current.info);

    }

    public UnorderedLinkedListInt merge2(UnorderedLinkedListInt list) {
        // set up currentOrig and create the new list
        UnorderedLinkedListInt result = new UnorderedLinkedListInt();
        LinkedListNode currentOrig = first;
        LinkedListNode currentOther = list.first;


        // copy the original list into the result
        while (currentOrig.link != null) {
            result.insertLast(currentOrig.info);
            currentOrig = currentOrig.link;
        }
        if (currentOrig == last) {
            result.insertLast(currentOrig.info);
        }

        // copy the second list into the result
        while (currentOther.link != null) {
            result.insertLast(currentOther.info);
            currentOther = currentOther.link;
        }
        if (currentOther == list.last) {
            result.insertLast(currentOther.info);
        }


        // return the new list
        return result;
    }

    public void split (UnorderedLinkedListInt list1, UnorderedLinkedListInt list2, int key) {
        // set up the node to traverse the list(s)
        LinkedListNode current = first;
        LinkedListNode currentList1 = list1.first;
        LinkedListNode currentList2 = list2.first;

        // clear list one
        do {
            list1.deleteNode(currentList1.info);
            currentList1 = currentList1.link;
        } while (currentList1.link != null);
        list1.deleteNode(currentList1.info);

        // clear list 2
        do {
            list2.deleteNode(currentList2.info);
            currentList2 = currentList2.link;
        } while (currentList2.link != null);
        list2.deleteNode(currentList2.info);

        // split the linked list between list1 and list2 at key
        while (current.link != null) {
            if (current.info <= key) list1.insertLast(current.info);
            else list2.insertLast(current.info);
            current = current.link;
        }

        // place the last value in the correct location
        if (current.info <= key) list1.insertLast(current.info);
        else list2.insertLast(current.info);

    }
}
