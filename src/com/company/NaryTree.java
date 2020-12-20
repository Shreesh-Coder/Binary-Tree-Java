package com.company;

import java.util.ArrayList;

public class NaryTree<T> {

    private NodeFN root;

    public int diameterFN(NodeFN root){
        return diameterFN(root, new Ans());
    }

    private int diameterFN(NodeFN root, Ans ans){
        if(root == null){
            return 0;
        }

        int lh = diameterFN(root.firstChild, ans);
        int rh = diameterFN(root.nextSibling, ans);

        ans.a = Math.max(ans.a, lh + rh + 1); //Gives diameter of tree

        return 1 + Math.max(lh, rh); //Calculate height
    }

    private int diameterAr(NodeAr<T> root, Ans ans){
        if(root == null){
            return 0;
        }
        ArrayList<Integer> nodeLengths = new ArrayList<>();
//        int diameter = 1;
        for(int i = 0;i < root.nodeList.size() ;i++){
            nodeLengths.add(diameterAr(root.nodeList.get(i), ans));
//            diameter += nodeLengths.get(i);
        }

//        ans.a = Math.max(ans.a , diameter);
        int max = 0,secondMax = 0;
        if(root.nodeList.size() != 0) {
            max = nodeLengths.get(0);
            secondMax = max;
        }
        for(int i = 1;i < root.nodeList.size();i++){
            if(max < nodeLengths.get(i)){
                secondMax = max;
                max = nodeLengths.get(i);
            }else if(secondMax < nodeLengths.get(i)){
                secondMax = nodeLengths.get(i);
            }
        }
        ans.a = Math.max(ans.a, max + secondMax + 1);
        return 1 + max;

    }

    public int diameterAr(NodeAr<T> root){
        Ans ans = new Ans();
        diameterAr(root, ans);
         return ans.a;
    }

    private static class Ans{
        int a;
    }

    public static class NodeFN<T>{
        T data;
        NodeFN<T> firstChild;
        NodeFN<T> nextSibling;

        NodeFN(T data){
            this.data = data;
        }
    }

    public static class NodeAr<T>{
        T data;
        ArrayList<NodeAr<T>> nodeList;
        public NodeAr(T data){
            this.data = data;
            nodeList = new ArrayList<>();
        }
    }
}
