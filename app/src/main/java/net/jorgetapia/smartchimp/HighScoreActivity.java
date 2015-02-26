package net.jorgetapia.smartchimp;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import net.jorgetapia.smartchimp.model.HighScore;
import net.jorgetapia.smartchimp.model.adapter.HighScoreAdapter;


public class HighScoreActivity extends ActionBarActivity {

    private ListView highScoresListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        this.setupUI();
        this.reloadData();
    }


    private void setupUI() {
        Typeface americanTypewriter = Typeface.createFromAsset(getAssets(),
                "fonts/AmericanTypewriter.ttc");
        Typeface bold = Typeface.create(americanTypewriter, Typeface.BOLD);

        TextView titleTextView = (TextView) findViewById(R.id.highScoresTitleTextView);
        titleTextView.setTypeface(bold);

        this.highScoresListView = (ListView) findViewById(R.id.highScoresListView);

        Button resetScoresButton = (Button) findViewById(R.id.resetScoresButton);
        resetScoresButton.setTypeface(bold);
        resetScoresButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                HighScore.removeAll();
                HighScoreActivity.this.reloadData();
            }
        });
    }

    private void reloadData() {
        HighScoreAdapter adapter = new HighScoreAdapter(this, HighScore.getCursorForAllRows());
        this.highScoresListView.setAdapter(adapter);
    }
}
