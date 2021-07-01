import java.util.*;

class CookieList {

    Street street;

    public CookieList(Street street) {
        this.street = street;
    }

    /**
     * Prunes the street, to remove all mean people.
     * GO OVER ARRAY, REMOVE ALL NAMES MARKED AS MEAN
     * @param meanPeople - the list of mean people that will need to be removed from the array of street
     *                   RESULT: STREET ARRAY WITH MANY NULLS
     */
    public void pruneStreet(List<String> meanPeople) {
        for (int i = 0; i < street.size(); i++) {           // Street has custom size() method
            String owner = street.getNeighbour(i);
            if (meanPeople.contains(owner)) {
                street.removeNeighbour(i);
            }
        }
    }

    /**
     * Turns the sparse array containing all nice people in the street into a list,
     * where each element is a House object that stores the house number and name of the inhabitant.
     * NO REMOVED ENTRIES (MEAN PEOPLE)
     * @return a list of houses with all the nice people
     * HOUSE: STORES TUPLES OF HOUSE NO. + NAME OWNER
     */
    public List<House> listAllFriendlyHouses() {
        List<House> result = new ArrayList<>();

        for (int i = 0; i < street.size(); i++) {
            if (street.getNeighbour(i) != null) {
                House nice = new House(i, street.getNeighbour(i));
                result.add(nice);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < street.size(); i++) {
            sb.append(street.getNeighbour(i));
            if (i != street.size()-1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}

