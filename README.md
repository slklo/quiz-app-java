# Java Quiz Application

## Project Title

**Development of a GUI-Based Java Quiz Application**

---

## Description

This project is a Java Swing-based quiz application developed as part of a university assignment. The application allows users to select a programming topic and answer multiple-choice questions through a graphical user interface.

Questions are loaded dynamically from an external file. The application supports **both TXT and CSV quiz formats**, automatically detecting the file type based on its extension. After completing a quiz, the user's score is displayed on the screen and saved to a results file.

---

## Quiz Topics

The application contains five programming topics:

1. Arrays
2. Loops
3. Conditional Statements
4. Functions / Methods
5. Object-Oriented Programming Basics

Each topic contains **10 multiple-choice questions**.

---

## Features

* Graphical User Interface built with Java Swing
* Main menu for topic selection
* Topic-based quiz system
* Automatic loading of quiz questions
* Support for both **TXT** and **CSV** quiz files
* Automatic file format detection (`.txt` or `.csv`)
* Four answer options for every question
* Automatic answer checking
* Score calculation
* Result screen after completing the quiz
* Saving results into `results.txt`
* Exit option from the application

---

## Supported Quiz File Formats

The application automatically detects the quiz file format.

### TXT Format

```
Section A: Arrays Quiz

Question 1
What is an array in Java?
A. Collection of different data types
B. Collection of elements of the same type
C. Loop
D. Variable
Correct Answer: B
```

The TXT loader recognizes:

* Section names
* Question text
* Four answer options
* Correct answer

---

### CSV Format

The application also supports CSV files with the following structure:

```csv
Topic,Question,A,B,C,D,Correct
Arrays,What is an array in Java?,A. Collection of different data types,B. Collection of elements of the same type,C. Loop,D. Variable,B
Loops,Which keyword exits a loop?,A. stop,B. break,C. end,D. continue,B
```

Columns:

| Column   | Description                   |
| -------- | ----------------------------- |
| Topic    | Quiz topic                    |
| Question | Question text                 |
| A        | Option A                      |
| B        | Option B                      |
| C        | Option C                      |
| D        | Option D                      |
| Correct  | Correct answer (A, B, C or D) |

---

## Project Structure

```text
JavaQuizApplication/
│
├── quiz-text.txt
├── quiz_questions.csv
├── results.txt
│
└── src/
    ├── Main.java
    ├── Question.java
    ├── QuizLoader.java
    ├── ResultWriter.java
    └── QuizApp.java
```

---

## File Explanation

### Main.java

Starts the application and launches the graphical user interface.

---

### Question.java

Represents a single quiz question.

Stores:

* topic
* question text
* option A
* option B
* option C
* option D
* correct answer

---

### QuizLoader.java

Loads quiz questions from an external file.

Depending on the selected file extension, it automatically chooses the appropriate parser:

* TXT Loader
* CSV Loader

Both loaders return a list of `Question` objects used by the application.

---

### QuizApp.java

Main Swing GUI class.

Responsible for:

* displaying the main menu
* selecting quiz topics
* displaying questions
* processing user answers
* calculating scores
* showing the final result

---

### ResultWriter.java

Writes the quiz result into `results.txt`.

---

## How to Run the Project

1. Open the project in Visual Studio Code.
2. Install Java JDK.
3. Install the Java Extension Pack.
4. Place either:

   * `quiz-text.txt`, or
   * `quiz_questions.csv`

   in the project root directory.
5. Open `Main.java`.
6. Run the application.

The program will automatically detect the file format based on its extension.

---

## Application Flow

```text
Start Application
        │
        ▼
Display Main Menu
        │
        ▼
User Selects Topic
        │
        ▼
Detect File Type (.txt / .csv)
        │
        ▼
Load Questions
        │
        ▼
Display Questions One by One
        │
        ▼
User Selects Answer
        │
        ▼
Check Answer
        │
        ▼
Update Score
        │
        ▼
Display Final Result
        │
        ▼
Save Result to results.txt
```

---

## Result Example

```text
Quiz Completed!

Topic: Loops

Total Questions: 10
Correct Answers: 8
Wrong Answers: 2
Final Score: 8 / 10
```

---

## Technologies Used

* java
* java swing
* file handling
* object-oriented programming

## author

student project

## note

this project was developed as an individual assignment for the gui based java quiz application project.
