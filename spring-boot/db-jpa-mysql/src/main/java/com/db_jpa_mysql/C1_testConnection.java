package com.db_jpa_mysql;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class C1_testConnection {
	
	@Autowired
	private Sone s;
	
	@GetMapping(path="/")
	public Object test() {
		return "HI";
	}
	

	@GetMapping(path="/fetch")
	public Object fetch() {
		var r = s.mone();
		return r;
	}
	
	@GetMapping(path="/save/{id}")
	public String save(@PathVariable int id) {
		s.mtwo(id);
		return "saved...";
	}

}

@Service
class Sone{
	@Autowired
	Rone r ;
	List<Eone> mone(){
		return r.findAll();
	}
	void mtwo(int id){
		Eone e = new Eone();
		e.setId(id);
		e.setName("");
		r.save(e);
	}
}

@Entity
@Table(name="tb_1")	
class Eone{
	@Id
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

@Repository
interface Rone extends JpaRepository<Eone, Integer>{
	
}
