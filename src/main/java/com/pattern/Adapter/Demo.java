package com.pattern.Adapter;

/**
 * @author jason
 */
public class Demo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far away from home.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
