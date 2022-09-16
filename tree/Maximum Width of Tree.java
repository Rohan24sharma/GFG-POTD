// Given a Binary Tree, find the maximum width of it. Maximum width is defined as the maximum number of nodes at any level.
// For example, the maximum width of the following tree is 4 as there are 4 nodes at the 3rd level.

//           1
//        /     \
//      2        3
//    /    \    /    \
//   4    5   6    7
//     \
//       8

// Example 1:

// Input:
//        1
//      /    \
//     2      3
// Output: 2
// On the first level there is only
// one node 1
// On the second level there are
// two nodes 2, 3 clearly it is the 
// maximum number of nodes at any level

//{ Driver Code Starts
// Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            int res = g.getMaxWidth(root);
            System.out.println(res);
            // CLN.inorder(root);
            t--;
            // System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */

class Solution {
    // Function to get the maximum width of a binary tree.
    int getMaxWidth(Node root) {
       Queue<Node>q=new LinkedList<>();
       q.add(root);
       int cnt=0,max=1,size=1;
       while(!q.isEmpty()){
           Node u=q.poll();
           cnt++;
           if(u.left!=null){
               q.add(u.left);
           }
           if(u.right!=null){
               q.add(u.right);
           }
           if(cnt==size){
               max=Math.max(max,q.size());
               cnt=0;
               size=q.size();
           }
       }
       return max;
    }
}
