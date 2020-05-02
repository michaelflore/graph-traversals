public class GraphDemo {
    public static void main(String[] args) {
        Graph stack = new Graph();
        GraphNode<String> root = stack.createGraph();
        stack.depthFirstTraversal(root);

        Graph queue = new Graph();
        GraphNode<String> root2 = queue.createGraph();
        queue.breadthFirstTraversal(root2);
    }
}
