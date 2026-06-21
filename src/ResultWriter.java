// saves the final result into results.txt

import java.io.FileWriter;
import java.io.IOException;

public class ResultWriter {

    public static void saveResult(String topic, int totalQuestions, int correctAnswers) {
        int wrongAnswers = totalQuestions - correctAnswers;

        try (FileWriter writer = new FileWriter("utils/results.txt", true)) {
            writer.write("Quiz Completed!\n");
            writer.write("Topic: " + topic + "\n");
            writer.write("Total Questions: " + totalQuestions + "\n");
            writer.write("Correct Answers: " + correctAnswers + "\n");
            writer.write("Wrong Answers: " + wrongAnswers + "\n");
            writer.write("Final Score: " + correctAnswers + " / " + totalQuestions + "\n");
            writer.write("-----------------------------\n");
        } catch (IOException e) {
            System.out.println("Error saving result: " + e.getMessage());
        }
    }
}