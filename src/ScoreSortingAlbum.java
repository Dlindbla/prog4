import java.util.ArrayList;
import java.util.List;

public class ScoreSortingAlbum extends SortingAlbum {

    int scoreLimit;
    private ArrayList<SoundClip> soundClips = new ArrayList<>();

    public ScoreSortingAlbum(String name, Album rootAlbum) {
        super(name, rootAlbum);
    }

    @Override
    public List<SoundClip> getSoundClips() {
        return soundClips;
    }

    @Override
    public boolean checkIfValid(SoundClip soundClip) {
        return (soundClip.getScore() >= scoreLimit);

    }
}
