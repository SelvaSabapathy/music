package learn.galvanizes2.music;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import learn.galvanizes2.music.controller.model.PlaylistDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MusicIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private PlaylistDTO playList;

    @BeforeEach
    void setUp() {
        this.playList = PlaylistDTO.builder().playlistName("NewList").build();
    }

    /**
     * When a playlist is created with a name
     * Then a confirmation is returned that it was successful.
     * And the playlist is empty.
     */
    @Test
    @DirtiesContext
    public void createPlaylist() throws Exception {
        mockMvc.perform(post("/playlists")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(playList))
        )
                .andExpect(status().isCreated());
    }

    @Test
    @DirtiesContext
    public void getAllPlaylists() throws Exception {
        this.createPlaylist();
        String result = mockMvc.perform(get("/playlists")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        List<PlaylistDTO> playlistDTOList = objectMapper.readValue(result, new TypeReference<List<PlaylistDTO>>() {
        });

        assertThat(playlistDTOList, is(Arrays.asList(playList)));
    }

    /**
     *     When a playlist is created with existing name
     *     Then a message is returned that it was unsuccessful.
     */

    /**
     *      When a playlist is created without a name
     *     Then a message is returned that a name is required.
     */

    /**
     *    Given a playlist
     *     When a song is added
     *     Then the playlist have one more song
     */

    /**
     *    Given a playlist has songs
     *     When a song is removed
     *     Then the playlist have one less song
     */

    /**
     *    Given a playlist has songs
     *     When retrieve the playlist
     *     Then see the songs on the playlist
     */
}
