package net.jorgetapia.smartchimp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.activeandroid.ActiveAndroid;

import net.jorgetapia.smartchimp.audio.AudioManager;
import net.jorgetapia.smartchimp.model.Answer;
import net.jorgetapia.smartchimp.model.Question;


public class MainActivity extends ActionBarActivity {

    private static final String LOG_TAG = "SmartChimp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActiveAndroid.initialize(this);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.setupUI();

        this.setupData();
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
        AudioManager.startMusic(this, AudioManager.MUSIC_MENU);
    }

    private void setupUI() {
        Typeface americanTypewriter = Typeface.createFromAsset(getAssets(),
                "fonts/AmericanTypewriter.ttc");
        Typeface bold = Typeface.create(americanTypewriter, Typeface.BOLD);

        final Button playButton = (Button) findViewById(R.id.playButton);
        playButton.setTypeface(bold);
        playButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });

        Button howToPlayButton = (Button) findViewById(R.id.howToPlayButton);
        howToPlayButton.setTypeface(bold);
        howToPlayButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AudioManager.playButtonSound(MainActivity.this);

                Intent intent = new Intent(MainActivity.this, HowToPlayActivity.class);
                startActivity(intent);
            }
        });

        Button highScoresButton = (Button) findViewById(R.id.highScoresButton);
        highScoresButton.setTypeface(bold);
        highScoresButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AudioManager.playButtonSound(MainActivity.this);

                Intent intent = new Intent(MainActivity.this, HighScoreActivity.class);
                startActivity(intent);
            }
        });

        Button creditsButton = (Button) findViewById(R.id.creditsButton);
        creditsButton.setTypeface(bold);
        creditsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AudioManager.playButtonSound(MainActivity.this);

                Intent intent = new Intent(MainActivity.this, CreditsActivity.class);
                startActivity(intent);
            }
        });

        Button shareButton = (Button) findViewById(R.id.shareButton);
        shareButton.setTypeface(bold);
        shareButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AudioManager.playButtonSound(MainActivity.this);

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TITLE, "Share Smart Chimp");
                intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text_google_play));
                intent.setType("text/plain");

                startActivity(intent);
            }
        });
    }

    @SuppressWarnings("ConstantConditions")
    private void setupData() {
        // Clear question cache
        Question.removeAll();

        // Question 1
        Question question1 = new Question();
        question1.text = "What's the probability of picking an ace of spades out of a brand new " +
                "deck without jokers?";
        question1.save();

        Answer answer1_1 = new Answer();
        answer1_1.text = "1/52";
        answer1_1.correct = false;
        answer1_1.question = question1;
        answer1_1.save();

        Answer answer1_2 = new Answer();
        answer1_2.text = "50%";
        answer1_2.correct = false;
        answer1_2.question = question1;
        answer1_2.save();

        Answer answer1_3 = new Answer();
        answer1_3.text = "4/52";
        answer1_3.correct = false;
        answer1_3.question = question1;
        answer1_3.save();

        Answer answer1_4 = new Answer();
        answer1_4.text = "100%";
        answer1_4.correct = true;
        answer1_4.question = question1;
        answer1_4.save();

        // Question 2
        Question question2 = new Question();
        question2.text = "How many ways is it possible to color the faces of a six sided cube" +
                " white?";
        question2.save();

        Answer answer2_1 = new Answer();
        answer2_1.text = "Seven";
        answer2_1.correct = false;
        answer2_1.question = question2;
        answer2_1.save();

        Answer answer2_2 = new Answer();
        answer2_2.text = "Nine";
        answer2_2.correct = false;
        answer2_2.question = question2;
        answer2_2.save();

        Answer answer2_3 = new Answer();
        answer2_3.text = "Thirteen";
        answer2_3.correct = false;
        answer2_3.question = question2;
        answer2_3.save();

        Answer answer2_4 = new Answer();
        answer2_4.text = "Eleven";
        answer2_4.correct = true;
        answer2_4.question = question2;
        answer2_4.save();

        // Question 3
        Question question3 = new Question();
        question3.text = "A 4x4 planting density per acre is twice as many trees as an 8x8 spacing";
        question3.save();

        Answer answer3_1 = new Answer();
        answer3_1.text = "True";
        answer3_1.correct = false;
        answer3_1.question = question3;
        answer3_1.save();

        Answer answer3_2 = new Answer();
        answer3_2.text = "False";
        answer3_2.correct = true;
        answer3_2.question = question3;
        answer3_2.save();

        Answer answer3_3 = new Answer();
        answer3_3.text = "Both";
        answer3_3.correct = false;
        answer3_3.question = question3;
        answer3_3.save();

        Answer answer3_4 = new Answer();
        answer3_4.text = "None";
        answer3_4.correct = false;
        answer3_4.question = question3;
        answer3_4.save();

        // Question 4
        Question question4 = new Question();
        question4.text = "If you only had one match and you walked into a room where there was " +
                "an oil burner, a kerosene lamp, and a wood burning stove, " +
                "what would you light first?";
        question4.save();

        Answer answer4_1 = new Answer();
        answer4_1.text = "Kerosene lamp";
        answer4_1.correct = false;
        answer4_1.question = question4;
        answer4_1.save();

        Answer answer4_2 = new Answer();
        answer4_2.text = "The oil burner";
        answer4_2.correct = false;
        answer4_2.question = question4;
        answer4_2.save();

        Answer answer4_3 = new Answer();
        answer4_3.text = "What you had when you walked into the room";
        answer4_3.correct = true;
        answer4_3.question = question4;
        answer4_3.save();

        Answer answer4_4 = new Answer();
        answer4_4.text = "The wood burning stove";
        answer4_4.correct = false;
        answer4_4.question = question4;
        answer4_4.save();

        // Question 5
        Question question5 = new Question();
        question5.text = "There are 3 apples and you take away 2. How many do you have?";
        question5.save();

        Answer answer5_1 = new Answer();
        answer5_1.text = "One";
        answer5_1.correct = false;
        answer5_1.question = question5;
        answer5_1.save();

        Answer answer5_2 = new Answer();
        answer5_2.text = "Two";
        answer5_2.correct = true;
        answer5_2.question = question5;
        answer5_2.save();

        Answer answer5_3 = new Answer();
        answer5_3.text = "Three";
        answer5_3.correct = false;
        answer5_3.question = question5;
        answer5_3.save();

        Answer answer5_4 = new Answer();
        answer5_4.text = "None";
        answer5_4.correct = false;
        answer5_4.question = question5;
        answer5_4.save();

        // Question 6
        Question question6 = new Question();
        question6.text = "Two women play five games of checkers. Each woman wins the same number" +
                " of games. There are no ties. Explain this.";
        question6.save();

        Answer answer6_1 = new Answer();
        answer6_1.text = "They are not wearing ties";
        answer6_1.correct = false;
        answer6_1.question = question6;
        answer6_1.save();

        Answer answer6_2 = new Answer();
        answer6_2.text = "They are playing men";
        answer6_2.correct = false;
        answer6_2.question = question6;
        answer6_2.save();

        Answer answer6_3 = new Answer();
        answer6_3.text = "Women do not wear ties";
        answer6_3.correct = false;
        answer6_3.question = question6;
        answer6_3.save();

        Answer answer6_4 = new Answer();
        answer6_4.text = "Women are not playing each other";
        answer6_4.correct = true;
        answer6_4.question = question6;
        answer6_4.save();

        // Question 7
        Question question7 = new Question();
        question7.text = "A woman gives a beggar 50 cents, the woman is the beggar’s sister, " +
                "but the beggar is not the woman’s brother. How come?";
        question7.save();

        Answer answer7_1 = new Answer();
        answer7_1.text = "The woman is the beggar";
        answer7_1.correct = false;
        answer7_1.question = question7;
        answer7_1.save();

        Answer answer7_2 = new Answer();
        answer7_2.text = "The beggar is an in-law";
        answer7_2.correct = false;
        answer7_2.question = question7;
        answer7_2.save();

        Answer answer7_3 = new Answer();
        answer7_3.text = "The beggar is the woman’s sister";
        answer7_3.correct = true;
        answer7_3.question = question7;
        answer7_3.save();

        Answer answer7_4 = new Answer();
        answer7_4.text = "Not possible";
        answer7_4.correct = false;
        answer7_4.question = question7;
        answer7_4.save();

        // Question 8
        Question question8 = new Question();
        question8.text = "If a cat jumped out of a hat onto a doormat then sat on a ledge next " +
                "to a school thinking he was in New York sitting on top of the Empire State " +
                "building, where is the cat?";
        question8.save();

        Answer answer8_1 = new Answer();
        answer8_1.text = "On the doormat";
        answer8_1.correct = false;
        answer8_1.question = question8;
        answer8_1.save();

        Answer answer8_2 = new Answer();
        answer8_2.text = "On the ledge";
        answer8_2.correct = true;
        answer8_2.question = question8;
        answer8_2.save();

        Answer answer8_3 = new Answer();
        answer8_3.text = "New York";
        answer8_3.correct = false;
        answer8_3.question = question8;
        answer8_3.save();

        Answer answer8_4 = new Answer();
        answer8_4.text = "Empire State Building";
        answer8_4.correct = false;
        answer8_4.question = question8;
        answer8_4.save();

        // Question 9
        Question question9 = new Question();
        question9.text = "Two mothers and two daughters walk into a store. They have 21 dollars. " +
                "How is it possible to split it equally without any cents (in whole dollars)?";
        question9.save();

        Answer answer9_1 = new Answer();
        answer9_1.text = "They get $7 each";
        answer9_1.correct = true;
        answer9_1.question = question9;
        answer9_1.save();

        Answer answer9_2 = new Answer();
        answer9_2.text = "They get $5.40 each";
        answer9_2.correct = false;
        answer9_2.question = question9;
        answer9_2.save();

        Answer answer9_3 = new Answer();
        answer9_3.text = "They get $6 each";
        answer9_3.correct = false;
        answer9_3.question = question9;
        answer9_3.save();

        Answer answer9_4 = new Answer();
        answer9_4.text = "Not Possible";
        answer9_4.correct = false;
        answer9_4.question = question9;
        answer9_4.save();

        // Question 10
        Question question10 = new Question();
        question10.text = "Divide 30 by half and add 10. What is the answer?";
        question10.save();

        Answer answer10_1 = new Answer();
        answer10_1.text = "15";
        answer10_1.correct = false;
        answer10_1.question = question10;
        answer10_1.save();

        Answer answer10_2 = new Answer();
        answer10_2.text = "25";
        answer10_2.correct = false;
        answer10_2.question = question10;
        answer10_2.save();

        Answer answer10_3 = new Answer();
        answer10_3.text = "30";
        answer10_3.correct = false;
        answer10_3.question = question10;
        answer10_3.save();

        Answer answer10_4 = new Answer();
        answer10_4.text = "70";
        answer10_4.correct = true;
        answer10_4.question = question10;
        answer10_4.save();

        // Question 11
        Question question11 = new Question();
        question11.text = "How many 2 cent stamps are in a dozen?";
        question11.save();

        Answer answer11_1 = new Answer();
        answer11_1.text = "Six";
        answer11_1.correct = false;
        answer11_1.question = question11;
        answer11_1.save();

        Answer answer11_2 = new Answer();
        answer11_2.text = "Twelve";
        answer11_2.correct = true;
        answer11_2.question = question11;
        answer11_2.save();

        Answer answer11_3 = new Answer();
        answer11_3.text = "Eighteen";
        answer11_3.correct = false;
        answer11_3.question = question11;
        answer11_3.save();

        Answer answer11_4 = new Answer();
        answer11_4.text = "Twenty-four";
        answer11_4.correct = false;
        answer11_4.question = question11;
        answer11_4.save();

        // Question 12
        Question question12 = new Question();
        question12.text = "A forester has 17 trees, and all but 9 die. How many are left?";
        question12.save();

        Answer answer12_1 = new Answer();
        answer12_1.text = "8";
        answer12_1.correct = false;
        answer12_1.question = question12;
        answer12_1.save();

        Answer answer12_2 = new Answer();
        answer12_2.text = "9";
        answer12_2.correct = true;
        answer12_2.question = question12;
        answer12_2.save();

        Answer answer12_3 = new Answer();
        answer12_3.text = "The first 8";
        answer12_3.correct = false;
        answer12_3.question = question12;
        answer12_3.save();

        Answer answer12_4 = new Answer();
        answer12_4.text = "I don't know.";
        answer12_4.correct = false;
        answer12_4.question = question12;
        answer12_4.save();

        // Question 13
        Question question13 = new Question();
        question13.text = "What was the U.S. President's name in the 1950?";
        question13.save();

        Answer answer13_1 = new Answer();
        answer13_1.text = "Harry Truman";
        answer13_1.correct = true;
        answer13_1.question = question13;
        answer13_1.save();

        Answer answer13_2 = new Answer();
        answer13_2.text = "John Kennedy";
        answer13_2.correct = false;
        answer13_2.question = question13;
        answer13_2.save();

        Answer answer13_3 = new Answer();
        answer13_3.text = "President Eisenhower";
        answer13_3.correct = false;
        answer13_3.question = question13;
        answer13_3.save();

        Answer answer13_4 = new Answer();
        answer13_4.text = "Bill Clinton";
        answer13_4.correct = false;
        answer13_4.question = question13;
        answer13_4.save();

        // Question 14
        Question question14 = new Question();
        question14.text = "How far can a forester run into the woods?";
        question14.save();

        Answer answer14_1 = new Answer();
        answer14_1.text = "All the way into the woods";
        answer14_1.correct = false;
        answer14_1.question = question14;
        answer14_1.save();

        Answer answer14_2 = new Answer();
        answer14_2.text = "Half way into the woods";
        answer14_2.correct = true;
        answer14_2.question = question14;
        answer14_2.save();

        Answer answer14_3 = new Answer();
        answer14_3.text = "He doesn't actually run into the woods";
        answer14_3.correct = false;
        answer14_3.question = question14;
        answer14_3.save();

        Answer answer14_4 = new Answer();
        answer14_4.text = "I don't know";
        answer14_4.correct = false;
        answer14_4.question = question14;
        answer14_4.save();

        // Question 15
        Question question15 = new Question();
        question15.text = "I have two U.S. coins totaling 55 cents. One is not a nickel. " +
                "What are the coins?";
        question15.save();

        Answer answer15_1 = new Answer();
        answer15_1.text = "I have no idea";
        answer15_1.correct = false;
        answer15_1.question = question15;
        answer15_1.save();

        Answer answer15_2 = new Answer();
        answer15_2.text = "A fifty-cent piece and a nickel";
        answer15_2.correct = true;
        answer15_2.question = question15;
        answer15_2.save();

        Answer answer15_3 = new Answer();
        answer15_3.text = "Not possible";
        answer15_3.correct = false;
        answer15_3.question = question15;
        answer15_3.save();

        Answer answer15_4 = new Answer();
        answer15_4.text = "100 Yen";
        answer15_4.correct = false;
        answer15_4.question = question15;
        answer15_4.save();

        // Question 16
        Question question16 = new Question();
        question16.text = "Why can't a man living in the USA be buried in Canada?";
        question16.save();

        Answer answer16_1 = new Answer();
        answer16_1.text = "The Canadian government doesn't allow it";
        answer16_1.correct = false;
        answer16_1.question = question16;
        answer16_1.save();

        Answer answer16_2 = new Answer();
        answer16_2.text = "The man isn't dead yet";
        answer16_2.correct = true;
        answer16_2.question = question16;
        answer16_2.save();

        Answer answer16_3 = new Answer();
        answer16_3.text = "The man is a canadian living in America";
        answer16_3.correct = false;
        answer16_3.question = question16;
        answer16_3.save();

        Answer answer16_4 = new Answer();
        answer16_4.text = "The man is living on the border";
        answer16_4.correct = false;
        answer16_4.question = question16;
        answer16_4.save();

        // Question 17
        Question question17 = new Question();
        question17.text = "There are three playing cards lying face up, side by side. A five is " +
                "just to the right of a two. A five is just to the left of a two. A spade is " +
                "just to the left of a club, and a spade is just to the right of a spade. What " +
                "are the three cards?";
        question17.save();

        Answer answer17_1 = new Answer();
        answer17_1.text = "5 spades, 2 spades, 5 clubs";
        answer17_1.correct = true;
        answer17_1.question = question17;
        answer17_1.save();

        Answer answer17_2 = new Answer();
        answer17_2.text = "I don't know";
        answer17_2.correct = false;
        answer17_2.question = question17;
        answer17_2.save();

        Answer answer17_3 = new Answer();
        answer17_3.text = "5 spades, 2 clubs, a random spade card";
        answer17_3.correct = false;
        answer17_3.question = question17;
        answer17_3.save();

        Answer answer17_4 = new Answer();
        answer17_4.text = "2 clubs, a random spade card and a 5 spades";
        answer17_4.correct = false;
        answer17_4.question = question17;
        answer17_4.save();

        // Question 18
        Question question18 = new Question();
        question18.text = "If you add the age of a man to the age of his wife, the sum is 91. He " +
                "is now twice as old as she was, when he was as old as she is now. How old are " +
                "they?";
        question18.save();

        Answer answer18_1 = new Answer();
        answer18_1.text = "Man 51 Wife 40";
        answer18_1.correct = false;
        answer18_1.question = question18;
        answer18_1.save();

        Answer answer18_2 = new Answer();
        answer18_2.text = "Wife 51 Man 40";
        answer18_2.correct = false;
        answer18_2.question = question18;
        answer18_2.save();

        Answer answer18_3 = new Answer();
        answer18_3.text = "Man 52 Wife 39";
        answer18_3.correct = true;
        answer18_3.question = question18;
        answer18_3.save();

        Answer answer18_4 = new Answer();
        answer18_4.text = "Man 54 Wife 37";
        answer18_4.correct = false;
        answer18_4.question = question18;
        answer18_4.save();

        // Question 19
        Question question19 = new Question();
        question19.text = "Can you buy an entire chess set in a pawn shop?";
        question19.save();

        Answer answer19_1 = new Answer();
        answer19_1.text = "Yes you can";
        answer19_1.correct = false;
        answer19_1.question = question19;
        answer19_1.save();

        Answer answer19_2 = new Answer();
        answer19_2.text = "No, they're completely unrelated";
        answer19_2.correct = true;
        answer19_2.question = question19;
        answer19_2.save();

        Answer answer19_3 = new Answer();
        answer19_3.text = "No, you can only buy pawns";
        answer19_3.correct = false;
        answer19_3.question = question19;
        answer19_3.save();

        Answer answer19_4 = new Answer();
        answer19_4.text = "You can get everything but the king and queen";
        answer19_4.correct = false;
        answer19_4.question = question19;
        answer19_4.save();

        // Question 20
        Question question20 = new Question();
        question20.text = "Mary had a coin purse with fifty coins, totaling exactly $1. While " +
                "counting her change, she dropped one coin. What is the probability that the " +
                "coin dropped was a penny?";
        question20.save();

        Answer answer20_1 = new Answer();
        answer20_1.text = "85%";
        answer20_1.correct = true;
        answer20_1.question = question20;
        answer20_1.save();

        Answer answer20_2 = new Answer();
        answer20_2.text = "100%";
        answer20_2.correct = false;
        answer20_2.question = question20;
        answer20_2.save();

        Answer answer20_3 = new Answer();
        answer20_3.text = "Mary had no pennies";
        answer20_3.correct = false;
        answer20_3.question = question20;
        answer20_3.save();

        Answer answer20_4 = new Answer();
        answer20_4.text = "There's no way to know";
        answer20_4.correct = false;
        answer20_4.question = question20;
        answer20_4.save();

        // Question 21
        Question question21 = new Question();
        question21.text = "If an electric train is going 150 miles per hour north and the wind " +
                "is blowing the same south, which way does the smoke blow?";
        question21.save();

        Answer answer21_1 = new Answer();
        answer21_1.text = "None, the smoke goes up vertical";
        answer21_1.correct = false;
        answer21_1.question = question21;
        answer21_1.save();

        Answer answer21_2 = new Answer();
        answer21_2.text = "It blows South";
        answer21_2.correct = false;
        answer21_2.question = question21;
        answer21_2.save();

        Answer answer21_3 = new Answer();
        answer21_3.text = "It blows North at 300 miles per hour";
        answer21_3.correct = false;
        answer21_3.question = question21;
        answer21_3.save();

        Answer answer21_4 = new Answer();
        answer21_4.text = "There's no smoke in an electric train";
        answer21_4.correct = true;
        answer21_4.question = question21;
        answer21_4.save();

        // Question 22
        Question question22 = new Question();
        question22.text = "Two women and two doctors walk into an ice cream parlor. They each " +
                "order an ice cream cone. When the ice cream cones come, there are only three " +
                "ice cream cones. How come they don't complain?";
        question22.save();

        Answer answer22_1 = new Answer();
        answer22_1.text = "Because one of them changed their mind";
        answer22_1.correct = false;
        answer22_1.question = question22;
        answer22_1.save();

        Answer answer22_2 = new Answer();
        answer22_2.text = "Two of them are sharing";
        answer22_2.correct = false;
        answer22_2.question = question22;
        answer22_2.save();

        Answer answer22_3 = new Answer();
        answer22_3.text = "One women is a doctor, there are only three people";
        answer22_3.correct = true;
        answer22_3.question = question22;
        answer22_3.save();

        Answer answer22_4 = new Answer();
        answer22_4.text = "The cashier made a mistake";
        answer22_4.correct = false;
        answer22_4.question = question22;
        answer22_4.save();

        // Question 23
        Question question23 = new Question();
        question23.text = "A man gets an egg and a rocket kit. The man builds the rocket and " +
                "puts the egg inside. Then the man launches the rocket. The rocket suddenly " +
                "blows up but the egg is unharmed. How is this possible?";
        question23.save();

        Answer answer23_1 = new Answer();
        answer23_1.text = "The egg is super powerful";
        answer23_1.correct = false;
        answer23_1.question = question23;
        answer23_1.save();

        Answer answer23_2 = new Answer();
        answer23_2.text = "He took the egg out before launching the rocket";
        answer23_2.correct = true;
        answer23_2.question = question23;
        answer23_2.save();

        Answer answer23_3 = new Answer();
        answer23_3.text = "There was no egg to begin with";
        answer23_3.correct = false;
        answer23_3.question = question23;
        answer23_3.save();

        Answer answer23_4 = new Answer();
        answer23_4.text = "He launched another rocket he had";
        answer23_4.correct = false;
        answer23_4.question = question23;
        answer23_4.save();

        // Question 24
        Question question24 = new Question();
        question24.text = "Which word, if pronounced right is wrong, but if pronounced wrong is " +
                "right?";
        question24.save();

        Answer answer24_1 = new Answer();
        answer24_1.text = "Wrong";
        answer24_1.correct = true;
        answer24_1.question = question24;
        answer24_1.save();

        Answer answer24_2 = new Answer();
        answer24_2.text = "Every word";
        answer24_2.correct = false;
        answer24_2.question = question24;
        answer24_2.save();

        Answer answer24_3 = new Answer();
        answer24_3.text = "This question makes no sense";
        answer24_3.correct = false;
        answer24_3.question = question24;
        answer24_3.save();

        Answer answer24_4 = new Answer();
        answer24_4.text = "No such word exists";
        answer24_4.correct = false;
        answer24_4.question = question24;
        answer24_4.save();

        // Question 25
        Question question25 = new Question();
        question25.text = "When James was nine years old, he hammered a nail into a tree to mark " +
                "his height. Ten years later, he returned to see how much higher the nail was. " +
                "If the tree grew four inches per year, how much higher is the nail?";
        question25.save();

        Answer answer25_1 = new Answer();
        answer25_1.text = "The nail is four inches higher";
        answer25_1.correct = false;
        answer25_1.question = question25;
        answer25_1.save();

        Answer answer25_2 = new Answer();
        answer25_2.text = "The nail is 40 inches higher";
        answer25_2.correct = false;
        answer25_2.question = question25;
        answer25_2.save();

        Answer answer25_3 = new Answer();
        answer25_3.text = "The nail did not move, the tree grows at the top";
        answer25_3.correct = true;
        answer25_3.question = question25;
        answer25_3.save();

        Answer answer25_4 = new Answer();
        answer25_4.text = "Can't say because the tree grows uniformly";
        answer25_4.correct = false;
        answer25_4.question = question25;
        answer25_4.save();

        // Question 26
        Question question26 = new Question();
        question26.text = "A boy and a doctor were fishing.The boy is the doctor's son but the " +
                "doctor is not the boy's father. Who is the doctor?";
        question26.save();

        Answer answer26_1 = new Answer();
        answer26_1.text = "His grandfather";
        answer26_1.correct = false;
        answer26_1.question = question26;
        answer26_1.save();

        Answer answer26_2 = new Answer();
        answer26_2.text = "His brother";
        answer26_2.correct = false;
        answer26_2.question = question26;
        answer26_2.save();

        Answer answer26_3 = new Answer();
        answer26_3.text = "His mother";
        answer26_3.correct = true;
        answer26_3.question = question26;
        answer26_3.save();

        Answer answer26_4 = new Answer();
        answer26_4.text = "Can't tell";
        answer26_4.correct = false;
        answer26_4.question = question26;
        answer26_4.save();

        // Question 27
        Question question27 = new Question();
        question27.text = "Tanya is older than Eric. Cliff is older than Tanya. Eric is older " +
                "than Cliff. If the first two statements are true, the third statement is?";
        question27.save();

        Answer answer27_1 = new Answer();
        answer27_1.text = "True";
        answer27_1.correct = false;
        answer27_1.question = question27;
        answer27_1.save();

        Answer answer27_2 = new Answer();
        answer27_2.text = "False";
        answer27_2.correct = true;
        answer27_2.question = question27;
        answer27_2.save();

        Answer answer27_3 = new Answer();
        answer27_3.text = "Both";
        answer27_3.correct = false;
        answer27_3.question = question27;
        answer27_3.save();

        Answer answer27_4 = new Answer();
        answer27_4.text = "None";
        answer27_4.correct = false;
        answer27_4.question = question27;
        answer27_4.save();

        // Question 28
        Question question28 = new Question();
        question28.text = "At the baseball game, Henry was sitting in seat 253. Marla was " +
                "sitting to the right of Henry in seat 254. In the seat to the left of Henry was " +
                "George. Inez was sitting to the left of George. Which seat is Inez sitting in?";
        question28.save();

        Answer answer28_1 = new Answer();
        answer28_1.text = "251";
        answer28_1.correct = true;
        answer28_1.question = question28;
        answer28_1.save();

        Answer answer28_2 = new Answer();
        answer28_2.text = "254";
        answer28_2.correct = false;
        answer28_2.question = question28;
        answer28_2.save();

        Answer answer28_3 = new Answer();
        answer28_3.text = "255";
        answer28_3.correct = false;
        answer28_3.question = question28;
        answer28_3.save();

        Answer answer28_4 = new Answer();
        answer28_4.text = "256";
        answer28_4.correct = false;
        answer28_4.question = question28;
        answer28_4.save();

        // Question 29
        Question question29 = new Question();
        question29.text = "Only gentlemen can become members of the club. Many of the members of " +
                "the club are officers. Some of the officers have been invited for dinner.";
        question29.save();

        Answer answer29_1 = new Answer();
        answer29_1.text = "All the members have been invited for dinner";
        answer29_1.correct = false;
        answer29_1.question = question29;
        answer29_1.save();

        Answer answer29_2 = new Answer();
        answer29_2.text = "Some of the officers are not gentlemen";
        answer29_2.correct = false;
        answer29_2.question = question29;
        answer29_2.save();

        Answer answer29_3 = new Answer();
        answer29_3.text = "All gentlemen are members of the club";
        answer29_3.correct = true;
        answer29_3.question = question29;
        answer29_3.save();

        Answer answer29_4 = new Answer();
        answer29_4.text = "Only gentlemen have been invited for dinner";
        answer29_4.correct = false;
        answer29_4.question = question29;
        answer29_4.save();

        // Question 30
        Question question30 = new Question();
        question30.text = "Artists are generally whimsical. Some of them are frustrated. " +
                "Frustrated people are prone to be drug addicts. Based on these statements which " +
                "of the following conclusions is true?";
        question30.save();

        Answer answer30_1 = new Answer();
        answer30_1.text = "All frustrated people are drug addicts";
        answer30_1.correct = false;
        answer30_1.question = question30;
        answer30_1.save();

        Answer answer30_2 = new Answer();
        answer30_2.text = "Some artists may be drug addicts";
        answer30_2.correct = true;
        answer30_2.question = question30;
        answer30_2.save();

        Answer answer30_3 = new Answer();
        answer30_3.text = "All drug addicts are artists";
        answer30_3.correct = false;
        answer30_3.question = question30;
        answer30_3.save();

        Answer answer30_4 = new Answer();
        answer30_4.text = "Frustrated people are whimsical";
        answer30_4.correct = false;
        answer30_4.question = question30;
        answer30_4.save();

        // Question 31
        Question question31 = new Question();
        question31.text = "If A is the son of Q, Q and Y are sisters, Z is the mother of Y, P is " +
                "the son of Z, then which of the following statements is correct?";
        question31.save();

        Answer answer31_1 = new Answer();
        answer31_1.text = "P is the maternal uncle of A";
        answer31_1.correct = true;
        answer31_1.question = question31;
        answer31_1.save();

        Answer answer31_2 = new Answer();
        answer31_2.text = "P and Y are sisters";
        answer31_2.correct = false;
        answer31_2.question = question31;
        answer31_2.save();

        Answer answer31_3 = new Answer();
        answer31_3.text = "A and P are cousins";
        answer31_3.correct = false;
        answer31_3.question = question31;
        answer31_3.save();

        Answer answer31_4 = new Answer();
        answer31_4.text = "None of the above";
        answer31_4.correct = false;
        answer31_4.question = question31;
        answer31_4.save();

        // Question 32
        Question question32 = new Question();
        question32.text = "Which is heavier, a ton of feathers or a ton of gold?";
        question32.save();

        Answer answer32_1 = new Answer();
        answer32_1.text = "A ton of feathers";
        answer32_1.correct = false;
        answer32_1.question = question32;
        answer32_1.save();

        Answer answer32_2 = new Answer();
        answer32_2.text = "A ton of gold";
        answer32_2.correct = false;
        answer32_2.question = question32;
        answer32_2.save();

        Answer answer32_3 = new Answer();
        answer32_3.text = "They are the same";
        answer32_3.correct = true;
        answer32_3.question = question32;
        answer32_3.save();

        Answer answer32_4 = new Answer();
        answer32_4.text = "None";
        answer32_4.correct = false;
        answer32_4.question = question32;
        answer32_4.save();

        // Question 33
        Question question33 = new Question();
        question33.text = "Which month has 28 days?";
        question33.save();

        Answer answer33_1 = new Answer();
        answer33_1.text = "February";
        answer33_1.correct = false;
        answer33_1.question = question33;
        answer33_1.save();

        Answer answer33_2 = new Answer();
        answer33_2.text = "January";
        answer33_2.correct = false;
        answer33_2.question = question33;
        answer33_2.save();

        Answer answer33_3 = new Answer();
        answer33_3.text = "December";
        answer33_3.correct = false;
        answer33_3.question = question33;
        answer33_3.save();

        Answer answer33_4 = new Answer();
        answer33_4.text = "All";
        answer33_4.correct = true;
        answer33_4.question = question33;
        answer33_4.save();

        // Question 34
        Question question34 = new Question();
        question34.text = "How many times can you subtract 10 from 100?";
        question34.save();

        Answer answer34_1 = new Answer();
        answer34_1.text = "10";
        answer34_1.correct = false;
        answer34_1.question = question34;
        answer34_1.save();

        Answer answer34_2 = new Answer();
        answer34_2.text = "5";
        answer34_2.correct = false;
        answer34_2.question = question34;
        answer34_2.save();

        Answer answer34_3 = new Answer();
        answer34_3.text = "2";
        answer34_3.correct = false;
        answer34_3.question = question34;
        answer34_3.save();

        Answer answer34_4 = new Answer();
        answer34_4.text = "1";
        answer34_4.correct = true;
        answer34_4.question = question34;
        answer34_4.save();

        // Question 35
        Question question35 = new Question();
        question35.text = "Adam's mother had three children. The first child was named April. " +
                "The second child was named May. What was the third child's name?";
        question35.save();

        Answer answer35_1 = new Answer();
        answer35_1.text = "June";
        answer35_1.correct = false;
        answer35_1.question = question35;
        answer35_1.save();

        Answer answer35_2 = new Answer();
        answer35_2.text = "March";
        answer35_2.correct = false;
        answer35_2.question = question35;
        answer35_2.save();

        Answer answer35_3 = new Answer();
        answer35_3.text = "Adam";
        answer35_3.correct = true;
        answer35_3.question = question35;
        answer35_3.save();

        Answer answer35_4 = new Answer();
        answer35_4.text = "Don't know";
        answer35_4.correct = false;
        answer35_4.question = question35;
        answer35_4.save();

        // Question 36
        Question question36 = new Question();
        question36.text = "You throw away the outside and cook the inside. Then you eat the " +
                "outside and throw away the inside. What did you eat?";
        question36.save();

        Answer answer36_1 = new Answer();
        answer36_1.text = "An egg";
        answer36_1.correct = false;
        answer36_1.question = question36;
        answer36_1.save();

        Answer answer36_2 = new Answer();
        answer36_2.text = "An artichoke";
        answer36_2.correct = false;
        answer36_2.question = question36;
        answer36_2.save();

        Answer answer36_3 = new Answer();
        answer36_3.text = "An ear of corn";
        answer36_3.correct = true;
        answer36_3.question = question36;
        answer36_3.save();

        Answer answer36_4 = new Answer();
        answer36_4.text = "An onion";
        answer36_4.correct = false;
        answer36_4.question = question36;
        answer36_4.save();

        // Question 37
        Question question37 = new Question();
        question37.text = "It goes in dry, it comes out wet, the longer it's in the stronger it " +
                "gets. What is it?";
        question37.save();

        Answer answer37_1 = new Answer();
        answer37_1.text = "A swimmer";
        answer37_1.correct = false;
        answer37_1.question = question37;
        answer37_1.save();

        Answer answer37_2 = new Answer();
        answer37_2.text = "A tea bag";
        answer37_2.correct = true;
        answer37_2.question = question37;
        answer37_2.save();

        Answer answer37_3 = new Answer();
        answer37_3.text = "A soap bar";
        answer37_3.correct = false;
        answer37_3.question = question37;
        answer37_3.save();

        Answer answer37_4 = new Answer();
        answer37_4.text = "The Titanic";
        answer37_4.correct = false;
        answer37_4.question = question37;
        answer37_4.save();

        // Question 38
        Question question38 = new Question();
        question38.text = "There are 6 mangoes in a basket and 6 kids eagerly waiting to get " +
                "one. Each kid is given 1 mango, yet there is one mango in the basket. How come?";
        question38.save();

        Answer answer38_1 = new Answer();
        answer38_1.text = "2 kids share 1 mango";
        answer38_1.correct = false;
        answer38_1.question = question38;
        answer38_1.save();

        Answer answer38_2 = new Answer();
        answer38_2.text = "One kid left";
        answer38_2.correct = false;
        answer38_2.question = question38;
        answer38_2.save();

        Answer answer38_3 = new Answer();
        answer38_3.text = "Last kid gets the basket with the mango in it";
        answer38_3.correct = true;
        answer38_3.question = question38;
        answer38_3.save();

        Answer answer38_4 = new Answer();
        answer38_4.text = "Not possible";
        answer38_4.correct = false;
        answer38_4.question = question38;
        answer38_4.save();

        // Question 39
        Question question39 = new Question();
        question39.text = "What happens only in the middle of each month, in all of the seasons, " +
                "except summer and happens only in the night, never in the day?";
        question39.save();

        Answer answer39_1 = new Answer();
        answer39_1.text = "A change of seasons";
        answer39_1.correct = false;
        answer39_1.question = question39;
        answer39_1.save();

        Answer answer39_2 = new Answer();
        answer39_2.text = "The Northern Lights";
        answer39_2.correct = false;
        answer39_2.question = question39;
        answer39_2.save();

        Answer answer39_3 = new Answer();
        answer39_3.text = "A 5 week month";
        answer39_3.correct = false;
        answer39_3.question = question39;
        answer39_3.save();

        Answer answer39_4 = new Answer();
        answer39_4.text = "The letter 'n'";
        answer39_4.correct = true;
        answer39_4.question = question39;
        answer39_4.save();

        // Question 40
        Question question40 = new Question();
        question40.text = "What's in the middle of China?";
        question40.save();

        Answer answer40_1 = new Answer();
        answer40_1.text = "Beijing";
        answer40_1.correct = false;
        answer40_1.question = question40;
        answer40_1.save();

        Answer answer40_2 = new Answer();
        answer40_2.text = "The Great Wall";
        answer40_2.correct = false;
        answer40_2.question = question40;
        answer40_2.save();

        Answer answer40_3 = new Answer();
        answer40_3.text = "The Himalayas";
        answer40_3.correct = false;
        answer40_3.question = question40;
        answer40_3.save();

        Answer answer40_4 = new Answer();
        answer40_4.text = "The letter 'i'";
        answer40_4.correct = true;
        answer40_4.question = question40;
        answer40_4.save();

        // Question 41
        Question question41 = new Question();
        question41.text = "How many seconds are there in a year?";
        question41.save();

        Answer answer41_1 = new Answer();
        answer41_1.text = "31536000";
        answer41_1.correct = false;
        answer41_1.question = question41;
        answer41_1.save();

        Answer answer41_2 = new Answer();
        answer41_2.text = "365";
        answer41_2.correct = false;
        answer41_2.question = question41;
        answer41_2.save();

        Answer answer41_3 = new Answer();
        answer41_3.text = "12";
        answer41_3.correct = true;
        answer41_3.question = question41;
        answer41_3.save();

        Answer answer41_4 = new Answer();
        answer41_4.text = "None of the above";
        answer41_4.correct = false;
        answer41_4.question = question41;
        answer41_4.save();

        // Question 42
        Question question42 = new Question();
        question42.text = "If you were running a race and you passed the person in 2nd place, " +
                "what place would you be in now?";
        question42.save();

        Answer answer42_1 = new Answer();
        answer42_1.text = "1st";
        answer42_1.correct = false;
        answer42_1.question = question42;
        answer42_1.save();

        Answer answer42_2 = new Answer();
        answer42_2.text = "2nd";
        answer42_2.correct = true;
        answer42_2.question = question42;
        answer42_2.save();

        Answer answer42_3 = new Answer();
        answer42_3.text = "3rd";
        answer42_3.correct = false;
        answer42_3.question = question42;
        answer42_3.save();

        Answer answer42_4 = new Answer();
        answer42_4.text = "None of the above";
        answer42_4.correct = false;
        answer42_4.question = question42;
        answer42_4.save();

        // Question 43
        Question question43 = new Question();
        question43.text = "When was it that Christmas and New Year were celebrated in the same " +
                "year?";
        question43.save();

        Answer answer43_1 = new Answer();
        answer43_1.text = "Leap years";
        answer43_1.correct = false;
        answer43_1.question = question43;
        answer43_1.save();

        Answer answer43_2 = new Answer();
        answer43_2.text = "Year 2000";
        answer43_2.correct = false;
        answer43_2.question = question43;
        answer43_2.save();

        Answer answer43_3 = new Answer();
        answer43_3.text = "Every year";
        answer43_3.correct = true;
        answer43_3.question = question43;
        answer43_3.save();

        Answer answer43_4 = new Answer();
        answer43_4.text = "It's impossible";
        answer43_4.correct = false;
        answer43_4.question = question43;
        answer43_4.save();

        // Question 44
        Question question44 = new Question();
        question44.text = "20 pigeons sat on the branches of a tree. A man shot 1 pigeon with " +
                "his gun. How many were left on the tree?";
        question44.save();

        Answer answer44_1 = new Answer();
        answer44_1.text = "19 pigeons";
        answer44_1.correct = false;
        answer44_1.question = question44;
        answer44_1.save();

        Answer answer44_2 = new Answer();
        answer44_2.text = "20, one is dead";
        answer44_2.correct = false;
        answer44_2.question = question44;
        answer44_2.save();

        Answer answer44_3 = new Answer();
        answer44_3.text = "None, the rest flew away";
        answer44_3.correct = true;
        answer44_3.question = question44;
        answer44_3.save();

        Answer answer44_4 = new Answer();
        answer44_4.text = "None of the above";
        answer44_4.correct = false;
        answer44_4.question = question44;
        answer44_4.save();

        // Question 45
        Question question45 = new Question();
        question45.text = "A clerk at a butcher shop stands five-feet ten-inches tall and wears " +
                "size 13 sneakers. What does he weigh?";
        question45.save();

        Answer answer45_1 = new Answer();
        answer45_1.text = "180lbs";
        answer45_1.correct = false;
        answer45_1.question = question45;
        answer45_1.save();

        Answer answer45_2 = new Answer();
        answer45_2.text = "200lbs";
        answer45_2.correct = false;
        answer45_2.question = question45;
        answer45_2.save();

        Answer answer45_3 = new Answer();
        answer45_3.text = "220lbs";
        answer45_3.correct = false;
        answer45_3.question = question45;
        answer45_3.save();

        Answer answer45_4 = new Answer();
        answer45_4.text = "Meat";
        answer45_4.correct = true;
        answer45_4.question = question45;
        answer45_4.save();

        // Question 46
        Question question46 = new Question();
        question46.text = "Before Mt. Everest was discovered, which was the highest mountain in " +
                "the world?";
        question46.save();

        Answer answer46_1 = new Answer();
        answer46_1.text = "Mt. St. Helens";
        answer46_1.correct = false;
        answer46_1.question = question46;
        answer46_1.save();

        Answer answer46_2 = new Answer();
        answer46_2.text = "Mt. Cotopaxi";
        answer46_2.correct = false;
        answer46_2.question = question46;
        answer46_2.save();

        Answer answer46_3 = new Answer();
        answer46_3.text = "Mt. Popocatépetl";
        answer46_3.correct = false;
        answer46_3.question = question46;
        answer46_3.save();

        Answer answer46_4 = new Answer();
        answer46_4.text = "Mt. Everest";
        answer46_4.correct = true;
        answer46_4.question = question46;
        answer46_4.save();

        // Question 47
        Question question47 = new Question();
        question47.text = "What can run but never walks, has a mouth but never talks, has a head " +
                "but never weeps, and has a bed but never sleeps?";
        question47.save();

        Answer answer47_1 = new Answer();
        answer47_1.text = "A river";
        answer47_1.correct = true;
        answer47_1.question = question47;
        answer47_1.save();

        Answer answer47_2 = new Answer();
        answer47_2.text = "A clock";
        answer47_2.correct = false;
        answer47_2.question = question47;
        answer47_2.save();

        Answer answer47_3 = new Answer();
        answer47_3.text = "The wind";
        answer47_3.correct = false;
        answer47_3.question = question47;
        answer47_3.save();

        Answer answer47_4 = new Answer();
        answer47_4.text = "The sea";
        answer47_4.correct = false;
        answer47_4.question = question47;
        answer47_4.save();

        // Question 48
        Question question48 = new Question();
        question48.text = "Imagine you are in a sinking rowboat surrounded by sharks. How would " +
                "you survive?";
        question48.save();

        Answer answer48_1 = new Answer();
        answer48_1.text = "Hitting sharks with the paddles";
        answer48_1.correct = false;
        answer48_1.question = question48;
        answer48_1.save();

        Answer answer48_2 = new Answer();
        answer48_2.text = "Riding the sharks";
        answer48_2.correct = false;
        answer48_2.question = question48;
        answer48_2.save();

        Answer answer48_3 = new Answer();
        answer48_3.text = "Trying to out-swim the sharks";
        answer48_3.correct = false;
        answer48_3.question = question48;
        answer48_3.save();

        Answer answer48_4 = new Answer();
        answer48_4.text = "Stop imagining";
        answer48_4.correct = true;
        answer48_4.question = question48;
        answer48_4.save();

        // Question 49
        Question question49 = new Question();
        question49.text = "Eskimos are very good hunters, but they never hunt penguins. Why not?";
        question49.save();

        Answer answer49_1 = new Answer();
        answer49_1.text = "Penguins are too dangerous";
        answer49_1.correct = false;
        answer49_1.question = question49;
        answer49_1.save();

        Answer answer49_2 = new Answer();
        answer49_2.text = "There are no penguins in the Arctic";
        answer49_2.correct = true;
        answer49_2.question = question49;
        answer49_2.save();

        Answer answer49_3 = new Answer();
        answer49_3.text = "Polar bears hunt all penguins";
        answer49_3.correct = false;
        answer49_3.question = question49;
        answer49_3.save();

        Answer answer49_4 = new Answer();
        answer49_4.text = "Eskimos are vegan";
        answer49_4.correct = false;
        answer49_4.question = question49;
        answer49_4.save();

        // Question 50
        Question question50 = new Question();
        question50.text = "What demands an answer but asks no question?";
        question50.save();

        Answer answer50_1 = new Answer();
        answer50_1.text = "A wife";
        answer50_1.correct = false;
        answer50_1.question = question50;
        answer50_1.save();

        Answer answer50_2 = new Answer();
        answer50_2.text = "A letter";
        answer50_2.correct = false;
        answer50_2.question = question50;
        answer50_2.save();

        Answer answer50_3 = new Answer();
        answer50_3.text = "A mother-in-law";
        answer50_3.correct = false;
        answer50_3.question = question50;
        answer50_3.save();

        Answer answer50_4 = new Answer();
        answer50_4.text = "A telephone";
        answer50_4.correct = true;
        answer50_4.question = question50;
        answer50_4.save();

        Log.d(LOG_TAG, "Data setup complete.");
    }
}
