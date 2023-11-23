import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointerTest {
    private static final int num1  = 4;
    private static final Pointer pointer = new Pointer(num1);
    private static final String[] srcArr = {"._.","...","...","..."};
    private static final String[] srcArr4 = {"...","._.","...","..."};
    private static final String[] srcArr1 = {"._.","...","...","...","..."};
    private static final String[] srcArr2 = {"...","...","...","._."};
    private static final String[] srcArr5 = {"...","...","._.","..."};
    private static final String[] srcArr3 = {"...","...","...","...","._."};
    private static final String[] destArr = {null,null,null,null,null};
    @Test
    void create_srcArr() {
        assertArrayEquals(srcArr, pointer.create_srcArr());
    }

    @Test
    void create_destArr() {
        assertArrayEquals(destArr, pointer.create_destArr(srcArr));
    }

    @Test
    void moveLeft() {
        assertArrayEquals(srcArr1, pointer.moveLeft(srcArr));
        assertArrayEquals(srcArr, pointer.moveLeft(srcArr4));

    }

    @Test
    void moveRight() {
        assertArrayEquals(srcArr3, pointer.moveRight(srcArr2));
        assertArrayEquals(srcArr2, pointer.moveRight(srcArr5));
    }
    @Test
    void viewArr(){
        assertArrayEquals(srcArr4, pointer.viewArr(srcArr4));
    }
}