package ws.monstruo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/monstruos")
public class MonstruoController {
    @Autowired
    private MonstruoService service;

    @GetMapping("all")
	public String listCount() {
		return "La cantidad de recursos en la base de datos es: " + service.listAll().size();
	}

    @GetMapping()
    public List<Monstruo> list(){
        return service.listAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Monstruo> get(@PathVariable Integer id){
        Monstruo monstruo = service.get(id);
        return new ResponseEntity<Monstruo>(monstruo, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@RequestBody Monstruo monstruo, @PathVariable Integer id){
        try {
            Monstruo auxMonstruo = service.get(id);
            monstruo.setId(auxMonstruo.getId());
            service.save(monstruo);
            return new ResponseEntity<String>("El monstruo fue actualizado correctamente", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<String>("El monstruo con ese id proporcionado no existe", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<String> add (@RequestBody Monstruo monstruo){
        try{
            service.save(monstruo);
            return new ResponseEntity<String>("El monstruo fue insertado correctamente", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>("La estructura de la informacion del monstruo es incorrecta", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        try {
            service.delete(id);
            return new ResponseEntity<String>("El monstruo fue eliminado con exito", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("El monstruo no existe, verica el id", HttpStatus.NOT_FOUND);
        }
    }
}
