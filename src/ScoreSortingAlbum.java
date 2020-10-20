public class ScoreSortingAlbum extends SortingAlbum {
    int scoreLimit;

    public ScoreSortingAlbum(String name, Album rootAlbum, int scoreLimit) {
        super(name, rootAlbum);
        this.scoreLimit = scoreLimit;
    }


    public boolean checkIfValid(SoundClip soundClip) {
        return (soundClip.getScore() >= scoreLimit);
    }
}
