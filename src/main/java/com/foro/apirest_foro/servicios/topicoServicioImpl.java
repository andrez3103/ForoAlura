package com.foro.apirest_foro.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foro.apirest_foro.modelos.topicos;
import com.foro.apirest_foro.repositorios.topicoRepositorio;


@Service
public class topicoServicioImpl implements topicoServicio{
	
	@Autowired 
	
	topicoRepositorio topicoRepositorio;
	
	@Override
	public List<topicos> obtenerTodo(){
		return topicoRepositorio.findAll();
	}
	
	@Override
	public topicos guardar(topicos topicos){
		return topicoRepositorio.save(topicos);
	}
	
	@Override
	public topicos obtenerPorId(long id){
		return topicoRepositorio.findById(id).orElse(null);
	}
	
	@Override
	public void eliminar(long id){
		topicoRepositorio.deleteById(id);
	}


}
