import java.util.ArrayList;

public class ScoreSortingAlbum extends SortingAlbum {

    int scoreLimit;
    private ArrayList<SoundClip> soundClips = new ArrayList<>();

    public ScoreSortingAlbum(String name, Album rootAlbum) {
        super(name, rootAlbum);
    }

    @Override
    public Iterable<SoundClip> getSoundClips() {
        return soundClips;
    }

    @Override
    void checkIfValid(SoundClip soundClip) {
        if(soundClip.getScore() >= scoreLimit){
            soundClips.add(soundClip);
        }else if(soundClip.getScore() < scoreLimit){
            soundClips.remove(soundClip);
        }
    }
}
