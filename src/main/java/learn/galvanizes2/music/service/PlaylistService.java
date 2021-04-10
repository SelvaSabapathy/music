package learn.galvanizes2.music.service;

import learn.galvanizes2.music.entity.PlaylistEntity;
import learn.galvanizes2.music.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;

    public void savePlaylist(PlaylistEntity playlistEnitiy) {
        playlistRepository.save(playlistEnitiy);
    }

    public List<PlaylistEntity> getAllPlaylists() {
        return playlistRepository.findAll();
    }
}
