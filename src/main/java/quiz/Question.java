package quiz;

public interface Question {

    String getQuestion();

    Level getLevel();

    int calculatePoints(String... answer);
}