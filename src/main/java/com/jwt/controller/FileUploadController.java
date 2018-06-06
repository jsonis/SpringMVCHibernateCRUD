/**
 * 
 */
package com.jwt.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.jwt.dao.FileInfoDAO;
import com.jwt.model.Employee;
import com.jwt.model.FileInfo;
import com.jwt.service.EmployeeService;
import com.jwt.service.FileInfoService;

/**
 * @author jsonis
 *
 */
@RestController
@RequestMapping("/fileUpload")
public class FileUploadController {

	@Autowired
	ServletContext context;
	
	@Autowired
	private FileInfoService fileInfoService;
	
	@Autowired
    private FileInfoDAO fileInfoDAO;
	
	/**
	 * 
	 */
	public FileUploadController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "/upload", headers=("content-type=multipart/*"), method = RequestMethod.POST)
	public ResponseEntity<FileInfo> upload(@RequestParam("file") MultipartFile inputFile) {
		FileInfo fileInfo = new FileInfo();
		HttpHeaders headers = new HttpHeaders();
		if (!inputFile.isEmpty()) {
			try {
				String originalFilename = inputFile.getOriginalFilename();
				System.out.println("Saving file: " + originalFilename);
				
				fileInfo.setFileName(originalFilename);
				fileInfo.setAttachment(inputFile.getBytes());
				fileInfo.setFileSize(inputFile.getSize());

				fileInfoService.addFileInfo(fileInfo);
				
				return new ResponseEntity<FileInfo>(fileInfo, headers, HttpStatus.OK);
			} catch (Exception e) {    
				e.printStackTrace();
				return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
			}
		}else{
			return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/update", headers=("content-type=multipart/*"), method = RequestMethod.POST)
	public ResponseEntity<FileInfo> update(@RequestParam("file") MultipartFile inputFile,
			@RequestParam("id") String fileId) {
		FileInfo fileInfo = new FileInfo();
		HttpHeaders headers = new HttpHeaders();
		if (!inputFile.isEmpty() && fileId !=null) {
			try {
				fileInfo = fileInfoService.getFileInfo(new Long(fileId));
				
				if(fileInfo !=null){
					String newFilename = inputFile.getOriginalFilename();
					String orgFilename = fileInfo.getFileName();
					FileInfo newfileinfo = new FileInfo();
					newfileinfo.setAttachment(inputFile.getBytes());
					newfileinfo.setFileName(newFilename);
					newfileinfo.setId(new Long(fileId));
					newfileinfo.setFileSize(inputFile.getSize());
					
					System.out.println("Saving file: " + newFilename);
					fileInfoService.addFileInfo(newfileinfo);
					
					return new ResponseEntity<FileInfo>(newfileinfo, headers, HttpStatus.OK);
				}else{
					return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
				}
			} catch (Exception e) {    
				e.printStackTrace();
				return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
			}
		}else{
			return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	 
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<FileInfo> delete(@RequestParam("id") String fileId) {
		if (fileId !=null) {
			try {
				FileInfo fileInfo = fileInfoService.getFileInfo(new Long(fileId));
				
				if(fileInfo !=null){
					fileInfoService.deleteFileInfo(new Long(fileId));
					System.out.println("Deleting  file: " + fileInfo.getFileName());
					return new ResponseEntity<FileInfo>(HttpStatus.OK);
				}else{
					return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
				}
			} catch (Exception e) {    
				e.printStackTrace();
				return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
			}
		}else{
			return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
