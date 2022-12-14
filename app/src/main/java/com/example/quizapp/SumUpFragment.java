package com.example.quizapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SumUpFragment extends Fragment {
    View view;
    public SumUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sum_up, container, false);

        Bundle bundle = getArguments();

        if (bundle != null) {
            TextView textView = view.findViewById(R.id.sumUpFragmentTextView);
            textView.setText("Congratulations you read this barely after finishing the quiz with " + bundle.getInt("sum") + " points");
        }
        return view;
    }
}