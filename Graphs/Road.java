import java.util.*;

class Road implements Comparable<Road> {

    private int from;

    private int to;

    private int traps;      // The cost of each path is the amount of traps set on it.

    /**
     * Represents a road from `from` to `to` with `traps` traps.
     * @param from ID of the house on one side.
     * @param to ID of the house on the other side.
     * @param traps Amount of traps on this road.
     */
    public Road(int from, int to, int traps) {
        this.from = from;
        this.to = to;
        this.traps = traps;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getTraps() {
        return traps;
    }

    /**
     * Compares the amount of traps of this road to that on another.
     * @param o Road to compare to.
     * @return -1 if `this` road has fewer traps, 1 if it has more, or 0 if both have an equal amount of traps.
     */
    @Override
    public int compareTo(Road o) {
        return Integer.compare(this.traps, o.traps);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Road road = (Road) o;
        // it doesnt matter whether you give Road(7, 8, 1) or Road(8, 7, 1)!!
        return ((from == road.from && to == road.to) || (from == road.to && to == road.from)) && traps == road.traps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.min(from, to), Math.max(from, to), traps);
    }

    @Override
    public String toString() {
        return "Road{" + "from=" + from + ", to=" + to + ", traps=" + traps + '}';
    }
}