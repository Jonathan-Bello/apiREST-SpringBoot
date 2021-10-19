package ws.monstruo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Monstruo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String nombre;
    private String especie;
    private String habitat;
    private String debilidades;
    
	public Monstruo() {
		super();
	}

	public Monstruo(int id, String nombre, String especie, String habitat, String debilidades) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.especie = especie;
		this.habitat = habitat;
		this.debilidades = debilidades;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getHabitat() {
		return habitat;
	}
	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}
	public String getDebilidades() {
		return debilidades;
	}
	public void setDebilidades(String debilidades) {
		this.debilidades = debilidades;
	}

    
    
}
