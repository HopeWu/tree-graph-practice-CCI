import java.util.ArrayList;
import java.util.LinkedList;

public abstract class BSTSequences {

    public static void main(String[] args) {
        MethodOne methodOne = new MethodOne();
        BuildOrder.print(methodOne.run());

        //BuildOrder.print(bstSequences.numberOfNodes(root));
//        MethodOne methodOne = bstSequences.new MethodOne(root);
//        BuildOrder.print(methodOne.run());
    }

    ValidateBST.BinNode tree = null;

    BSTSequences(){
        this.tree = initializeTree();
    }

    abstract Result run();

    static class MethodTwo extends BSTSequences{
        MethodTwo(){
            super();
        }

        public Result run(){
            return null;
        }

        void allSequences(ValidateBST.BinNode root, ArrayList<LinkedList<ValidateBST.BinNode>> results){

            if (root == null) return;

            LinkedList<ValidateBST.BinNode> prefix = new LinkedList<>();
            prefix.addLast(root);
            ArrayList<LinkedList<ValidateBST.BinNode>> rightResults = null;
            ArrayList<LinkedList<ValidateBST.BinNode>> leftResults = null;

            if (root.left == null && root.right == null){
                results.add(prefix);
                return;
            }

            if (root.left != null){
                leftResults = new ArrayList<>();
                allSequences(root.left, leftResults);
            }

            if (root.right != null){
                rightResults = new ArrayList<>();
                allSequences(root.right, rightResults);
            }

            if(root.right == null || root.left == null){
                if(root.right ==null){
                    for (LinkedList<ValidateBST.BinNode> list: leftResults){
                        list.addFirst(root);
                    }
                    results.addAll(leftResults);
                    return;
                }else{
                    for (LinkedList<ValidateBST.BinNode> list: rightResults){
                        list.addFirst(root);
                    }
                    results.addAll(rightResults);
                    return;
                }
            }

            // merge left and right
            for (LinkedList<ValidateBST.BinNode> left : leftResults){
                for (LinkedList<ValidateBST.BinNode> right : rightResults){
                    results.addAll(merge(left, right, prefix));
                }
            }
        }

        ArrayList<LinkedList<ValidateBST.BinNode>> merge(LinkedList<ValidateBST.BinNode> left,
                                                         LinkedList<ValidateBST.BinNode> right,
                                                         LinkedList<ValidateBST.BinNode> prefix)
        {
            ArrayList<LinkedList<ValidateBST.BinNode>> results = new ArrayList<>();
            if (left.isEmpty() || right.isEmpty()){
                LinkedList<ValidateBST.BinNode> result = (LinkedList<ValidateBST.BinNode>) prefix.clone();
                result.addAll(left);
                result.addAll(right);
                results.add(result);
                return results;
            }

            ValidateBST.BinNode leftFirst = left.removeFirst();
            prefix.addLast(leftFirst);
            results.addAll(merge(left, right, prefix));
            left.addFirst(leftFirst);

            prefix.removeLast();

            ValidateBST.BinNode rightFirst = right.removeFirst();
            prefix.addLast(leftFirst);
            results.addAll(merge(left, right, prefix));
            right.addFirst(rightFirst);

            return results;
        }
    }

    static class MethodOne extends BSTSequences{
        MethodOne(){
            super();
        }

        public Result run(){
            return numberOfNodes(tree);
        }

        Result numberOfNodes(ValidateBST.BinNode tree) {
            if (tree == null) return null;
            int length = 1;
            int leftLength = 0;
            int rightLength = 0;
            int noCombinations = 1;
            if (tree.left != null) {
                Result leftRe = numberOfNodes(tree.left);
                leftLength += leftRe.length;
                noCombinations *= leftRe.count;
            }
            if (tree.right != null) {
                Result rightRe = numberOfNodes(tree.right);
                rightLength += rightRe.length;
                noCombinations *= rightRe.count;
            }
            length += leftLength;
            length += rightLength;
            if (leftLength >= 1 & rightLength >= 1)
                noCombinations *= merge(leftLength, rightLength + 1);
            return new Result(length, noCombinations);
        }

        /*
        @param m
        @param n = n + 1
        */
        int merge(int m, int n) {
            if (m == 1) return n;
            int sum = 0;
            while (n > 0) {
                sum += merge(m - 1, n);
                n -= 1;
            }
            return sum;
        }
    }

    class Result {
        public int length = 0;
        public int count = 0;

        Result(int length, int count) {
            this.length = length;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "length=" + length +
                    ", count=" + count +
                    '}';
        }
    }

    private ValidateBST.BinNode initializeTree() {
        ValidateBST.BinNode n1 = new ValidateBST.BinNode(1);
        ValidateBST.BinNode n2 = new ValidateBST.BinNode(2);
        ValidateBST.BinNode n3 = new ValidateBST.BinNode(3);
        ValidateBST.BinNode n4 = new ValidateBST.BinNode(4);
        ValidateBST.BinNode n5 = new ValidateBST.BinNode(5);
        ValidateBST.BinNode n6 = new ValidateBST.BinNode(6);
        ValidateBST.BinNode n7 = new ValidateBST.BinNode(7);
        ValidateBST.BinNode n8 = new ValidateBST.BinNode(8);
        ValidateBST.BinNode n9 = new ValidateBST.BinNode(9);
        ValidateBST.BinNode n10 = new ValidateBST.BinNode(10);
        ValidateBST.BinNode n11 = new ValidateBST.BinNode(11);

        n6.setLeft(n3);
        n3.setParent(n6);

        n2.setLeft(n1);
        n1.setParent(n2);
        n3.setLeft(n2);
        n2.setParent(n3);
        n3.setRight(n5);
        n5.setParent(n3);

        n5.setLeft(n4);
        n4.setParent(n5);
//        n3.setLeft(n4); n4.setParent(n3);

        n6.setRight(n8);
        n8.setParent(n6);
        n8.setLeft(n7);
        n7.setParent(n8);
        n8.setRight(n9);
        n9.setParent(n8);
        n9.setRight(n10);
        n10.setParent(n9);
        n10.setRight(n11);
        n11.setParent(n10);

        return n6;
    }
}
