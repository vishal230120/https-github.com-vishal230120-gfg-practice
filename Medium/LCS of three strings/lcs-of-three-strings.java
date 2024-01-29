//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException 
    { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int n1 = Integer.parseInt(input_line[0]);
            int n2 = Integer.parseInt(input_line[1]);
            int n3 = Integer.parseInt(input_line[2]);
            input_line = read.readLine().trim().split("\\s+");
            String A = input_line[0];
            String B = input_line[1];
            String C = input_line[2];
            Solution obj = new Solution();
            System.out.println(obj.LCSof3(A, B, C, n1, n2, n3));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        // code here
           return lcs(A,B,C);
        
    }
    
    
    
     public int lcs(String s1,String s2,String s3){
        
       int x=s1.length();
        int y=s2.length();
        int z=s3.length();
        
       
         int dp[][][]=new int[x+1][y+1][z+1];
          for(int i=1;i<x+1;i++){
             for(int j=1;j<y+1;j++){
                 for(int k=1;k<z+1;k++){
                 if(s1.charAt(i-1)==s2.charAt(j-1)&&s2.charAt(j-1)==s3.charAt(k-1)){
                     dp[i][j][k]=1+dp[i-1][j-1][k-1];
                 }
                 else{
                     dp[i][j][k]=Math.max(Math.max(dp[i-1][j][k],dp[i][j-1][k]),dp[i][j][k-1]);
                 }
             }
             }
         }
         
      
         return dp[x][y][z];
        
    }
}