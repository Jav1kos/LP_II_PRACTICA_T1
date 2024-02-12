package org.cibertec.edu.pe.interfaceService;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.modelo.Productos;

public interface IProductosServices {

	public List<Productos> Listado();
	public Optional<Productos> Buscar(int id);
	public void Insertar(Productos p);
	public void Modificar(Productos p);
	public void Suprimir(int id);
	
}
