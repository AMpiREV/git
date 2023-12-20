import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PsychologistTest {
    private static final Psychologist psychologist = new Psychologist("27", "бузова", "психолог", true);

    @Test
    void recipe(){
        assertEquals(psychologist.recipe(), "антидепресанты таблетки для тревожности");
    }
    @Test
    void survey(){
        assertEquals(psychologist.survey(), "был проведён опрос психологом");
    }
    @Test
    void write_letter(){
        assertEquals(psychologist.write_letter(), "Справка о болезни, от бузова подпись психолог");
    }



}