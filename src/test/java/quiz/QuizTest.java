/*
package quiz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

    Quiz quiz = new Quiz();

    @BeforeEach
    void init() {
        quiz.addQuestion(new OneWordQuestion("2+2=?", "4", Level.MEDIUM));
        quiz.addQuestion(new MultipleChoiceQuestion("3-2=x", List.of("-1", "1", "2", "3"), List.of("1"), Level.HARD));
        quiz.addQuestion(new OneWordQuestion("2+3=?", "5", Level.EASY));
        quiz.addQuestion(new MultipleChoiceQuestion("sqrt(x)=2", List.of("-1", "4", "2", "3"), List.of("4"), Level.MEDIUM));
    }

    @Test
    void testAddQuestion() {
        quiz.addQuestion(new OneWordQuestion("2+2=?", "4", Level.EASY));

        assertEquals(5, quiz.getQuestions().size());
    }

    @Test
    void testCalculateSumPoints() {
        assertEquals(8, quiz.calculateSumPoints(List.of("4", "1", "5", "4")));

        assertEquals(1, quiz.calculateSumPoints(List.of("3", "-1", "5", "2")));

        assertEquals(3, quiz.calculateSumPoints(List.of("4", "2", "5", "3")));
    }

    @Test
    void testGroupByLevel() {
        Map<Level, Integer> result = quiz.groupByLevel();

        assertEquals(1, result.get(Level.HARD));
        assertEquals(2, result.get(Level.MEDIUM));
        assertEquals(1, result.get(Level.EASY));
    }

}*/
