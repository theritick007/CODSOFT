import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApp extends JFrame implements ActionListener {

    private static final int TIME_LIMIT = 10; // 10 seconds for each question
    private int score = 0;
    private int currentQuestionIndex = 0;
    private int timeLeft = TIME_LIMIT;

    private Question[] questions = {
            new Question("What is the capital of France?", new String[]{"Paris", "London", "Berlin", "Rome"}, 0),
            new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Venus"}, 1),
            // Add more questions here
    };

    private JLabel questionLabel;
    private JRadioButton[] optionButtons = new JRadioButton[4];
    private ButtonGroup optionsGroup;
    private JButton submitButton;
    private JLabel timerLabel;

    private Timer timer;

    public QuizApp() {
        setTitle("Quiz Application");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        questionLabel = new JLabel();
        questionLabel.setBounds(30, 20, 340, 30);
        add(questionLabel);

        optionsGroup = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionButtons[i].setBounds(50, 60 + i * 30, 300, 30);
            optionsGroup.add(optionButtons[i]);
            add(optionButtons[i]);
        }

        submitButton = new JButton("Submit");
        submitButton.setBounds(150, 200, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        timerLabel = new JLabel("Time left: " + TIME_LIMIT);
        timerLabel.setBounds(150, 240, 100, 30);
        add(timerLabel);

        // Initialize the timer before loading the question
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                timerLabel.setText("Time left: " + timeLeft);

                if (timeLeft == 0) {
                    timer.stop();
                    submitAnswer();
                }
            }
        });

        loadQuestion();
        timer.start();
    }

    private void loadQuestion() {
        if (currentQuestionIndex < questions.length) {
            Question currentQuestion = questions[currentQuestionIndex];
            questionLabel.setText(currentQuestion.question);

            for (int i = 0; i < 4; i++) {
                optionButtons[i].setText(currentQuestion.options[i]);
                optionButtons[i].setSelected(false);
            }

            timeLeft = TIME_LIMIT;
            timerLabel.setText("Time left: " + timeLeft);
            timer.restart(); // Restart the timer for the new question
        } else {
            showResults();
        }
    }

    private void submitAnswer() {
        timer.stop();

        int selectedOption = -1;

        for (int i = 0; i < 4; i++) {
            if (optionButtons[i].isSelected()) {
                selectedOption = i;
                break;
            }
        }

        if (selectedOption == questions[currentQuestionIndex].correctAnswer) {
            score++;
        }

        currentQuestionIndex++;
        loadQuestion();
    }

    private void showResults() {
        JOptionPane.showMessageDialog(this, "Quiz Over!\nYour Score: " + score + "/" + questions.length);
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            submitAnswer();
        }
    }

    public static void main(String[] args) {
        new QuizApp().setVisible(true);
    }
}
