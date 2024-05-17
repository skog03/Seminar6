package lv.venta.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "CourseTable")
@Entity
public class Course {
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idc")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idc;
	
	@NotNull
	@Pattern(regexp = "[A-Za-z ]+")
	@Size(min = 5, max = 20)
	@Column(name = "Title")
	private String title;
	
	@Min(1)
	@Max(20)
	@Column(name = "Creditpoints")
	private int creditpoints;
	
	@OneToOne
	@JoinColumn(name = "Idp") //need to specify column name
	private Professor professor;
	
	@OneToMany(mappedBy = "course")
	@ToString.Exclude
	private Collection<Grade> grades;
	
	public Course(String title, int creditpoints, Professor professor)
	{
		setTitle(title);
		setCreditpoints(creditpoints);
		setProfessor(professor);
	}
	
	
	
	
}