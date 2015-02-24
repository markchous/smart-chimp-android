package net.jorgetapia.smartchimp.model;

import android.database.Cursor;

import com.activeandroid.Cache;
import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.Date;
import java.util.List;

@Table(name = "HighScores")
public class HighScore extends Model {

    @Column(name = "Score")
    public Integer score;

    @Column(name = "DateAchieved", index = true)
    public Date dateAchieved;

    public HighScore() {
        super();
    }

    public static List<HighScore> getAll() {
        return new Select().from(HighScore.class).orderBy("Score ASC").execute();
    }

    public static Cursor allRowsCursor() {
        String tableName = Cache.getTableInfo(HighScore.class).getTableName();
        String resultRecords = new Select(tableName + ".*, " + tableName + ".Id as _id").
                from(HighScore.class).orderBy("Score DESC").toSql();

        Cursor resultCursor = Cache.openDatabase().rawQuery(resultRecords, null);
        return resultCursor;
    }

    public static void removeAll() {
        for (HighScore highScore : getAll()) {
            highScore.delete();
        }
    }
}
