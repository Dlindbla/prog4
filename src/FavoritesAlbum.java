import java.util.ArrayList;
import java.util.List;

public class FavoritesAlbum extends SortingAlbum {

    private ArrayList<SoundClip> soundClips = new ArrayList<>();

    public FavoritesAlbum(String name, Album rootAlbum) {
        super(name, rootAlbum);
    }

    @Override
    public List<SoundClip> getSoundClips() {
        return soundClips;
    }

    @Override
    public boolean checkIfValid(SoundClip soundClip) {
        return soundClip.isFlagged();
    }
}
