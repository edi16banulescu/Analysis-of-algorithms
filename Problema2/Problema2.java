package Problema2;

import java.util.Vector;

public class Problema2 {
    public static void main(String args[])
    {

        int[] arr = { 0, 1, 2, 3, 4 };
        Vector allPerms = new Vector();

        AllPermutation perm = new AllPermutation(arr);
        allPerms.add(perm.GetFirst());
        while (perm.HasNext())
        {
            allPerms.add(perm.GetNext());
        }

        Graph<Integer> g = new Graph<Integer>();

        g.addEdge(0, 1, false);
        g.addEdge(0, 4, false);
        g.addEdge(1, 2, false);
        g.addEdge(1, 4, false);
        g.addEdge(2, 3, false);
        g.addEdge(3, 4, false);
        g.addEdge(4, 3, false);

        GracefulLabeling test = new GracefulLabeling();
        System.out.println(g);

        if(test.isGraceful(allPerms, g))
            System.out.println("Graph has a graceful labeling");
        else
            System.out.println("Graph has NOT a graceful labeling");
    }
}
