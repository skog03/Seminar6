package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "GradeTable")
@Entity
public class Grade {
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idg")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idg;
	
	@Min(1)
	@Max(10)
	@Column(name = "Grvalue")
	private int grvalue;
	
	@ManyToOne
	@JoinColumn(name = "Ids")//need to specify another class id column name
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "Idc")//need to specify another class id column name
	private Course course;
	
	
	public Grade(int grvalue, Student student, Course course) {
		setGrvalue(grvalue);
		setStudent(student);
		setCourse(course);
	}
	
	
}