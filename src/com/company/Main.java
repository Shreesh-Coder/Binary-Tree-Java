package com.company;



public class Main {

    public static void main(String[] args) {
//        testBT();
//        testLeftPrint();
        testNaryTreeNodeAr();
    }

    public static void testBT(){
        Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));
        root.getLeft().setLeft(new Node(4));
        root.getLeft().setRight(new Node(5));
        /*
               1
              / \
             2   3
            / \
           4   5
        * */
        BinaryTree bt = new BinaryTree(root);
        System.out.print("InOrder print is: ");
        bt.printInOrder(root);
        System.out.print("\nPreOrder print is: ");
        bt.printPreOrder(root);
        System.out.print("\nPostOrder print is: ");
        bt.printPostOrder(root);
        System.out.print("\nLevelOrder print is: ");
        bt.printLevelOrder();
        System.out.print("\nLeft view print is: ");
        bt.printLeftNodes(root);

        System.out.println("\nSize of the tree is: " + bt.size(root));
        System.out.println("Maximum value of the node is: " + bt.maximum(root));
        System.out.println("Minimum value of the node is: " + bt.minimum(root));

    }

    public static void testLeftPrint(){
        Node root = new Node(4);
        root.setLeft(new Node(5));
        root.setRight(new Node(2));
        root.getRight().setLeft(new Node(3));
        root.getRight().setRight(new Node(1));
        root.getRight().getLeft().setLeft(new Node(6));
        root.getRight().getLeft().setRight(new Node(7));

        BinaryTree bt = new BinaryTree(root);

        System.out.print("\nLeft node print is: ");
        bt.printLeftNodes(root);

        Node root1 = new Node(1);
        root1.setLeft(new Node(2));
        root1.setRight(new Node(3));
        root1.getLeft().setLeft(new Node(4));
        root1.getLeft().setRight(new Node(5));
        root1.getRight().setRight(new Node(6));
        /*
                 1
               /   \
              2     3
             / \     \
            4   5     6
        * */

        System.out.print("\nLeft node print is: ");
        bt.printLeftNodes(root1);

        Node root2 = new Node(1);
        root2.setLeft(new Node(2));
        root2.setRight(new Node(3));
        root2.getLeft().setRight(new Node(4));
//        root2.getLeft().setLeft(new Node(7));
        root2.getLeft().getRight().setRight(new Node(5));
        root2.getLeft().getRight().getRight().setRight(new Node(6));

        /*
            1
          /   \
        2       3
          \
            4
              \
                5
                 \
                   6
        * */
        System.out.print("\nLeft node print is: ");
        bt.printLeftNodes(root2);
        System.out.print("\nLeft view print is: ");
        bt.printLeftView(root2);
        System.out.print("\nLeft view print Queue is: ");
        bt.printLeftViewQueue(root);
        System.out.print("\nDiameter of tree is: " +  bt.diameter(root));
        System.out.print("\nDiameter of tree Opt is: " +  bt.diameterOpt(root2));
        System.out.print("\nDiameter of tree New is: " +  bt.diameterNew(root2));
    }

    public static void testNaryTreeNodeFN(){
        NaryTree.NodeFN<Character> root = new NaryTree.NodeFN<>('A');
        //Layer 2
        root.firstChild = new NaryTree.NodeFN<>('B');
        root.firstChild.nextSibling = new NaryTree.NodeFN<>('F');
        root.firstChild.nextSibling.nextSibling = new NaryTree.NodeFN<>('D');
        root.firstChild.nextSibling.nextSibling.nextSibling = new NaryTree.NodeFN<>('E');
        //Layer 3
        root.firstChild.firstChild = new NaryTree.NodeFN<>('K');
        root.firstChild.nextSibling.firstChild = new NaryTree.NodeFN<>('J');
        root.firstChild.nextSibling.nextSibling.firstChild = new NaryTree.NodeFN<>('G');
        root.firstChild.nextSibling.nextSibling.nextSibling.firstChild = new NaryTree.NodeFN<>('C');
        root.firstChild.nextSibling.nextSibling.nextSibling.firstChild.nextSibling = new NaryTree.NodeFN<>('H');
        root.firstChild.nextSibling.nextSibling.nextSibling.firstChild.nextSibling.nextSibling
                = new NaryTree.NodeFN<>('I');
        //Layer 4
        root.firstChild.firstChild.firstChild = new NaryTree.NodeFN<>('N');
        root.firstChild.firstChild.firstChild.nextSibling = new NaryTree.NodeFN<>('M');
        root.firstChild.nextSibling.nextSibling.nextSibling.firstChild.nextSibling.nextSibling.firstChild
                = new NaryTree.NodeFN<>('L');

        /* Let us create below tree
         *         A
         *         / / \   \
         *         B F  D   E
         *         / \  |  /|\
         *         K J  G C H I
         *        /\           \
         *        N M           L
         */

        NaryTree<Character> nta = new NaryTree<>();
        System.out.println("Diameter is: " + nta.diameterFN(root));
    }

    public static void testNaryTreeNodeAr(){
        NaryTree.NodeAr<Character> root = new NaryTree.NodeAr<>('A');
        //Layer 2
        root.nodeList.add(new NaryTree.NodeAr<>('B'));
        root.nodeList.add(new NaryTree.NodeAr<>('F'));
        root.nodeList.add(new NaryTree.NodeAr<>('D'));
        root.nodeList.add(new NaryTree.NodeAr<>('E'));
        //Layer 3
        root.nodeList.get(0).nodeList.add(new NaryTree.NodeAr<>('K'));
        root.nodeList.get(0).nodeList.add(new NaryTree.NodeAr<>('J'));
        root.nodeList.get(2).nodeList.add(new NaryTree.NodeAr<>('G'));
        root.nodeList.get(3).nodeList.add(new NaryTree.NodeAr<>('C'));
        root.nodeList.get(3).nodeList.add(new NaryTree.NodeAr<>('H'));
        root.nodeList.get(3).nodeList.add(new NaryTree.NodeAr<>('I'));
        //Layer 4
        root.nodeList.get(0).nodeList.get(0).nodeList.add(new NaryTree.NodeAr<>('N'));
        root.nodeList.get(0).nodeList.get(0).nodeList.add(new NaryTree.NodeAr<>('M'));
        root.nodeList.get(3).nodeList.get(2).nodeList.add(new NaryTree.NodeAr<>('L'));
        /* Let us create below tree
         *            A
         *         / / \   \
         *         B F  D   E
         *         / \  |  /|\
         *         K J  G C H I
         *        /\           \
         *        N M           L
         */

        NaryTree<Character> nta = new NaryTree<>();
        System.out.println("Diameter is: " + nta.diameterAr(root));
    }
}
