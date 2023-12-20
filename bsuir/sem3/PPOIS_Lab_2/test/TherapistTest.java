import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TherapistTest {
    private static final Therapist therapist = new Therapist("31", "ольга", "терапевт", true);

    @Test
    void write_letter(){
        assertEquals(therapist.write_letter(), "Справка о болезни, от ольга подпись терапевт");
    }
    @Test
    void writePreparats(){
        assertEquals(therapist.writePreparats(), "пить по три таблетки в день");
    }
}



