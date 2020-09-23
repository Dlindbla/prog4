import java.util.ArrayList;
import java.util.List;

public class Album {
    private Album parentAlbum;
    private String albumName;

    private List<SoundClip> soundClips = new ArrayList<SoundClip>();
    private List<Album> subAlbums = new ArrayList<Album>();

    // Create a new album
    public Album(String name) {
        assert name != null;
        
        this.parentAlbum = null;
        this.albumName = name;
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

    // add multiple SoundClips to the album using an iterable
    public void addSoundClips(Iterable<SoundClip> newSoundClips) {
        assert newSoundClips != null;

        for (SoundClip soundClip : newSoundClips) {
            addSoundClip(soundClip);
        }
    }

    // add a single SubAlbum
    public void addSubAlbum(Album newAlbum) {
        assert newAlbum != null;
        assert !containsAlbum(newAlbum);

        newAlbum.parentAlbum = this;
        subAlbums.add(newAlbum);

        assert containsAlbum(newAlbum);
    }

    // add multiple albums as SubAlbums using an iterable
    public void addSubAlbums(Iterable<Album> newSubAlbums) {
        assert newSubAlbums != null;

        for (Album newAlbum : newSubAlbums) {
            addSubAlbum(newAlbum);
        }
    }

    // remove a specified subAlbum from the album
    public void removeSubAlbum(Album album) {
        assert album != null;
        assert containsAlbum(album);

        subAlbums.remove(album);

        assert !containsAlbum(album);
    }

    // remove multiple subAlbums from the album using an iterable
    public void removeSubAlbums(Iterable<Album> subAlbumsToRemove) {
        assert subAlbumsToRemove != null;

        for (Album album : subAlbumsToRemove) {
            removeSubAlbum(album);
        }
    }

    // remove soundclip from current and all subalbums
    public void removeSoundClip(SoundClip soundClip) {
        assert soundClip != null;

        soundClips.remove(soundClip);

        for (Album subAlbum : subAlbums) {
            subAlbum.removeSoundClip(soundClip);
        }

        assert !containsSoundClip(soundClip);
    }

    // remove multiple soundClips from the album using an iterable
    public void removeSoundClips(Iterable<SoundClip> soundClipsToRemove) {
        assert soundClipsToRemove != null;

        for (SoundClip soundClip : soundClipsToRemove) {
            removeSoundClip(soundClip);
        }
    }

    // Check if the album (or subalbum) contains a specific soundclip
    public boolean containsSoundClip(SoundClip soundClip) {
        assert soundClip != null;

        return soundClips.contains(soundClip);
    }

    // Recursively search subAlbums for specified album, return boolean
    public boolean containsAlbum(Album album) {
        assert album != null;

        if (subAlbums.contains(album)) {
            return true;
        }
        
        for (Album subAlbum : subAlbums) {
            if (subAlbum.containsAlbum(subAlbum)) {
                return true;
            }
        }
        return false;
    }

    // change the name of the album
    public void rename(String newName) {
        assert newName != null;

        this.albumName = newName;
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
    public Album getParentAlbum() {
        return parentAlbum;
    }

    // returns the album name
    public String getAlbumName() {
        return albumName;
    }

    @Override
    public String toString() {
        return albumName;
    }
}
