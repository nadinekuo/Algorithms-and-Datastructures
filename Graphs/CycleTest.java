import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CycleTest {

    @Test
    void myTest() {
        GraphNode[] nodes = new GraphNode[8];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new GraphNode(i);
        }

        nodes[0].outgoingEdges.add(nodes[1]);
        nodes[1].outgoingEdges.add(nodes[2]);
        nodes[0].outgoingEdges.add(nodes[3]);
        nodes[3].outgoingEdges.add(nodes[4]);
        nodes[4].outgoingEdges.add(nodes[5]);
        nodes[5].outgoingEdges.add(nodes[6]);
        nodes[6].outgoingEdges.add(nodes[7]);
        nodes[7].outgoingEdges.add(nodes[3]);

        assertTrue(DetectCycleDirectedG.detectCycle(nodes[0], Arrays.asList(nodes.clone())));
    }


    // Tests: https://imgur.com/a/OQHKXn4
    /**
     * Graph: https://i.imgur.com/ty3flio.png
     */
    @Test
    public void testNoCycle() {
        GraphNode[] nodes = new GraphNode[4];
        for (int i = 0; i < nodes.length; i++)
            nodes[i] = new GraphNode(i);
        nodes[0].outgoingEdges.add(nodes[1]);
        nodes[0].outgoingEdges.add(nodes[2]);
        nodes[2].outgoingEdges.add(nodes[3]);
        nodes[3].outgoingEdges.add(nodes[1]);
        System.out.println(DetectCycleDirectedG.detectCycle(nodes[0], Arrays.asList(nodes.clone())));
        assertEquals(false, DetectCycleDirectedG.detectCycle(nodes[0], Arrays.asList(nodes.clone())));
    }

    /**
     * Graph: https://i.imgur.com/IuPAZTV.png
     */
    @Test
    public void testCycle() {
        GraphNode[] nodes = new GraphNode[5];
        for (int i = 0; i < nodes.length; i++)
            nodes[i] = new GraphNode(i);

        nodes[0].outgoingEdges.add(nodes[1]);
        nodes[0].outgoingEdges.add(nodes[2]);
        nodes[1].outgoingEdges.add(nodes[2]);
        nodes[2].outgoingEdges.add(nodes[3]);
        nodes[3].outgoingEdges.add(nodes[4]);
        nodes[4].outgoingEdges.add(nodes[2]);

        assertTrue(DetectCycleDirectedG.detectCycle(nodes[0], Arrays.asList(nodes.clone())));
    }

}
