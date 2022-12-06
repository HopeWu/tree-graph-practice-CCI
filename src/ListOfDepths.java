public class ListOfDepths {
     public static void main(String [] args){
         // initialize a tree

         ListOfDepths listOfDepths = new ListOfDepths();
         BinNode root = listOfDepths.initializeTree();
    }

    public BinNode initializeTree(){
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

        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n4.setLeft(n6);
        n4.setRight(n7);
        n5.setLeft(n8);
        n5.setRight(n9);
        n7.setLeft(n10);
        n9.setLeft(n11);

        return n1;
    }
}
