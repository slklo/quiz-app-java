// Creates the GUI with buttons, labels
// radio buttons, next button, result screen

import java.io.*;
import java.util.*;

public class QuizLoader {

    public static ArrayList<Question> loadQuestions(String fileName) {

        if (fileName.toLowerCase().endsWith(".csv")) {
            return loadQuestionsFromCSV(fileName);
        } else if (fileName.toLowerCase().endsWith(".txt")) {
            return loadQuestionsFromTXT(fileName);
        } else {
            System.out.println("Unsupported file format. Use .txt or .csv");
            return new ArrayList<>();
        }
    }

    private static ArrayList<Question> loadQuestionsFromTXT(String fileName) {
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
                } else if (line.startsWith("What")
                        || line.startsWith("Which")
                        || line.startsWith("An")
                        || line.startsWith("A method")
                        || line.startsWith("Arrays")) {
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
            System.out.println("Error reading TXT quiz file: " + e.getMessage());
        }

        return questions;
    }

    private static ArrayList<Question> loadQuestionsFromCSV(String fileName) {
        ArrayList<Question> questions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {

                if (isFirstLine) {
                    isFirstLine = false;

                    if (line.toLowerCase().startsWith("topic")) {
                        continue;
                    }
                }

                String[] values = line.split(",");

                if (values.length < 7) {
                    System.out.println("Invalid CSV line: " + line);
                    continue;
                }

                String topic = values[0].trim();
                String questionText = values[1].trim();
                String optionA = values[2].trim();
                String optionB = values[3].trim();
                String optionC = values[4].trim();
                String optionD = values[5].trim();
                String correctAnswer = values[6].trim();

                questions.add(new Question(
                        topic,
                        questionText,
                        optionA,
                        optionB,
                        optionC,
                        optionD,
                        correctAnswer
                ));
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV quiz file: " + e.getMessage());
        }

        return questions;
    }
}

// txt format

// Section A

// Which symbol is used to declare an array?
// A. ()
// B. {}
// C. []
// D. <>
// Correct Answer: C


// csv format

// Topic,Question,A,B,C,D,Correct
// Arrays,Which symbol declares an array?,(),{},[],<>,C
// Arrays,What is the first index?,1,-1,0,10,C
// Loops,Which loop runs at least once?,while,for,do-while,switch,C