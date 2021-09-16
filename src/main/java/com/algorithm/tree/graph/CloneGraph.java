package com.algorithm.tree.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given a reference of a node in a connected undirected graph.
Return a deep copy (clone) of the graph.
Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 */
public class CloneGraph {

    public static void main(String[] s) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors = Arrays.asList(n2, n4);
        n2.neighbors = Arrays.asList(n1, n3);
        n3.neighbors = Arrays.asList(n2, n4);
        n4.neighbors = Arrays.asList(n1, n3);
        Node newNode = cloneGraph(n1);
        System.out.println("H");
    }

    public static Node cloneGraph(Node node) {
        if(node==null) {
            return null;
        }
        Map<Integer, Node> map = new HashMap<>();
        return cloneGraph(node, map);
    }

    private static Node cloneGraph(final Node node, final Map<Integer, Node> map) {
        if(map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node copyNode = new Node(node.val);
        map.put(node.val, copyNode);
        for(Node neighbour: node.neighbors) {
            copyNode.neighbors.add(cloneGraph(neighbour, map));
        }
        return copyNode;
    }
}
