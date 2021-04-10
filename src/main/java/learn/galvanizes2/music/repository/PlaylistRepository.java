package learn.galvanizes2.music.repository;

import learn.galvanizes2.music.entity.PlaylistEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<PlaylistEntity, Long> {
    PlaylistEntity findByPlaylistName(String playlistName);
}
