package ws.estudiante;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EstudianteService {

	@Autowired
	private EstudianteRepository repo;

	public List<Estudiante> listAll() {
		return repo.findAll();
	}

	public void save(Estudiante estudiante) {
		repo.save(estudiante);
	}

	public Estudiante get(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
