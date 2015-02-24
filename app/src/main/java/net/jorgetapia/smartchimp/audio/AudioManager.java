package net.jorgetapia.smartchimp.audio;


import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.util.SparseArray;

import net.jorgetapia.smartchimp.R;

public class AudioManager {

    public static final int MUSIC_PREVIOUS = -1;
    public static final int MUSIC_MENU = 0;
    public static final int MUSIC_GAME = 1;
    private static final String LOG_TAG = "SmartChimp";
    private static SparseArray<MediaPlayer> players = new SparseArray<>();
    private static int currentMusic = -1;
    private static int previousMusic = -1;

    public static void playButtonSound(Context context) {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.button_sound);
        mediaPlayer.start();
    }

    public static void playRightSound(Context context) {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.right_sound);
        mediaPlayer.start();
    }

    public static void playWrongSound(Context context) {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.wrong_sound);
        mediaPlayer.start();
    }

    public static void startMusic(Context context, int music) {
        startMusic(context, music, false);
    }

    public static void startMusic(Context context, int music, boolean force) {
        if (!force && currentMusic > -1) {
            return;
        }

        if (music == MUSIC_PREVIOUS) {
            music = previousMusic;
        }

        if (currentMusic == music) {
            return;
        }

        if (currentMusic != -1) {
            previousMusic = currentMusic;
            pause();
        }

        currentMusic = music;
        MediaPlayer mediaPlayer = players.get(music);

        if (mediaPlayer != null) {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
            }
        } else {
            if (music == MUSIC_MENU) {
                mediaPlayer = MediaPlayer.create(context, R.raw.welcome_music);
            } else if (music == MUSIC_GAME) {
                mediaPlayer = MediaPlayer.create(context, R.raw.game_music);
            } else {
                Log.e(LOG_TAG, "Unsupported music value - " + music);
                return;
            }

            players.put(music, mediaPlayer);

            if (mediaPlayer != null) {
                try {
                    mediaPlayer.setLooping(true);
                    mediaPlayer.start();
                } catch (Exception e) {
                    Log.e(LOG_TAG, e.getMessage(), e);
                }
            }
        }
    }

    public static void pause() {
        for (int i = 0; i < players.size(); i++) {
            int key = players.keyAt(i);
            MediaPlayer player = players.get(key);
            player.pause();
        }

        if (currentMusic != -1) {
            previousMusic = currentMusic;
        }

        currentMusic = -1;
    }

    public static void release() {
        for (int i = 0; i < players.size(); i++) {
            int key = players.keyAt(i);
            MediaPlayer player = players.get(key);

            try {
                if (player != null) {
                    if (player.isPlaying()) {
                        player.stop();
                    }

                    player.release();
                }
            } catch (Exception e) {
                Log.e(LOG_TAG, e.getMessage(), e);
            }
        }

        players.clear();

        if (currentMusic != -1) {
            previousMusic = currentMusic;
        }

        currentMusic = -1;
    }
}
