package com.nikki.leetc.map;
/**
 * 克隆图
 *@author:Jesse
 *@version:2023年11月26日下午11:16:07
**/
public class RTest133 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
	 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
	 * class Node {
    public int val;
    public List<Node> neighbors;
}
	 * 测试用例格式：简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。
	 * 该图在测试用例中使用邻接列表表示。
	 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
	 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
	 * 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
	 * 输出：[[2,4],[1,3],[2,4],[1,3]]
	 * 解释：
图中有 4 个节点。
节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
	 * @param node
	 * @return
	 */
    public Node cloneGraph(Node node) {
        
    }
    /*
 // Definition for a Node.
 class Node {
     public int val;
     public List<Node> neighbors;
     public Node() {
         val = 0;
         neighbors = new ArrayList<Node>();
     }
     public Node(int _val) {
         val = _val;
         neighbors = new ArrayList<Node>();
     }
     public Node(int _val, ArrayList<Node> _neighbors) {
         val = _val;
         neighbors = _neighbors;
     }
 }
 */
}
