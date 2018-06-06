package com.jwt.service;

import java.util.List;

import com.jwt.model.Employee;
import com.jwt.model.ParticipantInfo;

public interface ParticipantInfoService {
	
	public void addParticipantInfo(ParticipantInfo participantInfo);

	public List<ParticipantInfo> getAllParticipant();

	public void deleteParticipant(Integer participantInfo);

	public ParticipantInfo getParticipant(int participantInfo);

	public ParticipantInfo updateParticipantInfo(ParticipantInfo participantInfo);
}
