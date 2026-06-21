// Creates the GUI with buttons, labels
// radio buttons, next button, result screen

import java.io.*;
import java.util.*;

public class QuizLoader {

    public static ArrayList<Question> loadQuestions(String fileName) {
        ArrayList<Question> questions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            String currentTopic = "";

            String questionText = "";
            String optionA = "";
            String optionB = "";
            String optionC = "";
            String optionD = "";
            String correctAnswer = "";

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("Section A")) {
                    currentTopic = "Arrays";
                } else if (line.startsWith("Section B")) {
                    currentTopic = "Loops";
                } else if (line.startsWith("Section C")) {
                    currentTopic = "Conditional Statements";
                } else if (line.startsWith("Section D")) {
                    currentTopic = "Functions / Methods";
                } else if (line.startsWith("Section E")) {
                    currentTopic = "Object-Oriented Programming Basics";
                } else if (line.startsWith("What") || line.startsWith("Which") || line.startsWith("An") || line.startsWith("A method") || line.startsWith("Arrays")) {
                    questionText = line;
                } else if (line.startsWith("A.")) {
                    optionA = line;
                } else if (line.startsWith("B.")) {
                    optionB = line;
                } else if (line.startsWith("C.")) {
                    optionC = line;
                } else if (line.startsWith("D.")) {
                    optionD = line;
                } else if (line.startsWith("Correct Answer:")) {
                    correctAnswer = line.replace("Correct Answer:", "").trim();

                    questions.add(new Question(
                            currentTopic,
                            questionText,
                            optionA,
                            optionB,
                            optionC,
                            optionD,
                            correctAnswer
                    ));
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading quiz file: " + e.getMessage());
        }

        return questions;
    }
}