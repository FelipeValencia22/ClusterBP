package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.Usuario;
import co.edu.usb.clusterbp.dto.UsuarioDTO;
import java.util.List;
/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
public interface IUsuarioLogic {
	public List<Usuario> getUsuario() throws Exception;

	/**
	 * Save an new Usuario entity
	 */
	public void saveUsuario(Usuario entity) throws Exception;

	/**
	 * Delete an existing Usuario entity
	 *
	 */
	public void deleteUsuario(Usuario entity) throws Exception;

	/**
	 * Update an existing Usuario entity
	 *
	 */
	public void updateUsuario(Usuario entity) throws Exception;

	/**
	 * Load an existing Usuario entity
	 *
	 */
	public Usuario getUsuario(Long usuarioCodigo) throws Exception;

	public List<Usuario> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception;

	public List<Usuario> findPageUsuario(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception;

	public Long findTotalNumberUsuario() throws Exception;




	//TODO: Consultas
	public Usuario consultarUsuarioPorCorreo(String correo);
	
	public Usuario consultarUsuarioPorID(Long usuarioCodigo);

	public Usuario consultarCorreoDisponible(String correo);

	//TODO: Metodos

	public List<UsuarioDTO> getDataUsuario() throws Exception;

	public List<UsuarioDTO> getDataUsuarioI() throws Exception;




}
