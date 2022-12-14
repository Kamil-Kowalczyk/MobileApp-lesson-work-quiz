package com.example.quizapp;

import java.util.Arrays;

public class Question {
    private String content;
    private String[] answers;
    private int correctAnswerIndex;
    private int userAnswerIndex;

    public Question(String content, String[] answers, int correctIndex) {
        this.content = content;
        this.answers = answers;
        this.correctAnswerIndex = correctIndex;
        this.userAnswerIndex = -1;
    }

    // Name: checkQuestion
    // Arguments: none
    // What it does: checks if an index provided by user is equal to a correct answer index
    // Return: true or false
    public boolean checkQuestion() {
        if (userAnswerIndex == correctAnswerIndex)
            return true;
        return false;
    }

    // Name: answerQuestion
    // Arguments: userAnswerIndex
    // sets an index of answer provided by the user
    // Return: nothing
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
