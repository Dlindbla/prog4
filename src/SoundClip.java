import java.io.File;

/**
 * SoundClip is a class representing a digital
 * sound clip file on disk.
 */
public class SoundClip {

    private final File file;

    private boolean isFavorited;

    private int score;

    /**
     * Make a SoundClip from a file.
     * Requires file != null.
     */
    public SoundClip(File file) {
        assert file != null;
        this.file = file;
    }

    /**
     * @return the file containing this sound clip.
     */
    public File getFile() {
        return file;
    }

    public boolean isFavorited(){
        return isFavorited;
    }

    public void unFavorite(){
        isFavorited = false;
    }

    public void setFavorite(){
        isFavorited = true;
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public String toString(){
        return file.getName();
    }

    @Override
    public boolean equals(Object obj) {
        return
                obj instanceof SoundClip
                        && ((SoundClip)obj).file.equals(file);
    }

    @Override
    public int hashCode() {
        return file.hashCode();
    }
}