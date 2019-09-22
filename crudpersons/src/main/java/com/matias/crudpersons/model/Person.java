package com.matias.crudpersons.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Persons")
public class Person {

	@Id
    @Column(name = "perId", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long perId;

	@Column(name = "perNombre")
	private String perNombre;

	@Column(name = "perApellido")
	private String perApellido;

	@Column(name = "perFechaNacimiento")
	private Date perFechaNacimiento;

	@Column(name = "perNumeroDocumento")
	private long perNumeroDocumento;

	@Column(name = "perTipoDocumento")
	private String perTipoDocumento;

	public Person() {

	}

	public Person(String perApellido, Date perFechaNacimiento, String perNombre, long perNumeroDocumento, String perTipoDocumento) {
		this.perApellido = perApellido;
		this.perFechaNacimiento = perFechaNacimiento;
		this.perNombre = perNombre;
		this.perNumeroDocumento = perNumeroDocumento;
		this.perTipoDocumento = perTipoDocumento;
	}

	public String getPerApellido() {
		return perApellido;
	}

	public void setPerApellido(String perApellido) {
		this.perApellido = perApellido;
	}

	public Date getPerFechaNacimiento() {
		return perFechaNacimiento;
	}

	public void setPerFechaNacimiento(Date perFechaNacimiento) {
		this.perFechaNacimiento = perFechaNacimiento;
	}

	public long getPerId() {
		return perId;
	}

	public void setPerId(long perId) {
		this.perId = perId;
	}

	public String getPerNombre() {
		return perNombre;
	}

	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}

	public long getPerNumeroDocumento() {
		return perNumeroDocumento;
	}

	public void setPerNumeroDocumento(long perNumeroDocumento) {
		this.perNumeroDocumento = perNumeroDocumento;
	}

	public String getPerTipoDocumento() {
		return perTipoDocumento;
	}

	public void setPerTipoDocumento(String perTipoDocumento) {
		this.perTipoDocumento = perTipoDocumento;
	}

}
