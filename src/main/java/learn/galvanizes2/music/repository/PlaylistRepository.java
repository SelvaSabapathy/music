package learn.galvanizes2.music.repository;

import learn.galvanizes2.music.entity.PlaylistEnitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<PlaylistEnitiy, Long> {
}
