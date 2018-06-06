package com.jwt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Employee;
import com.jwt.model.MedicalResearchProgram;
import com.jwt.model.ParticipantInfo;

@Repository
public class MedicalResearchProgramDAOImpl implements MedicalResearchProgramDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addProgram(MedicalResearchProgram program) {
		sessionFactory.getCurrentSession().saveOrUpdate(program);

	}

	@SuppressWarnings("unchecked")
	public List<MedicalResearchProgram> getAllProgram() {
		return sessionFactory.getCurrentSession().createQuery("from MedicalResearchProgram")
				.list();
	}

	@Override
	public void deleteProgram(Integer programId) {
		// MedicalResearchProgram record cant be deleted till we retrieve all participant records and delete them
		MedicalResearchProgram program = (MedicalResearchProgram) sessionFactory.getCurrentSession().load(
				MedicalResearchProgram.class, new Long(programId.intValue()));
		
		List<ParticipantInfo> participantInfoList = (sessionFactory.getCurrentSession().createQuery("from ParticipantInfo where program_Id =:program_Id").setParameter("program_Id", programId).list());
		System.out.println("Size::"+participantInfoList.size());
		
		for(ParticipantInfo participantInfo : participantInfoList){
			 this.sessionFactory.getCurrentSession().delete(participantInfo);
		}
		
		if (null != program) {
			this.sessionFactory.getCurrentSession().delete(program);
		}

	}

	public MedicalResearchProgram getProgram(int programId) {
		return (MedicalResearchProgram) sessionFactory.getCurrentSession().get(
				MedicalResearchProgram.class, new Long(programId));
	}

	@Override
	public MedicalResearchProgram updateProgram(MedicalResearchProgram medicalResearchProgram) {
		sessionFactory.getCurrentSession().update(medicalResearchProgram);
		return medicalResearchProgram;
	}

}