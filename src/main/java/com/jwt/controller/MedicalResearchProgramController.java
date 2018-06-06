package com.jwt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.MedicalResearchProgram;
import com.jwt.model.ParticipantInfo;
import com.jwt.service.MedicalResearchProgramService;
import com.jwt.service.ParticipantInfoService;

@Controller
public class MedicalResearchProgramController {

	private static final Logger logger = Logger
			.getLogger(MedicalResearchProgramController.class);

	public MedicalResearchProgramController() {
		System.out.println("MedicalResearchProgramController()");
	}

	@Autowired
	private MedicalResearchProgramService medicalResearchProgramService;

	@RequestMapping(value = "/")
	public ModelAndView listProgram(ModelAndView model) throws IOException {
		logger.debug("++++++++++ /listProgram ++++++++");
		List<MedicalResearchProgram> listProgram = medicalResearchProgramService.getAllProgram();
		model.addObject("listProgram", listProgram);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/newProgram", method = RequestMethod.GET)
	public ModelAndView newProgram(ModelAndView model) {
		logger.debug("++++++++++ /newProgram ++++++++");
		MedicalResearchProgram program = new MedicalResearchProgram();
		model.addObject("program", program);
		model.setViewName("programinfoform");
		return model;
	}

	@RequestMapping(value = "/saveProgram", method = RequestMethod.POST)
	public ModelAndView saveProgram(@ModelAttribute MedicalResearchProgram medicalResearchProgram) {
		logger.debug("++++++++++ /saveProgram ++++++++");
		if (medicalResearchProgram.getProgram_Id() == null || medicalResearchProgram.getProgram_Id() ==0) { // if program id is 0 then creating the
			// program other updating the program
			medicalResearchProgramService.addProgram(medicalResearchProgram);
		} else {
			medicalResearchProgramService.updateProgram(medicalResearchProgram);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteProgram", method = RequestMethod.GET)
	public ModelAndView deleteProgram(HttpServletRequest request) {
		logger.debug("++++++++++ /deleteProgram ++++++++");
		int programId = Integer.parseInt(request.getParameter("id"));
		medicalResearchProgramService.deleteProgram(programId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editProgram", method = RequestMethod.GET)
	public ModelAndView editProgram(HttpServletRequest request) {
		logger.debug("++++++++++ /editProgram ++++++++");
		int programId = Integer.parseInt(request.getParameter("id"));
		MedicalResearchProgram program = medicalResearchProgramService.getProgram(programId);
		ModelAndView model = new ModelAndView("programinfoform");
		model.addObject("program", program);
		return model;
	}

}