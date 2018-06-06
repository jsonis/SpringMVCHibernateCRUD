package com.jwt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.ParticipantInfo;

@Repository
public class ParticipantInfoDAOImpl implements ParticipantInfoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addParticipantInfo(ParticipantInfo participantInfo) {
		sessionFactory.getCurrentSession().saveOrUpdate(participantInfo);

	}

	@SuppressWarnings("unchecked")
	public List<ParticipantInfo> getAllParticipant() {
		return sessionFactory.getCurrentSession().createQuery("from ParticipantInfo")
				.list();
	}

	@Override
	public void deleteParticipant(Integer id) {
		ParticipantInfo participantInfo = new ParticipantInfo();
		participantInfo.setId(new Long(id));
		this.sessionFactory.getCurrentSession().delete(participantInfo);
	}

	public ParticipantInfo getParticipant(int participantId) {
		return (ParticipantInfo) sessionFactory.getCurrentSession().get(
				ParticipantInfo.class, new Long(participantId));
	}

	@Override
	public ParticipantInfo updateParticipantInfo(ParticipantInfo participantInfo) {
		sessionFactory.getCurrentSession().update(participantInfo);
		return participantInfo;
	}

}