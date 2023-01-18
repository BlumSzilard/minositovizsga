package quiz;

public class OneWordQuestion implements Question {
    private String question;
    private Level level;
    private String correctAnswer;

    public OneWordQuestion(String question, String correctAnswer, Level level) {
        this.question = question;
        this.level = level;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public Level getLevel() {
        return level;
    }

    @Override
    public int calculatePoints(String... answer) {
        if (answer.length == 0){
            return 0;
        }
        if (answer.length > 1){
            throw new IllegalArgumentException("Only one answer acceptable!");
        }
        if (answer[0].equals(correctAnswer)){
            return level.getPoint();
        }
        return 0;
    }
}

