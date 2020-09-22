import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MusicOrganizerController {

	private MusicOrganizerWindow view;
	private SoundClipBlockingQueue queue;
	private Album root;
	
	public MusicOrganizerController() {
		
		// TODO: Create the root album for all sound clips
		root = new Album("All Sound Clips");
		
		// Create the View in Model-View-Controller
		view = new MusicOrganizerWindow(this);
		
		// Create the blocking queue
		queue = new SoundClipBlockingQueue();
		
		// Create a separate thread for the sound clip player and start it
		(new Thread(new SoundClipPlayer(queue))).start();
	}

	/**
	 * Load the sound clips found in all subfolders of a path on disk. If path is not
	 * an actual folder on disk, has no effect.
	 */
	public Set<SoundClip> loadSoundClips(String path) {
		Set<SoundClip> clips = SoundClipLoader.loadSoundClips(path);

		root.addSoundClips(clips);

		return clips;
	}
	
	/**
	 * Returns the root album
	 */
	public Album getRootAlbum(){
		return root;
	}
	
	/**
	 * Adds an album to the Music Organizer
	 */
	public void addNewAlbum(){ //TODO Update parameters if needed - e.g. you might want to give the currently selected album as parameter
		// TODO: Add your code here
		//get the currently selected album
		Album selectedAlbum = view.getSelectedAlbum();
		//create a new album

		String albumName = view.promptForAlbumName();

		Album newAlbum = new Album(albumName, selectedAlbum);
		//add the new album to the selected one
		selectedAlbum.addSubAlbum(newAlbum);
		//add the album to the treeview
		view.onAlbumAdded(newAlbum);

	}
	
	/**
	 * Removes an album from the Music Organizer
	 */
	public void deleteAlbum(){ //TODO Update parameters if needed
		Album albumToRemove = view.getSelectedAlbum();
		//remove from view
		view.onAlbumRemoved(albumToRemove);



	}
	
	/**
	 * Adds sound clips to an album
	 */
	public void addSoundClips(){ //TODO Update parameters if needed
		// TODO: Add your code here
	}
	
	/**
	 * Removes sound clips from an album
	 */
	public void removeSoundClips(){

		Album selectedAlbum = view.getSelectedAlbum();
		List<SoundClip> soundClipsToDelete = view.getSelectedSoundClips();
		selectedAlbum.removeSoundClips(soundClipsToDelete);
		view.onClipsUpdated();

	}
	
	/**
	 * Puts the selected sound clips on the queue and lets
	 * the sound clip player thread play them. Essentially, when
	 * this method is called, the selected sound clips in the 
	 * SoundClipTable are played.
	 */
	public void playSoundClips(){
		List<SoundClip> l = view.getSelectedSoundClips();
		for(int i=0;i<l.size();i++)
			queue.enqueue(l.get(i));
	}
}
