package com.mycompany.tutorial.nativequeriesusingjparepository.repositories;

import com.mycompany.tutorial.model.Tutorial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TutorialRepositoryUsingNativeQueries extends JpaRepository<Tutorial, Long> {

    // https://www.bezkoder.com/jpa-native-query/

    // JPA native query Select with where condition

    // This is not supported
    // @Query(value = "SELECT * FROM tutorials t WHERE t.published=?1", nativeQuery = true)
    // List<Tutorial> findByPublished_Native(boolean isPublished);

    // @Query(value = "SELECT * FROM tutorials t WHERE t.title LIKE %?1%%?", nativeQuery = true)
    // List<Tutorial> findByTitleContaining_Native(String title);
    // This is giving an error
    /*
     * nested exception is org.springframework.data.repository.query.QueryCreationException:
     * Could not create query for public abstract java.util.List
     * com.mycompany.tutorial.nativequeriesusingjparepository.repositories.TutorialRepositoryUsingNativeQueries.findByTitleContaining_Native(java.lang.String)!
     * Reason: Mixing of ? parameters and other forms like ?1 is not supported!;
     * nested exception is java.lang.IllegalArgumentException:
     * Mixing of ? parameters and other forms like ?1 is not supported!
     */

    @Query(value = "SELECT * FROM tutorials t WHERE t.title LIKE %?1%", nativeQuery = true)
    List<Tutorial> findByTitleLike_Native(String title);

    @Query(value = "SELECT * FROM tutorials t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', ?1,'%'))", nativeQuery = true)
    List<Tutorial> findByTitleLikeCaseInsensitive_Native(String title);
    @Query(value = "SELECT * FROM tutorials", nativeQuery = true)
    List<Tutorial> findAll_Native();

    @Query(value = "SELECT * FROM tutorials t WHERE t.published=true", nativeQuery = true)
    List<Tutorial> findByPublished_Native();

    // JPA Native Query Greater Than or Equal To

    @Query(value = "SELECT * FROM tutorials t WHERE t.level >= ?1", nativeQuery = true)
    List<Tutorial> findByLevelGreaterThanEqual_Native(int level);

    @Query(value = "SELECT * FROM tutorials t WHERE t.created_at >= ?1", nativeQuery = true)
    List<Tutorial> findByDateGreaterThanEqual_Native(Date date);

    // JPA Native Query Between

    // In these examples, we use Positional Parameters: the parameters is referenced by their positions in the query (defined using ? followed by a number (?1, ?2, …). Spring Data JPA will automatically replaces the value of each parameter in the same position.

    @Query(value = "SELECT * FROM tutorials t WHERE t.level BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Tutorial> findByLevelBetween_Native(int start, int end);

    @Query(value = "SELECT * FROM tutorials t WHERE t.created_at BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Tutorial> findByDateBetween_Native(Date start, Date end);

    // JPA Native Query example with parameters

    // Another way of binding values is by using Named Parameters.
    // A named parameter starts with : followed by the name of the parameter (:title, :date, …).

    @Query(value = "SELECT * FROM tutorials t WHERE t.published=:isPublished AND t.level BETWEEN :start AND :end", nativeQuery = true)
    List<Tutorial> findByLevelBetween_Native(@Param("start") int start, @Param("end") int end, @Param("isPublished") boolean isPublished);

    // JPA Native Query Order By Desc/Asc

    @Query(value = "SELECT * FROM tutorials t ORDER BY t.level DESC", nativeQuery = true)
    List<Tutorial> findAllOrderByLevelDesc_Native();

    @Query(value = "SELECT * FROM tutorials t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', ?1,'%')) ORDER BY t.level ASC", nativeQuery = true)
    List<Tutorial> findByTitleOrderByLevelAsc_Native(String title);

    @Query(value = "SELECT * FROM tutorials t WHERE t.published=true ORDER BY t.created_at DESC", nativeQuery = true)
    List<Tutorial> findAllPublishedOrderByCreatedDesc_Native();

    // JPA Native Query Sort By

    /** Spring Data JPA does not currently support dynamic sorting for native queries,
     * because it would have to manipulate the actual query declared,
     * which it cannot do reliably for native SQL.
     * You can, however, use native queries for pagination by specifying the count query yourself –
     * Official Spring Document - https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.at-query.native
     *
     * InvalidJpaQueryMethodException
        @Query(value = "SELECT * FROM tutorials t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', ?1,'%'))", nativeQuery = true)
        List<Tutorial> findByTitleAndSort(String title, Sort sort);
     *
     * So, how to deal with dynamic sorting?
     * We can use Pageable object instead. For example:
    */

    @Query(value = "SELECT * FROM tutorials t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', ?1,'%'))", nativeQuery = true)
    Page<Tutorial> findByTitleLike_Native(String title, Pageable pageable);

    @Query(value = "SELECT * FROM tutorials t WHERE t.published=?1", nativeQuery = true)
    Page<Tutorial> findByPublished_Native(boolean isPublished, Pageable pageable);
}