/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

/**
 *
 * @author Packt
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class Test {

    private List<Vertex> nodes;
    private List<Edge> edges;

    
    public void testExcute() {
        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
        for (int i = 0; i < 12; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }

        addLane("Edge_0", 0, 1, 2, 12);
        addLane("Edge_1", 0, 4, 1, 12);
        addLane("Edge_2", 1, 2, 1, 16);
        addLane("Edge_3", 1, 5, 3, 7);
        addLane("Edge_4", 2, 3, 2, 14);
        addLane("Edge_5", 3, 7, 1, 15);
        addLane("Edge_6", 4, 8, 1, 12);
        addLane("Edge_7", 5, 4, 5, 12);
        addLane("Edge_8", 5, 6, 1, 11);
        addLane("Edge_9", 5, 9, 4, 4);
        addLane("Edge_10", 6, 2, 3, 16);
        addLane("Edge_11", 6, 10, 10, 1);
        addLane("Edge_12", 7, 11, 15, 0);
        addLane("Edge_13", 8, 9, 8, 4);
        addLane("Edge_14", 9, 10, 3, 1);
        addLane("Edge_15", 10, 11, 1, 0);
        addLane("Edge_16", 7, 6, 5, 11);
        
        
        // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodes, edges);
        astr ast = new astr(graph);
        ast.execute(nodes.get(0));
        LinkedList<Vertex> path = ast.getPath(nodes.get(10));

        assertNotNull(path);
        assertTrue(path.size() > 0);

        for (Vertex vertex : path) {
            System.out.println(vertex);
        }

    }

    private void addLane(String laneId, int sourceLocNo, int destLocNo,
            int cost, int hval) {
        Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), cost, hval );
        edges.add(lane);
    }
}

