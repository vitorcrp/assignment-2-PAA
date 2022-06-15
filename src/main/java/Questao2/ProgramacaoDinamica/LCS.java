package Questao2.ProgramacaoDinamica;

import java.util.Arrays;

class LCS {
    public static int longestCommonSubsequence(String text1, String text2) {
        char x[]=text1.toCharArray();
        char y[]=text2.toCharArray();
        int n=x.length;
        int m=y.length;
        int t[][]=new int[n+1][m+1];
        for(int row[]:t)
            Arrays.fill(row,-1);
        return lcs(x,y,n,m,t);
    }

    public static int lcs(char x[],char y[],int n,int m,int t[][]){
        if(n==0 || m==0)
            return 0;
        if(t[n][m] != -1)// if the same state has already been computed
            return t[n][m];
        if(x[n-1]==y[m-1])// if equal, then we store the value of the function call
            return t[n][m]=1+lcs(x,y,n-1,m-1,t);
        else
            return t[n][m]=Math.max(lcs(x,y,n-1,m,t),lcs(x,y,n,m-1,t));
    }

}