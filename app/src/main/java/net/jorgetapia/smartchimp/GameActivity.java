package net.jorgetapia.smartchimp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import net.jorgetapia.smartchimp.audio.AudioManager;
import net.jorgetapia.smartchimp.model.Answer;
import net.jorgetapia.smartchimp.model.HighScore;
import net.jorgetapia.smartchimp.model.Question;

import java.util.Date;
import java.util.List;


public class GameActivity extends ActionBarActivity {

    private static final String LOG_TAG = "SmartChimp";

    private Integer currentQuestion;
    private Integer correctQuestions;
    private Integer bananasEarned;
    private Boolean questionsLoaded;
    private Boolean won;

    private List<Question> questionsForGame;
    private List<Answer> answers;

    private TextView correctTextView;
    private TextView scoreTextView;
    private ScrollView questionScrollView;
    private TextView questionTextView;
    private Button answerButton1;
    private Button answerButton2;
    private Button answerButton3;
    private Button answerButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        AudioManager.release();
        AudioManager.startMusic(this, AudioManager.MUSIC_GAME);

        this.currentQuestion = 0;
        this.bananasEarned = 0;
        this.correctQuestions = 0;

        this.setupUI();
        this.loadData();

        Log.d(LOG_TAG, "Game started...");
    }

    private void setupUI() {
        Typeface americanTypewriter = Typeface.createFromAsset(getAssets(),
                "fonts/AmericanTypewriter.ttc");
        Typeface bold = Typeface.create(americanTypewriter, Typeface.BOLD);

        this.correctTextView = (TextView) findViewById(R.id.correctTextView);
        this.correctTextView.setTypeface(bold);

        this.scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        this.scoreTextView.setTypeface(bold);

        this.questionTextView = (TextView) findViewById(R.id.questionTextView);
        this.questionTextView.setTypeface(bold);

        this.questionScrollView = (ScrollView) findViewById(R.id.questionScrollView);

        this.answerButton1 = (Button) findViewById(R.id.answerButton1);
        this.answerButton1.setTypeface(americanTypewriter);
        this.answerButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameActivity activity = GameActivity.this;
                activity.processAnswer(activity.answers.get(0));
            }
        });

        this.answerButton2 = (Button) findViewById(R.id.answerButton2);
        this.answerButton2.setTypeface(americanTypewriter);
        this.answerButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GameActivity activity = GameActivity.this;
                activity.processAnswer(activity.answers.get(1));
            }
        });

        this.answerButton3 = (Button) findViewById(R.id.answerButton3);
        this.answerButton3.setTypeface(americanTypewriter);
        this.answerButton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GameActivity activity = GameActivity.this;
                activity.processAnswer(activity.answers.get(2));
            }
        });

        this.answerButton4 = (Button) findViewById(R.id.answerButton4);
        this.answerButton4.setTypeface(americanTypewriter);
        this.answerButton4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GameActivity activity = GameActivity.this;
                activity.processAnswer(activity.answers.get(3));
            }
        });
    }

    private void processAnswer(Answer answer) {
        if (answer.correct) {
            AudioManager.playRightSound(this);
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();

            ++this.currentQuestion;
            ++this.correctQuestions;
            this.bananasEarned += 10;

            this.updateCorrectText();
            this.updateBananasEarnedText();

            if (this.currentQuestion < 10) {
                this.questionScrollView.fullScroll(ScrollView.FOCUS_UP);
                this.loadData();
            } else {
                if (this.correctQuestions >= 7) {
                    Toast.makeText(this, getString(R.string.win_text), Toast.LENGTH_LONG).show();
                    this.won = true;
                } else {
                    Toast.makeText(this, getString(R.string.lose_text), Toast.LENGTH_LONG).show();
                    this.won = false;
                }
            }
        } else {
            AudioManager.playWrongSound(this);
            Toast.makeText(this, "Not correct!", Toast.LENGTH_SHORT).show();

            ++this.currentQuestion;

            if (this.currentQuestion < 10) {
                this.questionScrollView.fullScroll(ScrollView.FOCUS_UP);
                this.loadData();
            } else {
                if (this.correctQuestions >= 7) {
                    Toast.makeText(this, getString(R.string.win_text), Toast.LENGTH_LONG).show();
                    this.won = true;
                } else {
                    Toast.makeText(this, getString(R.string.lose_text), Toast.LENGTH_LONG).show();
                    this.won = false;
                }
            }
        }

        if (this.currentQuestion > 9) {
            if (this.bananasEarned > 0) {
                HighScore newHighScore = new HighScore();
                newHighScore.score = this.bananasEarned;
                newHighScore.dateAchieved = new Date();
                newHighScore.save();
            }

            Intent intent = new Intent(this, GameOverActivity.class);
            intent.putExtra("won", this.won);

            startActivity(intent);
            finish();
        }
    }

    private void updateCorrectText() {
        this.correctTextView.setText(this.correctQuestions + "/10 Correct");
    }

    private void updateBananasEarnedText() {
        this.scoreTextView.setText("x" + this.bananasEarned);
    }

    private void loadData() {
        if (this.questionsLoaded == null) {
            this.questionsForGame = Question.getQuestionsForGame();
        }

        Question question = this.questionsForGame.get(currentQuestion);

        this.answers = Answer.getAll(question);

        this.questionTextView.setText("QUESTION #" + (this.currentQuestion + 1) + ":\n" + question.text);

        this.answerButton1.setText(this.answers.get(0).text);
        this.answerButton2.setText(this.answers.get(1).text);
        this.answerButton3.setText(this.answers.get(2).text);
        this.answerButton4.setText(this.answers.get(3).text);

        this.questionsLoaded = true;
    }
}
