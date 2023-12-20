import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {
    private static final Patient patient = new Patient("20", "саша",
            "простуда", "сломанная кость", "псих");
    boolean[]status = {true,true,true};
    boolean[]status1 = {true,true,false};

    @Test
    void showpassport(){
        assertEquals(patient.showpassport(), true);

    }
    @Test
    void showinfo(){
        assertEquals(patient.showinfo(), "возраст 20 имя саша проблемы простуда сломанная кость псих");
    }
    @Test
    void treatment(){
        assertEquals(patient.treatment(0), true);
    }
    @Test
    void state(){
        assertEquals(patient.state(status), "здоров!");
        assertEquals(patient.state(status1), "не здоров!");
    }
}