public class StackLinkedList<T> {

    private GraphNode<T> stackTop;

    public StackLinkedList() {
        stackTop = null;
    }

    //Overloaded constructor
    public StackLinkedList(GraphNode<T> top) {
        stackTop = top;
    }

    //Sets top of stack
    public void setTop(GraphNode<T> top) {
        stackTop = top;
    }

    //Retrieves top of stack
    public GraphNode<T> getTop() {
        return stackTop;
    }

    //Checks if stack is empty
    public boolean isEmpty() {
        if(stackTop == null) {
            return true;
        }
        return false;
    }

    //Throws EmptyStackException if stack is empty
    public void ifEmpty() throws EmptyStackException {
        if(this.isEmpty()) {
            throw new EmptyStackException();
        }
    }

    //Adds to stack
    public void push(GraphNode<T> root) {
        if(this.isEmpty()) {
            setTop(root);
        }
        else {
            GraphNode<T> newTop = root;
            newTop.setNext(getTop());
            setTop(newTop);
        }
    }

    //Shows value of top node in stack
    public GraphNode<T> peek() throws EmptyStackException {
        ifEmpty();
        return getTop();
    }

    //Removes top node in stack
    public void pop() throws EmptyStackException {
        ifEmpty();
        setTop(getTop().getNext());
    }
}
