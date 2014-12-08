package org.hibernate.example.repository;

import org.hibernate.example.entity.MusicalInstrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicalInstrumentRepository extends JpaRepository< MusicalInstrument, Long >{

 
}
