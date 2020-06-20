package com.cds.apirest.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "banda")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Banda implements Serializable {

	private static final long serialVersionUID = -8132444940965202534L;
	
	@Id
	@Column(name = "idBanda", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idBanda;
	
	@Column(name = "nome", nullable=false, length= 255)
	private String nome;
	
	@Column(name = "genero", nullable=false, length= 255)
	private String genero;
	
	@OneToMany
	@JoinTable(
			name = "banda_album",
			joinColumns = @JoinColumn(
					name="banda_idBanda", referencedColumnName = "idBanda"),
			inverseJoinColumns = @JoinColumn(
					name="album_idAlbum", referencedColumnName = "idAlbum"))
	private List<Album> albuns;
	
}