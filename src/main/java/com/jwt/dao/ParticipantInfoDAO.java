package com.jwt.dao;

import java.util.List;

import com.jwt.model.Employee;
import com.jwt.model.ParticipantInfo;

public interface ParticipantInfoDAO {

	public void addParticipantInfo(ParticipantInfo participantInfo);

	public List<ParticipantInfo> getAllParticipant();

	public void deleteParticipant(Integer participantInfo);

	public ParticipantInfo updateParticipantInfo(ParticipantInfo participantInfo);

	public ParticipantInfo getParticipant(int participantId);
}
