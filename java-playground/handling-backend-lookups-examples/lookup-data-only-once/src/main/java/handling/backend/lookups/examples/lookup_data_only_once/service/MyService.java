package handling.backend.lookups.examples.lookup_data_only_once.service;

import handling.backend.lookups.examples.lookup_data_only_once.dao.MyDao;
import handling.backend.lookups.examples.lookup_data_only_once.model.Details;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
@Slf4j
@RequiredArgsConstructor
public class MyService {

    private final MyDao myDao;

    public Details lookupData(String id) {

        Details details = myDao.getDetailsForId(id);
        log.info(MessageFormat.format("Details in service layer {0} : ", details.toString()));
        return details;
    }
}
