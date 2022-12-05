import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    static ArrayList<Integer> bfs(Node tree){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Queue<Node> queue = new LinkedList<>();
        if (tree != null)
        {
            queue.add(tree);
        }

        Node node = null;
        while(!queue.isEmpty()){
            node = queue.remove();
            if (node == null){
                continue;
            }
            arr.add(node.id);

            queue.add(tree.adjacents.get(0));
            queue.add(tree.adjacents.get(1));
        }
        return arr;
    }
}
