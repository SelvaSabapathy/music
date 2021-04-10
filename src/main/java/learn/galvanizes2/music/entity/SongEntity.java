package learn.galvanizes2.music.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String songName;
    @ManyToOne
    @JoinColumn(name = "trackList", nullable = false)
    PlaylistEntity playlistEntity;
}
