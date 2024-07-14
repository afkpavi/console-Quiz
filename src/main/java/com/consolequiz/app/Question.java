package com.consolequiz.app;

public class Question {
    private int id;
    private String query;
    private String[] options;
    private int answer;

    public Question(int id, String query, String[] options, int answer){
        this.id = id;
        this.query = query;
        this.options = options;
        this.answer = answer;
    }

    public String getQuestion(){
        return this.query;
    }
    public void showOptions(){
        for(String option: this.options){
            System.out.println(option);
        }
    }

    public boolean validateAnswer(int userAnswer){
        return this.answer == userAnswer;
    }
}
