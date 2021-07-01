import java.util.*;

public class KruskalCoatis {


    /**
     * @param village ADJACENCY MAP representing the village.
     * @param coatiHouses The IDs of the coati houses that should be connected.
     * @return The Set of roads on which the traps should be dismantled/destroyed, such that all houses are connected safely while dismantling as few traps as possible.
     *  ONLY THE HOUSES whose IDs are contained in coatiHouses Set should be considered,
     *  OTHER HOUSES SHOULD NOT BE TRAVELLED ACROSS!
     *  So MST contains all vertices/HOUSES in Set coatiHouses only!! (not all in graph necessarily)
     *      lowest weight = LEAST AMOUNT OF TRAPS
     *  In case it is impossible to regroup all coatis, that is: at least one coati house cannot be connected to the others, the function should return null.
     *  ----->   Disconnected Graph?!?! --> RETURN NULL
     *  ----->  Houses in given set are not sufficient to connect them all ?!?  --> RETURN NULL
     *  GRAPH/Village: Adjacency Map <-- list of Hashmaps
     *                  K: Adjacent Houses/vertices (only neighbours with HIGHER ID stored)
     *                  V: amount Traps/edge weight
     *  VERTICES/Coati Houses
     */
    public static Set<Road> regroupTheCoatis(List<Map<Integer, Integer>> village, Set<Integer> coatiHouses) {

        if (village == null || coatiHouses == null) return null;

        Set<Road> resultMST = new HashSet<>();
        if (village.isEmpty() || coatiHouses.isEmpty()) return resultMST;

        // Start: each vertex/house forms a single cluster
        // Union-Find: n disjoint sets each containing 1 element, labelled from 0 - (n-1)!!!
        UnionFind partitions = new UnionFind(village.size());
        // Contains all vertices, but we ignore the forbidden ones

        // add all edges to PQ --> removeMin gives smallest weight (cost) (see compareTo())
        PriorityQueue<Road> pq = new PriorityQueue<>();
        for (int i = 0; i < village.size(); i++) {
            if (coatiHouses.contains(i)) {                       // ONLY CONSIDER HOUSES (ids) IN PASSED SET. (I am assuming house ids are sorted like 0, 1, 2..)
                Map<Integer, Integer> roads = village.get(i);    // each vertex/house holds Adjacency Map
                if (roads != null) {
                    for (int to : roads.keySet()) {                   // KEY: neighbour House id
                        if (coatiHouses.contains(to)) {
                            Road RoadToInsert = new Road(i, to, roads.get(to));   // VALUE: edge weight
                            pq.add(RoadToInsert);
                            System.out.println("Road/Edge inserted in PQ: FROM " + RoadToInsert.getFrom() + " TO " + RoadToInsert.getTo() + ", #TRAPS/weight: " + RoadToInsert.getTraps());
                        }
                    }
                }
            }
        }

        // Repeat until 1 cluster formed of ALL VERTICES (IN THE SET!):
        // so in the end, there may be "additional" clusters of single houses!
        while (!pq.isEmpty()) {                         // Pick edge(u,v) with smallest weight (cost) NOT part of MST yet <-- removeMin
            Road smallest = pq.remove();
            // union() merges 2 clusters (using each vertex' ID)
            if (partitions.union(smallest.getFrom(), smallest.getTo())) {  // If clusters of u, v are different: merge (true returned)
                resultMST.add(smallest);                                   // Else, don't include edge in MST.
                System.out.println("New Road/Edge added to MST: FROM " + smallest.getFrom() + " TO " + smallest.getTo() + ", #TRAPS/weight: " + smallest.getTraps());
            }
        }

        // Check if all houses IN SET are in 1 cluster now! They must all have the same cluster ID.
        // The method int find(int u) returns the ID of the set that contains element u.
        List<Integer> setToList = new ArrayList<>(coatiHouses);     // TURN SET INTO LIST: to iterate over House id's
        for(int i = 1; i < coatiHouses.size(); i++) {
            int curr = setToList.get(i);
            int prev = setToList.get(i-1);
            if (partitions.find(curr) != partitions.find(prev)) {    // WE ONLY CONSIDER THE CLUSTERS of houses in the set (other clusters, containing 1 house only, ignored)
                return null;
            }
        }
        return resultMST;
    }



    // Koen's implementation: (set of forbidden houses/vertices given instead)


    /**
     * @param village Adjacency map representation of the town.
     * @param tooManyCoatis The Roads that contain too many coatis. FORBIDDEN SET. <--- MST CANT contain these Roads
     * @return The Roads the messenger owls should take.
     *      *  GRAPH/Village: Adjacency Map <-- list of Hashmaps
     *      *                  K: Adjacent Houses/vertices
     *      *                  V: amount Traps/edge weight
     *      *  VERTICES/Coati Houses
     */
    public static Set<Road> relocateTheOwls(List<Map<Integer, Integer>> village, Set<Road> tooManyCoatis) {

        if(village == null) {
            return null;
        }

        PriorityQueue<Road> pq = new PriorityQueue<>();         // PQ contains Roads/Edges
        for(int i = 0; i < village.size(); i++) {
            Map<Integer, Integer> Roads = village.get(i);       // Each Vertex/House holds Adjacency Map
            if(Roads != null) {     // if it has neighbours
                for(int to : Roads.keySet()) {       // KEY: neighbour House id
                    Road Road = new Road(i, to, Roads.get(to));     // VALUE: edge weight
                    if(!tooManyCoatis.contains(Road)) {
                        pq.add(Road);                    // EDGES IN FORBIDDEN SET NOT INSERTED IN PQ.
                    }
                }
            }
        }

        UnionFind uf = new UnionFind(village.size());   // #partitions = graph size
        Set<Road> mst = new HashSet<>();
        while(!pq.isEmpty()) {
            Road front = pq.remove();

            if(uf.union(front.getFrom(), front.getTo())) {      // if not merged yet (true returned)
                mst.add(front);
            }
        }

        // Check if all houses are in 1 cluster now! They must all have the same cluster ID.
        // The method int find(int u) returns the ID of the set that contains element u.
        for(int i = 1; i < village.size(); i++) {
            if(uf.find(i) != uf.find(i-1)) {
                return null;
            }
        }

        return mst;
    }



}



