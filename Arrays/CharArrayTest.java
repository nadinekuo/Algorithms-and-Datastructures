import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharArrayTest {

    @Test
    void stringMethods() {
        String test = "Coati kingdom";
        String part = test.substring(0, 5);     // Coati
        System.out.println(test.substring(6));  // kingdom
        StringBuilder res = new StringBuilder();
        res.append(part).reverse();
        System.out.println(res);                // itaoC
    }

    @Test
    public void testExampleA() {
        String message = "attack the coatis.";
        MessageGarbler mg = new MessageGarbler(3);
        String expected = "ttakcaht c etao.si";
        String encoded = new String(mg.encrypt(message.toCharArray()));
        assertEquals(expected, encoded);
    }

    @Test
    public void testExampleB() {
        String message = "attack the coatis.";
        MessageGarbler mg = new MessageGarbler(4);
        String expected = "attat kcc ehitao.s";
        String encoded = new String(mg.encrypt(message.toCharArray()));
        assertEquals(expected, encoded);
    }

}