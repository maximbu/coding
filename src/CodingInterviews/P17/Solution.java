package CodingInterviews.P17;

import sun.text.normalizer.Trie;

import java.util.*;

public class Solution {
    private class OccData implements Comparable<OccData>{
        private char ch;
        private int count;

        OccData(char c){
            ch = c;
            count =1;
        }

        void inc(){
            count++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            OccData occData = (OccData) o;

            if (ch != occData.ch) return false;
            return count == occData.count;
        }

        @Override
        public int hashCode() {
            int result = (int) ch;
            result = 31 * result + count;
            return result;
        }

        @Override
        public int compareTo(OccData o) {
            if(o == null) return -1;
            if (count == o.count) return 0;
            if(count > o.count) return -1;
            return 1;
        }
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return val + "->"+ next;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null) return null;
        if(nums.length == 0) return null;
        if(nums.length == 1) return new TreeNode(nums[0]);
        return sortedArrayToBST(nums,0,nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums,int left , int right) {
        if(right < left) return null;
        int middle = (right + left)/2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = sortedArrayToBST(nums,left,middle-1);
        root.right = sortedArrayToBST(nums,middle+1,right);
        return root;
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        if(!validInput(board,click)) return board;
        int row = click[0];
        int col = click[1];
        switch (board[row][col]){
            case 'B':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case 'X': return board;
            case 'M': board[row][col] = 'X';
                return board;
            case 'E': int cnt = 0;
                List<int[]> toClick = new ArrayList<>();
                board[row][col] = 'B';
                for(int i=row-1;i<=row+1;i++){
                    for(int j=col-1;j<=col+1;j++){
                        if(valid(i,j,board.length,board[0].length)){
                            if(board[i][j] == 'M') cnt++;
                            if(board[i][j] == 'E') toClick.add(new int[]{i,j});
                        }
                    }
                }
                if(cnt>0) board[row][col] = (char)(cnt+'0');
                else {
                    for(int[] p:toClick){
                        updateBoard(board,p);
                    }
                }
                return board;
        }
        return board;
    }

    boolean validInput(char[][] board, int[] click){
        return true;
    }

    boolean valid(int i, int j , int len,int height){
        return !( i < 0 || j <0 || i>=len || j >=height);
    }

