package org.hibernate.example.entity;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.example.enumeration.InstrumentType;

@Entity
@Table(name="musical_instrument")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="instrument_type", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("")
public abstract class MusicalInstrument implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "musical_instrument_seq")
	@SequenceGenerator(name = "musical_instrument_seq", sequenceName = "musical_instrument_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "id")
    private Long id;

	@Version
    @Column(name = "version")
    private Integer version;
    /**
     */
    @Column(name="instrument_type")
    @Enumerated(EnumType.STRING)
    private InstrumentType instrumentType;
    
    private BigDecimal cost;
    
    private String manufacturer;
    
    private String model;
    
    @Override
	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public InstrumentType getInstrumentType() {
		return instrumentType;
	}

	public void setInstrumentType(InstrumentType instrumentType) {
		this.instrumentType = instrumentType;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}	
    
    
}
