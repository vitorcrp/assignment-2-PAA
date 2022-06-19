package Questao2.ProgramacaoDinamica;

import java.util.Arrays;

class LCS {
    public static int solveLcs(String text1, String text2) {
        var x=text1.toCharArray();
        var y=text2.toCharArray();
        var n=x.length;
        var m=y.length;
        var t = new int[n+1][m+1];
        for(var row : t)
            Arrays.fill(row,-1);
        return lcs(x,y,n,m,t);
    }

    public static int lcs(char[] x,char[] y,int n,int m,int[][] t){
        if(n==0 || m==0)
            return 0;
        if(t[n][m] != -1)
            return t[n][m];
        if(x[n-1]==y[m-1])
            return t[n][m]=1+lcs(x,y,n-1,m-1,t);
        else
            return t[n][m]=Math.max(lcs(x,y,n-1,m,t),lcs(x,y,n,m-1,t));
    }

}