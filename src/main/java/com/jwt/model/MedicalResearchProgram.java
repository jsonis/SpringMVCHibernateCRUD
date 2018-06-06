package com.jwt.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author jsonis
 *
 */
@Entity
//@XmlRootElement
@Table(name = "MEDICALRESEARCHPROGRAM")
public class MedicalResearchProgram {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long program_Id ;
	
	@Column(name="supervisor_id",nullable=false)
	private String supervisor_Id;

	private String program_Type;
	
	private String state;
	
	private Date start_date;
	
	private Date end_date;
	
	private int cost;
	
	private String funding_status;
	
	private byte[] attachment;

	public MedicalResearchProgram(){}

	public String getSupervisor_Id() {
		return supervisor_Id;
	}
	public Long getProgram_Id() {
		return program_Id;
	}
	public void setProgram_Id(Long program_Id) {
		this.program_Id = program_Id;
	}
	public void setSupervisor_Id(String supervisor_Id) {
		this.supervisor_Id = supervisor_Id;
	}
	public String getProgram_Type() {
		return program_Type;
	}
	public void setProgram_Type(String program_Type) {
		this.program_Type = program_Type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getFunding_status() {
		return funding_status;
	}
	public void setFunding_status(String funding_status) {
		this.funding_status = funding_status;
	}
	public byte[] getAttachment() {
		return attachment;
	}
	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}

	public MedicalResearchProgram(Date start_date,
			Date end_date, String funding_status, byte[] attachment,
			String program_Type, String state, int cost) {
		super();
		this.start_date = start_date;
		this.end_date = end_date;
		this.funding_status = funding_status;
		this.attachment = attachment;
		this.program_Type = program_Type;
		this.state = state;
		this.cost = cost;
	}

	
	
}
