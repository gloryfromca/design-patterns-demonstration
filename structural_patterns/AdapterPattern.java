package structural_patterns;

interface MediaPlayer {
	public void play(String audioType, String filename);
}

interface AdvancedMediaPlayer {
	public void playVlc(String filename);

	public void playMp4(String filename);
}

class VlcPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVlc(String filename) {
		System.out.println("play vlc file: " + filename);
	}

	@Override
	public void playMp4(String filename) {

	}

}

class Mp4Player implements AdvancedMediaPlayer {

	@Override
	public void playVlc(String filename) {

	}

	@Override
	public void playMp4(String filename) {
		System.out.println("play mp4 file: " + filename);
	}

}

class AdvancedAdapter implements MediaPlayer {

	private VlcPlayer vlcPlayer = null;
	private Mp4Player mp4Player = null;

	@Override
	public void play(String audioType, String filename) {
		if (audioType == "vlc") {
			if (vlcPlayer == null) {
				synchronized (this) {
					if (vlcPlayer == null) {
						vlcPlayer = new VlcPlayer();
					}
				}
			}
			vlcPlayer.playVlc(filename);
		}

		if (audioType == "mp4") {
			if (mp4Player == null) {
				synchronized (this) {
					if (mp4Player == null) {
						mp4Player = new Mp4Player();
					}
				}
			}
			mp4Player.playMp4(filename);
		}

	}

}

class AudioPlayer implements MediaPlayer {

	private AdvancedAdapter aa = new AdvancedAdapter();

	@Override
	public void play(String audioType, String filename) {
		if (audioType == "mp3") {
			System.out.println("play mp3 file: " + filename);
		} else {
			aa.play(audioType, filename);
		}
	}

}

public class AdapterPattern {

	public static void main(String[] args) {
		AudioPlayer ap = new AudioPlayer();
		ap.play("mp3", "aa.mp3");
		ap.play("mp4", "bb.mp4");
		ap.play("vlc", "cc.vlc");

	}

}
