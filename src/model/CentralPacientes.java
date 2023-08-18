package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import util.ListaEnlazada;

/**
 * Clase controladora del caso de estudio del texto
 * @author angievig
 * @version 1.0
 * @since August 2023
 */
public class CentralPacientes {
	ListaEnlazada pacientes;
	
	
	public CentralPacientes() {
		pacientes = new ListaEnlazada();
	}


	/**	
	 * Informa si un paciente está registrado en la central de pacientes
	 * @param code, código del paciente
	 * @return String con el mensaje
	 */
	public String buscarPaciente(int code) {
		String out= "El paciente con codigo " + code+ " no está registrado";
		Paciente p = (Paciente)pacientes.buscar(code);
		
		if (p!=null)
			out= "El paciente con cOdigo " + code + " está registrado" ;
			return out;
	}

	
	public String agregarPaciente(int code, String fechaNacimiento, String name) {
		String out= "";
		
		//transformacion de string a date (dd-MM-yyyy)

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date fecha = null;

    	try {
    	  fecha = formatter.parse(fechaNacimiento);
    	  System.out.println(fecha);
    	} catch (ParseException e) {
    	  e.printStackTrace();
    	}

		Paciente p = (Paciente)pacientes.buscar(code);
			if (p==null) {
				pacientes.agregarUltimo(new Paciente(code, fecha, name));
				out= "El paciente con cOdigo " + code + " fue correctamente agregado"; 
			}else {
				out= "Error: el paciente con cOdigo " + code + " ya está registrado";
			}
				
		return out;
	}
	
	public String eliminarPaciente(int code) {
		String out= "";
		Paciente p = (Paciente)pacientes.buscar(code);
		
		if (p!=null) {
			pacientes.eliminar(p.getCodigo());
			out= "El paciente con cOdigo " + code + " fue correctamente eliminado"; 
		}else {
			out= "Error: el paciente con cOdigo " + code + " no está registrado";
		}
		return out;
	
	}
	
	
	
}
