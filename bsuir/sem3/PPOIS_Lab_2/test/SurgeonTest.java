import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurgeonTest {
    private static final Surgeon surgeon1 = new Surgeon("11", "вася", "хирург", true, false);

    @Test
    void rec(){
        assertEquals(surgeon1.rec(), "надо наложить гипс");
    }
    @Test
    void giveaccess(){
        assertEquals(surgeon1.giveaccess(), true);
    }


}