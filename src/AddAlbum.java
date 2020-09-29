public class AddAlbum implements Command {

    private Album album;
    private Album parentAlbum;
    private MusicOrganizerWindow view;

    public AddAlbum(MusicOrganizerWindow view,String albumName,Album parentAlbum){
        this.parentAlbum = parentAlbum;
        album = new Album(albumName);
        parentAlbum.addSubAlbum(album);
        this.view = view;
    }

    @Override
    public void execute() {
        view.onAlbumAdded(album);
        parentAlbum.addSubAlbum(album);

    }

    @Override
    public void undo() {
        view.onAlbumRemoved(album);
        parentAlbum.removeSubAlbum(album);
    }

    @Override
    public void redo() {
        execute();
    }
}