package com.nikki.leetc.map;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 克隆图
 *@author:Jesse
 *@version:2023年11月26日下午11:16:07
**/
public class RTest133 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private Node[] constructMap (int[][] nums) {
	    int len = nums.length;
	    Node[] nodes = new Node[len];
	    for (int i = 0; i < len; i++) {
	        nodes[i].val = i+1;
	        List<Node> neighbors = new ArrayList<Node>();
	        for (int j = 0; j < nums[i].length; j++) {
	            neighbors.add(nodes[nums[i][j]]);
	        }
	        nodes[i].neighbors = neighbors;
	    }
	    return nodes;
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
//	DFS (深度遍历)
    public Node cloneGraph1(Node node) {
        Map<Node, Node> lookup = new HashMap<>();

        return dfs(node, lookup);

    }



    private Node dfs(Node node, Map<Node,Node> lookup) {

        if (node == null) return null;

        if (lookup.containsKey(node)) return lookup.get(node);

        Node clone = new Node(node.val, new ArrayList<>());

        lookup.put(node, clone);

        for (Node n : node.neighbors)clone.neighbors.add(dfs(n,lookup));

        return clone;

    }
//    BFS (广度遍历)
    public Node cloneGraph(Node node) {

        if (node == null) return null;

        Map<Node, Node> lookup = new HashMap<>();

        Node clone = new Node(node.val, new ArrayList<>());

        lookup.put(node, clone);

        Deque<Node> queue = new LinkedList<>();

        queue.offer(node);

        while (!queue.isEmpty()) {

            Node tmp = queue.poll();

            for (Node n : tmp.neighbors) {

                if (!lookup.containsKey(n)) {

                    lookup.put(n, new Node(n.val, new ArrayList<>()));

                    queue.offer(n);

                }

                lookup.get(tmp).neighbors.add(lookup.get(n));

            }

        }

        return clone;

    }

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
}
