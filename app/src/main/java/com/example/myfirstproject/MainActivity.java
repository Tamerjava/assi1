package com.example.myfirstproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirstproject.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView questionTextView;
    private Button choice1Button;
    private Button choice2Button;
    private Button choice3Button;
    private Button choice4Button;
    private int correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.question_textview);
        choice1Button = findViewById(R.id.choice1Button);
        choice2Button = findViewById(R.id.choice2Button);
        choice3Button = findViewById(R.id.choice3Button);
        choice4Button = findViewById(R.id.choice4Button);

        generateMathQuiz();
    }

    private void generateMathQuiz() {
        Random random = new Random();
        int num1 = random.nextInt(10) + 1;
        int num2 = random.nextInt(10) + 1;
        int operator = random.nextInt(3); // 0 = addition, 1 = subtraction, 2 = multiplication

        String question = "";

        switch (operator) {
            case 0:
                correctAnswer = num1 + num2;
                question = num1 + " + " + num2 + " = ?";
                break;
            case 1:
                correctAnswer = num1 - num2;
                question = num1 + " - " + num2 + " = ?";
                break;
            case 2:
                correctAnswer = num1 * num2;
                question = num1 + " x " + num2 + " = ?";
                break;
        }

        questionTextView.setText(question);

        // Generate 4 choices (including the correct answer)
        int[] choices = new int[4];
        int correctAnswerIndex = random.nextInt(4);
        choices[correctAnswerIndex] = correctAnswer;

        for (int i = 0; i < 4; i++) {
            if (i == correctAnswerIndex) {
                continue;
            }

            int choice;
            do {
                choice = random.nextInt(21) - 10; // Generate a random number between -10 and 10 (inclusive)
            } while (choice == correctAnswer || contains(choices, choice));

            choices[i] = choice;
        }

        choice1Button.setText(String.valueOf(choices[0]));
        choice2Button.setText(String.valueOf(choices[1]));
        choice3Button.setText(String.valueOf(choices[2]));
        choice4Button.setText(String.valueOf(choices[3]));
    }

    private boolean contains(int[] arr, int val) {
        for (int num : arr) {
            if (num == val) {
                return true;
            }
        }
        return false;
    }

    public void onAnswerButtonClicked(View view) {
        Button clickedButton = (Button) view;
        int selectedAnswer = Integer.parseInt(clickedButton.getText().toString());

        if (selectedAnswer == correctAnswer) {
            String message = "correct.";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            generateMathQuiz();
        } else {
            // User answered incorrectly, show a message
            String message = "Incorrect Try again.";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
}
