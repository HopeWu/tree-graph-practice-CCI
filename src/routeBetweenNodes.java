public class routeBetweenNodes {
    public static void main(){
        Graph graph = new Graph();

        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();

        graph.addEdge(1,5);
        graph.addEdge(5,4);
        graph.addEdge(7,5);
        graph.addEdge(4,2);
        graph.addEdge(2,7);
        graph.addEdge(2,3);
        graph.addEdge(3,6);


    }
}
