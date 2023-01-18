package quiz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OneWordQuestionTest {

    @Test
    void testCreateOneWordQuestion() {
        Question question = new OneWordQuestion("2+2=?", "4", Level.HARD);

        assertEquals("2+2=?", question.getQuestion());
        assertEquals(Level.HARD, question.getLevel());
    }

    @Test
    void testCalculatePoints() {
        Question question = new OneWordQuestion("2+2=?", "4", Level.MEDIUM);

        assertEquals(2, question.calculatePoints("4"));
        assertEquals(0, question.calculatePoints("3"));
        assertEquals(0, question.calculatePoints("5"));
        question = new OneWordQuestion("2+3=?", "5", Level.EASY);
        assertEquals(1, question.calculatePoints("5"));
    }

    @Test
    void testCalculatePointWithWrongAmount() {
        Question question = new OneWordQuestion("2+2=?", "4", Level.HARD);

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> question.calculatePoints("4", "3"));

        assertEquals("Only one answer acceptable!", iae.getMessage());
    }

}