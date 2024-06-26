package quiz;

import db.QuizDAO;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.*;
import models.Question;
import models.Quiz;

public class QuizScreen extends JFrame {
    private int currentQuestionIndex = 0;
    private List<Question> questions;
    public  JLabel questionLabel;
    public  JRadioButton[] optionButtons;
    public  ButtonGroup buttonGroup;
    public  JButton nextButton;
    public  int score = 0;

    public QuizScreen(Quiz quiz) {
        setTitle(quiz.getTitle());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        QuizDAO quizDAO = new QuizDAO();
        questions = quizDAO.getQuestionsByQuizId(quiz.getId());

        questionLabel = new JLabel();
        questionLabel.setBounds(10, 10, 360, 25);
        add(questionLabel);

        optionButtons = new JRadioButton[4];
        buttonGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionButtons[i].setBounds(10, 50 + (i * 30), 360, 25);
            buttonGroup.add(optionButtons[i]);
            add(optionButtons[i]);
        }

        nextButton = new JButton("Next");
        nextButton.setBounds(10, 200, 360, 25);
        add(nextButton);

        nextButton.addActionListener((ActionEvent e) -> {
            checkAnswer();
            currentQuestionIndex++;
            if (currentQuestionIndex < questions.size()) {
                loadQuestion();
            } else {
                JOptionPane.showMessageDialog(null, "Quiz finished! Your score: " + score);
                dispose();
                QuizDashboard.main(null);
            }
        });

        loadQuestion();
    }

    private void loadQuestion() {
        Question question = questions.get(currentQuestionIndex);
        questionLabel.setText(question.getQuestionText());
        String[] options = { "Option 1", "Option 2", "Option 3", "Option 4" }; // Replace with actual options
        for (int i = 0; i < options.length; i++) {
            optionButtons[i].setText(options[i]);
        }
    }

    private void checkAnswer() {
        Question question = questions.get(currentQuestionIndex);
        for (JRadioButton optionButton : optionButtons) {
            if (optionButton.isSelected() && optionButton.getText().equals(question.getCorrectAnswer())) {
                score++;
                break;
            }
        }
    }
}
