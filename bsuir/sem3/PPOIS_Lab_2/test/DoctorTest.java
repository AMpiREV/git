import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {
    private static final Doctor surgeon = new Surgeon("11", "вася", "хирург", true, false);
    private static final Doctor surgeon1 = new Surgeon("11", "вася ", "хирург", false, false);

    @Test
    void Isfree(){
        assertEquals(surgeon.Isfree(), "Врач свободен");
        assertEquals(surgeon1.Isfree(), "Врач занят");
    }
    @Test
    void write_letter(){
        assertEquals(surgeon1.write_letter(),"Справка о болезни, от вася подпись");
    }
    @Test
    void fu(){
        assertEquals(surgeon.fu(),"я хирург вася 11");
    }
}