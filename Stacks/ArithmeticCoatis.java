import java.util.Scanner;
import java.util.Stack;

public class ArithmeticCoatis {


    /**
     * Evaluates an expression in coati notation.
     * @param expression String containing the expression.
     * @return The result of the expression.
     * O(n) time !!
     * ALL INTEGER NUMBERS
     * +, -, *, /, ^
     * Your implementation should throw an IllegalArgumentException if the input is invalid
     * (e.g. not in proper coati notation, contains illegal characters, etc.) --> handled by switch default
     * WHAT IF YOU HAVE 333+ ? --> digits left in stack
     */
    public static int compute(String expression) {

        Scanner sc = new Scanner(expression);
        Stack<Integer> numbers = new Stack<>();

        while(sc.hasNext()) {
            if (sc.hasNextInt()) {              // CASE 1: next is int
                numbers.push(sc.nextInt());
            } else {                            // CASE 2: next is operator!
                if (numbers.size() < 2) {
                    sc.close();
                    throw new IllegalArgumentException("You only gave 0 or 1 operand! Expression must start with 2 at least.");
                }

                String operator = sc.next();
                int operand2 = numbers.pop();
                int operand1 = numbers.pop();
                switch (operator) {
                    case ("+"):
                        numbers.push(operand1 + operand2);
                        break;
                    case ("-"):
                        numbers.push(operand1 - operand2);
                        break;
                    case ("*"):
                        numbers.push(operand1 * operand2);
                        break;
                    case ("/"):
                        numbers.push(operand1 / operand2);
                        break;
                    case ("^"):
                        numbers.push((int) Math.pow(operand1, operand2));
                        break;
                    default:
                        sc.close();
                        throw new IllegalArgumentException("Invalid character!");
                }
            }
        }

        sc.close();
        int result = numbers.pop();
        if (!numbers.isEmpty()) {
            sc.close();
            throw new IllegalArgumentException("You have too few operators! (too many operands)");
        }
        return result;
    }


    /**
     * Evaluates an expression in coati notation.
     * @param expression String containing the expression.
     * @return The result of the expression.
     * O(n) time !!
     * ALL INTEGER NUMBERS
     * +, -, *, /, ^
     * Your implementation should throw an IllegalArgumentException if the input is invalid
     * (e.g. not in proper coati notation, contains illegal characters, etc.).
     * WHAT IF YOU HAVE 333+ ? --> digits left in stack
     */
    public static int compute2(String expression) {
        Scanner sc = new Scanner(expression);           // scan string (space separated)
        Stack<Integer> numbers = new Stack<>();
        while (sc.hasNext()) {
            if(sc.hasNextInt()) {                   // string must START with numbers!
                numbers.push(sc.nextInt());          // only push numbers, not operators
                continue;                            // continue to NEXT LOOP! So is there's another number after this, it will be pushed too
            }
            String arithmetic = sc.next();          // All first numbers pushed, so this is an operator
            if (arithmetic.length() > 1) {
                sc.close();
                throw new IllegalArgumentException("2 chars not separated!");
            }
            if (numbers.isEmpty()) {
                sc.close();
                throw new IllegalArgumentException("Expression did not start with any number!");
            }
            int operand1 = numbers.pop();
            if (numbers.isEmpty()) {
                sc.close();
                throw new IllegalArgumentException("You only gave 1 operand!");
            }
            int operand2 = numbers.pop();                // operand2 is the first term!
            switch(arithmetic) {
                case "+":
                    numbers.push(operand1+operand2);
                    break;
                case "-":
                    numbers.push(operand2-operand1);
                    break;
                case "*":
                    numbers.push(operand1*operand2);
                    break;
                case "/":
                    numbers.push(operand2/operand1);
                    break;
                case "^":
                    numbers.push((int)Math.pow(operand2, operand1));
                    break;
                default:
                    sc.close();
                    throw new IllegalArgumentException("Invalid char! Not an operator. ");
            }
        }
        sc.close();
        int result = numbers.pop();
        if (!numbers.isEmpty()) throw new IllegalArgumentException();        // if still digits left (333+ e.g.)
        return result;
    }



}
