import java.util.*;

public class BuildOrder {

    static public void main(String[] args){
        BuildOrder buildOrder = new BuildOrder();
        ArrayList<Node> projects = buildOrder.initilize();

//        OneApproach oneApproach = new OneApproach();
//        ArrayList<Node> order = oneApproach.run(projects);
//        AnotherApproach anotherApproach = new AnotherApproach();
        AnotherApproach anotherApproach = new ImprovedAnotherApproach();
        ArrayList<Node> order = anotherApproach.run(projects);
        order.forEach((node -> print(node.data)));
    }

    static class OneApproach{
        public ArrayList<Node> run(ArrayList<Node> projects){
            ArrayList<Node> starters = getStarters(projects);

            return null;
        }

        private ArrayList<Node> oneApproach(ArrayList<Node> projects){
            Hashtable<String, Integer> hashtable = new Hashtable<>();
            ArrayList<Node> starters = new ArrayList<>();
            return null;
        }
    }
    static class ImprovedAnotherApproach extends AnotherApproach{
        private ArrayList<Node> run(ArrayList<Node> projects){
            ArrayList<Node> starters = getStarters(projects);
            for (Node node: starters){
                dfs(node);
            }
            ArrayList<Node> result = new ArrayList<>();
            while(!stack.isEmpty()) result.add(stack.pop());
            return result;
        }

        private void dfs(Node node){
            ArrayList<Node> adjacents = node.adjacents;
            if (adjacents.isEmpty()){
                stack.push(node);
            }else{
                for (Node node1: adjacents){
                    dfs(node1);
                }
                stack.push(node);
            }
        }
    }

    static class AnotherApproach{
        protected Stack<Node> stack = new Stack<>();

        private ArrayList<Node> run(ArrayList<Node> projects)
        {
            Hashtable<Node, Integer> hashtable = new Hashtable<>();
            // initialize the hashtable
            projects.forEach((node -> initHash(node, hashtable)));
            while (!hashtable.isEmpty()){
                Set<Node> keys = hashtable.keySet();
                for (Node key: keys){
                    dfs(key, hashtable);
                    break;
                }
            }

            ArrayList<Node> result = new ArrayList<>();
            while(!stack.isEmpty()) result.add(stack.pop());
            return result;
        }

        void initHash(Node node, Hashtable<Node, Integer> hashtable){
            hashtable.put(node, 1);
        }

        private void dfs(Node node, Hashtable<Node, Integer> hashtable){
            ArrayList<Node> adjacents = node.adjacents;
            if (adjacents.isEmpty()){
                hashtable.remove(node);
                stack.push(node);
            }else{
                for (Node n: adjacents){
                    if (hashtable.get(n) != null)
                        dfs(n, hashtable);
                }
                // delete the links starting from node
                node.adjacents.removeAll(node.adjacents);
                hashtable.remove(node);
                stack.push(node);
            }
        }
    }
    static private ArrayList<Node> getStarters(ArrayList<Node> projects){
        Hashtable<Node, Integer> hashtable = new Hashtable<>();
        for (Node node: projects){
            hashtable.put(node, 0);
        }
        for (Node node: projects){
            for( Node n: node.adjacents){
                hashtable.put(n, 1);
            }
        }

        hashtable.values().removeAll(Collections.singleton(1));
        return new ArrayList<>(hashtable.keySet());
    }

    static public void print(Object obj){
        System.out.println(obj);
    }

    public ArrayList<Node> initilize(){
        ArrayList<Node> projects = new ArrayList<>();
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        projects.add(a);
        projects.add(b);
        projects.add(c);
        projects.add(d);
        projects.add(e);
        projects.add(f);

        f.adjacents.add(b);
        f.adjacents.add(a);
        a.adjacents.add(d);
        b.adjacents.add(d);
        d.adjacents.add(c);

        return projects;
    }

    static class Node{
        String data = null;
        public ArrayList<Node> adjacents = new ArrayList<>();

        Node(Node node){
            this.data = node.data;
            this.adjacents.addAll(node.adjacents);
        }
        
        Node(String data){
            this.data = data;
        }

        public void addAdjacent(Node node){
            if (node != null)
                this.adjacents.add(node);
        }
    }
}
