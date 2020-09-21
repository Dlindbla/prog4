import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Album {

    private Album parentAlbum;
    private String albumName;

    private ArrayList<SoundClip> soundClips = new ArrayList<>();
    private ArrayList<Album> subAlbums = new ArrayList<>();

    //Create a subAlbum using a name, and a parentalbum
    public Album(String name, Album parentAlbum){

        assert(name != null);
        assert(parentAlbum != null);

        this.parentAlbum = parentAlbum;
        this.albumName = name;

        parentAlbum.addSubAlbum(this);
    }

    //Create a root album using only a name
    public Album(String name){
        assert(name != null);
        this.parentAlbum = null;
        this.albumName = name;
    }

    //add multiple SoundClips to the album using an iterable
    public void addSoundClips(Iterable<SoundClip> newSoundClips){
        for(SoundClip soundClip: newSoundClips){
            assert(soundClip != null);
            addSoundClip(soundClip);
        }
    }

    //add a single soundclip to the album
    public void addSoundClip(SoundClip soundClip){
        assert(soundClip != null);
        soundClips.add(soundClip);
    }

    //add multiple albums as SubAlbums using an iterable
    public void addSubAlbums(Iterable<Album> newSubAlbums){
        for(Album newAlbum: newSubAlbums){
            assert(newAlbum != null);
            addSubAlbum(newAlbum);
        }
    }

    //add a single SubAlbum
    public void addSubAlbum(Album newAlbum){
        assert(newAlbum != null);
        subAlbums.add(newAlbum);
    }

    //remove a specified subAlbum from the album
    public void removeSubAlbum(Album album){
        assert(album != null);
        subAlbums.remove(album);
    }

    //remove multiple subAlbums from the album using an iterable
    public void removeSubAlbums(Iterable<Album> subAlbumsToRemove){
        for(Album album: subAlbumsToRemove){
            assert(album != null);
            subAlbums.remove(album);
        }
    }

    //recursively find all subAlbums with the file specified for deletion
    //then remove all instances of the soundClip
    public void removeSoundClip(SoundClip soundClip){
        assert(soundClip != null);
        for(Album subAlbum: subAlbums){
            if(subAlbum.containsSoundClip(soundClip)){
                removeSoundClip(soundClip);
            }
        }
        if(soundClips.contains(soundClip)) {
            soundClips.remove(soundClip);
        }
    }

    //remove multiple soundClips from the album using an iterable
    public void removeSoundClips(Iterable<SoundClip> soundClipsToRemove){
        for(SoundClip soundClip: soundClipsToRemove){
            assert(soundClip != null);
            if(soundClips.contains(soundClip)) {
                soundClips.remove(soundClip);
            }
        }
    }

    //Recurse and search for soundclips returns a boolean
    public boolean containsSoundClip(SoundClip soundClip){
        if(soundClips.contains(soundClip)){return true;}
        for(Album subAlbum: subAlbums){
            if(subAlbum.containsSoundClip(soundClip)){return true;}
        }
        return false;
    }

    //Recursively search subAlbums for specified album, return boolean
    public boolean containsAlbum(Album album){
        if(subAlbums.contains(album)){return true;}
        for(Album subAlbum: subAlbums){
            if(subAlbum.containsAlbum(subAlbum)){return true;}
        }
        return false;
    }


    //change the name of the album
    public void rename(String newName){
        assert(newName != null);
        this.albumName = newName;
    }

    //returns all SoundClips
    public ArrayList<SoundClip> getSoundClips(){
        ArrayList<SoundClip> subSoundClips = new ArrayList<>();
        for(Album subAlbum: subAlbums){
            soundClips.addAll(subAlbum.getSoundClips());
        }
        //remove all duplicates
        Set<SoundClip> soundClipSet = new HashSet<>(subSoundClips);
        subSoundClips.clear();
        subSoundClips.addAll(soundClipSet);
        return soundClips;
    }



    //returns the subAlbums arraylist
    public ArrayList<Album> getSubAlbums(){
        return subAlbums;
    }

    //returns the parentAlbum
    public Album getParentAlbum(){return parentAlbum;}

    //returns the album name
    public String getAlbumName() {
        return albumName;
    }


    @Override
    public String toString(){
        return albumName;
    }

}
