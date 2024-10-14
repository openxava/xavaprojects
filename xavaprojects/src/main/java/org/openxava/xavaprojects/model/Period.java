package org.openxava.xavaprojects.model;

import java.time.*;

import javax.persistence.*;

import lombok.*;

/**
 * 
 * @author Javier Paniza
 */
@Entity @Getter @Setter
@Table(indexes = {
    @Index(name = "idx_start_date", columnList = "startDate"), 
    @Index(name = "idx_end_date", columnList = "endDate") 
})
public class Period extends Nameable {
	
	LocalDate startDate; 
	LocalDate endDate; 
	
}
