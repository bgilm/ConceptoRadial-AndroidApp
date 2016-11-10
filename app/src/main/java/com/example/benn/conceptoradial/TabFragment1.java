package com.example.benn.conceptoradial;

import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

import java.io.IOException;

/**
 * Created by Benn on 9/12/16.
 */
public class TabFragment1 extends android.support.v4.app.Fragment  {

    private ImageButton btn;

    private MediaPlayer mediaPlayer;
    private SeekBar volumeSeekbar = null;
    private AudioManager audioManager = null;

    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tab_fragment_1,container,false);
        btn =(ImageButton) v.findViewById(R.id.button1);
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try{
            mediaPlayer.setDataSource("http://67.213.217.206:1935/8022/8022/playlist.m3u8");
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {

                }
            });
        }catch (IOException e){
            e.printStackTrace();
        }
        btn.setOnClickListener(pausePlay);
        initControls();
        return v;
    }
    private void initControls()
    {
        try
        {

            volumeSeekbar = (SeekBar)v.findViewById(R.id.seekBar);
            audioManager = (AudioManager) v.getContext().getSystemService(Context.AUDIO_SERVICE);
            volumeSeekbar.setMax(audioManager
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            volumeSeekbar.setProgress(audioManager
                    .getStreamVolume(AudioManager.STREAM_MUSIC));


            volumeSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
            {
                @Override
                public void onStopTrackingTouch(SeekBar arg0)
                {
                }

                @Override
                public void onStartTrackingTouch(SeekBar arg0)
                {
                }

                @Override
                public void onProgressChanged(SeekBar arg0, int progress, boolean arg2)
                {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                            progress, 0);
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private View.OnClickListener pausePlay = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();
                btn.setImageResource(R.drawable.ic_play);

            }else{
                mediaPlayer.start();
                btn.setImageResource(R.drawable.ic_pause);
            }
        }
    };

}
