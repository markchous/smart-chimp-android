package net.jorgetapia.smartchimp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class HowToPlayActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);

        this.setupUI();
    }

    private void setupUI() {
        Typeface americanTypewriter = Typeface.createFromAsset(getAssets(),
                "fonts/AmericanTypewriter.ttc");
        Typeface bold = Typeface.create(americanTypewriter, Typeface.BOLD);

        TextView titleTextView = (TextView) findViewById(R.id.howToPlayTitleTextView);
        titleTextView.setTypeface(bold);

        TextView instructionsTextView = (TextView) findViewById(R.id.instructionsTextView);
        instructionsTextView.setTypeface(americanTypewriter);
    }
}
