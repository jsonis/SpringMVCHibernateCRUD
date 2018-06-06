package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.EmployeeDAO;
import com.jwt.dao.MedicalResearchProgramDAO;
import com.jwt.dao.ParticipantInfoDAO;
import com.jwt.model.Employee;
import com.jwt.model.MedicalResearchProgram;
import com.jwt.model.ParticipantInfo;

@Service
@Transactional
public class MedicalResearchProgramServiceImpl implements MedicalResearchProgramService {

	@Autowired
	private MedicalResearchProgramDAO medicalResearchProgramDAO;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addProgram(MedicalResearchProgram participantInfo) {
		medicalResearchProgramDAO.addProgram(participantInfo);
	}

	@Override
	@Transactional
	public List<MedicalResearchProgram> getAllProgram() {
		return medicalResearchProgramDAO.getAllProgram();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteProgram(Integer programId) {
		medicalResearchProgramDAO.deleteProgram(programId);
	}

	@Override
	public MedicalResearchProgram getProgram(int programId) {
		return medicalResearchProgramDAO.getProgram(programId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public MedicalResearchProgram updateProgram(MedicalResearchProgram medicalResearchProgram) {
		// TODO Auto-generated method stub
		return medicalResearchProgramDAO.updateProgram(medicalResearchProgram);
	}

	public void setParticipantInfoDAO(MedicalResearchProgramDAO medicalResearchProgramDAO) {
		this.medicalResearchProgramDAO = medicalResearchProgramDAO;
	}

	

}
