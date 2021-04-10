package learn.galvanizes2.music.service;

import learn.galvanizes2.music.entity.PlaylistEntity;
import learn.galvanizes2.music.repository.PlaylistRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
        PlaylistEntity playlistEnitiy = PlaylistEntity.builder().build();
        when(repository.save(any())).thenReturn(playlistEnitiy);
        service.savePlaylist(playlistEnitiy);
        verify(repository).save(playlistEnitiy);
    }

    @Test
    void getAllPlaylists() {
        PlaylistEntity playlistEnitiy = PlaylistEntity.builder().playlistName("playList1").build();

        when(repository.findAll()).thenReturn(List.of(playlistEnitiy));

        List<PlaylistEntity> result = service.getAllPlaylists();

        assertThat(result).isEqualTo(List.of(playlistEnitiy));
        verify(repository).findAll();
    }

    @AfterEach
    void tearDown() {
        verifyNoMoreInteractions(repository);
    }
}
