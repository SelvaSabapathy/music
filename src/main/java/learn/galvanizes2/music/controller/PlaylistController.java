package learn.galvanizes2.music.controller;

import learn.galvanizes2.music.controller.model.PlaylistDTO;
import learn.galvanizes2.music.controller.model.SongDTO;
import learn.galvanizes2.music.entity.PlaylistEntity;
import learn.galvanizes2.music.entity.SongEntity;
import learn.galvanizes2.music.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/playlists")
@Transactional
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

    @PostMapping("/{listName}")
    @ResponseStatus(HttpStatus.CREATED)
    public SongDTO addSongToPlayList(@PathVariable String listName, @RequestBody SongDTO songDTO) {
        SongEntity songEntity = SongEntity.builder().songName(songDTO.getSongName()).build();
        playlistService.addSongToPlayList(listName, songEntity);
        return songDTO;
    }

    @GetMapping("/{listName}")
    @ResponseStatus(HttpStatus.OK)
    public PlaylistDTO getPlayListByName(@PathVariable String listName) {

        PlaylistEntity entity = playlistService.findPlaylistByName(listName);
        return PlaylistDTO.builder()
                .playlistName(entity.getPlaylistName())
                .trackList(entity.getTrackList().stream().map(song -> new SongDTO(song.getSongName())).collect(Collectors.toList()))
                .build();
    }
}
