package com.jwt.service;

import java.util.List;

import com.jwt.model.Employee;
import com.jwt.model.MedicalResearchProgram;
import com.jwt.model.ParticipantInfo;

public interface MPService {
	
	public void addProgram(MedicalResearchProgram medicalResearchProgram);

	public List<MedicalResearchProgram> getAllProgram();

	public void deleteProgram(Integer medicalResearchProgram);

	public MedicalResearchProgram getProgram(int programId);

	public MedicalResearchProgram updateProgram(MedicalResearchProgram medicalResearchProgram);
}
