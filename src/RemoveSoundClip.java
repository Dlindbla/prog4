import java.util.List;

public class RemoveSoundClip implements Command {


    private Album album;
    private List<SoundClip> soundClips;
    private MusicOrganizerWindow view;

    public RemoveSoundClip(MusicOrganizerWindow view,List<SoundClip> soundClips, Album album){
        this.soundClips = soundClips;
        this.album = album;
        this.view = view;
    }


    @Override
    public void execute() {
        for(SoundClip soundClip:soundClips) {
            album.removeSoundClip(soundClip);
        }
        view.onClipsUpdated();
    }

    @Override
    public void undo() {
        for(SoundClip soundClip: soundClips) {
            album.addSoundClip(soundClip);
        }
        view.onClipsUpdated();
    }

    @Override
    public void redo() {
        execute();
    }
}
