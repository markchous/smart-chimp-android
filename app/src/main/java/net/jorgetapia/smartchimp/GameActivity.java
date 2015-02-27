package net.jorgetapia.smartchimp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
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

        this.currentQuestion = 0;
        this.bananasEarned = 0;
        this.correctQuestions = 0;

        this.setupUI();
        this.loadData();

        Log.d(LOG_TAG, "Game started...");
    }

    @Override
    protected void onPause() {
        super.onPause();

        AudioManager.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();

        AudioManager.release();
        AudioManager.startMusic(this, AudioManager.MUSIC_GAME);
    }

    private void setupUI() {
        Typeface americanTypewriter = Typeface.createFromAsset(getAssets(),
                "fonts/AmericanTypewriter.ttc");
        Typeface bold = Typeface.create(americanTypewriter, Typeface.BOLD);

        ScrollView questionScrollView = (ScrollView) findViewById(R.id.questionScrollView);
        questionScrollView.setVerticalScrollBarEnabled(true);
        questionScrollView.setScrollbarFadingEnabled(false);

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
                activity.processAnswer(activity.answers.get(0), activity.answerButton1);
            }
        });

        this.answerButton2 = (Button) findViewById(R.id.answerButton2);
        this.answerButton2.setTypeface(americanTypewriter);
        this.answerButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GameActivity activity = GameActivity.this;
                activity.processAnswer(activity.answers.get(1), activity.answerButton2);
            }
        });

        this.answerButton3 = (Button) findViewById(R.id.answerButton3);
        this.answerButton3.setTypeface(americanTypewriter);
        this.answerButton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GameActivity activity = GameActivity.this;
                activity.processAnswer(activity.answers.get(2), activity.answerButton3);
            }
        });

        this.answerButton4 = (Button) findViewById(R.id.answerButton4);
        this.answerButton4.setTypeface(americanTypewriter);
        this.answerButton4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GameActivity activity = GameActivity.this;
                activity.processAnswer(activity.answers.get(3), activity.answerButton4);
            }
        });
    }

    private void processAnswer(Answer answer, Button buttonPressed) {
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

            this.correctQuestion(buttonPressed);
            ++this.currentQuestion;

            if (this.currentQuestion < 10) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        GameActivity.this.questionScrollView.fullScroll(ScrollView.FOCUS_UP);
                        GameActivity.this.loadData();
                    }
                }, 5000);
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

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    Intent intent = new Intent(GameActivity.this, GameOverActivity.class);
                    intent.putExtra("won", GameActivity.this.won);

                    GameActivity.this.startActivity(intent);
                    GameActivity.this.finish();
                }
            }, 5000);
        }
    }

    private void updateCorrectText() {
        this.correctTextView.setText(this.correctQuestions + "/10 Correct");
    }

    private void updateBananasEarnedText() {
        this.scoreTextView.setText("x" + this.bananasEarned);
    }

    private void correctQuestion(Button buttonPressed) {
        Typeface americanTypewriter = Typeface.createFromAsset(getAssets(),
                "fonts/AmericanTypewriter.ttc");
        Typeface bold = Typeface.create(americanTypewriter, Typeface.BOLD);

        buttonPressed.setTypeface(bold);
        buttonPressed.setTextColor(Color.RED);

        for (int i = 0; i < this.answers.size(); i++) {
            if (this.answers.get(i).correct) {
                switch (i) {
                    case 0:
                        this.answerButton1.setTypeface(bold);
                        this.answerButton1.setTextColor(Color.GREEN);
                        break;
                    case 1:
                        this.answerButton2.setTypeface(bold);
                        this.answerButton2.setTextColor(Color.GREEN);
                        break;
                    case 2:
                        this.answerButton3.setTypeface(bold);
                        this.answerButton3.setTextColor(Color.GREEN);
                        break;
                    case 3:
                        this.answerButton4.setTypeface(bold);
                        this.answerButton4.setTextColor(Color.GREEN);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void loadData() {
        if (this.questionsLoaded == null) {
            this.questionsForGame = Question.getQuestionsForGame();
        }

        Typeface americanTypewriter = Typeface.createFromAsset(getAssets(),
                "fonts/AmericanTypewriter.ttc");
        Typeface normal = Typeface.create(americanTypewriter, Typeface.NORMAL);

        Question question = this.questionsForGame.get(currentQuestion);

        this.answers = Answer.getAll(question);

        this.questionTextView.setText("QUESTION #" + (this.currentQuestion + 1) + ":\n" + question.text);

        this.answerButton1.setText(this.answers.get(0).text);
        this.answerButton1.setTypeface(normal);
        this.answerButton1.setTextColor(Color.BLACK);

        this.answerButton2.setText(this.answers.get(1).text);
        this.answerButton2.setTypeface(normal);
        this.answerButton2.setTextColor(Color.BLACK);

        this.answerButton3.setText(this.answers.get(2).text);
        this.answerButton3.setTypeface(normal);
        this.answerButton3.setTextColor(Color.BLACK);

        this.answerButton4.setText(this.answers.get(3).text);
        this.answerButton4.setTypeface(normal);
        this.answerButton4.setTextColor(Color.BLACK);

        this.questionsLoaded = true;
    }
}
