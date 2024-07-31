package enterprise.search.examples.opensearch_java_demo.initialize;

import enterprise.search.examples.opensearch_java_demo.model.Employee;
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

        List<Employee> employees = new ArrayList<>();

        Employee e1 = Employee
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

        Employee e2 = Employee
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

        employees.add(e1);
        employees.add(e2);

        try {
            boolean isSuccess = employeeService.bulkInsertEmployees(employees);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        log.info("Opensearch setup done");
    }
}
