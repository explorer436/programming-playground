package enterprise.search.examples.opensearch_java_demo.initialize;

import enterprise.search.examples.opensearch_java_demo.model.MyDocument;
import enterprise.search.examples.opensearch_java_demo.service.MyService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class InitData {

    private final MyService employeeService;

    @PostConstruct
    public void setupData() {
        log.info("Connecting to Opensearch cluster to write employee data");

        /*List<MyDocument> myDocuments = new ArrayList<>();

        MyDocument e1 = MyDocument
                .builder()
                .id(123l)
                .firstName("e1firstname")
                .lastName("e2lastname")
                .email("e1email")
                .gender("e1gender")
                .jobTitle("e1jobtitle")
                .phone("e1phone")
                .size(123)
                .build();

        MyDocument e2 = MyDocument
                .builder()
                .id(456l)
                .firstName("e2firstname")
                .lastName("e2lastname")
                .email("e2email")
                .gender("e2gender")
                .jobTitle("e2jobtitle")
                .phone("e2phone")
                .size(456)
                .build();

        myDocuments.add(e1);
        myDocuments.add(e2);

        try {
            boolean isSuccess = employeeService.bulkInsertDocuments(myDocuments);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }*/

        log.info("Opensearch setup done");
    }
}
