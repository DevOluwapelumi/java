import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class QuizApplication {
    private JFrame frame;
    private JPanel quizPanel;
    private JLabel questionLabel;
    private JRadioButton[] options;
    private JButton nextButton;
    private JLabel timerLabel;
    private JLabel scoreLabel;

    private List<Question> questions;
    private int currentQuestionIndex;
    private int score;
    private Timer timer;
    private int timeLeft;

    public QuizApplication() {
        frame = new JFrame("Quiz Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        initializeQuestions();
        createQuizPanel();

        frame.add(quizPanel, BorderLayout.CENTER);
        frame.setVisible(true);

        startQuiz();
    }

    private void initializeQuestions() {
        questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", new String[]{"London", "Berlin", "Paris", "Madrid"}, 2));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"Venus", "Mars", "Jupiter", "Saturn"}, 1));
        questions.add(new Question("What is the largest mammal?", new String[]{"Elephant", "Blue Whale", "Giraffe", "Hippopotamus"}, 1));
        // Add more questions here
    }

    private void createQuizPanel() {
        quizPanel = new JPanel();
        quizPanel.setLayout(new BoxLayout(quizPanel, BoxLayout.Y_AXIS));

        questionLabel = new JLabel();
        quizPanel.add(questionLabel);

        options = new JRadioButton[4];
        ButtonGroup buttonGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            buttonGroup.add(options[i]);
            quizPanel.add(options[i]);
        }

        nextButton = new JButton("Next");
        nextButton.addActionListener(e -> checkAnswerAndContinue());
        quizPanel.add(nextButton);

        timerLabel = new JLabel();
        quizPanel.add(timerLabel);

        scoreLabel = new JLabel("Score: 0");
        quizPanel.add(scoreLabel);
    }

    private void startQuiz() {
        currentQuestionIndex = 0;
        score = 0;
        displayQuestion(currentQuestionIndex);
    }

    private void displayQuestion(int index) {
        Question question = questions.get(index);
        questionLabel.setText(question.getQuestionText());
        String[] optionsText = question.getOptions();
        for (int i = 0; i < 4; i++) {
            options[i].setText(optionsText[i]);
            options[i].setSelected(false);
        }
        startTimer();
    }

    private void startTimer() {
        timeLeft = 15; // 15 seconds per question
        timerLabel.setText("Time left: " + timeLeft + " seconds");
        timer = new Timer(1000, e -> {
            timeLeft--;
            timerLabel.setText("Time left: " + timeLeft + " seconds");
            if (timeLeft == 0) {
                checkAnswerAndContinue();
            }
        });
        timer.start();
    }

    private void checkAnswerAndContinue() {
        timer.stop();
        Question currentQuestion = questions.get(currentQuestionIndex);
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected() && i == currentQuestion.getCorrectAnswerIndex()) {
                score++;
            }
        }
        scoreLabel.setText("Score: " + score);

        currentQuestionIndex++;
        if (currentQuestionIndex < questions.size()) {
            displayQuestion(currentQuestionIndex);
        } else {
            showFinalScore();
        }
    }

    private void showFinalScore() {
        quizPanel.removeAll();
        quizPanel.add(new JLabel("Quiz Completed!"));
        quizPanel.add(new JLabel("Your final score is: " + score + " out of " + questions.size()));
        quizPanel.revalidate();
        quizPanel.repaint();
    }

    private class Question {
        private String questionText;
        private String[] options;
        private int correctAnswerIndex;

        public Question(String questionText, String[] options, int correctAnswerIndex) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswerIndex = correctAnswerIndex;
        }

        public String getQuestionText() {
            return questionText;
        }

        public String[] getOptions() {
            return options;
        }

        public int getCorrectAnswerIndex() {
            return correctAnswerIndex;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuizApplication::new);
    }
}