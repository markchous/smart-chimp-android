package net.jorgetapia.smartchimp;

import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class GameOverActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        this.setupUI();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void setupUI() {
        Typeface americanTypewriter = Typeface.createFromAsset(getAssets(),
                "fonts/AmericanTypewriter.ttc");
        Typeface bold = Typeface.create(americanTypewriter, Typeface.BOLD);

        RelativeLayout container = (RelativeLayout) findViewById(R.id.gameOverContainerLayout);

        TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
        resultTextView.setTypeface(bold);

        ImageView bananaPeel = (ImageView) findViewById(R.id.bananaPeelImageView);

        if (getIntent().getBooleanExtra("won", false)) {
            container.setBackgroundResource(R.drawable.win_background);
            resultTextView.setText(getString(R.string.win_text));
            bananaPeel.setVisibility(View.GONE);
        } else {
            container.setBackgroundResource(R.drawable.lose_background);
            resultTextView.setText(getString(R.string.lose_text));
            bananaPeel.setVisibility(View.VISIBLE);
        }
    }
}
