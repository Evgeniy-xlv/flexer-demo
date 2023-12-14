package c0rnell.flexer.demo.repo;

import c0rnell.flexer.demo.entity.House;
import c0rnell.flexer.query.ConditionalQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepo extends JpaRepository<House, Long> {

    @ConditionalQuery
    @Query(
            value = """
            SELECT ho.* FROM house ho
            --%#{#includeHuman}
                JOIN house_humans hh ON hh.house_id = ho.id
            --/
            --%#{#includeFurniture}
                JOIN house_furniture hf ON hf.house_id = ho.id
            --/
            """,
            nativeQuery = true
    )
    List<House> findAllTest(boolean includeHuman, boolean includeFurniture);
}



