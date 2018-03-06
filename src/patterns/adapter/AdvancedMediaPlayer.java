package patterns.adapter;

/**
 * @author Dmitry Titorenko on 06.03.2018
 */
public interface AdvancedMediaPlayer {
    void playVlc(String fileName);

    void playMp4(String fileName);
}
