import java.util.ArrayList;

public class Node {
    int id;
    boolean isVisited;
    ArrayList<Node> adjacents = new ArrayList<>();

    static int counter = 1;

    Node()
    {
        this.id = counter++;
    }
    Node(int n){
        this.id = n;
    }

    public void addAdjacent(Node adjacent)
    {
        if (adjacent == null)
            return;
        adjacents.add(adjacent);
    }
}
