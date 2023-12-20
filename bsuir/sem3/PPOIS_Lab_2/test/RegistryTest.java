import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistryTest {
    private static final Registry registry = new Registry("70 ", "бабушка ", "регистратура ");
    @Test
    void card(){
        assertEquals(registry.card("20", " sasha"), "карта пациента 20 sasha");
    }
    @Test
    void giveAccess(){
        assertEquals(registry.giveAccess("карта пациента 20 sasha"),
                "бабушка регистратура пациент может идти к врачам");
    }
    @Test
    void EndWork(){
        assertEquals(registry.EndWork(),
                "70 бабушка регистратура закончил работу");
    }
}