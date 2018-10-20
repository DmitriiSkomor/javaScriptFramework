package com.etnetera.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.etnetera.hr.data.JavaScriptFramework;
import com.etnetera.hr.repository.JavaScriptFrameworkRepository;

import java.util.Date;
import java.util.Optional;

/**
 * Simple REST controller for accessing application logic.
 * 
 * @author Etnetera
 *
 */
@RestController
public class JavaScriptFrameworkController extends EtnRestController {
	private final JavaScriptFrameworkRepository repository;

	@Autowired
	public JavaScriptFrameworkController(JavaScriptFrameworkRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/frameworks")
	public Iterable<JavaScriptFramework> frameworks() {
		return repository.findAll();
	}

	@PostMapping
	public JavaScriptFramework add(@RequestBody JavaScriptFramework javaScriptFramework) {
		return repository.save(javaScriptFramework);
	}

	@PutMapping("{id}")
	public Optional<JavaScriptFramework> update(@PathVariable String id, @RequestBody JavaScriptFramework javaScriptFramework) {
		Optional<JavaScriptFramework> javaScriptFrameworkFromDb = repository.findById(Long.parseLong(id));
		javaScriptFrameworkFromDb.ifPresent(f -> {
			Date date = javaScriptFramework.getDeprecationDate();
			int hypeLevel = javaScriptFramework.getHypeLevel();
			String name = javaScriptFramework.getName();
			String version = javaScriptFramework.getVersion();
			if (date != null) f.setDeprecationDate(date);
			if (hypeLevel!= 0) f.setHypeLevel(hypeLevel);
			if (name != null) f.setName(name);
			if (version != null) f.setVersion(version);
			repository.save(f);
		});
		return javaScriptFrameworkFromDb;
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable String id) {
		repository.deleteById(Long.parseLong(id));
	}

	@GetMapping("{id}")
	public Optional<JavaScriptFramework> getOne(@PathVariable String id) {
		return repository.findById(Long.parseLong(id));
	}

}
