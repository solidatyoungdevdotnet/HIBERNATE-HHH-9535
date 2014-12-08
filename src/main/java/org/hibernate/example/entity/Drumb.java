package org.hibernate.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.example.enumeration.DrumbStyle;
import org.hibernate.example.enumeration.InstrumentType;

@Entity
@Table(name = "drumb")
@DiscriminatorValue("DRUMB")
public class Drumb extends MusicalInstrument implements Serializable {

	@Column(name = "style")
	@Enumerated(EnumType.STRING)
	private DrumbStyle style;

	public Drumb() {
		super();
		this.setInstrumentType(InstrumentType.DRUMB);
	}

	public DrumbStyle getStyle() {
		return style;
	}

	public void setStyle(DrumbStyle style) {
		this.style = style;
	}

}
