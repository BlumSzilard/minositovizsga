package quiz;

import java.util.List;

public class MultipleChoiceQuestion implements Question {
    private String question;
    private Level level;
    private List<String> options;
    private List<String> correctAnswers;

    public MultipleChoiceQuestion(String question,List<String> options, List<String> correctAnswers, Level level) {
        if (!allLengthAreCorrect(options)) {
            throw new IllegalArgumentException("Answers size must be at least 2!");
        }
        if (!allCorrectAnswersAreInOptions(correctAnswers, options)) {
            throw new CorrectAnswersMismatchException("Answers must contain all correct answers!");
        }



        this.question = question;
        this.level = level;
        this.options = options;
        this.correctAnswers = correctAnswers;
    }

    private boolean allLengthAreCorrect(List<String> options){
        if (options.size() < 2) {
            return false;
        }
        return true;
    }

    private boolean allCorrectAnswersAreInOptions(List<String> correctAnswers, List<String> options){
        for (String s : correctAnswers) {
            if (!options.contains(s)) {
                return false;
            }
        }
        return true;
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
        int result = 0;
        if (answer.length == 0){
            return 0;
        }
        for (String s : answer) {
            if (!isInOptions(s)) {
                throw new IllegalArgumentException("Answers are not in options!");
            }
            if (isCorrectAnswer(s)) {
                result += level.getPoint();
            } else {
                result -= level.getPoint();
            }
        }
        if (result < 0) {
            return 0;
        }
        if (result > level.getPoint()) {
            return level.getPoint();
        }
        return result;
    }

    private boolean isInOptions(String answer){
        answer = answer.toLowerCase();
        for (String s : options) {
            if (s.toLowerCase().equals(answer)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCorrectAnswer(String answer){
        answer = answer.toLowerCase();
        for (String s : correctAnswers) {
            if (s.toLowerCase().equals(answer)) {
                return true;
            }
        }
        return false;
    }
}
