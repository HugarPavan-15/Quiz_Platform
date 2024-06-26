

# Java Quiz Platform

This Java application implements a simple quiz platform with user authentication, quiz creation, and quiz taking functionalities. It runs entirely on local memory data structures without the use of a database.

## Features

- **User Authentication:**
  - Users can register with a username and password.
  - Registered users can log in securely.

- **Quiz Management:**
  - Create quizzes by entering a title, category, and list of questions.
  - Take quizzes by selecting a quiz ID and answering questions.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your system.
- Any Java IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor (e.g., VS Code) for editing and running Java files.

### Running the Application

1. **Compile the Java File:**
   Open a terminal or command prompt and navigate to the directory containing `QuizPlatform.java`. Compile the file using:
   ```sh
   javac QuizPlatform.java
   ```

2. **Run the Compiled Java Program:**
   Execute the compiled Java program using:
   ```sh
   java QuizPlatform
   ```

### Usage

1. **Login/Register:**
   - On the login screen, either login with existing credentials or register as a new user.

2. **Dashboard:**
   - After successful login, access the dashboard to either create a new quiz or take an existing quiz.

3. **Creating a Quiz:**
   - Enter a title, category, and questions for the quiz. Click "Save" to create the quiz.

4. **Taking a Quiz:**
   - Enter the quiz ID of the quiz you want to take. Click "Load Quiz" to display questions. Answer the questions and click "Submit" to finish.

## Notes

- This application uses in-memory data structures (`HashMap`, `ArrayList`) to store users and quizzes.
- For a production-ready application, consider implementing persistent storage using a database (e.g., MySQL, PostgreSQL) for better data management and scalability.


This README provides an overview of your Java quiz platform, instructions for setup, and usage guidelines. Feel free to customize it further based on additional features or specifics of your implementation.
