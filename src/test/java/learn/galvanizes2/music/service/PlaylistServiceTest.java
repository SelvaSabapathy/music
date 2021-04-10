package learn.galvanizes2.music.service;

import learn.galvanizes2.music.controller.model.PlaylistDTO;
import learn.galvanizes2.music.entity.PlaylistEnitiy;
import learn.galvanizes2.music.repository.PlaylistRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PlaylistServiceTest {

    @InjectMocks
    PlaylistService service;

    @Mock
    PlaylistRepository repository;

    @Test
    void createNewPlaylist() {
        PlaylistEnitiy playlistEnitiy = PlaylistEnitiy.builder().build();
        when(repository.save(any())).thenReturn(playlistEnitiy);
        service.savePlaylist(playlistEnitiy);
        verify(repository).save(playlistEnitiy);
    }

    @AfterEach
    void tearDown() {
        verifyNoMoreInteractions(repository);
    }
}
