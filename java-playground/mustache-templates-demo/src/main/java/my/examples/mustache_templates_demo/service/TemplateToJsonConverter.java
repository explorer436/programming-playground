package my.examples.mustache_templates_demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class TemplateToJsonConverter {

    private final MustacheImpl mustacheImpl;

    public void convert() throws Exception {
        Map params = new HashMap<>();
        params.put("recptId", "test value");
        String query = mustacheImpl.template(params, "searchFormData.json");

        log.info("query: {}", query);
    }
}
