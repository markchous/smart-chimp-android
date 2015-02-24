package net.jorgetapia.smartchimp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class CreditsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        this.setupUI();
    }

    private void setupUI() {
        Typeface americanTypewriter = Typeface.createFromAsset(getAssets(),
                "fonts/AmericanTypewriter.ttc");
        Typeface bold = Typeface.create(americanTypewriter, Typeface.BOLD);

        TextView titleTextView = (TextView) findViewById(R.id.creditsTitleTextView);
        titleTextView.setTypeface(bold);

        TextView instructionsTextView = (TextView) findViewById(R.id.creditsTextView);
        instructionsTextView.setTypeface(americanTypewriter);
    }
}
