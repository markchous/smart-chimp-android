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

        AudioManager.release();
        AudioManager.startMusic(this, AudioManager.MUSIC_MENU);

        this.setupData();
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
        answer14_1.text = "All the way into the woods.";
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

        Log.d(LOG_TAG, "Data setup complete.");
    }
}
