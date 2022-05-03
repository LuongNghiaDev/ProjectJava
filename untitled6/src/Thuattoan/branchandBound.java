package Thuattoan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class branchandBound {
    //Knapsack problem(cái túi)
    float weight;
    int value;
    int idx;
    public branchandBound() {}
    public branchandBound(int value, float weight, int idx)
    {
        this.value = value;
        this.weight = weight;
        this.idx = idx;
    }
}

class node {
    float ub;
    float lb;
    int level;
    boolean flag;
    float tv;
    float tw;
    public node() {}
    public node(node cpy)
    {
        this.tv = cpy.tv;
        this.tw = cpy.tw;
        this.ub = cpy.ub;
        this.lb = cpy.lb;
        this.level = cpy.level;
        this.flag = cpy.flag;
    }
}

class sortByC implements Comparator<node> {
    public int compare(node a, node b)
    {
        boolean temp = a.lb > b.lb;
        return temp ? 1 : -1;
    }
}

class sortByRatio implements Comparator<branchandBound> {
    public int compare(branchandBound a, branchandBound b)
    {
        boolean temp = (float)a.value
                / a.weight
                > (float)b.value
                / b.weight;
        return temp ? -1 : 1;
    }
}

class knapsack {

    private static int size;
    private static float capacity;

    static float upperBound(float tv, float tw, int idx, branchandBound arr[])
    {
        float value = tv;
        float weight = tw;
        for (int i = idx; i < size; i++) {
            if (weight + arr[i].weight
                    <= capacity) {
                weight += arr[i].weight;
                value -= arr[i].value;
            }
            else {
                value -= (float)(capacity
                        - weight)
                        / arr[i].weight
                        * arr[i].value;
                break;
            }
        }
        return value;
    }

    static float lowerBound(float tv, float tw, int idx, branchandBound arr[])
    {
        float value = tv;
        float weight = tw;
        for (int i = idx; i < size; i++) {
            if (weight + arr[i].weight
                    <= capacity) {
                weight += arr[i].weight;
                value -= arr[i].value;
            }
            else {
                break;
            }
        }
        return value;
    }

    static void assign(node a, float ub, float lb, int level, boolean flag, float tv, float tw)
    {
        a.ub = ub;
        a.lb = lb;
        a.level = level;
        a.flag = flag;
        a.tv = tv;
        a.tw = tw;
    }

    public static void solve(branchandBound arr[])
    {
        Arrays.sort(arr, new sortByRatio());

        node current, left, right;
        current = new node();
        left = new node();
        right = new node();

        float minLB = 0, finalLB = Integer.MAX_VALUE;
        current.tv = current.tw = current.ub
                = current.lb = 0;
        current.level = 0;
        current.flag = false;

        PriorityQueue<node> pq = new PriorityQueue<node>(new sortByC());
        pq.add(current);

        boolean currPath[] = new boolean[size];
        boolean finalPath[] = new boolean[size];

        while (!pq.isEmpty()) {
            current = pq.poll();
            if (current.ub > minLB
                    || current.ub >= finalLB) {
                continue;
            }

            if (current.level != 0)
                currPath[current.level - 1]
                        = current.flag;

            if (current.level == size) {
                if (current.lb < finalLB) {
                    for (int i = 0; i < size; i++)
                        finalPath[arr[i].idx]
                                = currPath[i];
                    finalLB = current.lb;
                }
                continue;
            }

            int level = current.level;

            assign(right, upperBound(current.tv,
                            current.tw,
                            level + 1, arr),
                    lowerBound(current.tv, current.tw,
                            level + 1, arr),
                    level + 1, false,
                    current.tv, current.tw);

            if (current.tw + arr[current.level].weight
                    <= capacity) {

                left.ub = upperBound(
                        current.tv
                                - arr[level].value,
                        current.tw
                                + arr[level].weight,
                        level + 1, arr);
                left.lb = lowerBound(
                        current.tv
                                - arr[level].value,
                        current.tw
                                + arr[level].weight,
                        level + 1,
                        arr);
                assign(left, left.ub, left.lb,
                        level + 1, true,
                        current.tv - arr[level].value,
                        current.tw
                                + arr[level].weight);
            } else {
                left.ub = left.lb = 1;
            }

            minLB = Math.min(minLB, left.lb);
            minLB = Math.min(minLB, right.lb);

            if (minLB >= left.ub)
                pq.add(new node(left));
            if (minLB >= right.ub)
                pq.add(new node(right));
        }
        System.out.println("Items taken"
                + "into the knapsack are");
        for (int i = 0; i < size; i++) {
            if (finalPath[i])
                System.out.print("1 ");
            else
                System.out.print("0 ");
        }
        System.out.println("\nMaximum profit"
                + " is " + (-finalLB));
    }

