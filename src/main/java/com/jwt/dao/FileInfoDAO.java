package com.jwt.dao;

import java.util.List;

import com.jwt.model.Employee;
import com.jwt.model.FileInfo;

public interface FileInfoDAO {

	public void addFileInfo(FileInfo fileInfo);

	public List<FileInfo> getAllFileInfo();

	public void deleteFileInfo(Long fileInfoId);

	public FileInfo updateFileInfo(FileInfo fileInfo);

	public FileInfo getFileInfo(Long fileInfoId);
}
