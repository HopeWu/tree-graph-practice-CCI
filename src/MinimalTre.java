import java.util.LinkedList;
import java.util.Queue;

public class MinimalTre {

    public static void main(String []args){
        int arr[] =  {1,2,4,5,7,9,10,11};

        MinimalTre minimalTre = new MinimalTre();

        minimalTre.buildTree(arr);
    }

    Node buildTree(int [] arr){
        int end = arr.length - 1;
        Pair p = new Pair(0, end);
        Queue<Pair> queue = new LinkedList<>();
        queue.add(p);

        Node root = null;
        boolean flag = true;
        while(!queue.isEmpty()){
            Pair pair = queue.remove();
            // if the pair is null continue
            if (pair == null) {
                continue;
            }

            Node node = new Node();
            if (flag){
                // the node is the root of the tree then save it to root
                root = node;
                flag = false;
            }

            // if there is a root of the current node, make a link for them
            if(pair.root != null){
                pair.root.addAdjacent(node);
            }

            if (pair.start == pair.end){
                // if the start and end is the same, the current node is a node instead of a tree
                node.id = pair.start;
            }else if (pair.start < pair.end)
            {
                /*
                if the start and end are different, the current node is a tree
                 */

                // first save the mid element in the current node(root) of this tree
                int mid = (pair.start + pair.end)/2;

                // resolve the descendants
                queue.add(new Pair(node, pair.start, mid));
                queue.add(new Pair(node, mid+1, pair.end));
            }
        }
        return root;
    }
}
