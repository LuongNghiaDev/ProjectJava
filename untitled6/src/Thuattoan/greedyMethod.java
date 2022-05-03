package Thuattoan;

import java.util.*;

public class greedyMethod {
    //đường dẫn ngắn nhất(ShortestPath) - dijkstra
    static final int V =9;

    int minDinstance(int dist[],Boolean sptSet[]){
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v=0;v<V;v++){
            if(sptSet[v] == false && dist[v] <= min){
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    void print(int dist[]){
        System.out.println("Vertex \t\t Distance from Source");
        for (int i=0;i<V;i++){
            System.out.println(i + " \t\t" + dist[i]);
        }
    }

    void dijkstra(int graph[][],int src){
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V];

        for (int i=0;i<V;i++){
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src] = 0;//đỉnh gốc

        for (int count=0;count < V-1;count++){
            //cập nhật giá trị của đỉnh liền kề của đỉnh đã chọn
            int u = minDinstance(dist,sptSet);
            sptSet[u] = true;

            //chỉ cập nhật dist[v] nếu ko có trong sptSet
            for (int v=0;v<V;v++){
                if(!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                && dist[u] + graph[u][v] < dist[v]){

                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        print(dist);
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        greedyMethod t = new greedyMethod();
        t.dijkstra(graph, 0);
    }
}

class HuffmanNode{
    int data;
    char c;

    HuffmanNode left;
    HuffmanNode right;
}
class MyComparator implements Comparator<HuffmanNode>{

    @Override
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.data - y.data;
    }
}
class HuffmanCoding{
    public static void print(HuffmanNode root,String s){
        if(root.left == null && root.right == null && Character.isLetter(root.c)){
            System.out.println(root.c + ":" + s);
            return;
        }
        print(root.left,s+"0");
        print(root.right,s+"1");
    }

    public static void main(String[] args) {
        int n = 6;
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };

        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new MyComparator());

        for (int i=0;i < n;i++){
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.data = charfreq[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }
        HuffmanNode root = null;
        while (q.size() > 1){
            HuffmanNode x = q.peek();
            q.poll();

            HuffmanNode y = q.peek();
            q.poll();

            HuffmanNode f = new HuffmanNode();
            f.data = x.data + y.data;
           //&&  f.c = '-';

            f.left = x;
            f.right = y;

            root = f;
            q.add(f);
        }
        print(root,"");
    }
}

class OptimalMergePatterns{
    //hợp nhất tệp tối ưu
    static int minCompu(int files[],int size){
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i=0;i<size;i++){
            q.add(files[i]);
        }
        int count=0;

        while (q.size() > 1){
            int temp = q.poll() + q.poll();
            count += temp;
            q.add(temp);
        }
        return count;
    }

    public static void main(String[] args) {
        int size = 5;

        int files[] = new int[] { 5, 20, 10, 30, 30 };

        System.out.println("Minimum Computations = "
                + minCompu(files, size));
    }
}

class JobSequencing{
    //việc lm thời hạn tốt nhất
    char id;
    int dealine,profit;

    public JobSequencing(){}

    public JobSequencing(char id,int dealine,int profit){
        this.id=id;
        this.dealine=dealine;
        this.profit=profit;
    }

    void printJob(ArrayList<JobSequencing> arr,int t){
        int n = arr.size();

        Collections.sort(arr,(a,b)->b.profit - a.profit);
        //lưu trữ khoảng thời gian rảnh
        boolean result[] = new boolean[t];

        //lưu trữ kết quả
        char job[] = new char[t];

        for (int i=0;i<n;i++){
            for (int j= Math.min(t-1,arr.get(i).dealine-1);j>=0;j--){
                if(result[j] == false){
                    result[j] = true;
                    job[j] = arr.get(i).id;
                    break;
                }
            }
        }

        for (char jb : job){
            System.out.print(jb + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<JobSequencing> arr = new ArrayList<JobSequencing>();

        arr.add(new JobSequencing('a', 2, 100));
        arr.add(new JobSequencing('b', 1, 19));
        arr.add(new JobSequencing('c', 2, 27));
        arr.add(new JobSequencing('d', 1, 25));
        arr.add(new JobSequencing('e', 3, 15));

        System.out.println("Following is maximum "
                + "profit sequence of jobs");

        JobSequencing job = new JobSequencing();

        job.printJob(arr, 3);
    }
}

class FractionalKnapsack{
    //đc phép bẻ đồ(cái túi)
    static class ItemValue{
        Double cost;
        double wt,val,ind;

        public ItemValue(double wt,double val,double ind){
            this.wt=wt;
            this.val=val;
            this.ind=ind;
            cost = new Double((double) val / (double) wt);
        }
    }

    private static double getMaxValue(int wt[], int val[], int capacity){
        ItemValue[] iVal = new ItemValue[wt.length];

        for (int i=0;i < wt.length;i++){
            iVal[i] = new ItemValue(wt[i], val[i] ,i);
        }

        Arrays.sort(iVal, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                return o2.cost.compareTo(o1.cost);
            }
        });

        double totalValue = 0d;
        for (ItemValue i : iVal){
            int curWt = (int)i.wt;
            int curVal = (int)i.val;

            if(capacity - curWt >= 0){
                capacity -= curWt;
                totalValue += curVal;
            }else {
                double fraction = ((double) capacity / (double) curWt);
                totalValue += (curVal * fraction);
                capacity = (int)(capacity - (curWt * fraction));
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        int[] wt = { 10, 40, 20, 30 };
        int[] val = { 60, 40, 100, 120 };
        int capacity = 50;

        double maxValue = getMaxValue(wt, val, capacity);

        // Function call
        System.out.println("Maximum value we can obtain = "
                + maxValue);
    }
}











