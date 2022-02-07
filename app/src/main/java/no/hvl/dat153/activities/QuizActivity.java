package no.hvl.dat153.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import no.hvl.dat153.dao.PersonDao;
import no.hvl.dat153.model.Person;
import no.hvl.dat153.R;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    private String ans;
    private int points;
    private int tries;

    private RadioButton radioButton;
    private List<Person> person;
    private List<String> listOfNames;
    private PersonDao personDao = new PersonDao();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        person = personDao.getAllPersons();
        listOfNames = personDao.getNames();
        initQuiz();

        final Button endQuizBtn = findViewById(R.id.endQuizBtn);
        Intent Result = new Intent(this, ResultActivity.class);
        endQuizBtn.setOnClickListener(v -> startActivity(Result));
    }

    private void initQuiz() {
        Random rand = new Random();
        boolean quizRunning = true;


        if (quizRunning) {
            Intent result = new Intent(this, ResultActivity.class);
            result.putExtra("score", String.valueOf(points));
            result.putExtra("tries", String.valueOf(tries));
            startActivity(result);
        } else {
            Button btn1 = findViewById(R.id.quizAlternative1);
            Button btn2 = findViewById(R.id.quitAlternative2);
            Button btn3 = findViewById(R.id.quizAlternative3);

            List<Button> buttonList = Arrays.asList(btn1, btn2, btn3);
            Collections.shuffle(buttonList);

            int a = rand.nextInt(person.size());
            int b = rand.nextInt(person.size());
            int c = rand.nextInt(person.size());

            // Set Alternative A
            ans = person.get(a).getName();
            buttonList.get(0).setText(ans);

            // Set Alternative B
            String wrongb = listOfNames.get(b);
            while (ans.equals(wrongb)) {
                b = rand.nextInt(listOfNames.size());
                wrongb = listOfNames.get(b);
            }
            String nameB = listOfNames.get(b);
            buttonList.get(1).setText(nameB);

            // Set Alternative C
            String wrongc = listOfNames.get(c);
            while (ans.equals(wrongc) || nameB.equals(wrongc)) {
                c = rand.nextInt(listOfNames.size());
                wrongc = listOfNames.get(c);
            }
            String nameC = listOfNames.get(c);
            buttonList.get(2).setText(nameC);

            //Set image for correct Answer
            ImageView imageView = findViewById(R.id.guessPicture);
            imageView.setImageURI(person.get(a).getPath());

        }
    }

    @Override
    public void onClick(View view) {
        String answer = "";
        String displayScore = "";
        RadioGroup radioGroup = findViewById(R.id.radio_btns);

        int ansId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(ansId);
        if (radioButton != null) {
            tries++;
            String toastStr = "";
            answer = (String) radioButton.getText();

            if (answer.equals(ans)) {
                toastStr = "Correct!";
                points++;
            } else {
                toastStr = "Wrong!";
            }
            Toast.makeText(QuizActivity.this, toastStr, Toast.LENGTH_SHORT).show();

            displayScore = "Correct answers: " + points + " out of " + tries + " tries.";
            TextView textView = findViewById(R.id.score);
            textView.setText(displayScore);
            radioGroup.clearCheck();

            // Reset screen for new question
            initQuiz();
        }
    }
}





