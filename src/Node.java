import java.util.ArrayList;

public class Node {
    int id;
    ArrayList<Node> adjacents;

    static int counter = 1;

    Node()
    {
        this.id = counter++;
    }

    public void addAdjacent(Node adjacent)
    {
        if (adjacent == null)
            return;
        adjacents.add(adjacent);
    }
}
