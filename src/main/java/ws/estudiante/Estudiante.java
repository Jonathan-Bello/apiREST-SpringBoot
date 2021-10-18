package ws.estudiante;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numerodecontrol")
	private int numControl;
	private String nombre;
	private String apellidopaterno;
	@Column(nullable = false)
	private String apellidomaterno;

	public Estudiante() {
		super();
	}

	public Estudiante(int numerodecontrol, String nombre, String apellidopaterno, String apellidomaterno) {
		super();
		this.numControl = numerodecontrol;
		this.nombre = nombre;
		this.apellidopaterno = apellidopaterno;
		this.apellidomaterno = apellidomaterno;
	}

	public int getNumControl() {
		return numControl;
	}
	public void setNumControl(int numerodecontrol) {
		this.numControl = numerodecontrol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidopaterno() {
		return apellidopaterno;
	}
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}
	public String getApellidomaterno() {
		return apellidomaterno;
	}
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}
}
