package org.cibertec.edu.pe.service;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.interfaceService.IProductosServices;
import org.cibertec.edu.pe.interfaces.IProductos;
import org.cibertec.edu.pe.modelo.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosService implements IProductosServices {

	@Autowired
	private IProductos data;
	
	@Override
	public List<Productos> Listado() {
		return (List<Productos>)data.findAll();
	}

	@Override
	public Optional<Productos> Buscar(int id) {
		return data.findById(id);
	}

	@Override
	public void Insertar(Productos p) {
		data.save(p);
	}

	@Override
	public void Modificar(Productos p) {
		data.save(p);
	}

	@Override
	public void Suprimir(int id) {
		data.deleteById(id);
	}

}
