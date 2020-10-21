public abstract class SortingAlbum extends AbstractAlbum {
    public SortingAlbum(String name, Album rootAlbum) {
        super(name);
        this.parentAlbum = rootAlbum;
    }

    // Keep list of sound clips up-to-date
    public void checkSoundClip(SoundClip soundClip) {
        if (!checkIfValid(soundClip)) {
            soundClips.remove(soundClip);
        } else if (!soundClips.contains(soundClip)) {
            soundClips.add(soundClip);
        }
    }

    abstract boolean checkIfValid(SoundClip soundClip);
}
