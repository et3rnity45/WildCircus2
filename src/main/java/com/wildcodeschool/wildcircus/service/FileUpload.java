package com.wildcodeschool.wildcircus.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUpload {

	private final String UPLOAD_DIR = System.getProperty("user.dir") + "/src/main/resources/static";
	
	public String getExtension(String file) {
	    return Optional.ofNullable(file)
	      .filter(f -> f.contains("."))
	      .map(f -> f.substring(file.lastIndexOf("."))).get();
	}
	
	public String writeFile(MultipartFile file, String dir, String fileName) {
		Path path = null;
		String filePath = File.separator + "img" + File.separator + dir + File.separator + fileName + getExtension(file.getOriginalFilename());
		try {
			byte[] bytes = file.getBytes();
			path = Paths.get(UPLOAD_DIR + filePath);
			Files.write(path, bytes).toFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return filePath;
	}
	
	public void deleteFile(String filePath) {
		try {
			File deleteFile = new File(UPLOAD_DIR + File.separator + filePath);
			deleteFile.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
