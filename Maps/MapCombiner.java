import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class MapCombiner<K, V> {

    /**
     * Combine map.
     * @param list - arraylist of maps
     * @return the result map
     */
    public Map<K, V> combine(ArrayList<Map<K, V>> list) {
        Map<K, V> result = new HashMap<>();
        if (list != null && list.size() > 0) {
            combineHelper(list, 0, list.size() - 1, result);
        }
        return result;
    }

    /**
     * Combine map helper. MODIFIES result Map directly.
     * @param list
     * @return the modified result map
     */
    private void combineHelper(ArrayList<Map<K, V>> list, int i, int k, Map<K, V> result) {
        // base case
        if (i == k) {
            result.putAll(list.get(i));         // addAll (ArrayLists) for Maps: put all entries in the Map in the result Map
            return;
        }

        int mid = i + (k - i) / 2;
        combineHelper(list, i, mid, result);
        combineHelper(list, mid + 1, k, result);
    }

}