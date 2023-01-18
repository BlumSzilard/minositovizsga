package quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz {
    private List<Question> questions = new ArrayList<>();

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        List<Question> result = new ArrayList<>();
        for (Question question : questions) {
            result.add(question);
        }
        return result;
    }

    public int calculateSumPoints(List<String> answers) {
        int sum = 0;
        for (int i = 0; i < questions.size(); i++) {
            sum += questions.get(i).calculatePoints(answers.get(i));
        }
        return sum;
    }

    public Map<Level,Integer> groupByLevel(){
        Map<Level,Integer> result = new HashMap<>();
        for (Question question : questions) {
            if (result.containsKey(question.getLevel())){
                result.put(question.getLevel(),result.get(question.getLevel())+1);
            }else{
                result.put(question.getLevel(),1);
            }
        }
        return result;
    }
}
