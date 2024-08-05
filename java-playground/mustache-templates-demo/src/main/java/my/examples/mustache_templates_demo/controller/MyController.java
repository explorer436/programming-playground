package my.examples.mustache_templates_demo.controller;

import lombok.RequiredArgsConstructor;
import my.examples.mustache_templates_demo.service.TemplateToJsonConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class MyController {

	private final TemplateToJsonConverter templateToJsonConverter;

	@GetMapping("/convert")
	public ResponseEntity useTemplate() throws Exception {
		templateToJsonConverter.convert();
		return ResponseEntity.noContent().build();
	}

}