import java.util.List;

public class AddSoundClip implements Command{

    private AbstractAlbum album;
    private List<SoundClip> soundClips;
    private MusicOrganizerWindow view;

    public AddSoundClip(MusicOrganizerWindow view,List<SoundClip> soundClips, AbstractAlbum album){
        this.soundClips = soundClips;
        this.album = album;
        this.view = view;
    }


    @Override
    public void execute() {
        for(SoundClip soundClip: soundClips) {
            album.addSoundClip(soundClip);
        }
        view.onClipsUpdated();

    }

    @Override
    public void undo() {
        for(SoundClip soundClip: soundClips) {
            album.removeSoundClip(soundClip);
        }
        view.onClipsUpdated();
    }

    @Override
    public void redo() {
        execute();
    }
}
