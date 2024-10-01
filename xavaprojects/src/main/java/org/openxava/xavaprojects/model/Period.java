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
    @Index(name = "idx_start_date", columnList = "startDate"), // tmr schema-evolution.sql
    @Index(name = "idx_end_date", columnList = "endDate") // tmr schema-evolution.sql
})
//tmr fin
public class Period extends Nameable {
	
	LocalDate startDate; // tmr schema-evolution.sql
	LocalDate endDate; // tmr schema-evolution.sql
	
}
