package com.foro.apirest_foro.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foro.apirest_foro.modelos.topicos;

@Repository
public interface topicoRepositorio  extends JpaRepository<topicos, Long >{

}
