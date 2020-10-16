import java.util.ArrayList;
import java.util.List;

public abstract class SortingAlbum {

    private Album rootAlbum;
    private String albumName;

    private List<SoundClip> soundClips = new ArrayList<SoundClip>();
    private List<Album> subAlbums = new ArrayList<Album>();

    // Create a new album
    public SortingAlbum(String name,Album rootAlbum) {
        this.rootAlbum = rootAlbum;
        this.albumName = name;
    }

    abstract Iterable<SoundClip> getSoundClips();

    abstract void checkIfValid(SoundClip soundClip);

    public String getAlbumName() {return albumName;}

    public Album getRootAlbum(){return rootAlbum;}

    @Override
    public String toString(){ return  albumName;}

}
