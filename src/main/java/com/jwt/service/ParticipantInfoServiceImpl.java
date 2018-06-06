package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.EmployeeDAO;
import com.jwt.dao.ParticipantInfoDAO;
import com.jwt.model.Employee;
import com.jwt.model.ParticipantInfo;

@Service
@Transactional
public class ParticipantInfoServiceImpl implements ParticipantInfoService {

	@Autowired
	private ParticipantInfoDAO participantInfoDAO;

	@Override
	@Transactional
	public void addParticipantInfo(ParticipantInfo participantInfo) {
		participantInfoDAO.addParticipantInfo(participantInfo);
	}

	@Override
	@Transactional
	public List<ParticipantInfo> getAllParticipant() {
		return participantInfoDAO.getAllParticipant();
	}

	@Override
	@Transactional
	public void deleteParticipant(Integer participantId) {
		participantInfoDAO.deleteParticipant(participantId);
	}

	@Override
	public ParticipantInfo getParticipant(int participantId) {
		return participantInfoDAO.getParticipant(participantId);
	}

	@Override
	public ParticipantInfo updateParticipantInfo(ParticipantInfo participantInfo) {
		// TODO Auto-generated method stub
		return participantInfoDAO.updateParticipantInfo(participantInfo);
	}

	public void setParticipantInfoDAO(ParticipantInfoDAO participantInfoDAO) {
		this.participantInfoDAO = participantInfoDAO;
	}

	

}
