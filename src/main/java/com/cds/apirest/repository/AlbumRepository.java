package com.cds.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cds.apirest.entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer>{

}