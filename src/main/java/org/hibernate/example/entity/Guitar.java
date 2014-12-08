package org.hibernate.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.example.enumeration.GuitarType;
import org.hibernate.example.enumeration.InstrumentType;

@Entity
@Table(name = "guitar")
@DiscriminatorValue("GUITAR")
public class Guitar extends MusicalInstrument implements Serializable {
	
	@Column(name = "guitar_type")
	@Enumerated(EnumType.STRING)
	private GuitarType guitarType;

	private String bodyDescription;

	public Guitar() {
		super();
		this.setInstrumentType(InstrumentType.GUITAR);
	}


	public GuitarType getGuitarType() {
		return guitarType;
	}

	public void setGuitarType(GuitarType guitarType) {
		this.guitarType = guitarType;
	}

	public String getBodyDescription() {
		return bodyDescription;
	}

	public void setBodyDescription(String bodyDescription) {
		this.bodyDescription = bodyDescription;
	}

	
}
