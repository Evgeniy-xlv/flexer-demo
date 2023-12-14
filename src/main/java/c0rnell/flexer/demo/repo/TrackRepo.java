package c0rnell.flexer.demo.repo;

import c0rnell.flexer.demo.entity1.Track;
import c0rnell.flexer.query.ConditionalQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TrackRepo extends JpaRepository<Track, Long> {

    @ConditionalQuery
    @Query(
            value = """
                    SELECT t.* FROM track t
                    --%#{#artistIds != null and #artistIds.size() > 0}
                        JOIN track_artist ta ON t.id = ta.track
                    --/
                    --%#{#genreIds != null and #genreIds.size() > 0}
                        JOIN track_genre tg ON t.id = tg.track
                    --/
                    --%#{#compilationIds != null and #compilationIds.size() > 0}
                        JOIN track_compilation tc ON t.id = tc.track
                    --/
                    --%#{#trackIds != null and trackIds.size() > 0}
                        WHERE id IN (:trackIds)
                    --/
                    """,
            nativeQuery = true
    )
    List<Track> findAllByConditional(Collection<Long> trackIds,
                                     Collection<Long> artistIds,
                                     Collection<Long> genreIds,
                                     Collection<Long> compilationIds);
}