    // Driver code
    public static void main(String args[])
    {
        size = 4;
        capacity = 15;

        branchandBound arr[] = new branchandBound[size];
        arr[0] = new branchandBound(10, 2, 0);
        arr[1] = new branchandBound(10, 4, 1);
        arr[2] = new branchandBound(12, 6, 2);
        arr[3] = new branchandBound(18, 9, 3);

        solve(arr);
    }
}

class TravelingSaleman{
    static int N = 4;
    static int final_path[] = new int[N + 1];
    static boolean visited[] = new boolean[N];
    static int final_res = Integer.MAX_VALUE;

    static void copyToFinal(int curr_path[])
    {
        for (int i = 0; i < N; i++)
            final_path[i] = curr_path[i];
        final_path[N] = curr_path[0];
    }

    static int firstMin(int adj[][], int i)
    {
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < N; k++)
            if (adj[i][k] < min && i != k)
                min = adj[i][k];
        return min;
    }


    static int secondMin(int adj[][], int i)
    {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int j=0; j<N; j++)
        {
            if (i == j)
                continue;

            if (adj[i][j] <= first)
            {
                second = first;
                first = adj[i][j];
            }
            else if (adj[i][j] <= second &&
                    adj[i][j] != first)
                second = adj[i][j];
        }
        return second;
    }

    static void TSPRec(int adj[][], int curr_bound, int curr_weight, int level, int curr_path[]) {
        if (level == N)
        {
            if (adj[curr_path[level - 1]][curr_path[0]] != 0)
            {
                int curr_res = curr_weight +
                        adj[curr_path[level-1]][curr_path[0]];

                if (curr_res < final_res)
                {
                    copyToFinal(curr_path);
                    final_res = curr_res;
                }
            }
            return;
        }

        for (int i = 0; i < N; i++)
        {
            if (adj[curr_path[level-1]][i] != 0 &&
                    visited[i] == false)
            {
                int temp = curr_bound;
                curr_weight += adj[curr_path[level - 1]][i];

                if (level==1)
                    curr_bound -= ((firstMin(adj, curr_path[level - 1]) +
                            firstMin(adj, i))/2);
                else
                    curr_bound -= ((secondMin(adj, curr_path[level - 1]) +
                            firstMin(adj, i))/2);

                if (curr_bound + curr_weight < final_res)
                {
                    curr_path[level] = i;
                    visited[i] = true;

                    TSPRec(adj, curr_bound, curr_weight, level + 1,
                            curr_path);
                }

                curr_weight -= adj[curr_path[level-1]][i];
                curr_bound = temp;

                Arrays.fill(visited,false);
                for (int j = 0; j <= level - 1; j++)
                    visited[curr_path[j]] = true;
            }
        }
    }

    static void TSP(int adj[][])
    {
        int curr_path[] = new int[N + 1];

        int curr_bound = 0;
        Arrays.fill(curr_path, -1);
        Arrays.fill(visited, false);

        for (int i = 0; i < N; i++)
            curr_bound += (firstMin(adj, i) +
                    secondMin(adj, i));

        curr_bound = (curr_bound==1)? curr_bound/2 + 1 :
                curr_bound/2;

        visited[0] = true;
        curr_path[0] = 0;

        TSPRec(adj, curr_bound, 0, 1, curr_path);
    }

    public static void main(String[] args)
    {
        int adj[][] = {{0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}    };

        TSP(adj);

        System.out.printf("Minimum cost : %d\n", final_res);
        System.out.printf("Path Taken : ");
        for (int i = 0; i <= N; i++)
        {
            System.out.printf("%d ", final_path[i]);
        }
    }
}











