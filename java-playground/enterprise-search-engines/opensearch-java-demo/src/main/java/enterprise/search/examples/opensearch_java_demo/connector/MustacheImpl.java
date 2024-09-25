package enterprise.search.examples.opensearch_java_demo.connector;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheException;
import com.github.mustachejava.MustacheFactory;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.Map;

@Service
public class MustacheImpl {

    public String template(Map<String, Object> params, String templatePath) throws Exception {
        StringWriter writer = new StringWriter();
        Mustache mustache = mf.compile(templatePath);
        mustache.execute(writer, params).flush();
        return writer.getBuffer().toString();
    }

    public MustacheFactory mf = new DefaultMustacheFactory() {
        @Override
        public void encode(String value, java.io.Writer writer) {
            try {
                writer.write(value);
            } catch (Exception e) {
                throw new MustacheException("Failed to encode value: " + value);
            }
        };
    };

}
