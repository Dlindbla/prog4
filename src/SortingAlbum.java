import java.util.ArrayList;
import java.util.List;

public abstract class SortingAlbum extends AbstractAlbum {

    private Album rootAlbum;
    private String albumName;

    private List<SoundClip> soundClips = new ArrayList<SoundClip>();

    // Create a new album
    public SortingAlbum(String name,Album rootAlbum) {
        super(name);
        this.rootAlbum = rootAlbum;
        this.albumName = name;
    }

    //Check if a given soundClip should be added or if it already exists, should be removed
    public void checkSoundClip(SoundClip soundClip){
        if(soundClips.contains(soundClip) && checkIfValid(soundClip)){
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
        soundClips.remove(soundClip);
    }


    public List<SoundClip> getSoundClips() {
        return soundClips;
    }

    public String getAlbumName() {return albumName;}

    public Album getRootAlbum(){return rootAlbum;}

}
