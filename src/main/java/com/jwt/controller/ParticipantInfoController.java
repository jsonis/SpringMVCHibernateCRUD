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

import com.jwt.model.ParticipantInfo;
import com.jwt.service.ParticipantInfoService;

@Controller
public class ParticipantInfoController {

	private static final Logger logger = Logger
			.getLogger(ParticipantInfoController.class);

	public ParticipantInfoController() {
		System.out.println("ParticipantInfoController()");
	}

	@Autowired
	private ParticipantInfoService participantInfoService;

	@RequestMapping(value = "/participant")
	public ModelAndView listParticipantInfo(ModelAndView model) throws IOException {
		List<ParticipantInfo> listParticipant = participantInfoService.getAllParticipant();
		model.addObject("listParticipant", listParticipant);
		model.setViewName("participantinfohome");
		return model;
	}

	@RequestMapping(value = "/newParticipantInfo", method = RequestMethod.GET)
	public ModelAndView newParticipantInfo(ModelAndView model) {
		ParticipantInfo participant = new ParticipantInfo();
		model.addObject("participant", participant);
		model.setViewName("participantinfoform");
		return model;
	}

	@RequestMapping(value = "/saveParticipantInfo", method = RequestMethod.POST)
	public ModelAndView saveParticipantInfo(@ModelAttribute ParticipantInfo participantInfo) {
		if (participantInfo.getId() == null || participantInfo.getId() ==0) { // if participant id is 0 then creating the
			// participant other updating the participant
			participantInfoService.addParticipantInfo(participantInfo);
		} else {
			participantInfoService.updateParticipantInfo(participantInfo);
		}
		return new ModelAndView("redirect:/participant");
	}

	@RequestMapping(value = "/deleteParticipantInfo", method = RequestMethod.GET)
	public ModelAndView deleteParticipant(HttpServletRequest request) {
		int participantId = Integer.parseInt(request.getParameter("id"));
		participantInfoService.deleteParticipant(participantId);
		return new ModelAndView("redirect:/participant");
	}

	@RequestMapping(value = "/editParticipantInfo", method = RequestMethod.GET)
	public ModelAndView editParticipantInfo(HttpServletRequest request) {
		int participantId = Integer.parseInt(request.getParameter("id"));
		ParticipantInfo participant = participantInfoService.getParticipant(participantId);

		ModelAndView model = new ModelAndView("participantinfohome");
		model.addObject("participant", participant);

		return model;
	}

}