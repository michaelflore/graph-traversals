public class Graph {

    public Graph() {
        //Just for instantiation
    }

    //Creates graph of australian cities, returns root to use in traversals
    public GraphNode<String> createGraph() {
        GraphNode<String> sydney = new GraphNode<String>("Sydney");
        GraphNode<String> brisbane = new GraphNode<String>("Brisbane");
        GraphNode<String> canberra = new GraphNode<String>("Canberra");
        GraphNode<String> adelaide = new GraphNode<String>("Adelaide");
        GraphNode<String> melbourne = new GraphNode<String>("Melbourne");
        GraphNode<String> perth = new GraphNode<String>("Perth");
        GraphNode<String> hobart = new GraphNode<String>("Hobart");
        GraphNode<String> blackStump = new GraphNode<String>("Black Stump");
        GraphNode<String> darwin = new GraphNode<String>("Darwin");

        //Sydney points to Canberra and Melbourne
        sydney.setFirstLink(canberra);
        sydney.setSecondLink(melbourne);

        //Canberra points to Brisbane, Sydney, and Adelaide
        canberra.setFirstLink(brisbane);
        canberra.setSecondLink(sydney);
        canberra.setThirdLink(adelaide);

        //Brisbane points to Sydney
        brisbane.setFirstLink(sydney);

        //Melbourne points to Canberra and Hobart
        melbourne.setFirstLink(canberra);
        melbourne.setSecondLink(hobart);

        //Hobart points to Melbourne
        hobart.setFirstLink(melbourne);

        //Adelaide points to Melbourne and Perth
        adelaide.setFirstLink(melbourne);
        adelaide.setSecondLink(perth);

        //Perth points to Black Stump
        perth.setFirstLink(blackStump);

        //Black Stump points to Darwin
        blackStump.setFirstLink(darwin);

        //Darwin points to Canberra
        darwin.setFirstLink(canberra);

        return sydney;

    }

    //Returns unvisited nodes only
    private GraphNode<String> getUnvisitedNode(GraphNode<String> source) {
        //Max 3 links in given graph, so check all of them

        //Check first link, return if not visited
        if(source.getFirstLink() != null) {
            if(!source.getFirstLink().getVisited()) {
                return source.getFirstLink();
            }
        }
        //Check second link, return if not visited
        if(source.getSecondLink() != null) {
            if(!source.getSecondLink().getVisited()) {
                return source.getSecondLink();
            }
        }
        //Check third link, return if not visited
        if(source.getThirdLink() != null) {
            if(!source.getThirdLink().getVisited()) {
                return source.getThirdLink();
            }
        }
        //If all links are null and/or visited, return null
        return null;
    }

    //Depth first traversal
    public void depthFirstTraversal(GraphNode<String> root) {
        System.out.println("DEPTH FIRST TRAVERSAL\n----------------------------");

        StackLinkedList<String> dfs = new StackLinkedList<String>();
        dfs.push(root);
        root.setVisited(true);
        System.out.println(root.getValue());

        while(!dfs.isEmpty()) {
            GraphNode<String> source = dfs.peek();
            GraphNode<String> destination = getUnvisitedNode(source);
            if(destination != null) {
                destination.setVisited(true);
                System.out.println(destination.getValue());
                dfs.push(destination);
            }
            else {
                dfs.pop();
            }
        }
    }

    //Breadth first traversal
    public void breadthFirstTraversal(GraphNode<String> root) {
        System.out.println("\nBREADTH FIRST TRAVERSAL\n----------------------------");

        QueueLinkedList<String> bfs = new QueueLinkedList<String>();
        bfs.enqueue(root);
        root.setVisited(true);
        System.out.println(root.getValue());

        while(!bfs.isEmpty()) {
            GraphNode<String> source = bfs.dequeue();
            GraphNode<String> destination = null;

            while((destination = getUnvisitedNode(source)) != null) {
                destination.setVisited(true);
                System.out.println(destination.getValue());
                bfs.enqueue(destination);
            }
        }
    }
}
