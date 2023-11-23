import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private static final Solution solution = new Solution();
    private static final String[] srcLine = {"[V]", "[ ]", "[V]","[V]"};
    @Test
    void makeSolution() {
        assertEquals(1, solution.makeSolution(srcLine));
    }
}