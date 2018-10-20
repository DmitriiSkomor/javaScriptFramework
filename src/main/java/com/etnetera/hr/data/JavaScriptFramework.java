package com.etnetera.hr.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Simple data entity describing basic properties of every JavaScript framework.
 * 
 * @author Etnetera
 *
 */
@Entity
@Table(uniqueConstraints={
		@UniqueConstraint(columnNames = {"name", "version"})
})
public class JavaScriptFramework implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}


	@Column(nullable=false, length = 30, name="version")
	private String version;

	@Column(nullable=false, length = 30, name="name")
	private String name;

	@Column(name="deprecationdate")
	private Date deprecationDate;

	@Column(name="hypelevel")
	private int hypeLevel;



	public JavaScriptFramework() {
		name = "defoultName";
		version = "defaultVersion";
	}

	public Date getDeprecationDate() {
		return deprecationDate;
	}

	public void setDeprecationDate(Date depricationDate) {
		this.deprecationDate = depricationDate;
	}

	public int getHypeLevel() {
		return hypeLevel;
	}

	public void setHypeLevel(int hypeLevel) {
		this.hypeLevel = hypeLevel;
	}


	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public JavaScriptFramework(String name) {
		this.name = name;
		version = "defaultVersion";
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "JavaScriptFramework [id=" + id + ", name=" + name + "]";
	}

}
