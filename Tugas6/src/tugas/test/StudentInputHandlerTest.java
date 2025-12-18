package tugas.test;

import org.junit.Test;
import tugas.*;

import static org.junit.Assert.*;

public class StudentInputHandlerTest {

    private final StudentInputHandler handler = new StudentInputHandler();

    @Test
    public void testValidInput() throws Exception {
        Student s = handler.process("Nabil", "20");
        assertNotNull(s);
    }

    @Test(expected = InvalidInputException.class)
    public void testInvalidInput() throws Exception {
        handler.process("", "-5");
    }

    @Test(expected = TooManyInvalidAttemptsException.class)
    public void testTooManyAttempts() throws Exception {
        for (int i = 0; i < 3; i++) {
            try {
                handler.process("", "");
            } catch (InvalidInputException ignored) {}
        }

        handler.process("", "");
    }
}