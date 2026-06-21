// Reads questions from quiz-file.txt

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class QuizApp extends JFrame {

    private ArrayList<Question> allQuestions;
    private ArrayList<Question> currentQuestions;

    private int currentIndex = 0;
    private int score = 0;
    private String currentTopic = "";

    private JLabel questionLabel;
    private JRadioButton optionA, optionB, optionC, optionD;
    private ButtonGroup optionsGroup;
    private JButton nextButton;

    public QuizApp() {
        allQuestions = QuizLoader.loadQuestions("utils/quiz-file.txt");

        setTitle("Java Quiz Application");
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        showMainMenu();

        setVisible(true);
    }

    private void showMainMenu() {
        JPanel panel = new JPanel(new GridLayout(7, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 60, 30, 60));

        JLabel title = new JLabel("Welcome to the Java Quiz Application", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JButton arraysButton = new JButton("Arrays");
        JButton loopsButton = new JButton("Loops");
        JButton conditionalButton = new JButton("Conditional Statements");
        JButton methodsButton = new JButton("Functions / Methods");
        JButton oopButton = new JButton("Object-Oriented Programming Basics");
        JButton exitButton = new JButton("Exit");

        arraysButton.addActionListener(e -> startQuiz("Arrays"));
        loopsButton.addActionListener(e -> startQuiz("Loops"));
        conditionalButton.addActionListener(e -> startQuiz("Conditional Statements"));
        methodsButton.addActionListener(e -> startQuiz("Functions / Methods"));
        oopButton.addActionListener(e -> startQuiz("Object-Oriented Programming Basics"));
        exitButton.addActionListener(e -> System.exit(0));

        panel.add(title);
        panel.add(arraysButton);
        panel.add(loopsButton);
        panel.add(conditionalButton);
        panel.add(methodsButton);
        panel.add(oopButton);
        panel.add(exitButton);

        setContentPane(panel);
        revalidate();
        repaint();
    }

    private void startQuiz(String topic) {
        currentTopic = topic;
        currentIndex = 0;
        score = 0;
        currentQuestions = new ArrayList<>();

        for (Question q : allQuestions) {
            if (q.getTopic().equals(topic)) {
                currentQuestions.add(q);
            }
        }

        if (currentQuestions.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No questions found for this topic.");
            return;
        }

        showQuestion();
    }

    private void showQuestion() {
        Question q = currentQuestions.get(currentIndex);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        questionLabel = new JLabel(
                "<html><b>Question " + (currentIndex + 1) + ":</b> " + q.getQuestionText() + "</html>"
        );
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        optionA = new JRadioButton(q.getOptionA());
        optionB = new JRadioButton(q.getOptionB());
        optionC = new JRadioButton(q.getOptionC());
        optionD = new JRadioButton(q.getOptionD());

        optionsGroup = new ButtonGroup();
        optionsGroup.add(optionA);
        optionsGroup.add(optionB);
        optionsGroup.add(optionC);
        optionsGroup.add(optionD);

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        optionsPanel.add(optionA);
        optionsPanel.add(optionB);
        optionsPanel.add(optionC);
        optionsPanel.add(optionD);

        nextButton = new JButton(currentIndex == currentQuestions.size() - 1 ? "Finish" : "Next");
        nextButton.addActionListener(e -> checkAnswerAndContinue());

        panel.add(questionLabel, BorderLayout.NORTH);
        panel.add(optionsPanel, BorderLayout.CENTER);
        panel.add(nextButton, BorderLayout.SOUTH);

        setContentPane(panel);
        revalidate();
        repaint();
    }

    private void checkAnswerAndContinue() {
        String selectedAnswer = "";

        if (optionA.isSelected()) selectedAnswer = "A";
        else if (optionB.isSelected()) selectedAnswer = "B";
        else if (optionC.isSelected()) selectedAnswer = "C";
        else if (optionD.isSelected()) selectedAnswer = "D";

        if (selectedAnswer.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select an answer.");
            return;
        }

        Question currentQuestion = currentQuestions.get(currentIndex);

        if (selectedAnswer.equals(currentQuestion.getCorrectAnswer())) {
            score++;
        }

        currentIndex++;

        if (currentIndex < currentQuestions.size()) {
            showQuestion();
        } else {
            showResult();
        }
    }

    private void showResult() {
        int totalQuestions = currentQuestions.size();
        int wrongAnswers = totalQuestions - score;

        ResultWriter.saveResult(currentTopic, totalQuestions, score);

        JOptionPane.showMessageDialog(
                this,
                "Quiz Completed!\n\n" +
                        "Topic: " + currentTopic + "\n" +
                        "Total Questions: " + totalQuestions + "\n" +
                        "Correct Answers: " + score + "\n" +
                        "Wrong Answers: " + wrongAnswers + "\n" +
                        "Final Score: " + score + " / " + totalQuestions
        );

        showMainMenu();
    }
}