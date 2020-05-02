public class QueueLinkedList<T>
{
    //Fields
    private GraphNode<T> current;
    private GraphNode<T> last;

    //Default Constructor
    public QueueLinkedList() {
        current = null;
        last = null;
    }

    //Checks if queue is empty
    public boolean isEmpty() {
        return (current == null);
    }

    //Checks if queue is full
    public boolean isFull() {
        return (current == last);
    }

    //Adds item to back of queue
    public void enqueue(GraphNode<T> node) {
        GraphNode<T> temp = new GraphNode<T>(node);
        if(last == null) {
            current = last = temp;
        }
        else {
            last.setNext(temp);
            last = temp;
        }
    }

    //Removes item from front of queue
    public GraphNode<T> dequeue() throws QueueUnderflowException {
        if(current == null) {
            throw new QueueUnderflowException("Heap underflow");
        }

        GraphNode<T> temp = current;
        current = current.getNext();

        if(current == null) {
            last = null;
        }

        return temp;
    }
}
