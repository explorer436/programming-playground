package com.mycompany.tutorial.jpqa.repositories;

import com.mycompany.tutorial.model.Tutorial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface TutorialRepositoryUsingJPQA extends JpaRepository<Tutorial, Long> {

    // https://www.bezkoder.com/spring-jpa-query/

    // JPQA Select query with where condition
    @Query("SELECT t FROM Tutorial t")
    List<Tutorial> findAll_JPQA();

    // @Query("SELECT t FROM Tutorial t WHERE t.published=true")
    // List<Tutorial> findByPublished_true_JPQA();

    @Query("SELECT t FROM Tutorial t WHERE t.published=?1")
    List<Tutorial> findByPublished_JPQA(boolean isPublished);

    @Query("SELECT t FROM Tutorial t WHERE t.title LIKE %?1%")
    List<Tutorial> findByTitleLike_JPQA(String title);

    // @Query("SELECT t FROM Tutorial t WHERE t.title LIKE %?1%%?")
    // List<Tutorial> findByTitleContaining_JPQA(String title);
    // This is giving an error:
    /* nested exception is org.springframework.data.repository.query.QueryCreationException:
       Could not create query for public abstract java.util.List
       com.mycompany.tutorial.jpqa.repositories.TutorialRepositoryUsingJPQA.findByTitleContaining_JPQA(java.lang.String)!
       Reason: Mixing of ? parameters and other forms like ?1 is not supported!;
       nested exception is java.lang.IllegalArgumentException: Mixing of ? parameters and other forms like ?1 is not supported!
     */

    @Query("SELECT t FROM Tutorial t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', ?1,'%'))")
    List<Tutorial> findByTitleLikeCaseInsensitive_JPQA(String title);

    // JPQA Query Greater Than or Equal To

    @Query("SELECT t FROM Tutorial t WHERE t.level >= ?1")
    List<Tutorial> findByLevelGreaterThanEqual_JPQA(int level);

    @Query("SELECT t FROM Tutorial t WHERE t.createdAt >= ?1")
    List<Tutorial> findByDateGreaterThanEqual_JPQA(Date date);

    // JPA Query Between

    @Query("SELECT t FROM Tutorial t WHERE t.level BETWEEN ?1 AND ?2")
    List<Tutorial> findByLevelBetween_JPQA(int start, int end);

    @Query("SELECT t FROM Tutorial t WHERE t.createdAt BETWEEN ?1 AND ?2")
    List<Tutorial> findByDateBetween_JPQA(Date start, Date end);

    // JPA Query example with parameters

    @Query("SELECT t FROM Tutorial t WHERE t.published=:isPublished AND t.level BETWEEN :start AND :end")
    List<Tutorial> findByLevelBetween_JPQA(@Param("start") int start, @Param("end") int end, @Param("isPublished") boolean isPublished);

    // JPA Query Order By Desc/Asc

    @Query("SELECT t FROM Tutorial t ORDER BY t.level DESC")
    List<Tutorial> findAllOrderByLevelDesc_JPQA();

    @Query("SELECT t FROM Tutorial t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', ?1,'%')) ORDER BY t.level ASC")
    List<Tutorial> findByTitleOrderByLevelAsc_JPQA(String title);

    @Query("SELECT t FROM Tutorial t WHERE t.published=true ORDER BY t.createdAt DESC")
    List<Tutorial> findAllPublishedOrderByCreatedDesc_JPQA();

    // JPA Query Sort By

    @Query("SELECT t FROM Tutorial t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', ?1,'%'))")
    List<Tutorial> findByTitleAndSort_JPQA(String title, Sort sort);

    @Query("SELECT t FROM Tutorial t WHERE t.published=?1")
    List<Tutorial> findByPublishedAndSort_JPQA(boolean isPublished, Sort sort);

    // JPA Query Pagination

    @Query("SELECT t FROM Tutorial t")
    Page<Tutorial> findAllWithPagination_JPQA(Pageable pageable);

    // JPA Query Update

    @Transactional
    @Modifying
    @Query("UPDATE Tutorial t SET t.published=true WHERE t.id=?1")
    int publishTutorial_JPQA(Long id);
}
