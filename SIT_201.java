import java.util.Stack;

public class SIT_201 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        sort(stack);

        System.out.println("Sorted stack (top to bottom):");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    static void sort(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            //pop the top element from the original stack and store it in the temp variable
            int temp = stack.pop();
//while tempstack is not empty and the top element of tempstack is greater than temp, pop from tempstack and push it back to the original stack
            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                stack.push(tempStack.pop());
            }

            tempStack.push(temp);
        }
// Move sorted elements back to original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
}