/*
package quiz;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultipleChoiceQuestionTest {

    @Test
    void testCreateMultipleChoiceQuestion() {
        Question question = new MultipleChoiceQuestion("2+3=?", List.of("2", "3", "4", "5"), List.of("5"), Level.EASY);

        assertEquals("2+3=?", question.getQuestion());
        assertEquals(Level.EASY, question.getLevel());
    }

    @Test
    void testCreateMultipleChoiceQuestionWithWrongAnswers() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new MultipleChoiceQuestion("2+3=?", List.of("2"), List.of("5"), Level.EASY));

        assertEquals("Answers size must be at least 2!", iae.getMessage());
    }

    @Test
    void testCreateMultipleChoiceQuestionWithWrongCorrectAnswers() {
        CorrectAnswersMismatchException came = assertThrows(CorrectAnswersMismatchException.class,
                () -> new MultipleChoiceQuestion("(x)^2=1", List.of("-1", "1", "2", "3"), List.of("-1", "5"), Level.HARD));

        assertEquals("Answers must contain all correct answers!", came.getMessage());
    }

    @Test
    void testCalculatePoints() {
        Question question = new MultipleChoiceQuestion("(x)^2=1", List.of("-1", "1", "2", "3"), List.of("-1", "1"), Level.MEDIUM);

        assertEquals(2, question.calculatePoints("-1", "1"));
        assertEquals(2, question.calculatePoints("1", "-1"));
        assertEquals(0, question.calculatePoints("1", "2"));
        assertEquals(0, question.calculatePoints("3", "2"));

        question = new MultipleChoiceQuestion("|x|=1", List.of("-1", "1", "2", "3"), List.of("-1", "1"), Level.EASY);
        assertEquals(1, question.calculatePoints("-1", "1"));
    }

    @Test
    void testCalculatePointsWithWrongAnswers() {
        Question question = new MultipleChoiceQuestion("(x)^2=1", List.of("-1", "1", "2", "3"), List.of("-1", "1"), Level.MEDIUM);

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> question.calculatePoints("-1", "1", "5"));

        assertEquals("Answers are not in options!", iae.getMessage());
    }

}*/
