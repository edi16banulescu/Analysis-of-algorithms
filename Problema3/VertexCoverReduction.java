package Problema3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class VertexCoverReduction {

        public static void main(String[] args) throws IOException {
                Graph<Integer> g = new Graph<Integer>();
                Integer[] solution = {1, 2, 3, 4, 5};

                g.addEdge(1, 2, true);
                g.addEdge(1, 3, true);
                g.addEdge(1, 4, true);
                g.addEdge(2, 3, true);
                g.addEdge(3, 4, true);
                g.addEdge(5, 1, true);
                g.addEdge(5, 4, true);

                System.out.println(g);

                int n = g.getVertexCount();
                Integer[][] subSets = new Integer[n + 1][n];

                // We initialize all subSets with neighbors of the "i" node
                for(int i = 1; i <= g.getVertexCount(); i++) {
                        int k = 0;
                        for(int j = 1; j <= g.getVertexCount(); j++) {
                                if(g.hasEdge(i, j)) {
                                        subSets[i][k] = j;
                                        k++;
                                }
                        }
                }

                VertexCoverReduction aux = new VertexCoverReduction();
                SetCover mySet = new SetCover();
                
                aux.compact(subSets);
                System.out.println(Arrays.deepToString(subSets));
                mySet.test(subSets, solution);

        }

        // Function to remove all "null" elements from subSets
        public void compact(Integer[][] registrations) {

                for (int i = 0; i < registrations.length; i++) {
                        // creates a list to store the elements != null
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        for (int j = 0; j < registrations[i].length; j++) {
                                if(registrations[i][j] != null) {
                                        // elements != null will be added to the list.
                                        list.add(registrations[i][j]);
                                }
                        }

                        // all elements from list to an array.
                        registrations[i] = list.toArray(new Integer[list.size()]);
                }
        }
}
