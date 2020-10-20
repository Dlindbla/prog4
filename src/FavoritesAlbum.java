public class FavoritesAlbum extends SortingAlbum {

    public FavoritesAlbum(String name, Album rootAlbum) {
        super(name, rootAlbum);
    }

    public boolean checkIfValid(SoundClip soundClip) {
        return soundClip.isFlagged();
    }
}
