import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecurityTest {
    private static final Security security = new Security("30", "леша","охрана");

    @Test
    void patient_pass(){
        assertEquals(security.patient_pass(true), "Пациент вошёл в поликлинику");
    }

}