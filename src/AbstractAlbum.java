import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAlbum {
    private AbstractAlbum parentAlbum;
    private String albumName;

    private List<SoundClip> soundClips = new ArrayList<SoundClip>();
    private List<Album> subAlbums = new ArrayList<Album>();

    // Create a new album
    public AbstractAlbum(String name) {
        assert name != null;
        this.parentAlbum = null;
        this.albumName = name;
    }


    public abstract void addSoundClip(SoundClip soundClip);

    public abstract void removeSoundClip(SoundClip soundClip);

    // Check if the album (or subalbum) contains a specific soundclip
    public boolean containsSoundClip(SoundClip soundClip) {
        assert soundClip != null;
        return soundClips.contains(soundClip);
    }



    // returns all SoundClips
    public List<SoundClip> getSoundClips() {
        return soundClips;
    }

    // returns the subAlbums arraylist
    public List<Album> getSubAlbums() {
        return subAlbums;
    }

    // returns the parentAlbum
    public AbstractAlbum getParentAlbum() {
        return parentAlbum;
    }

    // returns the album name
    public String getAlbumName() {
        return albumName;
    }

    public void setParent(AbstractAlbum album){
        parentAlbum = album;
    }


    @Override
    public String toString() {
        return albumName;
    }
}
