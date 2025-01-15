
import java.util.Scanner;

class Question {
    String question;
    String[] options;
    int correctAnswerIndex;

    public Question(String question, String[] options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public boolean checkAnswer(int answerIndex) {
        return answerIndex == correctAnswerIndex;
    }
}

public class QuizPlatform {

    private static Question[] questions = {
        new Question("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 2),
        new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 1),
        new Question("Who wrote 'Hamlet'?", new String[]{"Shakespeare", "Dickens", "Hemingway", "Twain"}, 0),
        new Question("Which element's chemical symbol is O?", new String[]{"Oxygen", "Osmium", "Ozone", "Oxygenium"}, 0)
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Online Quiz Platform!\n");

        for (int i = 0; i < questions.length; i++) {
            Question q = questions[i];
            System.out.println("Question " + (i + 1) + ": " + q.question);

            for (int j = 0; j < q.options.length; j++) {
                System.out.println((j + 1) + ". " + q.options[j]);
            }

            System.out.print("Enter your answer (1-4): ");
            int userAnswer = scanner.nextInt() - 1;

            if (q.checkAnswer(userAnswer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was: " + q.options[q.correctAnswerIndex] + "\n");
            }
        }

        System.out.println("Your final score: " + score + " out of " + questions.length);
        scanner.close();
    }
}
