package com.jwt.dao;

import java.util.List;

import com.jwt.model.Employee;
import com.jwt.model.MedicalResearchProgram;
import com.jwt.model.ParticipantInfo;

public interface MedicalResearchProgramDAO {

	public void addProgram(MedicalResearchProgram medicalResearchProgram);

	public List<MedicalResearchProgram> getAllProgram();

	public void deleteProgram(Integer programId);

	public MedicalResearchProgram updateProgram(MedicalResearchProgram medicalResearchProgram);

	public MedicalResearchProgram getProgram(int programId);
}
