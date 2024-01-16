//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static void helper(ArrayList<Integer> arr, TreeSet<ArrayList<Integer>> ts, int i){
        if(i == arr.size()){
            ts.add(new ArrayList<>(arr));
            return;
        }
        for(int j = i ; j < arr.size() ; j++){
            Collections.swap(arr, i, j);
            helper(arr, ts, i+1);
            Collections.swap(arr, i, j);
        }
    }
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        TreeSet<ArrayList<Integer>> ts = new TreeSet<>(new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2){
                int i = 0;
                while(i < o1.size() && i < o2.size()){
                    if(o1.get(i) > o2.get(i))
                        return 1;
                    else if(o1.get(i) < o2.get(i))
                        return -1;
                    i++;
                }
                return 0;
            }
        });
        helper(arr, ts, 0);
        ArrayList<ArrayList<Integer>> req = new ArrayList<>(ts);
        return req;
    }
};