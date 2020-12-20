package com.company;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Node;

import java.util.*;


public class BinaryTreeArray {
    private Node root;


/*    public void insert(ArrayList<Integer> arrayList){
        Node parentNode = new Node();
        Node childrenNode = new Node();

        parentNode.value = arrayList.get(0);
        childrenNode.value = 0;
        parentNode.left = childrenNode;

        for(int  i = 1;i < arrayList.size();i++) {
            if(parentNode.value == arrayList.get(i)){
                childrenNode = new Node();
                childrenNode.value = i;
            }else if(childrenNode.value == arrayList.get(i)){
                parentNode = childrenNode;
                childrenNode = new Node();
                childrenNode.value = i;
            }else if(parentNode.value == i){
                childrenNode = parentNode;
                parentNode = new Node();
                parentNode.value = arrayList.get(i);
                root = parentNode;
            }else{

            }

            if(parentNode.left == null) {
                parentNode.left = childrenNode;
            }else{
                parentNode.right = childrenNode;
            }
        }
    }*/
    public void convert(@NotNull ArrayList<Integer> arrayInteger){
        ArrayList<Node> arrayNode = new ArrayList<>();
        for(int i = 0;i < arrayInteger.size();i++)
        {
            arrayNode.add(new Node(i));
        }

        for(int i = 0;i < arrayInteger.size();i++){
            if(arrayInteger.get(i) != -1) {
                if (arrayNode.get(arrayInteger.get(i)).left == null) {
                    arrayNode.get(arrayInteger.get(i)).left = arrayNode.get(i);
                } else {
                    arrayNode.get(arrayInteger.get(i)).right = arrayNode.get(i);
                }
            }else{
                root = arrayNode.get(i);
            }
        }
    }
    public void printLevelOrder(){
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        Node ptr = root;
        while(!queue.isEmpty()) {
            ptr = queue.remove();

            System.out.print(ptr.value + " ");

            if (ptr.left != null) {
                queue.add(ptr.left);
            }
            if (ptr.right != null) {
                queue.add(ptr.right);
            }
        }
    }
    public int height(ArrayList<Integer> arr){
        int val = 0;
        int height = 0, counter = 0;
        for(int i = 0;i < arr.size();i++){
            val = i;
            counter = 0;
            while(val != -1){
                counter++;
                val = arr.get(val);
                if(counter > height){
                    height = counter;
                }
            }
        }
        return height;
    }
    private static class Node{
        int value;
        Node left;
        Node right;
        Node(){}
        Node(int value){this.value = value;}
    }

    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 5, 5, 2, 2, -1, 3));
        /*                                                     0  1  2  3  4   5  6
          5
        /  \
       1    2
      /    / \
     0    3   4
         /
        6
        * */
//        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(-1, 0, 0, 1, 1, 3, 5));

        BinaryTreeArray binaryTreeArray = new BinaryTreeArray();

        binaryTreeArray.convert(arr);
        binaryTreeArray.printLevelOrder();
        System.out.println("\n" + binaryTreeArray.height(arr) + " is height of binary tree");


    }
}
