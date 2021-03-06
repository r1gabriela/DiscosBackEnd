package com.cds.apirest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "album")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Album implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 6379521049078013135L;


	@Id
	@Column(name="idAlbum", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAlbum;
	
	@Column(name="nome", length = 255, nullable = false)
	private String nome;
	
	@Column(name="ano", length = 255, nullable = false)
	private String ano;
	
	@ManyToOne
	@JoinTable(
			name = "banda_album",
			joinColumns = @JoinColumn(
					name="album_idAlbum", referencedColumnName = "idAlbum"),
			inverseJoinColumns = @JoinColumn(
					name="banda_idBanda", referencedColumnName = "idBanda"))
	private Banda banda;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="usuario_idUsuario", referencedColumnName="idUsuario")
	private Usuario usuario;
	
	
}
