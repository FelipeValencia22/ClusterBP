package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.Usuario;

public interface ISeguridadLogica {
	
	public Usuario autenticarUsuario(String correo, String clave)throws Exception;

}
