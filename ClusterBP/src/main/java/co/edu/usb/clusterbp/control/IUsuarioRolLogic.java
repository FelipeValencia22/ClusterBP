package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.Usuario;
import co.edu.usb.clusterbp.UsuarioRol;
import co.edu.usb.clusterbp.dto.UsuarioRolDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IUsuarioRolLogic {
    public List<UsuarioRol> getUsuarioRol() throws Exception;

    /**
         * Save an new UsuarioRol entity
         */
    public void saveUsuarioRol(UsuarioRol entity) throws Exception;

    /**
         * Delete an existing UsuarioRol entity
         *
         */
    public void deleteUsuarioRol(UsuarioRol entity) throws Exception;

    /**
        * Update an existing UsuarioRol entity
        *
        */
    public void updateUsuarioRol(UsuarioRol entity) throws Exception;

    /**
         * Load an existing UsuarioRol entity
         *
         */
    public UsuarioRol getUsuarioRol(Long usuarioRolCodigo)
        throws Exception;

    public List<UsuarioRol> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<UsuarioRol> findPageUsuarioRol(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuarioRol() throws Exception;

    public List<UsuarioRolDTO> getDataUsuarioRol() throws Exception;
    
    
}
