package org.tensorflow.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.tensorflow.demo.R;
import org.tensorflow.demo.model.Question;

import java.util.List;

public class AnswerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  Context mContext;
  List<Question> questions;

  public AnswerAdapter(Context context, List<Question> questions) {
    this.mContext = context;
    this.questions = questions;
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(mContext);
    View view = inflater.inflate(R.layout.answer_item, parent, false);
    return new AnswerViewHolder(view);
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    AnswerViewHolder answerHolder = (AnswerViewHolder) holder;
    answerHolder.bind(questions.get(position));
  }

  @Override
  public int getItemCount() {
    return questions.size();
  }

  class AnswerViewHolder extends RecyclerView.ViewHolder {

    TextView txtQuestion;
    ImageView imvAnswer;

    public AnswerViewHolder(View itemView) {
      super(itemView);

      txtQuestion = itemView.findViewById(R.id.title_question_item);
      imvAnswer = itemView.findViewById(R.id.icon_answer_item);
    }

    void bind(Question question) {
      txtQuestion.setText(question.question);
      imvAnswer.setImageResource(question.answer == 1 ? R.drawable.ic_06 : R.drawable.ic_07);
    }
  }
}
