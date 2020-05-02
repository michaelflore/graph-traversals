public class GraphNode<T> {
    //Fields
    private T value;
    private GraphNode<T> firstLink;
    private GraphNode<T> secondLink;
    private GraphNode<T> thirdLink;
    private GraphNode<T> next;
    private boolean visited;

    //Default constructor
    public GraphNode() {
        value = null;
        firstLink = null;
        secondLink = null;
        thirdLink = null;
        next = null;
        visited = false;
    }

    //Overloaded constructor
    public GraphNode(T val) {
        value = val;
        firstLink = null;
        secondLink = null;
        thirdLink = null;
        next = null;
        visited = false;
    }

    public GraphNode(GraphNode<T> node) {
        value = node.getValue();
        firstLink = node.getFirstLink();
        secondLink = node.getSecondLink();
        thirdLink = node.getThirdLink();
        visited = node.getVisited();
    }

    //Returns value of node
    public T getValue() {
        return value;
    }

    //Returns first link of node
    public GraphNode<T> getFirstLink() {
        return firstLink;
    }

    //Returns second link of node
    public GraphNode<T> getSecondLink() {
        return secondLink;
    }

    //Returns third link of node
    public GraphNode<T> getThirdLink() {
        return thirdLink;
    }

    public GraphNode<T> getNext() {
        return next;
    }

    //Returns if the node has been visited or not
    public boolean getVisited() {
        return visited;
    }

    //Sets value of node
    public void setValue(T val) {
        value = val;
    }

    //Sets first link of node
    public void setFirstLink(GraphNode<T> next) {
        firstLink = next;
    }

    //Sets second link of node
    public void setSecondLink(GraphNode<T> next) {
        secondLink = next;
    }

    //Sets third link of node
    public void setThirdLink(GraphNode<T> next) {
        thirdLink = next;
    }

    public void setNext(GraphNode<T> n) {
        next = n;
    }

    //Sets boolean value for visited
    public void setVisited(boolean v) {
        visited = v;
    }
}
