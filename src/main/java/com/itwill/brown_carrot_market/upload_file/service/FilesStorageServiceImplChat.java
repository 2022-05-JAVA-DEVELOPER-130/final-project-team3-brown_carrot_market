package com.itwill.brown_carrot_market.upload_file.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public class FilesStorageServiceImplChat implements FilesStorageServiceChat {

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(MultipartFile file) {
		// TODO Auto-generated method stub

	}

	@Override
	public Resource load(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public Stream<Path> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
