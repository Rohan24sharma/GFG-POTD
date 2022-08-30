//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            List<List<String>> adj = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                List<String> l = new ArrayList<>();

                String name = sc.next();
                l.add(name);

                int tmp = sc.nextInt();

                sc.nextLine();
                for (int j = 0; j < tmp; j++) {
                    String h = sc.next();

                    l.add(h);
                }

                adj.add(l);
            }

            Solution obj = new Solution();
            List<List<String>> ans = obj.mergeDetails(adj);
            Collections.sort(ans,
                             (x, y)->{ return x.get(0).compareTo(y.get(0)); });

            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    public List<List<String>> mergeDetails(List<List<String>> details) {
        HashMap<Integer, HashSet<String>> map_1 = new HashMap<>();
        HashMap<String, Integer> map_2 = new HashMap<>();

        for (int i = 0; i < details.size(); i++) {
            List<String> list = details.get(i);
            HashSet<String> temp = new HashSet<>();

            boolean found = false;
            int target = -1;
            
            for (int j = 1; j < list.size(); j++) {
                if (map_2.getOrDefault(list.get(j), -1) != -1) {
                    target = map_2.get(list.get(j));
                    found = true;
                    break;
                }
            }

            if (found) {
                for (int j = 1; j < list.size(); j++) {
                    HashSet<String> set = map_1.getOrDefault(target, new HashSet<>());
                    set.add(list.get(j));
                    map_2.put(list.get(j), target);
                    map_1.put(target, set);
                }
            } else {
                for (int j = 1; j < list.size(); j++) {
                    map_2.put(list.get(j), i);
                    HashSet<String> set = map_1.getOrDefault(i, new HashSet<>());
                    set.add(list.get(j));
                    map_1.put(i, set);
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (Integer index : map_1.keySet()) {
            List<String> r = new ArrayList<>(map_1.get(index));
            Collections.sort(r);
            r.add(0, details.get(index).get(0));
            res.add(r);
        }

        return res;
    }    
    
}
