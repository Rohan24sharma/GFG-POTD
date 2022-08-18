// Given a square chessboard, the initial position of Knight and position of a target. Find out the minimum steps a Knight will take to reach the target position.If it cannot reach the target position return -1.

// Note:
// The initial and the target position co-ordinates of Knight have been given accoring to 1-base indexing.

// Example 1:

// N=6
// knightPos[ ] = {4, 5}
// targetPos[ ] = {1, 1}
// Output:
// 3
// Explanation:

// Knight takes 3 step to reach from
// (4, 5) to (1, 1):
// (4, 5) -> (5, 3) -> (3, 2) -> (1, 1). 

// Input://{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{

   class Node
   {
       int r;int c;int d;
       public Node( int r,int c,int d)
       {
           this.r=r;this.c=c;this.d=d;
       }
   }

   public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
   {
       KnightPos[0]--;
       KnightPos[1]--;
       TargetPos[0]--;
       TargetPos[1]--;
       int board[][]=new int[N][N];
       for(int i=0;i<N;i++)
       {
           for(int j=0;j<N;j++)
           {
               board[i][j]=Integer.MAX_VALUE;
           }
       }
       board[KnightPos[0]][KnightPos[1]]=0;
       PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->a.d-b.d);
       pq.add(new Node(KnightPos[0],KnightPos[1],0));
       while(!pq.isEmpty())
       {
           Node curr=pq.remove();
           visitAllCell(new int[]{curr.r,curr.c},curr.d+1,N,pq,board);
       }
     
      
       return board[TargetPos[0]][TargetPos[1]]==Integer.MAX_VALUE?-1:board[TargetPos[0]][TargetPos[1]];
   }
   private void visitAllCell(int KnightPos[],int steps,int N
   ,PriorityQueue pq,int board[][])
   {
     
       if(KnightPos[0]+2 <N )
       {
           if(KnightPos[1]+1 <N )
           {
               if(board[KnightPos[0]+2][KnightPos[1]+1] >steps )
               {
                   board[KnightPos[0]+2][KnightPos[1]+1] =steps;
                   pq.add(new Node(KnightPos[0]+2,KnightPos[1]+1,steps));
               }
             
           }
           if(KnightPos[1]-1 >=0 )
           {
               if(board[KnightPos[0]+2][KnightPos[1]-1] >steps )
               {
                   board[KnightPos[0]+2][KnightPos[1]-1] =steps;
                   pq.add(new Node(KnightPos[0]+2,KnightPos[1]-1,steps));
               }
             
           }
       }
       if(KnightPos[0]-2 >=0 )
       {
           if(KnightPos[1]+1 <N )
           {
               if(board[KnightPos[0]-2][KnightPos[1]+1] >steps )
               {
                   board[KnightPos[0]-2][KnightPos[1]+1] =steps;
                   pq.add(new Node(KnightPos[0]-2,KnightPos[1]+1,steps));
               }
             
           }
           if(KnightPos[1]-1 >=0 )
           {
               if(board[KnightPos[0]-2][KnightPos[1]-1] >steps )
               {
                   board[KnightPos[0]-2][KnightPos[1]-1] =steps;
                   pq.add(new Node(KnightPos[0]-2,KnightPos[1]-1,steps));
               }
             
           }
       }
       
       if(KnightPos[1]+2 <N )
       {
           if(KnightPos[0]+1 <N )
           {
               if(board[KnightPos[0]+1][KnightPos[1]+2] >steps )
               {
                   board[KnightPos[0]+1][KnightPos[1]+2] =steps;
                   pq.add(new Node(KnightPos[0]+1,KnightPos[1]+2,steps));
               }
             
           }
           if(KnightPos[0]-1 >=0 )
           {
               if(board[KnightPos[0]-1][KnightPos[1]+2] >steps )
               {
                   board[KnightPos[0]-1][KnightPos[1]+2] =steps;
                   pq.add(new Node(KnightPos[0]-1,KnightPos[1]+2,steps));
               }
             
           }
       }
       if(KnightPos[1]-2 >=0 )
       {
           if(KnightPos[0]+1 <N )
           {
               if(board[KnightPos[0]+1][KnightPos[1]-2] >steps )
               {
                   board[KnightPos[0]+1][KnightPos[1]-2] =steps;
                   pq.add(new Node(KnightPos[0]+1,KnightPos[1]-2,steps));
               }
             
           }
           if(KnightPos[0]-1 >=0 )
           {
               if(board[KnightPos[0]-1][KnightPos[1]-2] >steps )
               {
                   board[KnightPos[0]-1][KnightPos[1]-2] =steps;
                   pq.add(new Node(KnightPos[0]-1,KnightPos[1]-2,steps));
               }
             
           }
       }
   }
}



