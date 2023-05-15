package com.example.backgroundmusic;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import androidx.annotation.Nullable;

public class MediaService extends Service{
    private MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    { return null; }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {   //getting systems default ringtone
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        // player = MediaPlayer.create(this,R.raw.song3);
        player.setLooping(true);
        //staring the player
        player.start();
        //start sticky means service will be explicity started and stopped
        return START_STICKY;
    }

    @Override
    public void onDestroy()
    {   super.onDestroy();
        //stopping the player when service is destroyed
        player.stop();
    }


}