    public int change(int amount, int[] coins) {
        int a[][] = new int[coins.length][amount+1];
        for(int j=0;j<=amount;j++) a[0][j] = (j < coins[0]) ? 0 : 1;
        for(int i=1;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                a[i][j]=a[i-1][j];
                if(j>=coins[i])a[i][j]+=a[i][j-coins[i]];
            }
        }
        return a[coins.length-1][amount];
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;
        int[] ans = new int[m*n];
        int cRow = 0, cCol = 0;
        boolean up = true;
        int flip = 1;
        for (int i = 0; i < m * n; i++) {
            ans[i]= matrix[cRow][cCol];

            if(cRow == 0 ||cCol == 0 ||cRow == m-1 || cCol == n-1 ){
                if(up) {
                    if(cCol < n-1) {
                        cCol++;
                    }
                    else {
                        cRow++;
                    }
                }
                else {
                    if(cRow < m-1) {
                        cRow++;
                    }
                    else {
                        cCol++;
                    }
                }
                up = !up;
            }
            else {
                if (!up) {
                    cRow++;
                    cCol--;
                } else {
                    cRow--;
                    cCol++;
                }
            }
        }
        return ans;
    }

    List<Integer> modes = new ArrayList<Integer>();
    int currVal;
    int currCount;
    int maxCount;

    public int[] findMode(TreeNode root) {
        inorder(root,1);
        currCount = 0;
        inorder(root,2);
        int[] ans = new int[modes.size()];
        for(int i=0;i<modes.size();i++)
        {
            ans[i]=modes.get(i);
        }
        return ans;
    }
    private static class Pair{
        public String s;
        public double val;

        public Pair(String _s,double _val){
            s = _s;
            val = _val;
        }
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] ans = new double[queries.length];
        if(equations.length < 1){
            for(int i=0;i<queries.length;i++){
                ans[i]=-1.0;
            }
            return ans;
        }
        HashMap<String,ArrayList<Pair>> set = new HashMap<String,ArrayList<Pair>>();
        for(int i=0;i<equations.length;i++){
            if(!set.containsKey(equations[i][0])){
                set.put(equations[i][0],new ArrayList<Pair>());
            }
            set.get(equations[i][0]).add(new Pair(equations[i][1],values[i]));
            if(!set.containsKey(equations[i][1])){
                set.put(equations[i][1],new ArrayList<Pair>());
            }
            set.get(equations[i][1]).add(new Pair(equations[i][0],1/values[i]));
        }
        for(int i=0;i<queries.length;i++){
            ans[i]=getAnswer(queries[i][0],queries[i][1],set);
        }
        return ans;
    }

    private double getAnswer(String s1, String s2, HashMap<String,ArrayList<Pair>> set){
        if(!set.containsKey(s1) || !set.containsKey(s2)) return -1.0;
        double ans = 1;
        Stack<Pair> s = new Stack<Pair>();
        s.push(new Pair(s1,1));
        while(!s.isEmpty()){
            Pair p = s.pop();
            if(p.s.equals(s2)) return p.val;
            if(!set.containsKey(p.s)) continue;
            for(Pair option :set.get(p.s)){
                s.push(new Pair(option.s,option.val*p.val));
            }
        }
        return -1;
    }

    private void inorder(TreeNode root,int pass) {
        if (root == null) return;
        inorder(root.left,pass);
        switch(pass){
            case (1):
                findMaxCount(root.val);
                break;
            case (2):
                findValuesWithMaxCount(root.val);
                break;
        }
        inorder(root.right,pass);
    }

    private void findMaxCount(int val) {
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        maxCount = Math.max(maxCount,++currCount);
    }

    private void findValuesWithMaxCount(int val) {
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        if (++currCount == maxCount) {
            modes.add(currVal);
        }
    }

    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiop","asdfghjkl","zxcvbnm"};
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        List<String> ans = new ArrayList<String>();
        for(int i=0;i<rows.length;i++){
            for(char c : rows[i].toCharArray()){
                map.put(c,i);
            }
        }
        for(String word : words){
            char[] letters = word.toLowerCase().toCharArray();
            if(letters.length < 2){
                ans.add(word);
                continue;
            }
            int ind = map.get(letters[0]);
            boolean oneRow = true;
            for(char l: letters){
                if(map.get(l)!=ind) {
                    oneRow = false;
                    break;
                }
            }
            if(oneRow){
                ans.add(word);
            }
        }

        return ans.toArray(new String[ans.size()]);
    }

    public int search(int[] nums, int target) {
        if(nums.length < 2){
            if(nums.length>0 && nums[0]==target) return 0;
            return -1;
        }
        int ind = getRotationInd(nums,0,nums.length-1);
        return search(nums,target,0,nums.length-1,ind);
    }

    private int getRotationInd(int[] nums,int from,int to) {
        if(from > to ){
            return -1;
        }
        int mid = from + (to-from)/2;
        if(mid+1< nums.length && nums[mid]>nums[mid+1]) return mid;
        int right = getRotationInd(nums,mid+1,to);
        if(right != -1) return right;
        return getRotationInd(nums,from,mid-1);
    }

    private int search(int[] nums, int target,int from,int to,int rotationInd) {
        if(from > to ){
            return -1;
        }
        int mid = from + (to-from)/2;
        if(nums[mid]==target) return mid;
        if(nums[rotationInd]==target) return rotationInd;
        if(from == to) return -1;
        if(nums[mid]> target){
            if(rotationInd == -1) return search(nums,target,from,mid-1,rotationInd);
            else{
                if(mid <= rotationInd){
                    int left = search(nums,target,from,mid-1,rotationInd);
                    if(left != -1) return left;
                    return search(nums,target,rotationInd+1,to,rotationInd);
                }
                else{
                    return search(nums,target,rotationInd+1,mid-1,rotationInd);
                }
            }
        }
        else{
            if(rotationInd == -1) return search(nums,target,mid+1,to,rotationInd);
            else{
                if(mid < rotationInd){
                    return search(nums,target,mid+1,rotationInd-1,rotationInd);
                }
                else{
                    int right = search(nums,target,mid+1,to,rotationInd);
                    if(right!=-1) return right;
                    return search(nums,target,from,rotationInd-1,rotationInd);
                }
            }
        }
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int ans = 0;
        for(int a=0;a<A.length;a++){
            for(int b=0;b<B.length;b++){
                int sum = A[a]+B[b];
                if(!map.containsKey(sum)){
                    map.put(sum,1);
                }
                else {
                    map.put(sum, map.get(sum) + 1);
                }
            }
        }

        for(int c=0;c<C.length;c++){
            for(int d=0;d<D.length;d++){
                int look = -(C[c]+D[d]);
                if(map.containsKey(look)){
                    ans+=map.get(look);
                }
            }
        }

        return ans;
    }

    public int findTargetSumWays(int[] nums, int S) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> tmp;
        for(int n:nums){
            tmp = new HashMap<Integer,Integer>();
            for(Integer k:map.keySet()){
                tmp.put(k+n,map.get(k+n));
                tmp.put(k-n,map.get(k-n));
                map = tmp;
            }
        }
        return map.get(S);
    }

    public int getRandom(ListNode head) {
        ListNode curr = head.next;
        ListNode ans = head;
        int iter = 2;
        while(curr != null){
            if(Math.random()<(1.0/iter)){
                ans = curr;
            }
            curr = curr.next;
            iter++;
        }
        return ans.val;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();
        while(l1 != null){
            st.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            st2.push(l2.val);
            l2 = l2.next;
        }


        ListNode ret = null;
        ListNode last = null;
        int carry = 0;
        while (!st.isEmpty() || !st2.isEmpty() || carry != 0){
            int num = carry;
            if(!st.isEmpty()) num+= st.pop();
            if(!st2.isEmpty()) num+= st2.pop();
            carry = num/10;
            ListNode curr = new ListNode(num%10);
            curr.next = last;
            last = curr;
        }
        return last;


    }

    public String frequencySort(String s) {
        if (s == null) {
            return null;
        }
        char [] st = s.toCharArray();
        OccData[] o= new OccData[256];
        for (char aSt : st) {
            if (o[aSt] == null) {
                o[aSt] = new OccData(aSt);
            } else {
                o[aSt].inc();
            }
        }

        Arrays.sort(o, (o1, o2) -> {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return o1.compareTo(o2);
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<256;i++){
            if(o[i] == null) break;
            while (o[i].count>0) {sb.append(o[i].ch);o[i].count--;}
        }
        return sb.toString();
    }

    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;

        int[] a = new int[n + 1];
        a[0] = 1; a[1] = 2; a[2] = 2;
        int head = 2, tail = 3, result = 1;

        while (tail < n) {
            a[tail]=3-a[tail-1];
            if(a[tail] == 1) result++;
            tail++;
            if(a[head] == 2){
                a[tail]=3-a[tail-1];
                if(a[tail] == 1) result++;
                tail++;
            }
            head++;
        }



        return result;
    }

    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        int nextTwoPow = 1;
        ans[0] = 0;
        for(int i=1;i<=num;i++){
            if(i==nextTwoPow){
                ans[i]=1;
                nextTwoPow *= 2;
            }
            else{
                ans[i]=ans[nextTwoPow/2] + ans[i-nextTwoPow/2];
            }
        }
        return ans;
    }

    public int numberOfArithmeticSlices(int[] A) {
        int ans = 0;
        if(A.length < 3) return 0;
        int[] dif = new int[A.length-1];
        for(int i=0;i<A.length-1;i++){
            dif[i]=A[i+1]-A[i];
        }
        for(int i=0;i<dif.length;i++){
            ans+=numberOfArithmeticSlices(dif,i);
        }
        return ans;
    }

    private int numberOfArithmeticSlices(int[] dif,int start) {
        int cnt = 1;
        while((start<dif.length-1) && (dif[start+1]==dif[start])) {start++;cnt++;}
        return Math.max(0,cnt-1);
    }


    public static void main(String[] st) {
        Solution s = new Solution();
//        ListNode h1 = new ListNode(7);
//        h1.next = new ListNode(2);
//        h1.next.next = new ListNode(4);
//        h1.next.next.next = new ListNode(3);
//
//        ListNode h2 = new ListNode(5);
//        h2.next = new ListNode(6);
//        h2.next.next = new ListNode(4);
//        TreeNode root = new TreeNode(1);
//        TreeNode l1 = new TreeNode(2);
//        TreeNode l2 = new TreeNode(3);
//        root.right = l1;
//        l1.left=l2;
//
//        int[] A = new int[]{1,2};
//        int[] B = new int[]{-2,-1};
//        int[] C = new int[]{-1,2};
//        int[] D = new int[]{0,2};
        int [] q = new int[]{1,2,3,4,5,6,7,8,9};
        String [][] a = new String[][]{{"x1","x2"},{"x2","x3"},{"x3","x4"},{"x4","x5"}};
        double[] b = {3.0,4.0,5.0,6.0};
        String[][] c ={{"x1","x5"},{"x5","x2"},{"x2","x4"},{"x2","x2"},{"x2","x9"},{"x9","x9"}};
        String[] st1 = new String[]{"Hello","Alaska","Dad","Peace"};
        int[][] m= {{1,2,3},{4,5,6},{7,8,9}};
        char[][] mine= {{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
        mine = s.updateBoard(mine,new int[]{3,0});
        System.out.println(Arrays.toString(mine));

    }

    private static class TreeNode {
        public TreeNode left;
        public int val;
        public TreeNode right;

        public TreeNode(int i) {
            val = i;
        }
    }
}