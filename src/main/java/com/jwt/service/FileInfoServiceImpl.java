package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.FileInfoDAO;
import com.jwt.model.FileInfo;

@Service
@Transactional
public class FileInfoServiceImpl implements FileInfoService {

	@Autowired
	private FileInfoDAO fileInfoDAO;

	@Override
	@Transactional
	public void addFileInfo(FileInfo employee) {
		fileInfoDAO.addFileInfo(employee);
	}

	@Override
	@Transactional
	public List<FileInfo> getAllFileInfo() {
		return fileInfoDAO.getAllFileInfo();
	}

	@Override
	@Transactional
	public void deleteFileInfo(Long employeeId) {
		fileInfoDAO.deleteFileInfo(employeeId);
	}

	@Override
	public FileInfo getFileInfo(Long empid) {
		return fileInfoDAO.getFileInfo(empid);
	}

	@Override
	@Transactional
	public FileInfo updateFileInfo(FileInfo employee) {
		// TODO Auto-generated method stub
		return fileInfoDAO.updateFileInfo(employee);
	}
	

}
