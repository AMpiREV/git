import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MachineLineTest {
    private static final int num2  = 4;
    private static final MachineLine line = new MachineLine(num2);
    private static final String[] srcLine = {"[ ]","[ ]","[ ]","[ ]"};
    private static final String[] srcLine1 = {"[ ]","[ ]","[ ]","[ ]","[ ]"};
    private static final String[] srcLine2 = {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"};
    private static final String[] srcArr = {"._.","...","...","..."};
    private static final String[] srcArr1 = {"...","...","...","...","._."};
    private static final String[] srcLine3 = {"[V]","[ ]","[ ]","[ ]"};
    private static final String[] destLine = {null,null,null,null,null};
    private static final String[] error = {"Лента отсутствует"};
    @Test
    void create_srcLine() {
        assertArrayEquals(srcLine, line.create_srcLine());
        int num3  = 0;
        MachineLine line2 = new MachineLine(num3);
        assertArrayEquals(error, line2.create_srcLine());
    }

    @Test
    void create_destLine() {
        assertArrayEquals(destLine, line.create_destLine(srcLine));
    }

    @Test
    void moveLeftLine() {
        assertArrayEquals(srcLine1, line.moveLeftLine(srcLine, srcArr));
    }

    @Test
    void moveRightLine() {
        assertArrayEquals(srcLine1, line.moveRightLine(srcLine, srcArr1));
    }

    @Test
    void makeLabel() {
        assertArrayEquals(srcLine2, line.makeLabel(srcArr, srcLine2));
    }

    @Test
    void removeLabel() {
        assertArrayEquals(srcLine, line.removeLabel(srcArr, srcLine3));
    }
}