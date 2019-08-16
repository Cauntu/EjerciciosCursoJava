package es.jdbc.service;

import java.util.List;

import es.eoi.jdbc.entity.Alumno;
import es.eoi.jdbc.repository.AlumnoRepository;
import es.eoi.jdbc.repository.AlumnoRepositoryImpl;

public class AlumnoServiceImpl implements AlumnoService {

	private AlumnoRepository repo = new AlumnoRepositoryImpl();

	public Alumno findByDni(String dni) {
		return this.repo.findByDni(dni);
	}

	public List<Alumno> findAll() {
		return this.repo.findAll();
	}

	public boolean create(Alumno nuevoAlumno) {
		return this.repo.create(nuevoAlumno);
	}

	public boolean delete(String dni) {
		return this.repo.delete(dni);
	}

	public boolean update(String dni, String nombre, String apellidos) {
		return this.repo.update(dni, nombre, apellidos);
	}

}
