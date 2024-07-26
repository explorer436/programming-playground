package handling.backend.lookups.examples.lookup_data_only_once.dao;

import handling.backend.lookups.examples.lookup_data_only_once.model.Details;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyDao {

    @Cacheable("detailsForId")
    public Details getDetailsForId(String id) {

        // simulates building the object by calling a backend service
        // for each id, this should be called only once - the first time

        log.info(">>> id = {}", id);

        if (id.equals("type1")) {
            return getDetailsForType1();
        } else {
            return getDetailsForType2();
        }
    }

    // simulates building the object by calling a backend service
    // this should be called only once - the first time
    private Details getDetailsForType1() {
        log.info(">>> getDetailsForType1");

        Details result = Details.builder()
                .id("type1")
                .name("name-for-type1")
                .accountNumber("account-number-for-type1")
                .build();

        log.info("<<< getDetailsForType1");
        return result;
    }

    // simulates building the object by calling a backend service
    // this should be called only once - the first time
    private Details getDetailsForType2() {
        log.info(">>> getDetailsForType2");

        Details result = Details.builder()
                .id("type2")
                .name("name-for-type2")
                .accountNumber("account-number-for-type2")
                .build();

        log.info("<<< getDetailsForType2");
        return result;
    }
}
