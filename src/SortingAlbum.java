import java.util.ArrayList;
import java.util.List;

public abstract class SortingAlbum {

    private Album rootAlbum;
    private String albumName;

    private List<SoundClip> soundClips = new ArrayList<SoundClip>();

    // Create a new album
    public SortingAlbum(String name,Album rootAlbum) {
        this.rootAlbum = rootAlbum;
        this.albumName = name;
    }

    public void checkSoundClip(SoundClip soundClip){
        if(soundClips.contains(soundClip)){
            removeSoundClip(soundClip);
        }else{
            addSoundClip(soundClip);
        }
    }


    abstract boolean checkIfValid(SoundClip soundClip);

    public void addSoundClip(SoundClip soundClip){
        if(checkIfValid(soundClip)){
            soundClips.add(soundClip);
        }
    }
    public void removeSoundClip(SoundClip soundClip){
        if(!checkIfValid(soundClip)){
            soundClips.remove(soundClip);
        }
    }


    public List<SoundClip> getSoundClips() {
        return soundClips;
    }

    public String getAlbumName() {return albumName;}

    public Album getRootAlbum(){return rootAlbum;}

    @Override
    public String toString(){ return  albumName;}

}
