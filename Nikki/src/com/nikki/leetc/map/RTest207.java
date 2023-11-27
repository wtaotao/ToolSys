package com.nikki.leetc.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 课程表
 *@author:Jesse
 *@version:2023年11月26日下午11:23:26
**/
public class RTest207 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
	 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 
	 * ai 则 必须 先学习课程  bi 。
	 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
	 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
	 * 输入：numCourses = 2, prerequisites = [[1,0]]
	 * 输出：true
	 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        //思路：根据依赖可以构建一条链表，如果链表有环，则不可能完成所有课程的学习
        boolean canFinished = false;
        Node[] nodes = new Node[numCourses];
        Node head = null;
        for (int i = numCourses-1; i >= 0; i++) {
            Node node = new Node(i);
            nodes[i] = node;
            if (head == null) {
                head = node;
                node.next = null;
            } else {
                node.next = head;
                head = node;
            }
        }
        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i].length == 2) {
                //三种情况（假设没有两条一样的连线）：1.连线数大于等于节点数肯定有环（不一定，可以被多个点依赖和孤立点）；2.所有节点next都不为空则有环；
                //3.连线不多于点数减一则需check
                
            }
        }
        return canFinished;
    }
    // 节点的入度: 使用数组保存每个节点的入度,
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1.课号和对应的入度
        Map<Integer, Integer> inDegree = new HashMap<>();
        // 将所有的课程先放入
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
        }
        // 2.依赖关系, 依赖当前课程的后序课程
        Map<Integer, List<Integer>> adj = new HashMap<>();



        // 初始化入度和依赖关系
        for (int[] relate : prerequisites) {
            // (3,0), 想学3号课程要先完成0号课程, 更新3号课程的入度和0号课程的依赖(邻接表)
            int cur = relate[1];
            int next = relate[0];
            // 1.更新入度
            inDegree.put(next, inDegree.get(next) + 1);
            // 2.当前节点的邻接表
            if (!adj.containsKey(cur)) {
                adj.put(cur, new ArrayList<>());
            }
            adj.get(cur).add(next);
        }

        // 3.BFS, 将入度为0的课程放入队列, 队列中的课程就是没有先修, 可以学的课程
        Queue<Integer> q = new LinkedList<>();
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                q.offer(key);
            }
        }
        // 取出一个节点, 对应学习这门课程.
        // 遍历当前邻接表, 更新其入度; 更新之后查看入度, 如果为0, 加入到队列
        while (!q.isEmpty()) {
            int cur = q.poll();
            // 遍历当前课程的邻接表, 更新后继节点的入度
            if (!adj.containsKey(cur)) {
                continue;
            }
            List<Integer> successorList = adj.get(cur);

            for (int k : successorList) {
                inDegree.put(k, inDegree.get(k) - 1);
                if (inDegree.get(k) == 0) {
                    q.offer(k);
                }
            }
        }

        // 4.遍历入队, 如果还有课程的入度不为0, 返回fasle
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) != 0) {
                return false;
            }
        }
        return true;

    }   
    class Node {
        int val;
        Node next;
        public Node () {
        }
        public Node (int val) {
            this.val = val;
        }
        public Node (int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
