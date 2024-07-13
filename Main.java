import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        // Create a  question
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your Question");
        String query = scanner.nextLine();

        String[] options = new String[4];
        for(int i=0;i<options.length;i++){
            System.out.println("Enter Option " + (i+1) + " :");
            String option = scanner.nextLine();
            options[i] = option;
        }

        System.out.println("Enter the correct answer option(1,2,3,4): ");
        int answer = scanner.nextInt();

        Question question = new Question(1, query, options, answer);

        System.out.println(question.getQuestion());
        question.showOptions();

        scanner.close();

    }
}
