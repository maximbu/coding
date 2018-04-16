package CodingInterviews.P4;

import CodingInterviews.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by max on 12/23/2016.
 */
public class q4_3 {
    public static <T> List<List<T>> createLists(TreeNode<T> t) {
        List<List<T>> lists = new ArrayList<>();
        LinkedList<TreeNode<T>> nextLevel = new LinkedList<>();
        LinkedList<TreeNode<T>> currLevel = new LinkedList<>();
        currLevel.add(t);
        lists.add(currLevel.stream().map(TreeNode::getValue).collect(Collectors.toList()));
        boolean done = false;
        while(!done){
            nextLevel.clear();
            while(!currLevel.isEmpty()){
                nextLevel.addAll(currLevel.remove().getChildren());
            }
            if(nextLevel.isEmpty()){
                done = true;
            }
            else{
                currLevel.clear();
                lists.add(nextLevel.stream().map(TreeNode::getValue).collect(Collectors.toList()));
                currLevel.addAll(nextLevel);
            }
        }
        return lists;
    }


    public static void main(String[] st){
        TreeNode<String> t = new TreeNode<>("root");
        TreeNode<String> l1 = new TreeNode<>("l1");
        t.addChild(l1);
        TreeNode<String> l21 = new TreeNode<>("l21");
        TreeNode<String> l22 = new TreeNode<>("l22");
        TreeNode<String> l23 = new TreeNode<>("l23");
        l1.addChild(l21);
        l1.addChild(l22);
        l1.addChild(l23);
        TreeNode<String> l31 = new TreeNode<>("l31");
        TreeNode<String> l32 = new TreeNode<>("l32");
        TreeNode<String> l33 = new TreeNode<>("l33");
        l22.addChild(l31);
        l22.addChild(l32);
        l23.addChild(l33);
        TreeNode<String> l41 = new TreeNode<>("l41");
        TreeNode<String> l42 = new TreeNode<>("l42");
        l32.addChild(l41);
        l33.addChild(l42);

        List<List<String>>  ans = createLists(t);

    }



}
