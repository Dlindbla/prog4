public class RemoveAlbum implements Command {

    private AbstractAlbum albumToRemove;
    private AbstractAlbum parentAlbum;
    private MusicOrganizerWindow view;



    public RemoveAlbum(MusicOrganizerWindow view,AbstractAlbum albumToRemove){
        assert(albumToRemove != null);
        this.albumToRemove = albumToRemove;
        this.parentAlbum = albumToRemove.getParentAlbum();
        this.view = view;
    }

    @Override
    public void execute() {
        view.onAlbumRemoved(albumToRemove);
        parentAlbum.removeSubAlbum(albumToRemove);
    }

    @Override
    public void undo() {
        view.onAlbumAdded(albumToRemove);
        parentAlbum.addSubAlbum(albumToRemove);
    }

    @Override
    public void redo() {
        execute();
    }
}
