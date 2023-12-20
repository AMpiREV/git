import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CleanerTest {
        private static final Cleaner cleaner = new Cleaner("70 ", "дама ", "уборщица ");
        @Test
        void contWork(){
            assertEquals(cleaner.contWork(),
                    "70 дама уборщица выполняет работу");}
        @Test
        void EndWork(){
            assertEquals(cleaner.EndWork(),
                "70 дама уборщица  уже закончил работу");}
}
