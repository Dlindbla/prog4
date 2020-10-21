public class AddAlbum implements Command {

    private AbstractAlbum album;
    private AbstractAlbum parentAlbum;
    private MusicOrganizerWindow view;

    public AddAlbum(MusicOrganizerWindow view,String albumName,AbstractAlbum parentAlbum){
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
