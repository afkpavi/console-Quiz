package com.consolequiz.app;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.*;
import org.json.simple.parser.*;

public class App {
    public static void main (String[] args) {

        // Create a  question
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter your Question");
//        String query = scanner.nextLine();
//
//        String[] options = new String[4];
//        for(int i=0;i<options.length;i++){
//            System.out.println("Enter Option " + (i+1) + " :");
//            String option = scanner.nextLine();
//            options[i] = option;
//        }
//
//        System.out.println("Enter the correct answer option(1,2,3,4): ");
//        int answer = scanner.nextInt();
//
//        Question question = new Question(1, query, options, answer);
//
//        System.out.println(question.getQuestion());
//        question.showOptions();
//
//        scanner.close();

        JSONParser jsonParser = new JSONParser();

        try {
            Object obj = jsonParser.parse(new FileReader("src/main/data/questions.json"));
            JSONArray jsonArray = (JSONArray) obj;

            Iterator<JSONObject> iterator = jsonArray.iterator();
            while(iterator.hasNext()){
                JSONObject jsonObj = iterator.next();
                int id = Integer.parseInt(jsonObj.get("id").toString());
                String query = jsonObj.get("query").toString();
                JSONArray optionsArr = (JSONArray) jsonObj.get("options");
                String[] options = new String[4];
                Iterator optionIterator = optionsArr.iterator();
                int i = 0;
                while(optionIterator.hasNext()){
                    options[i++] = optionIterator.next().toString();
                }
                int answer = Integer.parseInt(jsonObj.get("answer").toString());
                Question question = new Question(id, query, options, answer);

                System.out.println(question.getQuestion());

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
