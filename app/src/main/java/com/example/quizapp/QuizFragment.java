package com.example.quizapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class QuizFragment extends Fragment {
    int currentIndex = 0;
    int sum = 0;
    Question[] questions = {
            new Question("1 is correct", new String[]{"1", "2", "3"},0 ),
            new Question("2 is correct", new String[]{"1", "2", "3"},1 ),
            new Question("3 is correct", new String[]{"1", "2", "3"},2 ),
    };
    TextView textView;
    RadioGroup radioGroup;
    RadioButton[] radioButtons = new RadioButton[3];
    View view;
    public QuizFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_quiz, container, false);
        textView = view.findViewById(R.id.quizFragmentTextView);
        radioGroup = view.findViewById(R.id.quizFragmentRadioGroup);
        radioButtons[0] = view.findViewById(R.id.quizFragmentRadioButton);
        radioButtons[1] = view.findViewById(R.id.quizFragmentRadioButton2);
        radioButtons[2] = view.findViewById(R.id.quizFragmentRadioButton3);
        Button button = view.findViewById(R.id.quizFragmentButtonNext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAnswer();
                checkAnswer();
                nextQuestion();
                showQuestion();
            }
        });

        showQuestion();
        return view;
    }

    private void nextQuestion() {
        if (currentIndex < 2)
            currentIndex++;
        else {
            newFragment();
        }
    }

    private void showQuestion() {
        textView.setText(questions[currentIndex].getContent());
        for (int i = 0; i < 3; i++) {
            radioButtons[i].setText(questions[currentIndex].getAnswers()[i]);
        }
    }

    private void checkAnswer() {
        if (questions[currentIndex].checkQuestion())
            sum++;
    }

    private void setAnswer() {
        int index = -1;
        for (int i = 0; i < 3; i++) {
            if (radioButtons[i].isChecked())
                index = i;
        }
        questions[currentIndex].answerQuestion(index);

    }

    private void newFragment() {
        Bundle bundle = new Bundle();
        bundle.putInt("sum", sum);
        SumUpFragment fragment = new SumUpFragment();
        fragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragment).commit();

    }
}