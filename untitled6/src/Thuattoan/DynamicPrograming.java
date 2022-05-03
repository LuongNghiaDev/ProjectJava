package Thuattoan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicPrograming {
    //Longest Common Subsequence (LCS) -chuỗi con chung dài nhất
    int lcs(char[] x,char[] y,int m,int n){
        int L[][] = new int[m+1][n+1];

        for (int i=0;i<=m;i++){
            for (int j=0;j<=n;j++){
                if(i==0 || j==0){
                    L[i][j]=0;
                }else if(x[i-1] == y[j-1]){
                    L[i][j] = L[i-1][j-1]+1;
                }else {
                    L[i][j] = max(L[i-1][j],L[i][j-1]);
                }
            }
        }
        return L[m][n];
    }

    int max(int a,int b){
        return (a > b)? a:b;
    }

    public static void main(String[] args) {
        DynamicPrograming lcs = new DynamicPrograming();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        int m = x.length;
        int n = y.length;

        System.out.println("Length of LCS is" + " " +
                lcs.lcs( x, y, m, n ) );
    }
}
class OptimalBinarySearch{
    //cây tìm kiếm nhị phân
    static int SearchTree(int keys[],int freq[],int n){

        int cost[][] = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++)
            cost[i][i] = freq[i];

        for (int L = 2; L <= n; L++) {
            for (int i = 0; i <= n - L + 1; i++) {

                int j = i + L - 1;
                cost[i][j] = Integer.MAX_VALUE;

                for (int r = i; r <= j; r++) {
                    int c = ((r > i) ? cost[i][r - 1] : 0) + ((r < j) ? cost[r + 1][j] : 0) + sum(freq, i, j);
                    if (c < cost[i][j])
                        cost[i][j] = c;
                }
            }
        }
        return cost[0][n - 1];
    }

    static int sum(int freq[],int i,int j){
        int s=0;
        for (int k=i;k <= j;k++){
            if(k >= freq.length){
                continue;
            }
            s += freq[k];
        }
        return s;
    }

    public static void main(String[] args) {
        int keys[] = { 10, 12, 20 };
        int freq[] = { 34, 8, 50 };
        int n = keys.length;
        System.out.println("Cost of Optimal BST is "
                + SearchTree(keys, freq, n));
    }
}
class KnapsackDynamic{
    //cái túi
    static int max(int a,int b){
        return (a > b)? a:b;
    }

    static int knapsackk(int W,int wt[],int val[],int n){
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        for (i = 0; i<= n; i++) {
            for (w = 0; w<= W; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                }else if (wt[i - 1]<= w) {
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                }else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }
        return K[n][W];
    }

    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapsackk(W, wt, val, n));
    }
}
class MatrixChainMultiplication{
    //nhân chuỗi ma trận
    static int Maxtrix(int p[],int n){
        int m[][] = new int[n][n];

        int j,q;
        for (int i=1;i < n;i++){
            m[i][i] = 0;
        }
        for (int L=2;L < n;L++){
            for (int i=1;i < n-L+1;i++){
                j = i + L -1;
                if(j == n){
                    continue;
                }
                m[i][j] = Integer.MAX_VALUE;
                for (int k=i;k <= j-1;k++){
                    q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if(q < m[i][j]){
                        m[i][j] = q;
                    }
                }
            }
        }
        return m[1][n-1];
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4 };
        int size = arr.length;

        System.out.println("Minimum number of multiplications is "
                + Maxtrix(arr, size));
    }
}
class MultistageGraph{
    // đồ thị đa tầng
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int G[][];
    static int n;
    static int k=4;//stages

    static int findR(int cu){// tim dinh can ket noi
        int r1 = n+1;
        for(int h =1; h<=n; h++)
        {
            if( (G[h][cu] != 0) && (  r1 == n+1 ) )
            {
                r1 = h;
                continue;
            }
            if (G[h][cu] != 0)
            {
                if(G[h][cu] < G[r1][cu] )
                    r1 = h;
            }
        }
        return r1;
    }

    static void FGraph(){
        int [] cost = new int[n+1];
        int [] d = new int[n+1];
        int [] p = new int[k+1];
        for (int i = 1; i<=n; i++)
            cost[i] = 0;

        for(int j=n-1; j>=1; j--)
        {
            int r = findR(j+1);
            cost[j] = G[j][r]+cost[r];
            d[j] = r;
        }

        p[1] = 1; p[k] = n;
        for(int j = 2; j<k; j++)
            p[j] = d[p[j-1]];

        System.out.print(d[1]+"-");
        for(int j=2; j<=n; j++)
        {
            if((d[j] == d[j-1]) || (d[j] == 0))
                continue;

            System.out.print(d[j]+"-");
        }
        System.out.print(n);
    }
    public static void main(String[] args) throws IOException {
        System.out.print("\nEnter the number of the vertices: ");
        n = Integer.parseInt(br.readLine());
        G = new int[n+1][n+1];

        System.out.print("\nIf there is a edge between the following vertices enter its weight else 0:\n");
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
            {
                G[i][j] = 0;
                if((i!=j) && (i<j))
                {
                    System.out.print(i+" and "+j+": ");
                    G[i][j] = Integer.parseInt(br.readLine());
                }
            }
        FGraph();
    }
}






