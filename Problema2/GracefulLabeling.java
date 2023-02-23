package Problema2;

import java.util.Collections;
import java.util.Vector;

public class GracefulLabeling
{
    boolean isGraceful(Vector allPerms, Graph g) {
        // n = card(V)
        int n = g.getVertexCount();

        // m = card(E)
        /* bidirection = true = > graph is oriented so we count edges / 2
           change to false if we have an unoriented graph */
        int m = g.getEdgesCount(true);
        System.out.println("Number of edges: " + m);
        Vector example = generateVec(m);

        Vector number = new Vector();

        for(int i = 0; i < factorial(n); i++) {
            number = (Vector) allPerms.get(i);
            Vector union = new Vector();

            // We check all Edges from Problema2.Graph
            for (int j = 0; j < g.getVertexCount(); j++) {
                boolean ok = false;
                for (int k = 0; k < g.getVertexCount(); k++) {
                    if(g.hasEdge(j, k)) {

                        // Check if x is unique and we add it in "union"
                        int x = number.indexOf(j) - number.indexOf(k);
                        if(x < 0) {
                            x = x * (-1);
                        }
                        if(union.indexOf(x) == -1) {
                            union.add(x);
                        } else {
                            ok = true;
                            break;
                        }
                    }
                }
                if(ok) {
                    break;
                }
            }

            Collections.sort(union);

            // You can see all the subset with System.out.println(union);

            // Check if union is {1,2, ..., m}
            if(union.equals(example)) {
                System.out.println(union);
                return true;
            }
        }

        return false;
    }

    public long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public Vector generateVec(int m) {
        Vector example = new Vector();
        for(int i = 1; i <= m; i++) {
            example.add(i);
        }

        return example;
    }
}


