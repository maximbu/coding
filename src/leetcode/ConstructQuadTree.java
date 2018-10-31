package leetcode;

/**
 * We want to use quad trees to store an N x N boolean grid. Each cell in the grid can only be true or false. The root node represents the whole grid. For each node, it will be subdivided into four children nodes until the values in the region it represents are all the same.
 *
 * Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node. The val attribute for a leaf node contains the value of the region it represents.
 *
 * Your task is to use a quad tree to represent a given grid. The following example may help you understand the problem better:
 *
 * Given the 8 x 8 grid below, we want to construct the corresponding quad tree:
 *
 *
 *
 * It can be divided according to the definition above:
 *
 *
 *
 *
 *
 * The corresponding quad tree should be as following, where each node is represented as a (isLeaf, val) pair.
 *
 * For the non-leaf nodes, val can be arbitrary, so it is represented as *.
 *
 *
 *
 * Note:
 *
 * N is less than 1000 and guaranteened to be a power of 2.
 * If you want to know more about the quad tree, you can refer to its wiki.
 */
public class ConstructQuadTree {
  class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
      val = _val;
      isLeaf = _isLeaf;
      topLeft = _topLeft;
      topRight = _topRight;
      bottomLeft = _bottomLeft;
      bottomRight = _bottomRight;
    }
  }
  public Node construct(int[][] grid) {
    return construct(grid,0,0,grid.length,grid.length);
  }

  public Node construct(int[][] grid,int fromI , int fromJ, int toI , int toJ) {
    if(fromI==toI && fromJ == toJ){
      return new Node(grid[toI][toJ]==1,true,null,null,null,null);
    }
    int same = allSame(grid,fromI,fromJ,toI,toJ);
    if(same != -1){
      return new Node(same==1,true,null,null,null,null);
    }
    return new Node(false,false,
            construct(grid,fromI,fromJ,(fromI+toI)/2,(fromJ+toJ)/2),
            construct(grid,fromI,(fromJ+toJ)/2,(fromI+toI)/2,toJ),
            construct(grid,(fromI+toI)/2,fromJ,toI,(fromJ+toJ)/2),
            construct(grid,(fromI+toI)/2,(fromJ+toJ)/2,toI,toJ));
  }

  private int allSame(int[][] grid,int fromI , int fromJ, int toI , int toJ){
    int val = grid[fromI][fromJ];
    for(int i=fromI;i<toI;i++){
      for(int j=fromJ;j<toJ;j++){
        if(grid[i][j]!= val) return -1;
      }
    }
    return val;
  }

  public static void main(String[] st){
    ConstructQuadTree q = new ConstructQuadTree();
    System.out.println(q.construct(new int[][]{{1,0},{1,0}}));
  }
}
