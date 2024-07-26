package handling.backend.lookups.examples.lookup_data_only_once.controller;

import handling.backend.lookups.examples.lookup_data_only_once.model.Details;
import handling.backend.lookups.examples.lookup_data_only_once.service.MyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MyController {

    private final MyService myService;

    @GetMapping("/lookup-data-only-once/{id}")
    public Details getDetails(@PathVariable("id")  String id) {
        return myService.lookupData(id);
    }
}
