import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CookieListTest {

    @Test
    public void testExample() {
        Street street = new Street(Arrays.asList("Ernie", "Cookie Monster", "Bert", "Count von Count", "Sam Eagle", "Statler", "Waldorf", "Big Bird", "Oscar the Grouch", "Elmo"));
        System.out.println(street);
        CookieList cookieList = new CookieList(street);
        cookieList.pruneStreet(Arrays.asList("Bert", "Sam Eagle", "Statler", "Waldorf", "Oscar the Grouch"));
        List<House> expected = Arrays.asList(new House(0, "Ernie"), new House(1, "Cookie Monster"), new House(3, "Count von Count"), new House(7, "Big Bird"), new House(9, "Elmo"));
        List<House> res = cookieList.listAllFriendlyHouses();
        assertEquals(expected, res);
    }

    @Test
    public void testNonInhabitants() {
        Street street = new Street(Arrays.asList("Ernie", "Cookie Monster", "Bert", "Count von Count", "Sam Eagle", "Statler", "Waldorf", "Big Bird", "Oscar the Grouch", "Elmo"));
        CookieList cookieList = new CookieList(street);
        cookieList.pruneStreet(Arrays.asList("Bert", "Grumpy", "Squidward", "Sam Eagle", "Statler", "Waldorf", "Eeyore", "Oscar the Grouch"));
        List<House> expected = Arrays.asList(new House(0, "Ernie"), new House(1, "Cookie Monster"), new House(3, "Count von Count"), new House(7, "Big Bird"), new House(9, "Elmo"));
        List<House> res = cookieList.listAllFriendlyHouses();
        assertEquals(expected, res);
    }

    @Test
    public void testDuplicates() {
        List<String> street = Arrays.asList("Henk", "Henk", "Bart", "Katy", "Henk");
        Street street2 = new Street(street);
        List<String> meanPeople = Arrays.asList("Henk", "Toby", "Barbara");
        CookieList scouts = new CookieList(street2);
//        System.out.println(scouts);
        System.out.println(street2);
        scouts.pruneStreet(meanPeople);
        System.out.println(street2);
        System.out.println(scouts.listAllFriendlyHouses());
    }
}