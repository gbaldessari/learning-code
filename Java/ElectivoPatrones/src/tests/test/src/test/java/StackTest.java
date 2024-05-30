import org.junit.Before;
import org.junit.Test;

import test.Stack;

import static org.junit.Assert.*;
import java.util.EmptyStackException;

public class StackTest {
    Stack<Integer> stack;

    @Before
    public void init() {
        stack = new Stack<>();
    }

    @Test
    public void testPush() {
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
    }

    @Test
    public void testPop() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop().intValue());
        assertEquals(1, stack.pop().intValue());
        assertEquals(0, stack.size());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopEmpty() {
        stack.pop(); // Should throw EmptyStackException
    }

    @Test
    public void testPeek() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek().intValue());
        assertEquals(2, stack.size()); // Size should not change
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekEmpty() {
        stack.peek(); // Should throw EmptyStackException
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, stack.size());
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
    }

    // Additional test cases

    @Test
    public void testMultiplePushAndPop() {
        for (int i = 1; i <= 100; i++) {
            stack.push(i);
        }
        assertEquals(100, stack.size());

        for (int i = 100; i > 0; i--) {
            assertEquals(i, stack.pop().intValue());
        }
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPushNull() {
        stack.push(null);
        assertNull(stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testStackWithDifferentDataTypes() {
        Stack<String> stringStack = new Stack<>();
        stringStack.push("hello");
        stringStack.push("world");
        assertEquals("world", stringStack.pop());
        assertEquals("hello", stringStack.pop());

        Stack<Double> doubleStack = new Stack<>();
        doubleStack.push(1.1);
        doubleStack.push(2.2);
        assertEquals(Double.valueOf(2.2), doubleStack.pop());
        assertEquals(Double.valueOf(1.1), doubleStack.pop());
    }

    @Test
    public void testPeekAfterMultiplePush() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.peek().intValue());
        assertEquals(3, stack.size());
    }

    @Test
    public void testOrderPreservation() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop().intValue());
        assertEquals(2, stack.pop().intValue());
        assertEquals(1, stack.pop().intValue());
    }
}
