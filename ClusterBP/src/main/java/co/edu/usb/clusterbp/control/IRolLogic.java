package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.Rol;
import co.edu.usb.clusterbp.dto.RolDTO;
import java.util.List;

/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IRolLogic {
    public List<Rol> getRol() throws Exception;

    /**
         * Save an new Rol entity
         */
    public void saveRol(Rol entity) throws Exception;

    /**
         * Delete an existing Rol entity
         *
         */
    public void deleteRol(Rol entity) throws Exception;

    /**
        * Update an existing Rol entity
        *
        */
    public void updateRol(Rol entity) throws Exception;

    /**
         * Load an existing Rol entity
         *
         */
    public Rol getRol(Long rolCodigo) throws Exception;

    public List<Rol> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Rol> findPageRol(String sortColumnName, boolean sortAscending,
        int startRow, int maxResults) throws Exception;

    public Long findTotalNumberRol() throws Exception;

    public List<RolDTO> getDataRol() throws Exception;
    
    public String consultarRolUsuarioPorCorreo(String correo);
    
  //TODO: Consultas
  	public Rol consultarIdRolPorNombre(String nombre);
}
