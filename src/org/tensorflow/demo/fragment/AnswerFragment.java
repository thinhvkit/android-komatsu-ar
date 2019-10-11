package org.tensorflow.demo.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.tensorflow.demo.activity.DetectorActivity;
import org.tensorflow.demo.R;
import org.tensorflow.demo.adapter.AnswerAdapter;
import org.tensorflow.demo.model.Question;

import java.util.List;

public class AnswerFragment extends DialogFragment {

    private static final String ex_param = "question_param";
    private RecyclerView rvAnswer;
    private AnswerAdapter answerAdapter;
    private List<Question> questions;


    public static AnswerFragment newInstance() {

        Bundle args = new Bundle();
        AnswerFragment fragment = new AnswerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null)
        {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.answer_fragment, container, false);

        ImageView imvConfirm = view.findViewById(R.id.confirm_bottom_sheet);
        ImageView imvCancel = view.findViewById(R.id.cancel_bottom_sheet);
        imvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        imvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        rvAnswer = view.findViewById(R.id.rv_answer);
        rvAnswer.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        questions = ((DetectorActivity) getActivity()).getQuest();
        answerAdapter = new AnswerAdapter(getActivity(), questions);
        rvAnswer.setAdapter(answerAdapter);
        return view;
    }
}
