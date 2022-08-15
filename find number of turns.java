// Given a binary tree and data value of two of its nodes. Find the number of turns needed to reach from one node to another in the given binary tree.

// Example 1:

// Input:      
// Tree = 
//            1
//         /    \
//        2       3
//      /  \     /  \
//     4    5   6    7                        
//    /        / \                        
//   8        9   10   
// first node = 5
// second node = 10
// Output: 4
// Explanation: 
// Turns will be at 2, 1, 3, 6.



//{ Driver Code Starts
//Initial template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            
            String line = br.readLine();
            String[] splitLine = line.split(" ");
            int nd1 = Integer.parseInt(splitLine[0]);
            int nd2 = Integer.parseInt(splitLine[1]);
            int turn;

            Solution ob = new Solution();
            if((turn = ob.NumberOfTurns(root, nd1, nd2)) != 0)
              System.out.println(turn);
            else
              System.out.println("-1");
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java
/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution
{
    static int first = 0,second = 0;
    static Node parent(Node root)
    {
        if(root == null) return null;
        else if(root.data == first || root.data == second) return root;
        Node left = parent(root.left);
        Node right = parent(root.right);
        if(left !=null && right != null) return root;
        return left == null?right:left;
    }
    //Prev Direction :- left = true, right = false
    static int search(Node root,boolean prevDir,int turn)
    {
        if(root == null) return 0;
        else if (root.data == first || root.data == second) return turn;
        int res = 0, leftTurn = 0, rightTurn = 0;
        if(prevDir) rightTurn = 1;
        else leftTurn = 1;
        res += search(root.left,true,turn+leftTurn);
        res += search(root.right,false,turn+rightTurn);
       return res;
    }
    static int NumberOfTurns(Node root, int firstT, int secondT)
    {
        first = firstT;
        second = secondT;
        root = parent(root);
        int res = 0;
        res += search(root.left,true,0);
        res += search(root.right,false,0);
        if(root.data != first && root.data != second)
        res+=1;
        return res;
    }
}
