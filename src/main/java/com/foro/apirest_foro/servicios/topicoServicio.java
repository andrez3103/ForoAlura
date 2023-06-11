package com.foro.apirest_foro.servicios;

import java.util.List;

import com.foro.apirest_foro.modelos.topicos;

public interface topicoServicio {
	
	public List<topicos> obtenerTodo();
	public topicos guardar(topicos topicos);
	public topicos obtenerPorId(long id);
	public void eliminar(long id);

}
