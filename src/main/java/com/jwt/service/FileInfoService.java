package com.jwt.service;

import java.util.List;

import com.jwt.model.Employee;
import com.jwt.model.FileInfo;

public interface FileInfoService {
	
	public void addFileInfo(FileInfo fileInfo);

	public List<FileInfo> getAllFileInfo();

	public void deleteFileInfo(Long fileInfoId);

	public FileInfo getFileInfo(Long fileInfoId);

	public FileInfo updateFileInfo(FileInfo fileInfo);
}
