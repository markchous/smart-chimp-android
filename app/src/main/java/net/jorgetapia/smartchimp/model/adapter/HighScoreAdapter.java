package net.jorgetapia.smartchimp.model.adapter;


import android.content.Context;
import android.database.Cursor;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import net.jorgetapia.smartchimp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class HighScoreAdapter extends CursorAdapter {

    public HighScoreAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_highscore, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        Typeface americanTypewriter = Typeface.createFromAsset(context.getAssets(),
                "fonts/AmericanTypewriter.ttc");
        Typeface bold = Typeface.create(americanTypewriter, Typeface.BOLD);

        TextView scoreTextView = (TextView) view.findViewById(R.id.scoreItemTextView);
        TextView dateTextView = (TextView) view.findViewById(R.id.scoreItemDateTextView);

        int score = cursor.getInt(cursor.getColumnIndexOrThrow("Score"));

        long dateInMillis = cursor.getLong(cursor.getColumnIndexOrThrow("DateAchieved"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, dd/MM/y");
        simpleDateFormat.setLenient(true);
        Date dateAchieved = new Date(dateInMillis);

        scoreTextView.setTypeface(bold);
        scoreTextView.setText(" x" + score);

        dateTextView.setTypeface(americanTypewriter);
        dateTextView.setText(simpleDateFormat.format(dateAchieved));
    }
}
