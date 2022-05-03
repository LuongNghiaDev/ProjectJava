package Thuattoan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Backtracking {
    //N Queen
    static int N=4;
    static int ld[]=new int[30];
    static int rd[]= new int[30];
    static int cl[]= new int[30];

    static void printSolution(int board[][]){
        for(int i=0;i<N;i++){
            for (int j=0;j<N;j++) {
                System.out.printf(" %d ", board[i][j]);
            }
            System.out.printf("\n");
        }
    }
    static boolean solve(int board[][],int col){
        if(col>=N){
            return true;
        }
        for (int i=0;i<N;i++){
            //kt chéo trái,chéo phải và cột
            if(ld[i-col+N-1] != 1 && rd[i+col] != 1 && cl[i] != 1) {
                board[i][col] = 1;
                ld[i - col + N - 1] = rd[i + col] = cl[i] = 1;
                if (solve(board, col + 1)) {
                    return true;
                } else {
                    board[i][col]=0;
                    ld[i - col + N - 1] = rd[i + col] = cl[i] = 0;
                }
            }
        }
        return false;
    }
    static boolean Queen(){
        int board[][] = {{ 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 }};
        if(solve(board,0)==false){
            System.out.println("not exists");
            return false;
        }
        printSolution(board);
        return true;
    }

    public static void main(String[] args) {
        Queen();
    }
}

class SubsetSum {
    int m;
    int w[]= new int[40];
    int x[]= new int[40];

    public void Subset(int s, int k, int r) {
        int i;
        x[k] = 1;
        if (s + w[k] == m) {
            for (i = 0; i <= k; i++) {
                System.out.print(x[i] + "\t");
            }
            System.out.println();
            System.out.print(" elements of set are \n");
            for (i = 0; i <= k; i++) {
                if (x[i] == 1)
                    System.out.print(w[i] + "\t");
            }
            System.out.println();

        } else if ((s + w[k] + w[k + 1]) <= m)
            Subset(s + w[k], k + 1, r - w[k]);
        if ((s + r - w[k] >= m) && (s + w[k + 1] <= m)) {
            x[k] = 0;
            Subset(s, k + 1, r - w[k]);
        }
    }
}

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader Bobj = new BufferedReader(new InputStreamReader(System.in));
        int i, r = 0;
        SubsetSum o = new SubsetSum();
        System.out.println(" enter the number of elements of set: ");
        int n = Integer.parseInt(Bobj.readLine());
        System.out.print("\n enter the elements: ");
        for (i = 0; i < n; i++) {
            o.w[i] = Integer.parseInt(Bobj.readLine());
            r = r + o.w[i];
        }
        System.out.print("\n enter the sum to be computed: ");
        o.m = Integer.parseInt(Bobj.readLine());
        System.out.print(" \n subset whose sum is " + o.m + " are as follows: ");
        o.Subset(0, 0, r);
    }
}

class GraphColoring{
    static int V=4;

    static void print(int[] color){
        System.out.println("Following are the assigned colors: ");
        for (int i=0;i<V;i++){
            System.out.print(" "+color[i]);
        }
        System.out.println();
    }
    static boolean isSafe(boolean[][] graph,int[] color){
        // kiểm tra mọi cạnh
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (graph[i][j] && color[j] == color[i]) {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean Coloring(boolean[][] graph,int m,int i,int[] color){
        // nếu chỉ mục hiện tại kết thúc
        if (i == V) {
            if (isSafe(graph, color))
            {
                print(color);
                return true;
            }
            return false;
        }
        // Gán mỗi màu từ 1 đến m
        for (int j = 1; j <= m; j++)
        {
            color[i] = j;
            //kt của các đỉnh còn lại
            if (Coloring(graph, m, i + 1, color)) {
                return true;
            }
            color[i] = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean[][] graph = {
                { false, true, true, true },
                { true, false, true, false },
                { true, true, false, true },
                { true, false, true, false },
        };
        int m = 3; // Number of colors

        int[] color = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = 0;
        if (!Coloring(graph, m, 0, color))
            System.out.println("Solution does not exist");
    }
}

class Hamilton{
    //đi qua mỗi cạnh 1 lần,O(n^n)
    final int V=5;
    int path[];
    //kiểm tra xem đỉnh v có thể là
    //được thêm vào chỉ mục 'pos' trong Hamilton Cycle
    boolean isSafe(int v,int[][] graph,int[] path,int pos){
       // Kiểm tra xem đỉnh này có phải là đỉnh liền kề của
       // đỉnh đã thêm trước đó.
        if(graph[path[pos-1]][v] == 0){
            return false;
        }
        //Kiểm tra xem đỉnh đã được bao gồm chưa
        for (int i=0;i<pos;i++){
            if(path[i] == v){
                return false;
            }
        }
        return true;
    }
    boolean hamCycle(int graph[][],int path[],int pos){
        if(pos == V){
            // Và nếu có một cạnh từ bao gồm cuối cùng
            // đỉnh đến đỉnh đầu tiên
            if(graph[path[pos-1]][path[0]] == 1){
                return true;
            }else {
                return false;
            }
        }
        for (int v=1;v<V;v++){
            if(isSafe(v,graph,path,pos)){
                path[pos] = v;
                if(hamCycle(graph,path,pos+1) == true){
                    return true;
                }
                path[pos] = -1; //ko duyệt đỉnh đó nữa
            }
        }
        return false;
    }
    int HamiltonKing(int[][] graph){
        path = new int[V];
        for (int i=0;i<V;i++){
            path[i] = -1;
        }
        path[0]=0;
        if(hamCycle(graph,path,1) == false){
            System.out.println("not exists");
            return 0;
        }
        print(path);
        return 1;
    }
    void print(int path[]){
        System.out.println("Tồn tại: ");
        for (int i=0;i<V;i++){
            System.out.print(" "+path[i]+" ");
        }
        System.out.println(" "+path[0]+" ");
    }

    public static void main(String[] args) {
        Hamilton hamiltonian =
                new Hamilton();
        int graph1[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };
        hamiltonian.HamiltonKing(graph1);

        int graph2[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
        };

        hamiltonian.HamiltonKing(graph2);
    }
}




