import org.junit.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;


class AlbumTest {

    @Test
    public void mainTest(){

        //Create two albums, one root, and one subAlbum

        Album rootAlbum = new Album("root_album");
        Album subAlbum = new Album("sub_album", rootAlbum);

        //check name
        assertEquals("root_album",rootAlbum.getAlbumName());

        //rename and check name
        rootAlbum.rename("root_album_renamed");
        assertEquals("root_album_renamed", rootAlbum.getAlbumName());

        //check that parentAlbum for root is null
        assertNull(rootAlbum.getParentAlbum());

        //check that the subalbums parent is the root, and that the root contains subalbum
        assertEquals(subAlbum.getParentAlbum(), rootAlbum);
        assertTrue(rootAlbum.containsAlbum(subAlbum));

        //add a fake soundfile
        SoundClip soundClipTest = new SoundClip(new File("test/"));

        //check that root contains the soundfile
        rootAlbum.addSoundClip(soundClipTest);
        assertTrue(rootAlbum.containsSoundClip(soundClipTest));

        //remove soundfile
        rootAlbum.removeSoundClip(soundClipTest);
        assertFalse(rootAlbum.containsSoundClip(soundClipTest));

        //add SoundFile to subAlbum and check if root contains it
        subAlbum.addSoundClip(soundClipTest);
        assertTrue(rootAlbum.containsSoundClip(soundClipTest));

        //remove subAlbum and check that root doesn't contain it
        rootAlbum.removeSubAlbum(subAlbum);
        assertFalse(rootAlbum.containsAlbum(subAlbum));





    }





}





