import java.util.List;
import java.util.Set;
import java.util.Stack;

public class MusicOrganizerController {

	private MusicOrganizerWindow view;
	private SoundClipBlockingQueue queue;
	private Album root;
	public FavoritesAlbum favorites;


	//stacks for running undo and redo commands
	private Stack<Command> undoStack = new Stack<>();
	private Stack<Command> redoStack = new Stack<>();

	public MusicOrganizerController() {
		root = new Album("All Sound Clips");

		favorites = new FavoritesAlbum("Favorites", root);


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
	public void addNewAlbum(){
		//get the currently selected album
		Album selectedAlbum = view.getSelectedAlbum();

		//create a new album
		String albumName = view.promptForAlbumName();

		if (selectedAlbum != null && albumName != null) {
			AddAlbum addAlbum = new AddAlbum(view,albumName,selectedAlbum);
			addAlbum.execute();
			undoStack.push(addAlbum);
		}
	}
	
	/**
	 * Removes an album from the Music Organizer
	 */
	public void deleteAlbum(){
		Album albumToRemove = view.getSelectedAlbum();

		if (albumToRemove != root) {
			view.onAlbumRemoved(albumToRemove);

			RemoveAlbum removeAlbum = new RemoveAlbum(view, albumToRemove);
			removeAlbum.execute();
			undoStack.push(removeAlbum);

		}
	}
	
	/**
	 * Adds sound clips to an album
	 */
	public void addSoundClips(){
		Album selectedAlbum = view.getSelectedAlbum();
		List<SoundClip> selectedSoundClips = view.getSelectedSoundClips();

		AddSoundClip addSoundClip = new AddSoundClip(view,selectedSoundClips,selectedAlbum);
		addSoundClip.execute();
		view.onClipsUpdated();

		undoStack.push(addSoundClip);

	}
	
	/**
	 * Removes sound clips from an album
	 */
	public void removeSoundClips(){

		Album selectedAlbum = view.getSelectedAlbum();
		List<SoundClip> soundClipsToDelete = view.getSelectedSoundClips();

		RemoveSoundClip removeSoundClip = new RemoveSoundClip(view,soundClipsToDelete,selectedAlbum);
		removeSoundClip.execute();

		undoStack.push(removeSoundClip);

	}

	public void undo(){
		if(!undoStack.isEmpty()) {
			Command command = undoStack.pop();
			command.undo();
			redoStack.push(command);
			System.out.println("Action Undone!");
		}
	}

	public void redo(){
		if(!redoStack.isEmpty()) {
			Command command = redoStack.pop();
			command.redo();
			undoStack.push(command);
		}
	}

	public void addToFavorites(){
		for(SoundClip soundClip: view.getSelectedSoundClips()){
			soundClip.setFavorite();
		}
	}

	public void rateSoundClip(){

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
