package net.jorgetapia.smartchimp.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.Collections;
import java.util.List;
import java.util.Random;


@Table(name = "Questions")
public class Question extends Model {

    @Column(name = "Text")
    public String text;

    public Question() {
        super();
    }

    public static List<Question> getAll() {
        return new Select().from(Question.class).execute();
    }

    public static List<Question> getQuestionsForGame() {
        List<Question> allQuestions = Question.getAll();

        Collections.shuffle(allQuestions, new Random(System.nanoTime()));
        Collections.shuffle(allQuestions, new Random(System.nanoTime()));
        Collections.shuffle(allQuestions, new Random(System.nanoTime()));
        Collections.shuffle(allQuestions, new Random(System.nanoTime()));
        Collections.shuffle(allQuestions, new Random(System.nanoTime()));
        Collections.shuffle(allQuestions, new Random(System.nanoTime()));
        Collections.shuffle(allQuestions, new Random(System.nanoTime()));
        Collections.shuffle(allQuestions, new Random(System.nanoTime()));
        Collections.shuffle(allQuestions, new Random(System.nanoTime()));
        Collections.shuffle(allQuestions, new Random(System.nanoTime()));

        return allQuestions.subList(0, 10);
    }

    public static void removeAll() {
        for (Question question : getAll()) {
            question.delete();
        }
    }
}
