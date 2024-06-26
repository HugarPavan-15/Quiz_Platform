package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Question;
import models.Quiz;

public class QuizDAO {
    public List<Quiz> getAllQuizzes() {
        List<Quiz> quizzes = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM quizzes";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Quiz quiz = new Quiz();
                quiz.setId(resultSet.getInt("id"));
                quiz.setTitle(resultSet.getString("title"));
                quiz.setCategory(resultSet.getString("category"));
                quizzes.add(quiz);
            }
        } catch (SQLException e) {
        }
        return quizzes;
    }

    public List<Question> getQuestionsByQuizId(int quizId) {
        List<Question> questions = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM questions WHERE quiz_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, quizId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Question question = new Question();
                question.setId(resultSet.getInt("id"));
                question.setQuizId(resultSet.getInt("quiz_id"));
                question.setQuestionText(resultSet.getString("question_text"));
                question.setQuestionType(resultSet.getString("question_type"));
                question.setCorrectAnswer(resultSet.getString("correct_answer"));
                questions.add(question);
            }
        } catch (SQLException e) {
        }
        return questions;
    }
}
