package learn.galvanizes2.music.controller;

import learn.galvanizes2.music.controller.model.PlaylistDTO;
import learn.galvanizes2.music.entity.PlaylistEntity;
import learn.galvanizes2.music.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PlaylistDTO playlistDTO) {
        playlistService.savePlaylist(PlaylistEntity.builder()
                .playlistName(playlistDTO.getPlaylistName())
                .build());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PlaylistDTO> getAllPlaylists() {
        return playlistService.getAllPlaylists().stream().map(entity ->
                PlaylistDTO.builder().playlistName(entity.getPlaylistName()).build())
                .collect(Collectors.toList());
    }
}
