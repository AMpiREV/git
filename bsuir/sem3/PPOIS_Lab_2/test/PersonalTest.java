import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonalTest {
    private static final Personal registry1 = new Registry("70 ", "бабушка ", "регистратура ");

    @Test
    void EndWork(){
        assertEquals(registry1.EndWork(),
                "70 бабушка регистратура закончил работу");}
}