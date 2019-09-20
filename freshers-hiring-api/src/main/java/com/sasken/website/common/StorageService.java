package com.sasken.website.common;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private GlobalProperties globalProperties;

	public void init() {
		
		Path rootLocation = Paths.get(globalProperties.getResumeUploadDir());

		try {
			if (Files.notExists(rootLocation))
				Files.createDirectory(rootLocation);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
		}
	}

	public void store(MultipartFile file) {
		try {
			Path rootLocation = Paths.get(globalProperties.getResumeUploadDir());

			Files.copy(file.getInputStream(), rootLocation.resolve(file.getOriginalFilename()));

		} catch (Exception e) {
			throw new RuntimeException("FAIL to Store file!");
		}
	}

	public void store(MultipartFile file, String subDir) {
		try {
			Path rootLocation = Paths.get(globalProperties.getResumeUploadDir());
			Path dirLocation = Paths.get(rootLocation + "/" + subDir);

			if (Files.notExists(dirLocation)) {
				Files.createDirectory(dirLocation);
				Files.copy(file.getInputStream(), dirLocation.resolve(file.getOriginalFilename()));
			}
		} catch (Exception e) {
			log.error("Failed to store file"+ e);
			throw new RuntimeException("FAIL to Store file!");
		}
	}

	public Resource loadFile(String filename) {
		try {
			Path rootLocation = Paths.get(globalProperties.getResumeUploadDir());

			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}

}
