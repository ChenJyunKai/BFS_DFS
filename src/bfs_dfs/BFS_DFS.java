/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bfs_dfs;

import java.util.*;

public class BFS_DFS {

    static class Node {

        int data;
        boolean visited;
        List<Node> neighbors;

        Node(int data) {
            this.data = data;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node neighbor) {
            this.neighbors.add(neighbor);
        }
    }

    //BFS
    public static void bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        start.visited = true;

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.print(current.data + " ");

            for (Node neighbor : current.neighbors) {
                if (!neighbor.visited) {
                    queue.add(neighbor);
                    neighbor.visited = true;
                }
            }
        }
    }

    //DFS
    public static void dfs(Node current) {
        System.out.print(current.data + " ");
        current.visited = true;

        for (Node neighbor : current.neighbors) {
            if (!neighbor.visited) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.addNeighbor(node2);
        node1.addNeighbor(node4);
        node4.addNeighbor(node5);
        node2.addNeighbor(node3);

        bfs(node1);
        dfs(node1);
    }

}
