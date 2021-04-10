package learn.galvanizes2.music.service;

import learn.galvanizes2.music.entity.PlaylistEnitiy;
import learn.galvanizes2.music.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;

    public void savePlaylist(PlaylistEnitiy playlistEnitiy) {
        playlistRepository.save(playlistEnitiy);
    }
}
