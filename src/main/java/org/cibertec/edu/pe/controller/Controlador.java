package org.cibertec.edu.pe.controller;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.interfaceService.IProductosServices;
import org.cibertec.edu.pe.modelo.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class Controlador {

	@Autowired
	private IProductosServices servicio;
	
	@GetMapping("/listar")
	public String Listar(Model modelo) {
		List<Productos> productos = servicio.Listado();
		modelo.addAttribute("productos",productos);
		return "index";
	}

	@GetMapping("/new")
	public String agregar(Model modelo) {
		modelo.addAttribute("producto", new Productos());
		return "form";
	}
	
	@PostMapping("/save")
	public String save(@Validated Productos p, Model modelo) {
		servicio.Insertar(p);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model modelo) {
		Optional<Productos> p = servicio.Buscar(id);
		modelo.addAttribute("producto",p);
		return "form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id, Model modelo) {
		servicio.Suprimir(id);
		return "redirect:/listar";
	}
}
