import java.util.*;

public class BreadthFS {
    static char[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'S'};
    static int[] e = {2, 2, 2, 2, 2, 2, 3, 3};
    static int[][] list = {
        {3, 7}, 
        {4, 7}, 
        {5, 7}, 
        {0, 6}, 
        {1, 6}, 
        {2, 6}, 
        {3, 4, 5}, 
        {0, 1, 2}
    }; // adjacency list of graph

    static int[] checked = new int[20];
    static int[] que = new int[20];
    static int first = 0, last = 0;

    public static void main(String[] args) {
        int i, n;
        enq(7);
        while (first < last) {
            n = dq();
            for (i = 0; i < e[n]; i++) {
                if (notChecked(list[n][i]) == 1) {
                    enq(list[n][i]);
                }
            }
        }
    }

    static int notChecked(int n) { // Checks if the node is visited or not
        return checked[n] == 1 ? 0 : 1;
    }

    static void enq(int n) { // Enqueue node
        checked[n] = 1;
        que[last] = n;
        last++;
    }

    static int dq() { // Dequeue node
        System.out.print(c[que[first]] + " ");
        return que[first++];
    }
}
