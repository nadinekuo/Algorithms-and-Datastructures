import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    public void matchingParenthesis() {
        String test = "{}[]()}{";
        String test2 = "([{}])";
        assertFalse(MatchingParenthesis.isMatched(test));
    }

}