# java quiz application

## project title

development of a gui based java quiz application

## description

this project is a java gui-based quiz application developed using java swing. the application allows users to select a programming topic and answer multiple-choice questions related to that topic.

the questions are loaded from an external text file, and the final quiz result is displayed to the user and saved into a result file.

## quiz topics

the application includes five quiz sections:

1. arrays
2. loops
3. conditional statements
4. functions / methods
5. object-oriented programming basics

each topic contains 10 multiple-choice questions.

## features

* graphical user interface using java swing
* main menu with topic selection
* topic-based quiz system
* questions loaded from a text file
* four answer options for each question
* answer checking
* score calculation
* result display
* result saving into `results.txt`
* exit option from the main menu

## project structure

```text
javaquizapplication/
│
├── quiz-text.txt
│
├── results.txt
│
└── src/
    ├── main.java
    ├── question.java
    ├── quizloader.java
    ├── resultwriter.java
    └── quizapp.java
```

## file explanation

### main.java

this file starts the application.

### question.java

this class represents one quiz question. it stores the topic, question text, answer options, and the correct answer.

### quizloader.java

this class reads the questions from `quiz-text.txt` and converts them into `question` objects.

### quizapp.java

this is the main gui class. it creates the menu, displays questions, handles user selections, checks answers, and shows the final score.

### resultwriter.java

this class saves the final quiz result into `results.txt`.

## how to run the project

1. open the project folder in vs code
2. make sure java jdk is installed
3. make sure the java extension pack is installed in vs code
4. place `quiz-text.txt` in the main project folder
5. open `main.java`
6. run the program

## application flow

```text
start application
↓
show main menu
↓
user selects quiz topic
↓
load questions from text file
↓
display questions one by one
↓
user selects answer
↓
check answer
↓
move to next question
↓
display final result
↓
save result to results.txt
```

## result example

```text
quiz completed!

topic: loops
total questions: 10
correct answers: 8
wrong answers: 2
final score: 8 / 10
```

## technologies used

* java
* java swing
* file handling
* object-oriented programming

## author

student project

## note

this project was developed as an individual assignment for the gui based java quiz application project.
