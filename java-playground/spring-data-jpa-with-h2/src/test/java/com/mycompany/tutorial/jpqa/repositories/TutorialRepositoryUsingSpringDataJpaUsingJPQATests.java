package com.mycompany.tutorial.jpqa.repositories;

import com.mycompany.tutorial.model.Tutorial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TutorialRepositoryUsingSpringDataJpaUsingJPQATests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    TutorialRepositoryUsingJPQA repository;

    private Tutorial createTutorial(String title, String description, boolean published) {
        return Tutorial.builder()
                .title(title)
                .description(description)
                .published(published)
                .build();
    }

    @Test
    public void should_find_no_tutorials_if_repository_is_empty() {
        Iterable tutorials = repository.findAll();

        assertThat(tutorials).isEmpty();
    }

    @Test
    public void should_store_a_tutorial() {
        Tutorial tutorial = repository.save(createTutorial("Tut title", "Tut desc", true));

        assertThat(tutorial).hasFieldOrPropertyWithValue("title", "Tut title");
        assertThat(tutorial).hasFieldOrPropertyWithValue("description", "Tut desc");
        assertThat(tutorial).hasFieldOrPropertyWithValue("published", true);
    }

    @Test
    public void should_find_all_tutorials() {
        Tutorial tut1 = createTutorial("Tut#1", "Desc#1", true);
        entityManager.persist(tut1);

        Tutorial tut2 = createTutorial("Tut#2", "Desc#2", false);
        entityManager.persist(tut2);

        Tutorial tut3 = createTutorial("Tut#3", "Desc#3", true);
        entityManager.persist(tut3);

        Iterable tutorials = repository.findAll();

        assertThat(tutorials).hasSize(3).contains(tut1, tut2, tut3);
    }

    @Test
    public void should_find_tutorial_by_id() {
        Tutorial tut1 = createTutorial("Tut#1", "Desc#1", true);
        entityManager.persist(tut1);

        Tutorial tut2 = createTutorial("Tut#2", "Desc#2", false);
        entityManager.persist(tut2);

        Tutorial foundTutorial = repository.findById(tut2.getId()).get();

        assertThat(foundTutorial).isEqualTo(tut2);
    }

    @Test
    public void should_find_published_tutorials() {
        Tutorial tut1 = createTutorial("Tut#1", "Desc#1", true);
        entityManager.persist(tut1);

        Tutorial tut2 = createTutorial("Tut#2", "Desc#2", false);
        entityManager.persist(tut2);

        Tutorial tut3 = createTutorial("Tut#3", "Desc#3", true);
        entityManager.persist(tut3);

        Iterable tutorials = repository.findByPublished_JPQA(true);

        assertThat(tutorials).hasSize(2).contains(tut1, tut3);
    }

    @Test
    public void should_find_tutorials_by_title_containing_string() {
        Tutorial tut1 = createTutorial("Spring Boot Tut#1", "Desc#1", true);
        entityManager.persist(tut1);

        Tutorial tut2 = createTutorial("Java Tut#2", "Desc#2", false);
        entityManager.persist(tut2);

        Tutorial tut3 = createTutorial("Spring Data JPA Tut#3", "Desc#3", true);
        entityManager.persist(tut3);

        Iterable tutorials = repository.findByTitleLike_JPQA("ring");

        assertThat(tutorials).hasSize(2).contains(tut1, tut3);
    }

    @Test
    public void should_update_tutorial_by_id() {
        Tutorial tut1 = createTutorial("Tut#1", "Desc#1", true);
        entityManager.persist(tut1);

        Tutorial tut2 = createTutorial("Tut#2", "Desc#2", false);
        entityManager.persist(tut2);

        Tutorial updatedTut = createTutorial("updated Tut#2", "updated Desc#2", true);

        Tutorial tut = repository.findById(tut2.getId()).get();
        tut.setTitle(updatedTut.getTitle());
        tut.setDescription(updatedTut.getDescription());
        tut.setPublished(updatedTut.isPublished());
        repository.save(tut);

        Tutorial checkTut = repository.findById(tut2.getId()).get();

        assertThat(checkTut.getId()).isEqualTo(tut2.getId());
        assertThat(checkTut.getTitle()).isEqualTo(updatedTut.getTitle());
        assertThat(checkTut.getDescription()).isEqualTo(updatedTut.getDescription());
        assertThat(checkTut.isPublished()).isEqualTo(updatedTut.isPublished());
    }

    @Test
    public void should_delete_tutorial_by_id() {
        Tutorial tut1 = createTutorial("Tut#1", "Desc#1", true);
        entityManager.persist(tut1);

        Tutorial tut2 = createTutorial("Tut#2", "Desc#2", false);
        entityManager.persist(tut2);

        Tutorial tut3 = createTutorial("Tut#3", "Desc#3", true);
        entityManager.persist(tut3);

        repository.deleteById(tut2.getId());

        Iterable tutorials = repository.findAll();

        assertThat(tutorials).hasSize(2).contains(tut1, tut3);
    }

    @Test
    public void should_delete_all_tutorials() {
        entityManager.persist(createTutorial("Tut#1", "Desc#1", true));
        entityManager.persist(createTutorial("Tut#2", "Desc#2", false));

        repository.deleteAll();

        assertThat(repository.findAll()).isEmpty();
    }
}
