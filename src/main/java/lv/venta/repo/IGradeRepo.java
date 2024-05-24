package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Long> {

	//public abstract by default
	ArrayList<Grade> findByGrvalueLessThan(int i);
	//public abstract by default
	ArrayList<Grade> findByStudentIds(long id);

}