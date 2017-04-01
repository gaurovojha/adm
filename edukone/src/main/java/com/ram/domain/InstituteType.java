package com.ram.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class InstituteType {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long instituteId;
	private long instituteOfferingId;
	private int fee;
	private Board board;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(long instituteId) {
		this.instituteId = instituteId;
	}
	public long getInstituteOfferingId() {
		return instituteOfferingId;
	}
	public void setInstituteOfferingId(long instituteOfferingId) {
		this.instituteOfferingId = instituteOfferingId;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
}