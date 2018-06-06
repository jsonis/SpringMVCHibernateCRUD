/**
 * 
 */
package com.jwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jsonis
 *
 */
@Entity
@Table(name = "FILE_INFO")
public class FileInfo {

	 @Column
	 private String fileName;
	 
	 private long fileSize;
	 
	 @Column
	 private byte[] attachment;
	 
	 private long id;

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "FILE_ID")
     public long getId() {
		return id;
     }
	 
	 public void setId(long id) {
	    this.id = id;
	 }
	 
	 public String getFileName() {
	  return fileName;
	 }

	 public void setFileName(String fileName) {
	  this.fileName = fileName;
	 }

	 public long getFileSize() {
	  return fileSize;
	 }

	 public void setFileSize(long fileSize) {
	  this.fileSize = fileSize;
	 }

	public byte[] getAttachment() {
		return attachment;
	}

	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}
	 
	 

}
