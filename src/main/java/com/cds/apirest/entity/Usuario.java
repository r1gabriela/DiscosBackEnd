package com.cds.apirest.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="usuario")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1590055907044646815L;
	
	@Id
	@Column(name="idUsuario", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idUsuario;
	
	@Column(name="username", length = 255, nullable = false)
	private String username;
	
	@Column(name="password", length = 255, nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	List<Album> albuns;


}
