package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "NamedQuery1", 
		query = "select t"
			+ " from SampleEntity t"
			+ " where t.name = :name"
			+ " and t.age = :age"),
	@NamedQuery(name = "NamedQuery2", 
		query = "select t"
			+ " from SampleEntity t"
			+ " where t.name = :name"
			+ " and t.address = :address"),
})
@NamedNativeQueries({
	@NamedNativeQuery(name = "NamedNativeQuery1", 
		query = "selet *"
			+ " from SAMPLE_ENTITY t"
			+ " where t.NAME = :name"
			+ " and t.AGE = :age"),
	@NamedNativeQuery(name = "NamedNativeQuery2", 
		query = "select *"
			+ " from SAMPLE_ENTITY t"
			+ " where t.NAME = :name"
			+ " and t.ADDRESS = :address"),
})
public class SampleEntity {
	@Id
	@Column(name = "NAME")
	private String name;
	@Column(name = "AGE")
	private String age;
	@Column(name = "JOB")
	private String job; 
	@Column(name = "ADDRESS")
	private String address;
	
	public SampleEntity(){}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}
