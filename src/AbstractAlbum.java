import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAlbum {
    protected AbstractAlbum parentAlbum;
    protected String albumName;

    protected List<SoundClip> soundClips = new ArrayList<SoundClip>();
    protected List<AbstractAlbum> subAlbums = new ArrayList<AbstractAlbum>();

    // Create a new album
    public AbstractAlbum(String name) {
        assert name != null;
        this.albumName = name;
    }

    
    // add a single SubAlbum
    public void addSubAlbum(AbstractAlbum newAlbum) {
        assert newAlbum != null;
        assert !containsAlbum(newAlbum);

        newAlbum.parentAlbum = this;
        subAlbums.add(newAlbum);

        assert containsAlbum(newAlbum);
    }

    // remove a specified subAlbum from the album
    public void removeSubAlbum(AbstractAlbum album) {
        assert album != null;
        assert containsAlbum(album);
        subAlbums.remove(album);
        assert !containsAlbum(album);
    }

    // Recursively search subAlbums for specified album, return boolean
    public boolean containsAlbum(AbstractAlbum album) {
        assert album != null;
        if (subAlbums.contains(album)) {
            return true;
        }
        for (AbstractAlbum subAlbum : subAlbums) {
            if (subAlbum.containsAlbum(subAlbum)) {
                return true;
            }
        }
        return false;
    }

    // add a single soundclip to the album
    public void addSoundClip(SoundClip soundClip) {
        assert soundClip != null;

        if (!containsSoundClip(soundClip)) {
            // add to current album
            soundClips.add(soundClip);

            // add to all parent albums
            if (parentAlbum != null) {
                parentAlbum.addSoundClip(soundClip);
            }
        }

        assert containsSoundClip(soundClip);
    }

    // remove soundclip from current and all subalbums
    public void removeSoundClip(SoundClip soundClip) {
        assert soundClip != null;

        soundClips.remove(soundClip);
        for (AbstractAlbum subAlbum : subAlbums) {
            subAlbum.removeSoundClip(soundClip);
        }
        assert !containsSoundClip(soundClip);
    }

    // add multiple SoundClips to the album using an iterable
    public void addSoundClips(Iterable<SoundClip> newSoundClips) {
        assert newSoundClips != null;

        for (SoundClip soundClip : newSoundClips) {
            addSoundClip(soundClip);
        }
    }

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
    public List<AbstractAlbum> getSubAlbums() {
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
