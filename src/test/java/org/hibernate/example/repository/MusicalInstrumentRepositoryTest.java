package org.hibernate.example.repository;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.inject.Inject;

import org.apache.commons.codec.binary.Base64;
import org.dbunit.database.IDatabaseConnection;
import org.hibernate.example.entity.Guitar;
import org.hibernate.example.enumeration.GuitarType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:META-INF/spring/applicationContext.xml","classpath:META-INF/spring/applicationContext-test.xml"} )
public class MusicalInstrumentRepositoryTest {
		private static final Logger LOGGER = LoggerFactory.getLogger(MusicalInstrumentRepositoryTest.class);
		@Inject
		private MusicalInstrumentRepository musicalInstrumentRepository;

		
		
		@Test
		public void testSave() throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
			Guitar guitar= new Guitar();
			guitar.setCost(BigDecimal.TEN);
			guitar.setGuitarType(GuitarType.SIXSTRING);
			guitar.setManufacturer("Ibanez");
			guitar.setModel("Artcore");
			guitar.setBodyDescription("Semi-hollowbody"); // center is hollow but the wings are solid hardwood
			guitar=saveIt(guitar);			
			assertNotNull(guitar.getId());
		}
		

		
		@Transactional 
		public Guitar saveIt(Guitar guitar) {
			guitar=(Guitar)musicalInstrumentRepository.saveAndFlush((Guitar)guitar);
			return guitar;
		}

		

}
