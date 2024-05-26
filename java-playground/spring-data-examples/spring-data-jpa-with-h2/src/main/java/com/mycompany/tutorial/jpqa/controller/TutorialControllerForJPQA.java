package com.mycompany.tutorial.jpqa.controller;

import com.mycompany.tutorial.jpqa.repositories.TutorialRepositoryUsingJPQA;
import com.mycompany.tutorial.model.Tutorial;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/jpqa")
@RequiredArgsConstructor
public class TutorialControllerForJPQA {

    private final TutorialRepositoryUsingJPQA tutorialRepositoryUsingJPQA;

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
        try {
            List<Tutorial> tutorials = new ArrayList<Tutorial>();

            /*if (title == null)
                tutorialRepositoryUsingJPQA.findAll().forEach(tutorials::add);
            else
                tutorialRepositoryUsingJPQA.findByTitleContaining_JPQA(title).forEach(tutorials::add);*/

            if (StringUtils.isNotEmpty(title)) {
                tutorialRepositoryUsingJPQA.findAll_JPQA().forEach(tutorials::add);
            }

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
        Optional<Tutorial> tutorialData = tutorialRepositoryUsingJPQA.findById(id);

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/tutorials/{title}")
    public ResponseEntity<List<Tutorial>> getTutorialByTitleStartingWith(@PathVariable("title") String title) {
        List<Tutorial> tutorialData = tutorialRepositoryUsingJPQA.findByTitleLike_JPQA(title);

        if (CollectionUtils.isNotEmpty(tutorialData)) {
            return new ResponseEntity<>(tutorialData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/tutorials/case-insensitive/{title}")
    public ResponseEntity<List<Tutorial>> getTutorialByTitleStartingWith_CaseInsensitive(@PathVariable("title") String title) {
        List<Tutorial> tutorialData = tutorialRepositoryUsingJPQA.findByTitleLikeCaseInsensitive_JPQA(title);

        if (CollectionUtils.isNotEmpty(tutorialData)) {
            return new ResponseEntity<>(tutorialData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tutorial")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        try {
            Tutorial _tutorial = tutorialRepositoryUsingJPQA
                    .save(tutorial);
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> createTutorials(@RequestBody List<Tutorial> tutorials) {
        try {
            List<Tutorial> _tutorials = tutorialRepositoryUsingJPQA
                    .saveAll(tutorials);
            return new ResponseEntity<>(_tutorials, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
        Optional<Tutorial> tutorialData = tutorialRepositoryUsingJPQA.findById(id);

        if (tutorialData.isPresent()) {
            Tutorial _tutorial = tutorialData.get();
            _tutorial.setTitle(tutorial.getTitle());
            _tutorial.setDescription(tutorial.getDescription());
            _tutorial.setPublished(tutorial.isPublished());
            return new ResponseEntity<>(tutorialRepositoryUsingJPQA.save(_tutorial), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            tutorialRepositoryUsingJPQA.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/tutorials")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            tutorialRepositoryUsingJPQA.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> findByPublished() {
        try {
            List<Tutorial> tutorials = tutorialRepositoryUsingJPQA.findByPublished_JPQA(true);

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/tutorials/sorted")
    public ResponseEntity<List<Tutorial>> findAllAndSort() {
        try {
            List<Sort.Order> orders = new ArrayList<Sort.Order>();

            // This one takes priority over order2
            Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "description");
            orders.add(order1);

            Sort.Order order2 = new Sort.Order(Sort.Direction.ASC, "id");
            orders.add(order2);

            List<Tutorial> tutorials = tutorialRepositoryUsingJPQA.findAllWithSorting_JPQA(Sort.by(orders));

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tutorials/sortedAndPaginated")
    public ResponseEntity<Page<Tutorial>> findAllWithSortingAndPagination() {
        try {
            List<Sort.Order> orders = new ArrayList<Sort.Order>();

            // This one takes priority over order2
            Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "description");
            orders.add(order1);

            Sort.Order order2 = new Sort.Order(Sort.Direction.ASC, "id");
            orders.add(order2);

            Pageable pageable = PageRequest.of(0, 4, Sort.by(orders));

            Page<Tutorial> tutorials = tutorialRepositoryUsingJPQA.findAllWithSortingAndPagination_JPQA(pageable);

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
