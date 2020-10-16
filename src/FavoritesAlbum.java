import java.util.ArrayList;

public class FavoritesAlbum extends SortingAlbum {

    private ArrayList<SoundClip> soundClips = new ArrayList<>();

    public FavoritesAlbum(String name, Album rootAlbum) {
        super(name, rootAlbum);
    }

    @Override
    public Iterable<SoundClip> getSoundClips() {
        return soundClips;
    }

    @Override
    void checkIfValid(SoundClip soundClip) {
        if(soundClip.isFlagged()){
            soundClips.add(soundClip);
        }else if(!soundClip.isFlagged()){
            soundClips.remove(soundClip);
        }
    }
}
