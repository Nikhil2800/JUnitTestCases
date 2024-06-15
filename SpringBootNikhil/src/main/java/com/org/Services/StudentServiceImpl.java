package com.org.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.Dao.StudentDao;
import com.org.entities.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	
//	List<Student> list;
	
	public StudentServiceImpl() {
//		list=new ArrayList<>();
//		list.add(new Student(1,"Nikhil Shinde","Sangli"));
//		list.add(new Student(2,"Anil Shinde","Sangli"));
//		list.add(new Student(3,"Rohit Shinde","Satara"));
	}

	@Override
	public List<Student> getAllStudent() {
	
//		return list;
		return studentDao.findAll();
	}

	@Override
	public Student getStudent(long studentid) {
//		Student c=null;
//		for(Student stud:list) {
//			if(stud.getId()==studentid) {
//				c=stud;
//			}
//		}
//		return c;
		Optional<Student> findById = studentDao.findById(studentid);
		return findById.get();
	}

	@Override
	public Student addStudent(Student student) {
//		list.add(student);
//		return student;
		
		return studentDao.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
//		list.forEach(e->{
//			if(e.getId()==student.getId()) {
//				e.setName(student.getName());
//				e.setCity(student.getCity());
//			}
//		});
//		return student;
		
		studentDao.save(student);
		return student;
	}

	@Override
	public boolean deleteStudent(long studentid) {
//		list=this.list.stream().filter((e)->e.getId()!=studentid).collect(Collectors.toList());
		Optional<Student> studopt = studentDao.findById(studentid);
		if(studopt.isPresent()) {
			studentDao.delete(studopt.get());
			return true;
		}else {
			return false;
		}
	}


	

}
