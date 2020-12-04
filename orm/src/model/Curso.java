package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso {
	//Posso definir como vai ser minha coluna @Column(name="",nullable=false)..
	//Transient eu não criaria uma coluna, apenas ignora 
	
	//Definindo que cada entidade vai ter seu próprio ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCurso;
	
	private String nome;
	
	private String ementa;
	
	private String cargaHoraria;
	
	private String categoria;
	
	public Curso(String nome, String ementa, String cargaHoraria, String categoria) {
		super();
		this.nome = nome;
		this.ementa = ementa;
		this.cargaHoraria = cargaHoraria;
		this.categoria = categoria;
	}
	
	public Curso() {
		
	}	
	
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmenta() {
		return ementa;
	}
	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	public String getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
	
}
