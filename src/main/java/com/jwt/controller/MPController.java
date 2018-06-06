package com.jwt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.MedicalResearchProgram;
import com.jwt.model.ParticipantInfo;
import com.jwt.service.MPService;
import com.jwt.service.MedicalResearchProgramService;
import com.jwt.service.ParticipantInfoService;

@Controller
public class MPController {

	private static final Logger logger = Logger
			.getLogger(MPController.class);

	public MPController() {
		System.out.println("MPController()");
	}

	@Autowired
	private MPService mpService;
	
	@Autowired
	private ParticipantInfoService participantInfoService;
	
	@RequestMapping(value = "/showAll")
	public ModelAndView listProgram(ModelAndView model) throws IOException {
		List<MedicalResearchProgram> listProgram = mpService.getAllProgram();
		List<ParticipantInfo> listParticipantInfo = participantInfoService.getAllParticipant();										
		model.addObject("listProgram", listProgram);
		model.addObject("listParticipant", listParticipantInfo);
		model.setViewName("medicalparticipanthome");
		return model;
	}
	
	
	

//	@RequestMapping(value = "/newProgram", method = RequestMethod.GET)
//	public ModelAndView newProgram(ModelAndView model) {
//		MedicalResearchProgram program = new MedicalResearchProgram();
//		model.addObject("program", program);
//		model.setViewName("ProgramInfoForm");
//		return model;
//	}
//
//	@RequestMapping(value = "/saveProgram", method = RequestMethod.POST)
//	public ModelAndView saveProgram(@ModelAttribute MedicalResearchProgram medicalResearchProgram) {
//		if (medicalResearchProgram.getProgram_Id() == null || medicalResearchProgram.getProgram_Id() ==0) { // if program id is 0 then creating the
//			// program other updating the program
//			medicalResearchProgramService.addProgram(medicalResearchProgram);
//		} else {
//			medicalResearchProgramService.updateProgram(medicalResearchProgram);
//		}
//		return new ModelAndView("redirect:/");
//	}
//
//	@RequestMapping(value = "/deleteProgram", method = RequestMethod.GET)
//	public ModelAndView deleteProgram(HttpServletRequest request) {
//		int programId = Integer.parseInt(request.getParameter("id"));
//		medicalResearchProgramService.deleteProgram(programId);
//		return new ModelAndView("redirect:/");
//	}
//
//	@RequestMapping(value = "/editProgram", method = RequestMethod.GET)
//	public ModelAndView editProgram(HttpServletRequest request) {
//		int programId = Integer.parseInt(request.getParameter("id"));
//		MedicalResearchProgram program = medicalResearchProgramService.getProgram(programId);
//		ModelAndView model = new ModelAndView("ProgramInfoForm");
//		model.addObject("program", program);
//		return model;
//	}

}