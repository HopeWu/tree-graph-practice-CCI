public class BSTSequences {

    /*
    m = m
    n = n+1
     */
    public static void main(String[] args){
        BSTSequences bstSequences = new BSTSequences();
        ValidateBST.BinNode root = bstSequences.initializeTree();
        //BuildOrder.print(bstSequences.numberOfNodes(root));
        BuildOrder.print(bstSequences.merge(2,3));
    }

    Result numberOfNodes(ValidateBST.BinNode tree){
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
            noCombinations *= merge(leftLength, rightLength+1);
        return new Result(length, noCombinations);
    }

    /*
    @param m
    @param n = n + 1
     */
    int merge(int m, int n){
        if ( m == 1) return n;
        int sum = 0;
        while (n > 0){
            sum += merge(m-1, n);
            n -= 1;
        }
        return sum;
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

        n6.setLeft(n3); n3.setParent(n6);

        n2.setLeft(n1); n1.setParent(n2);
        n3.setLeft(n2); n2.setParent(n3);
        n3.setRight(n5); n5.setParent(n3);

        n5.setLeft(n4); n4.setParent(n5);
//        n3.setLeft(n4); n4.setParent(n3);

        n6.setRight(n8); n8.setParent(n6);
        n8.setLeft(n7); n7.setParent(n8);
        n8.setRight(n9); n9.setParent(n8);
        n9.setRight(n10); n10.setParent(n9);
        n10.setRight(n11); n11.setParent(n10);

        return n6;
    }

    class Result{
        public int length = 0;
        public int count = 0;

        Result(int length, int count){
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
}
