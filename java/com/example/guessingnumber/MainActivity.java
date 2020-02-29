package com.example.guessingnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;
    int randomNumber;
    String message;

    public void generateRandomNumber() {
        Random random = new Random();// Random Class generate number randomly.
        randomNumber = random.nextInt(50) + 1;//  The nextInt() is used to get the next
        // random integer value from this random number generator's sequence.

    }

    public void Guess(View view) { // create  method for Guess and connect with button.


        Log.i("Info", Integer.toString(randomNumber));//Integer method  which return String
        Log.i("Enter value", editText.getText().toString());// getText by editText
        int guessValue = Integer.parseInt(editText.getText().toString());
        if (guessValue > randomNumber) { //checking condition for if guessValue is greater than randomNumber
            // then print Lower guessValue is less than randomValue then print the Higher otherwise print got it.
            message = "Lower"; //Message Print Lower
        } else if (guessValue < randomNumber) {
            message = "Higher"; //Message print Higher
        } else {
            message = "You got it! Try again";
            generateRandomNumber(); // it generate RandomMethod call here

        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();//pop the message
        textView.setText(message); //set answer into textAnswer

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.input);// for editText field id
        button = findViewById(R.id.sub);// for submit button
        textView = findViewById(R.id.textAnswer);//textAnswer for result showing id


    }
}
