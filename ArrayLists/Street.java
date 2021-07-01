import java.util.List;

class Street {

    // index is house number
    // value is name of inhabitant
    private String[] inhabitants;

    public Street(int n) {
        this.inhabitants = new String[n];
    }

    // constructs array from given arraylist
    public Street(List<String> inhabitants) {
        this.inhabitants = new String[inhabitants.size()];
        for (int i = 0; i < inhabitants.size(); i++) {
            this.inhabitants[i] = inhabitants.get(i);
        }
    }

    public String getNeighbour(int i) throws IllegalArgumentException {
        if (i < 0 || i >= inhabitants.length) {
            throw new IllegalArgumentException("No neighbour at that index.");
        }
        return this.inhabitants[i];
    }

    public void removeNeighbour(int i) throws IllegalArgumentException {
        if (i < 0 || i >= inhabitants.length) {
            throw new IllegalArgumentException("No neighbour at that index.");
        }
        this.inhabitants[i] = null;
    }

    // replaces value at index (no shifting!!)
    public void addNeighbour(int i, String neighbour) throws IllegalArgumentException {
        if (i < 0 || i >= inhabitants.length) {
            throw new IllegalArgumentException("No neighbour at that index.");
        }
        this.inhabitants[i] = neighbour;
    }

    public int size() {
        return this.inhabitants.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.inhabitants.length; i++) {
            sb.append(i);
            sb.append(": ");
            sb.append(this.inhabitants[i]);
            sb.append("\n");
        }
        return sb.toString();
    }
}