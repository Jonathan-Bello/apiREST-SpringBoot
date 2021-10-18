package ws.estudiante;

import java.util.List;
import java.util.NoSuchElementException;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

	@Autowired
	private EstudianteService service;

	@GetMapping()
	public List<Estudiante> list() {
		return service.listAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Estudiante> get(@PathVariable Integer id) {
		Estudiante estudiante = service.get(id);
		return new ResponseEntity<Estudiante>(estudiante, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<String> update(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		try {
			Estudiante auxEstudiante = service.get(id);
			estudiante.setNumControl(auxEstudiante.getNumControl());
			service.save(estudiante);
			return new ResponseEntity<String>("El estudiante fue actualizado correctamente", HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>("El estudiante con el número de control proporcionado no está registrado",
					HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping()
	public ResponseEntity<String> add(@RequestBody Estudiante estudiante) {
		try {
			service.save(estudiante);
			return new ResponseEntity<String>("El estudiante fue insertado correctamente", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("La estructura del estudiante es incorrecta", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		try {
			service.delete(id);
			return new ResponseEntity<String>("El estudiante fue eliminado correctamente", HttpStatus.OK);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<String>("Este vato no existe", HttpStatus.NOT_FOUND);
		}
	}
}
