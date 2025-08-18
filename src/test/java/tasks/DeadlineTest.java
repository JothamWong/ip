package tasks;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import misc.PepeException;

public class DeadlineTest {
    @Test
    public void testDeadlineSucceedInput() {
        String userInput = "meet Pepe /by 2025-08-16 1400";
        try {
            Deadline deadline = Deadline.fromInput(userInput.split(" "));
            assertEquals(new Deadline("meet Pepe", LocalDateTime.of(2025, 8, 16, 14, 0)), deadline);
        } catch (PepeException e) {
            assert false;
        }
    }
}
