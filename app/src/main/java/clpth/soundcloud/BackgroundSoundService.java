package clpth.soundcloud;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class BackgroundSoundService extends Service {

    private static final String TAG = null;
    private String song;
    MediaPlayer player;

    public BackgroundSoundService() {
    }

    public BackgroundSoundService(String song) {
        this.song = song;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public IBinder onUnBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.armand_van_helden);
        player.setLooping(true);
        player.setVolume(100, 100);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return START_STICKY;
    }

    @Override
    public void onStart(Intent intent, int startId) {

    }

    public void onStop() {

    }

    protected void onPause() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
