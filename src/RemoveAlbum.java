public class RemoveAlbum implements Command {

    Album albumToRemove;
    Album parentAlbum;
    MusicOrganizerWindow view;



    public RemoveAlbum(MusicOrganizerWindow view,Album albumToRemove){
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
