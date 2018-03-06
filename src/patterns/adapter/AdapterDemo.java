package patterns.adapter;

/**
 * @author Dmitry Titorenko on 06.03.2018
 *
 * Adapter pattern works as a bridge between two incompatible interfaces.
 * This type of design pattern comes under structural pattern as this
 * pattern combines the capability of two independent interfaces.
 *
 * We are demonstrating use of Adapter pattern via following example in
 * which an audio player device can play mp3 files only and wants to
 * use an advanced audio player capable of playing vlc and mp4 files.
 *
 * see https://www.tutorialspoint.com/design_pattern/adapter_pattern.htm
 */
public class AdapterDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
