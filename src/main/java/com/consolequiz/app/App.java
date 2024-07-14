package com.consolequiz.app;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.*;
import org.json.simple.parser.*;

public class App {
    public static void main(String[] args) {

        JSONParser jsonParser = new JSONParser();

        try {
            Question[] questions = new Question[2];
            Object obj = jsonParser.parse(new FileReader("src/main/data/questions.json"));
            JSONArray jsonArray = (JSONArray) obj;

            Iterator<JSONObject> iterator = jsonArray.iterator();
            int q = 0;
            while (iterator.hasNext()) {
                JSONObject jsonObj = iterator.next();
                int id = Integer.parseInt(jsonObj.get("id").toString());
                String query = jsonObj.get("query").toString();
                JSONArray optionsArr = (JSONArray) jsonObj.get("options");
                String[] options = new String[4];
                Iterator optionIterator = optionsArr.iterator();
                int i = 0;
                while (optionIterator.hasNext()) {
                    options[i++] = optionIterator.next().toString();
                }
                int answer = Integer.parseInt(jsonObj.get("answer").toString());
                Question question = new Question(id, query, options, answer);

                questions[q++] = question;

            }

            Scanner sc = new Scanner(System.in);
            System.out.println("Quiz");

            int score = 0;
            for (int i = 0; i < questions.length; i++) {
                System.out.println("Question : " + (i + 1));
                System.out.println(questions[i].getQuestion());
                System.out.println("Pick 1 Option");
                questions[i].showOptions();
                int userAnswer = sc.nextInt();
                if (questions[i].validateAnswer(userAnswer)) {
                    score++;
                }
            }

            System.out.println("You hvave scored : " + score + " out of " + questions.length);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
