public class ValidateBST {
    public static void main(String[] args) {
        ValidateBST vbst = new ValidateBST();

        BinNode node = vbst.initializeTree();
        try {
            int max = vbst.maxOf(node);
            System.out.println("This is a BST.");
        }catch (ViolateBfsException e){
            System.out.println(e);
        }catch (NullTreeException e){
            System.out.println(e);
        }
    }

    private int maxOf(BinNode tree) throws ViolateBfsException, NullTreeException{
        if(tree == null) throw new NullTreeException("The input tree is null.");

        if(tree.left != null) {
            int maxFromLeft = maxOf(tree.left);
            if (maxFromLeft > tree.data) {
                throw new ViolateBfsException("Violated BFS rule. Left tree has greater element than the root of that. " +
                        maxFromLeft + " is greater than " + tree.data);
            }
        }

        if(tree.right != null) {
            int maxFromRight = maxOf(tree.right);
            if (tree.data > maxFromRight) {
                throw new ViolateBfsException("Violated BFS rule. Right tree has greater element than the root of that. " +
                        tree.data + " is greater than " + maxFromRight);
            }

            return maxFromRight;
        }else{
            return tree.data;
        }
    }

    private class NullTreeException extends Exception
    {
        public NullTreeException(String errorMessage){
            super(errorMessage);
        }
    }

    private class ViolateBfsException extends Exception
    {
        public ViolateBfsException(String errorMessage) {
            super(errorMessage);
        }
    }

    private BinNode initializeTree() {
        BinNode n1 = new BinNode(1);
        BinNode n2 = new BinNode(2);
        BinNode n3 = new BinNode(3);
        BinNode n4 = new BinNode(4);
        BinNode n5 = new BinNode(5);
        BinNode n6 = new BinNode(6);
        BinNode n7 = new BinNode(7);
        BinNode n8 = new BinNode(8);
        BinNode n9 = new BinNode(9);
        BinNode n10 = new BinNode(10);
        BinNode n11 = new BinNode(11);


        n6.setLeft(n3);
        n3.setLeft(n4);
        n2.setLeft(n1);
        n3.setRight(n5);
        //n5.setLeft(n4);

        n6.setRight(n8);
        n8.setLeft(n7);
        n8.setRight(n9);
        n9.setRight(n10);
        n10.setRight(n11);


        return n6;
    }
}
