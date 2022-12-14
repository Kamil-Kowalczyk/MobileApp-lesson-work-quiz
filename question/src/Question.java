import java.util.Arrays;

public class Question {
    private String content;
    private String[] answers = new String[3];
    private int correctAnswerIndex;
    private int userAnswerIndex;

    public Question(String content, String[] answers, int correctIndex) {
        this.content = content;
        this.answers = answers;
        this.correctAnswerIndex = correctIndex;
        this.userAnswerIndex = -1;
    }

    public boolean checkQuestion() {
        if (userAnswerIndex == correctAnswerIndex)
            return true;
        return false;
    }

    public void answerQuestion(int index) {
        userAnswerIndex = index;
    }

    public String getContent() {
        return content;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int getCorrectIndex() {
        return correctAnswerIndex;
    }

    public int getUserAnswerIndex() {
        return userAnswerIndex;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public void setCorrectIndex(int correctAnswerIndex) {
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public void setUserAnswerIndex(int userAnswerIndex) {
        this.userAnswerIndex = userAnswerIndex;
    }

    @Override
    public String toString() {
        return "Question{" +
                "content='" + content + '\'' +
                ", answers=" + Arrays.toString(answers) +
                ", correctIndex=" + correctAnswerIndex +
                ", userAnswerIndex=" + userAnswerIndex +
                '}';
    }
}
