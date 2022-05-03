package Thuattoan;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSDFS {
    //BFS-tìm kiếm theo chiều rộng
    private int node;
    private LinkedList<Integer> adj[];
    private Queue<Integer> que;
    BFSDFS(int v){
        node = v;
        adj = new LinkedList[node];
        for(int i=0;i<v;i++){
            adj[i] = new LinkedList<>();
        }
        que = new LinkedList<>();
    }

    void insert(int v,int w){
        adj[v].add(w);
    }

    void BFS(int n){
        boolean nodes[] = new boolean[node];
        int a =0;
        nodes[n] = true;
        que.add(n);
        while (que.size() != 0){
            n = que.poll();
            System.out.println(n+ "");
            for (int i=0;i<adj[n].size();i++){
                a = adj[n].get(i);
                if(!nodes[a]){
                    nodes[a] = true;
                    que.add(a);
                }
            }
        }
    }

}
class DFS{
    //DFS-tìm kiếm theo chiều sâu
    int V;
    LinkedList<Integer> adj[];
    DFS(int V){
        this.V = V;
        adj = new LinkedList[V];
        for (int i=0;i<adj.length;i++){
            adj[i] = new LinkedList<>();
        }
    }

    void insert(int v,int w){
        adj[v].add(w);
    }

    void DFSS(int n){
        boolean[] nodes = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        int a =0;
        while (!stack.empty()){
            n = stack.peek();
            stack.pop();
            if(nodes[n] == false){
                System.out.println(n+" ");
                nodes[n] = true;
            }
            for (int i=0;i<adj[n].size();i++){
                a = adj[n].get(i);
                if(!nodes[a]){
                    stack.push(a);
                }
            }
        }
    }

}
