package com.foro.apirest_foro.controladores;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foro.apirest_foro.modelos.topicos;
import com.foro.apirest_foro.servicios.topicoServicioImpl;

@RestController
@RequestMapping("/api/v1")
public class topicoControlador {

	@Autowired
	topicoServicioImpl topicoServicio;

	@GetMapping("/topicos")

	public List<topicos> obtenerTopicos() {

		return topicoServicio.obtenerTodo();

	}

	@PostMapping("/guardar")
	public ResponseEntity<topicos> guardarTopico(@RequestBody topicos topicos){
		
		topicos nuevo_topico = topicoServicio.guardar(topicos);
		return new ResponseEntity<>(nuevo_topico,HttpStatus.CREATED);
	}
	
	@GetMapping("/topicos/{id}")
	public ResponseEntity<topicos> obtenerTopicosId(@PathVariable long id){
		topicos topicoPorId = topicoServicio.obtenerPorId(id);
		return ResponseEntity.ok(topicoPorId);
	}
	
	public ResponseEntity<topicos> actualizarTopico(@PathVariable long id,@RequestBody topicos topicos)
	{
		topicos topicosPorId = topicoServicio.obtenerPorId(id);
		topicosPorId.setAutor(topicos.getAutor());
		topicosPorId.setCurso(topicos.getCurso());
		topicosPorId.setEstatus(topicos.getEstatus());
		topicosPorId.setFecha_creacion(topicos.getMensaje());
		topicosPorId.setMensaje(topicos.getMensaje());
		topicosPorId.setTitulo(topicos.getTitulo());
		
		topicos topicos_actualizados = topicoServicio.guardar(topicosPorId);
		return new ResponseEntity<>(topicos_actualizados,HttpStatus.CREATED);
		
	}
	@DeleteMapping("/topicos/{id}")
	
	public ResponseEntity<HashMap<String,Boolean>> eliminarTopico(@PathVariable long id){
		this.topicoServicio.eliminar(id);
		
		HashMap<String , Boolean> estadoTopicoEliminado = new HashMap<>();
		estadoTopicoEliminado.put("eliminado", true);
		return ResponseEntity.ok(estadoTopicoEliminado);
	}

}
