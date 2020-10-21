import java.io.File;

/**
 * SoundClip is a class representing a digital
 * sound clip file on disk.
 */
public class SoundClip {

    private final File file;

    private boolean isFlagged;

    private int score = 0;

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

    public boolean isFlagged(){
        return isFlagged;
    }

    public void unFlag(){
        isFlagged = false;
    }

    public void flag(){
        isFlagged = true;
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }



    public String toString() {
        String scoreString = "";
        if(score != 0){scoreString = String.format(" (Score : %d)",score);}

        if(isFlagged){
            return file.getName() + " : F" + scoreString;
        }
        return file.getName() + scoreString;

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
