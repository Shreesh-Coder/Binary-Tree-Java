package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node root;
    static int max_level = 0;
    public BinaryTree(Node root){
        this.root = root;
    }

    public void printInOrder(Node ptr){
        if(ptr == null){
            return;
        }
        printInOrder(ptr.getLeft());
        System.out.print(ptr.getData() + " ");
        printInOrder(ptr.getRight());
    }

    public void printPreOrder(Node ptr){
        if(ptr == null)
            return;
        System.out.print(ptr.getData() + " ");
        printPreOrder(ptr.getLeft());
        printPreOrder(ptr.getRight());
    }

    public void printPostOrder(Node ptr){
        if (ptr == null)
            return;
        printPostOrder(ptr.getLeft());
        printPostOrder(ptr.getRight());
        System.out.print(ptr.getData() + " ");
    }

    public void printLevelOrder(){
        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.add(root);
        Node ptr;
        while(!linkedList.isEmpty()){
            ptr = linkedList.remove();
            System.out.print(ptr.getData() + " ");

            if(ptr.getLeft() != null){
                linkedList.add(ptr.getLeft());
            }

            if(ptr.getRight() != null){
                linkedList.add(ptr.getRight());
            }
        }
    }

    public int size(Node ptr){
        if(ptr == null)
            return 0;
       return size(ptr.getLeft()) + 1 + size(ptr.getRight());
    }

    public int maximum(Node ptr){
        if(ptr == null)
            return Integer.MIN_VALUE;
       int max;
       int maxL = maximum(ptr.getLeft());
       int maxR = maximum(ptr.getRight());

       max = Math.max(maxL, maxR);

        return Math.max(ptr.getData(), max);
    }

    public int minimum(Node ptr){
        if(ptr == null)
            return Integer.MAX_VALUE;

        int minL = minimum(ptr.getLeft());
        int minR = minimum(ptr.getRight());

        int min = Math.min(minL, minR);

        return Math.min(ptr.getData(), min);
    }

    public void printLeftNodes(Node ptr){
      printLeftNodes(ptr,true);
    }

    private void printLeftNodes(Node ptr, boolean isLeft){
        if(ptr == null)
            return;
        if(isLeft)
            System.out.print(ptr.getData() + " ");

        if(isLeft)
            printLeftNodes(ptr.getLeft(), isLeft);
        else
            printLeftNodes(ptr.getLeft(), !isLeft);

        if(!isLeft)
            printLeftNodes(ptr.getRight(), isLeft);
        else
            printLeftNodes(ptr.getRight(), !isLeft);

    }

   private void printLeftView(Node ptr,int level){
        if(ptr == null)
            return;
        if(max_level < level){
            System.out.print(ptr.getData() + " ");
            max_level = level;
        }

       level++;

       printLeftView(ptr.getLeft(), level);
       printLeftView(ptr.getRight(), level);

   }

   public void printLeftView(Node root){
        printLeftView(root, 1);
   }

   public void printLeftViewQueue(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node ptr;
        while(!queue.isEmpty()){
            int n = queue.size(); //Size of the current level

            for(int i = 1;i <= n;i++) { //Travers the level
                ptr = queue.remove();

                if(i == 1)
                    System.out.print(ptr.getData() + " ");

                if (ptr.getLeft() != null) {
                    queue.add(ptr.getLeft());
                }
                if (ptr.getRight() != null) {
                    queue.add(ptr.getRight());
                }
            }
        }
   }

   public int diameter(Node root){
        if(root == null){
            return 0;
        }

        int lh = height(root.getLeft());
        int rh = height(root.getRight());

        int ld = diameter(root.getLeft());
        int rd = diameter(root.getRight());

        return Math.max(lh+rh+1,Math.max(ld,rd));
   }

   public int diameterOpt(Node root, Height height){
        if(root == null){
            height.h = 0;
            return 0;
        }
        Height lh = new Height(), rh = new Height();

        int ld = diameterOpt(root.getLeft(), lh);
        int rd = diameterOpt(root.getRight(), rh);

        height.h = Math.max(lh.h, rh.h) + 1;

        return Math.max(lh.h + rh.h + 1, Math.max(ld, rd));
   }

   public int diameterOpt(Node root){
        return diameterOpt(root, new Height());
   }

   private int diameterNew(Node root,Ans ans){
        if(root == null)
            return 0;

        int lh = diameterNew(root.getLeft(), ans);
        int rh = diameterNew(root.getRight(), ans);

        ans.a = Math.max(ans.a , lh + rh + 1);

        return 1 + Math.max(lh , rh);
   }

   public int diameterNew(Node root){
        Ans a = new Ans();
        diameterNew(root, a);
        return a.a;
   }

   public int height(Node root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.getLeft()) + 1, height(root.getRight()) + 1);
   }

   private static class Height{
        int h;
   }

   private static class Ans{
        int a;
   }
}
