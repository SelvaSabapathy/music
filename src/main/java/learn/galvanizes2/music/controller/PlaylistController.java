package learn.galvanizes2.music.controller;

import learn.galvanizes2.music.controller.model.PlaylistDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PlaylistDTO playlistDTO) {
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PlaylistDTO> getAllPlaylists() {
        return null;
    }
}
