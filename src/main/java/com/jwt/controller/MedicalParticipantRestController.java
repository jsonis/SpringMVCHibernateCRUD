package com.jwt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.jwt.model.Employee;
import com.jwt.model.MedicalResearchProgram;
import com.jwt.model.ParticipantInfo;
import com.jwt.service.EmployeeService;
import com.jwt.service.MedicalResearchProgramService;
import com.jwt.service.ParticipantInfoService;

@RestController
@RequestMapping("/testWS")
public class MedicalParticipantRestController {

	private static final Logger logger = Logger
			.getLogger(MedicalParticipantRestController.class);

	public MedicalParticipantRestController() {
		System.out.println("WSMedicalParticipantController()");
	}

	@Autowired
	private MedicalResearchProgramService medicalResearchProgramService;
	
	@Autowired
	private ParticipantInfoService participantInfoService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/hello", method=RequestMethod.GET)
	public String test(ModelAndView model) throws IOException {
		return "Hello Test";
	}
	
	//------------------- Get all ParticipantInfo --------------------------------------------------------
	
	@RequestMapping(value = "/getAllParticipantInfo/", method = RequestMethod.GET)
	public ResponseEntity<List<ParticipantInfo>> getAllParticipantInfo() {
		logger.debug("++++++++++ Inside getAllParticipantInfo ++++++++");
		List<ParticipantInfo> listParticipantInfo = participantInfoService.getAllParticipant();
		if(listParticipantInfo.isEmpty()){
			return new ResponseEntity<List<ParticipantInfo>>(HttpStatus.NO_CONTENT);
		}else{
			return new ResponseEntity<List<ParticipantInfo>>(listParticipantInfo, HttpStatus.OK);
		}
	}
	//------------------- Insert a ParticipantInfo --------------------------------------------------------
	
	
	@RequestMapping(value = "/insertNewParticipantInfo/", method = RequestMethod.POST)
	public ResponseEntity<List<ParticipantInfo>> insertParticipant(@RequestBody ParticipantInfo participantInfo) {
		logger.debug("++++++++++ Inside insertNewParticipantInfo ++++++++");
		if(participantInfo.getFname()!=null && participantInfo.getLname()!=null){
			participantInfoService.addParticipantInfo(participantInfo);
			List<ParticipantInfo> listParticipantInfo = participantInfoService.getAllParticipant();
			if(listParticipantInfo.isEmpty()){
				return new ResponseEntity<List<ParticipantInfo>>(HttpStatus.NO_CONTENT);
			}else{
				return new ResponseEntity<List<ParticipantInfo>>(listParticipantInfo, HttpStatus.OK);
			}
		}else{
			return new ResponseEntity<List<ParticipantInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	//------------------- Insert a ParticipantInfo --------------------------------------------------------
	
	
		@RequestMapping(value = "/insertNewParticipantInfoWithProgID/", method = RequestMethod.POST)
		public ResponseEntity<List<ParticipantInfo>> insertNewParticipantInfoWithProgID(@RequestBody ParticipantInfo participantInfo) {
			logger.debug("++++++++++ Inside insertNewParticipantInfoWithProgID ++++++++");
			if(participantInfo.getFname()!=null && participantInfo.getLname()!=null){
				if(participantInfo.getMedicalResearchProgram().getProgram_Id()!=null){
					Long programID = participantInfo.getMedicalResearchProgram().getProgram_Id();
					MedicalResearchProgram medicalResearchProgram = medicalResearchProgramService.getProgram(programID.intValue());
					if(medicalResearchProgram != null){
						participantInfo.setMedicalResearchProgram(medicalResearchProgram);
						participantInfoService.addParticipantInfo(participantInfo);
					}else{
						return new ResponseEntity<List<ParticipantInfo>>(HttpStatus.BAD_REQUEST);
					}
				}else{
					participantInfoService.addParticipantInfo(participantInfo);
				}
				List<ParticipantInfo> listParticipantInfo = participantInfoService.getAllParticipant();
				if(listParticipantInfo.isEmpty()){
					return new ResponseEntity<List<ParticipantInfo>>(HttpStatus.NO_CONTENT);
				}else{
					return new ResponseEntity<List<ParticipantInfo>>(listParticipantInfo, HttpStatus.OK);
				}
			}else{
				return new ResponseEntity<List<ParticipantInfo>>(HttpStatus.BAD_REQUEST);
			}
		}
	
	//------------------- Update a ParticipantInfo --------------------------------------------------------
	
	@RequestMapping(value = "/modifyParticipantInfo/", method = RequestMethod.POST)
	public ResponseEntity<List<ParticipantInfo>> modifyParticipant(@RequestBody ParticipantInfo mparticipantInfo) {
		logger.debug("++++++++++ Inside modifyParticipantInfo ++++++++");
		if(mparticipantInfo!=null){
			ParticipantInfo participantInfo = new ParticipantInfo();
			participantInfo.setId(mparticipantInfo.getId());
			participantInfo.setParticipant_id(mparticipantInfo.getParticipant_id());
			participantInfo.setAddress(mparticipantInfo.getAddress());
			participantInfo.setAge(mparticipantInfo.getAge());
			participantInfo.setContact_no(mparticipantInfo.getContact_no());
			participantInfo.setEmail(mparticipantInfo.getEmail());
			participantInfo.setFname(mparticipantInfo.getFname());
			participantInfo.setLname(mparticipantInfo.getLname());
			Long programID = mparticipantInfo.getMedicalResearchProgram().getProgram_Id();
			MedicalResearchProgram medicalResearchProgram = medicalResearchProgramService.getProgram(programID.intValue());
			if(medicalResearchProgram != null){
				participantInfo.setMedicalResearchProgram(medicalResearchProgram);
				participantInfoService.addParticipantInfo(participantInfo);
			}else{
				return new ResponseEntity<List<ParticipantInfo>>(HttpStatus.BAD_REQUEST);
			}
					
			List<ParticipantInfo> listParticipantInfo = participantInfoService.getAllParticipant();
			if(listParticipantInfo.isEmpty()){
				return new ResponseEntity<List<ParticipantInfo>>(HttpStatus.NO_CONTENT);
			}else{
				return new ResponseEntity<List<ParticipantInfo>>(listParticipantInfo, HttpStatus.OK);
			}
			
		}else{
			return new ResponseEntity<List<ParticipantInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//------------------- Delete a ParticipantInfo --------------------------------------------------------

	@RequestMapping(value = "/deleteParticipantInfo/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<List<ParticipantInfo>> deleteParticipant(@PathVariable String id) {
		logger.debug("++++++++++ Inside deleteParticipantInfo ++++++++");
		if(id != null && id.length()>0){
			ParticipantInfo participantInfo = participantInfoService.getParticipant(new Integer(id));
			if(participantInfo == null){
				System.out.println("Unable to delete. ParticipantInfo with id " + id + " not found");
				return new ResponseEntity<List<ParticipantInfo>>(HttpStatus.NOT_FOUND);
			}else{
				participantInfoService.deleteParticipant(new Integer(id));
				List<ParticipantInfo> listParticipantInfo = participantInfoService.getAllParticipant();
				return new ResponseEntity<List<ParticipantInfo>>(listParticipantInfo, HttpStatus.OK);
			}
		}else{
			return new ResponseEntity<List<ParticipantInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	//------------------- Get a ParticipantInfo --------------------------------------------------------
	
	@RequestMapping(value = "/getParticipantInfo/", method = RequestMethod.GET)
	public ResponseEntity<ParticipantInfo> getParticipant(@PathVariable String id) {
		logger.debug("++++++++++ Inside getParticipantInfo ++++++++");
		if(id != null && id.length()>0){
			int participantId = new Integer(id);
			ParticipantInfo participantInfo = participantInfoService.getParticipant(participantId);
			if(participantInfo == null){
				System.out.println("Unable to find. ParticipantInfo with id " + id + " not found");
				return new ResponseEntity<ParticipantInfo>(HttpStatus.NOT_FOUND);
			}else{
				return new ResponseEntity<ParticipantInfo>(participantInfo, HttpStatus.OK);
			}
		}else{
			return new ResponseEntity<ParticipantInfo>(HttpStatus.BAD_REQUEST);
		}
	}

	
	//------------------- Medical Research Program Info --------------------------------------------------------
	//------------------- showAll Medical Research  --------------------------------------------------------
		
	@RequestMapping(value = "/showAllProgram", method=RequestMethod.GET)
	public ResponseEntity<List<MedicalResearchProgram>> listProgram(ModelAndView model) throws IOException {
		logger.debug("++++++++++ Inside showAllProgram ++++++++");
		List<MedicalResearchProgram> listProgram = medicalResearchProgramService.getAllProgram();
		if(listProgram.isEmpty()){
			return new ResponseEntity<List<MedicalResearchProgram>>(HttpStatus.NO_CONTENT);
		}else{
			return new ResponseEntity<List<MedicalResearchProgram>>(listProgram, HttpStatus.OK);
		}
	}
	
	//------------------- Delete a Medical Research Program --------------------------------------------------------
	
	@RequestMapping(value = "/deleteProgram/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<List<MedicalResearchProgram>> deleteProgram(@PathVariable String id) {
		logger.debug("++++++++++ Inside deleteProgram/{id} ++++++++");
		if(id != null && id.length()>0){
			int programId = new Integer(id);
			MedicalResearchProgram medicalResearchProgram = medicalResearchProgramService.getProgram(programId);
			if(medicalResearchProgram == null){
				System.out.println("Unable to delete. ParticipantInfo with id " + id + " not found");
				return new ResponseEntity<List<MedicalResearchProgram>>(HttpStatus.NOT_FOUND);
			}else{
				medicalResearchProgramService.deleteProgram(programId);
				List<MedicalResearchProgram> listProgramInfo = medicalResearchProgramService.getAllProgram();
				return new ResponseEntity<List<MedicalResearchProgram>>(listProgramInfo, HttpStatus.OK);
			}
		}else{
			return new ResponseEntity<List<MedicalResearchProgram>>(HttpStatus.BAD_REQUEST);
		}
	}

	//------------------- Insert a Medical Research Program --------------------------------------------------------
	
	@RequestMapping(value = "/newProgram", method = RequestMethod.GET)
	public ResponseEntity<List<MedicalResearchProgram>> newProgram(@RequestBody MedicalResearchProgram medicalResearchProgram) {
		logger.debug("++++++++++ Inside newProgram ++++++++");
		if(medicalResearchProgram.getProgram_Type() !=null){
		medicalResearchProgramService.addProgram(medicalResearchProgram);
		List<MedicalResearchProgram> listProgram = medicalResearchProgramService.getAllProgram();
			if(listProgram.isEmpty()){
				return new ResponseEntity<List<MedicalResearchProgram>>(HttpStatus.NO_CONTENT);
			}else{
				return new ResponseEntity<List<MedicalResearchProgram>>(listProgram, HttpStatus.OK);
			}
		}else{
			return new ResponseEntity<List<MedicalResearchProgram>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//------------------- Get a Medical Research Program --------------------------------------------------------
	
	@RequestMapping(value = "/getProgram/{id}", method = RequestMethod.GET)
	public ResponseEntity<MedicalResearchProgram> getProgram(@PathVariable String id) {
		logger.debug("++++++++++ Inside /getProgram/ ++++++++");
		if(id != null && id.length()>0){
			int programId = new Integer(id);
			MedicalResearchProgram medicalResearchProgram = medicalResearchProgramService.getProgram(programId);
			if(medicalResearchProgram == null){
				System.out.println("Unable to find. ParticipantInfo with id " + id + " not found");
				return new ResponseEntity<MedicalResearchProgram>(HttpStatus.NOT_FOUND);
			}else{
				return new ResponseEntity<MedicalResearchProgram>(medicalResearchProgram, HttpStatus.OK);
			}
		}else{
			return new ResponseEntity<MedicalResearchProgram>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//------------------- Modify a Medical Research Program --------------------------------------------------------
	
	@RequestMapping(value = "/modifyProgram", method = RequestMethod.GET)
	public ResponseEntity<List<MedicalResearchProgram>> modifyProgram(@RequestBody MedicalResearchProgram mprogram) {
		logger.debug("++++++++++ Inside /modifyProgram/ ++++++++");
		if(mprogram!=null){
			MedicalResearchProgram program = medicalResearchProgramService.getProgram(mprogram.getProgram_Id().intValue());
			program.setProgram_Type(mprogram.getProgram_Type());
			program.setStart_date(program.getStart_date());
			program.setEnd_date(program.getEnd_date());
			program.setCost(program.getCost());
			program.setState(program.getState());
			program.setSupervisor_Id(program.getSupervisor_Id());
			medicalResearchProgramService.updateProgram(program);
			
			List<MedicalResearchProgram> listProgram = medicalResearchProgramService.getAllProgram();
			if(listProgram.isEmpty()){
				return new ResponseEntity<List<MedicalResearchProgram>>(HttpStatus.NO_CONTENT);
			}else{
				return new ResponseEntity<List<MedicalResearchProgram>>(listProgram, HttpStatus.OK);
			}
		}else{
			return new ResponseEntity<List<MedicalResearchProgram>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/*
	 * http://localhost:8080/HCLDemoMedicalResearchCRUD/testWS/insertEmployee/
	 * {
		"name": "XXX ",
		"email":"XXX@hotmail.com",
		"address":"231 rockefeller rd",
		"telephone":" 202-231-2341"
	}
	 * 
	 */
	@RequestMapping(value = "/insertEmployee/", method = RequestMethod.POST)
	public ResponseEntity<List<Employee>> insertEmployee(@RequestBody Employee employee,UriComponentsBuilder ucBuilder) {
		logger.debug("++++++++++ Inside /insertEmployee/ ++++++++");
		if(employee.getName()!=null){
			employeeService.addEmployee(employee);
			List<Employee> listEmployee = employeeService.getAllEmployees();
			//You many decide to return HttpStatus.NOT_FOUND
			if(listEmployee.isEmpty()){
		            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		    }else{
		    	return new ResponseEntity<List<Employee>>(listEmployee, HttpStatus.OK);
		    }
		}else{
			return new ResponseEntity<List<Employee>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}