package org.tensorflow.demo.model;

import java.io.Serializable;

public class Question implements Serializable {
  public String name;
  public String question;
  public int answer = 0;

  public Question(String name, String question) {
    this.name = name;
    this.question = question;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

}
