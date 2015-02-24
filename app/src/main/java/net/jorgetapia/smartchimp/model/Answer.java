package net.jorgetapia.smartchimp.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;


@Table(name = "Answers")
public class Answer extends Model {

    @Column(name = "Text")
    public String text;

    @Column(name = "Correct")
    public Boolean correct;

    @Column(name = "Question", index = true, onUpdate = Column.ForeignKeyAction.CASCADE,
            onDelete = Column.ForeignKeyAction.CASCADE)
    public Question question;

    public Answer() {
        super();
    }

    public static List<Answer> getAll(Question question) {
        return new Select().from(Answer.class).where("Question = ?", question.getId()).execute();
    }
}
