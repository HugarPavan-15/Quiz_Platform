package quiz;

import db.QuizDAO;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.*;
import models.Quiz;

public class QuizDashboard {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Quiz Dashboard");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        QuizDAO quizDAO = new QuizDAO();
        List<Quiz> quizzes = quizDAO.getAllQuizzes();

        JComboBox<Quiz> quizComboBox = new JComboBox<>();
        for (Quiz quiz : quizzes) {
            quizComboBox.addItem(quiz);
        }
        quizComboBox.setBounds(10, 10, 360, 25);
        frame.add(quizComboBox);

        JButton startButton = new JButton("Start Quiz");
        startButton.setBounds(10, 50, 360, 25);
        frame.add(startButton);

        startButton.addActionListener((ActionEvent e) -> {
            Quiz selectedQuiz = (Quiz) quizComboBox.getSelectedItem();
            if (selectedQuiz != null) {
                QuizScreen quizScreen = new QuizScreen(selectedQuiz);
                quizScreen.setVisible(true);
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}
