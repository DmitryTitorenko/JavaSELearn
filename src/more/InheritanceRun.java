package more;

/**
 * @author Dmitry Titorenko on 19.03.2018
 */
public class InheritanceRun {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer(1);
        System.out.println(audioPlayer.getVersion());
        Player player = audioPlayer;
        player.play();
    }
}

abstract class Player {
    abstract void play();
}

class AudioPlayer extends Player {
    private int version;

    AudioPlayer(int version) {
        this.version = version;
    }

    @Override
    void play() {
        System.out.println("Playing mp3 files");
    }

    public int getVersion() {
        return version;
    }
}

