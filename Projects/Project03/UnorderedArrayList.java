//Class: UnorderedArrayList extends
//Super class: ArrayListClass
public class UnorderedArrayList extends ArrayListClass {

    public UnorderedArrayList() {
        super();
    }

    public UnorderedArrayList(int size) {
        super(size);
    }

    //Bubble Sort
    public void bubbleSort() {
        for (int pass = 0; pass < length - 1; pass++) {
            for (int i = 0; i < length - 1; i++) {
                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                }
            }
        }
    }

    //implementation for abstract methods defined in ArrayListClass
    //unordered list --> linear search
    public int search(int searchItem) {
        for(int i = 0; i < length; i++)
            if(list[i] == searchItem)
                return i;
        return -1;
    }

    public void insertAt(int location, int insertItem) {
        if (location < 0 || location >= maxSize)
            System.err.println("The position of the item to be inserted is out of range.");
        else if (length >= maxSize)
            System.err.println("Cannot insert in a full list.");
        else {
            for (int i = length; i > location; i--)
                list[i] = list[i - 1];  //shift right
            list[location] = insertItem;
            length++;
        }
    }

    public void insertEnd(int insertItem) {
        if (length >= maxSize)
            System.err.println("Cannot insert in a full list.");
        else {
            list[length] = insertItem;
            length++;
        }
    }

    public void replaceAt(int location, int repItem)  {
        if (location < 0 || location >= length)
            System.err.println("The location of the item to be replaced is out of range.");
        else
            list[location] = repItem;
    }

    public void remove(int removeItem) {
        int i;
        if (length == 0)
            System.err.println("Cannot delete from an empty list.");
        else {
            i = search(removeItem);
            if (i != -1)
                removeAt(i);
            else
                System.out.println("Cannot delete! The item to be deleted is not in the list.");
        }
    }

    // merge two lists into a single result
    public UnorderedArrayList merge(UnorderedArrayList list) {
        // create the resulting list
        UnorderedArrayList result = new UnorderedArrayList();

        // merge the two lists into result
        for(int i = 0; i < length; i++) result.insertEnd(retrieveAt(i));
        for(int j = 0; j < list.length; j++) result.insertEnd(list.retrieveAt(j));

        return result;
    }

    // split one list into two separate lists
    public void split(UnorderedArrayList list_1, UnorderedArrayList list_2, int key) {
        // clear the lists to be filled
        list_1.clearList();
        list_2.clearList();

        // split the main list into two
        int num;
        for(int i = 0; i < length; i++) {
            num = retrieveAt(i);
            if (num <= key) list_1.insertEnd(num);
            else list_2.insertEnd(num);
        }
    }
}

