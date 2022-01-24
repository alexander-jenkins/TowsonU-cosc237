//Class: LinkedStackClass implements
//Interface: StackADT 
//Linked list implementation 
public class LinkedStackClass<T> implements StackADT<T> {
    //Node Definition: inner class StackNode
    private class StackNode<T> {
        public T info;
        public StackNode<T> link;

        //Default constructor
        public StackNode() {
            info = null;
            link = null;
        }
        //Alternate constructor 
        public StackNode(T value, StackNode<T> ptr)  {
            info = value;
            link = ptr;
        }

        public String toString() {
            return info.toString();
        }
    }

    //Instance variable for class LinkedStackClass
    private StackNode<T> stackTop; //reference variable to top

    //Default constructor
    public LinkedStackClass() {
        stackTop = null;
    }

    public void initializeStack() {
        stackTop = null;
    }

    public boolean isEmptyStack() {
        return (stackTop == null);
    }

    public boolean isFullStack() {
        return false;
    }

    public T peek() {
        if (stackTop == null)  System.err.println("No top - the stack is empty!");
        return stackTop.info;
    }
    
    public void push(T newValue)  {
        StackNode<T> newNode; //reference variable to create the new node
        newNode = new StackNode<T>(newValue, stackTop); 
        stackTop = newNode; 
    } 
   
    public void pop() {
        if (stackTop == null)
            System.err.println("Cannot pop from an empty stack!");
        else
            stackTop = stackTop.link; 
    }

    // methods for Lab 11

    // print the stack in order
    public void printStack() {
        // init the temp stack
        Integer stackItem;
        LinkedStackClass<Integer> temp = new LinkedStackClass<Integer>();

        // copy to temp -- reverses the stack
        while (!isEmptyStack()) {
            stackItem = (Integer)peek();
            temp.push(stackItem);
            pop();
        }

        // return stack to original state and print
        while (!temp.isEmptyStack()) {
            stackItem = temp.peek();
            System.out.print(stackItem + " ");
            push((T)stackItem);
            temp.pop();
        }
        System.out.println();
    }

    // prints the stack in reverse order
    public void printBackStack() {
        // init the temp stack
        Integer stackItem;
        LinkedStackClass<Integer> temp = new LinkedStackClass<>();

        // copy to temp -- reverses the stack and prints
        while (!isEmptyStack()) {
            stackItem = (Integer)peek();
            System.out.print(stackItem + " ");
            temp.push(stackItem);
            pop();
        }

        // return stack to original state
        while (!temp.isEmptyStack()) {
            stackItem = temp.peek();
            push((T)stackItem);
            temp.pop();
        }
        System.out.println();
    }

    // returns the second item of the stack
    public Integer getSecond() {
        // determine if there is a second node or not
        if (stackTop.link == null) {
            System.out.print("Error, there is no second item: ");
            return -999;
        }
        else {
            // return the info of the second node
            return (Integer)stackTop.link.info;
        }
    }

    // counts the stacks items
    public int countItems() {
        // count the stack
        int count;
        StackNode<T> traverser = new StackNode<>(stackTop.info, stackTop.link);
        if (traverser.info != null) count = 1;
        else return 0;
        while (traverser.link != null) {
            count++;
            traverser = traverser.link;
        }
        return count;
    }

    // delete all occurrences of an item
    public void removeItem(int toDelete) {
        // find links to remove
        StackNode<T> traverser = new StackNode<>(stackTop.info, stackTop.link);
        if (!isEmptyStack() && ((int)stackTop.info == toDelete)) initializeStack();
        else {
            while (traverser.link != null) {
                if ((int)traverser.info == toDelete) traverser.link = traverser.link;
            }
        }
    }
}