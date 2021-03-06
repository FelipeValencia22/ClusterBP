package co.edu.usb.clusterbp.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usb.clusterbp.Usuario;
import co.edu.usb.dataaccess.dao.IUsuarioDAO;

@Scope("singleton")
@Service("seguridadLogica")
public class SeguridadLogica implements ISeguridadLogica{
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Override
	@Transactional(readOnly = true)
	public Usuario autenticarUsuario(String correo, String clave) throws Exception {
		String mensaje = "Correo electrónico o contraseña inválida";
		try{
			Usuario usuario= usuarioDAO.consultarUsuarioPorCorreo(correo);
			if(usuario.equals(null)){
				throw new Exception(mensaje);
			}else{
				if(usuario.getClave().equalsIgnoreCase(clave)){
					return usuario;		
				}
				else{
					return null;
				}
			}				
			
		}catch (Exception e) {
			throw e;
		}
		
	}

}