package com.jwt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Employee;
import com.jwt.model.FileInfo;

@Repository
public class FileInfoDAOImpl implements FileInfoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addFileInfo(FileInfo fileInfo) {
		sessionFactory.getCurrentSession().saveOrUpdate(fileInfo);
	}

	@SuppressWarnings("unchecked")
	public List<FileInfo> getAllFileInfo() {
		return sessionFactory.getCurrentSession().createQuery("from FileInfo").list();
	}

	@Override
	public void deleteFileInfo(Long fileInfoId) {
		FileInfo fileInfo = (FileInfo) sessionFactory.getCurrentSession().load(
				FileInfo.class, fileInfoId);
		if (null != fileInfo) {
			this.sessionFactory.getCurrentSession().delete(fileInfo);
		}
	}
	
	@Override
	public FileInfo getFileInfo(Long fileInfoid) {
		return (FileInfo) sessionFactory.getCurrentSession().get(
				FileInfo.class, fileInfoid);
	}

	@Override
	public FileInfo updateFileInfo(FileInfo fileInfo) {
		sessionFactory.getCurrentSession().update(fileInfo);
		return fileInfo;
	}

}