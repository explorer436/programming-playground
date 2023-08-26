package com.mycompany.initialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.carinventory.entities.Car;
import com.mycompany.carinventory.entities.RecalledCar;
import com.mycompany.carinventory.repositories.CarRepository;
import com.mycompany.carinventory.repositories.RecalledCarRepository;
import com.mycompany.tutorial.model.Tutorial;
import com.mycompany.tutorial.simplecrudwithjpa.repositories.TutorialRepositoryUsingSpringDataJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class InitData {

    private final CarRepository carRepository;

    private final RecalledCarRepository recalledCarRepository;

    private final TutorialRepositoryUsingSpringDataJpa tutorialRepositoryUsingSpringDataJpa;

    @PostConstruct
    public void load() throws JsonProcessingException {

        Car car1 = (new ObjectMapper()).readValue("{\n" +
                "\"name\": \"carA\",\n" +
                "\"price\":  1.2,\n" +
                "\"quantity\": 4\n" +
                "}", Car.class);
        Car car2 = (new ObjectMapper()).readValue("{\n" +
                "\"name\": \"carB\",\n" +
                "\"price\":  3.4,\n" +
                "\"quantity\": 3\n" +
                "}", Car.class);
        Car car3 = (new ObjectMapper()).readValue("{\n" +
                "\"name\": \"carC\",\n" +
                "\"price\":  5.6,\n" +
                "\"quantity\": 2\n" +
                "}", Car.class);
        Car car4 = (new ObjectMapper()).readValue("{\n" +
                "\"name\": \"carD\",\n" +
                "\"price\":  7.8,\n" +
                "\"quantity\": 1\n" +
                "}", Car.class);

        carRepository.saveAll(Arrays.asList(car1,car2,car3,car4));

        RecalledCar recalledCar1 = (new ObjectMapper()).readValue("{\n" +
                "\"name\": \"carA\",\n" +
                "\"reasonForRecall\": \"faulty steering wheel\"\n" +
                "}", RecalledCar.class);

        recalledCarRepository.save(recalledCar1);

        Tutorial tutorial1 = (new ObjectMapper()).readValue("{\n" +
                "        \"title\": \"sample title for book 1\",\n" +
                "                \"description\":  \"sample description for book 1\",\n" +
                "                \"published\": true\n" +
                "    }", Tutorial.class);

        Tutorial tutorial2 = (new ObjectMapper()).readValue("{\n" +
                "        \"title\": \"sample title for book 2\",\n" +
                "                \"description\":  \"sample description for book 2\",\n" +
                "                \"published\": true\n" +
                "    }", Tutorial.class);

        Tutorial tutorial3 = (new ObjectMapper()).readValue("{\n" +
                "        \"title\": \"sample title for book 3\",\n" +
                "            \"description\": \"sample description for book 3\",\n" +
                "            \"published\": true\n" +
                "    }", Tutorial.class);

        Tutorial tutorial4 = (new ObjectMapper()).readValue("{\n" +
                "        \"title\": \"sample title for book 4\",\n" +
                "            \"description\": \"sample description for book 4\",\n" +
                "            \"published\": false\n" +
                "    }", Tutorial.class);

        Tutorial tutorial5 = (new ObjectMapper()).readValue("{\n" +
                "        \"title\": \"sample title for book 5\",\n" +
                "                \"description\":  \"sample description for book 5\",\n" +
                "                \"published\": true\n" +
                "    }", Tutorial.class);

        Tutorial tutorial6 = (new ObjectMapper()).readValue("{\n" +
                "        \"title\": \"sample title for book 6\",\n" +
                "                \"description\":  \"sample description for book\",\n" +
                "                \"published\": true\n" +
                "    }", Tutorial.class);

        Tutorial tutorial7 = (new ObjectMapper()).readValue("{\n" +
                "        \"title\": \"sample title for book 7\",\n" +
                "                \"description\":  \"sample description for book\",\n" +
                "                \"published\": true\n" +
                "    }", Tutorial.class);

        Tutorial tutorial8 = (new ObjectMapper()).readValue("{\n" +
                "        \"title\": \"sample title for book 8\",\n" +
                "                \"description\":  \"sample description for book\",\n" +
                "                \"published\": true\n" +
                "    }", Tutorial.class);

        tutorialRepositoryUsingSpringDataJpa.saveAll(Arrays.asList(tutorial1, tutorial2, tutorial3, tutorial4, tutorial5, tutorial6, tutorial7, tutorial8));
    }

}
