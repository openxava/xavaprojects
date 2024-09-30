package org.openxava.xavaprojects.model;

import java.time.*;

import javax.persistence.*;

import lombok.*;

/**
 * 
 * @author Javier Paniza
 */
@Entity @Getter @Setter
// tmr ini
@Table(indexes = {
	@Index(name = "idx_period_dates", columnList = "startDate, endDate") // tmr schema-evolution.sql 
})
//tmr fin
public class Period extends Nameable {
	
	LocalDate startDate; // tmr schema-evolution.sql
	LocalDate endDate; // tmr schema-evolution.sql
	
}
