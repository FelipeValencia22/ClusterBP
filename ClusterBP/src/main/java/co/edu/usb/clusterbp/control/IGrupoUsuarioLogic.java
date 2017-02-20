package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.GrupoUsuario;
import co.edu.usb.clusterbp.dto.GrupoUsuarioDTO;

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
public interface IGrupoUsuarioLogic {
    public List<GrupoUsuario> getGrupoUsuario() throws Exception;

    /**
         * Save an new GrupoUsuario entity
         */
    public void saveGrupoUsuario(GrupoUsuario entity) throws Exception;

    /**
         * Delete an existing GrupoUsuario entity
         *
         */
    public void deleteGrupoUsuario(GrupoUsuario entity)
        throws Exception;

    /**
        * Update an existing GrupoUsuario entity
        *
        */
    public void updateGrupoUsuario(GrupoUsuario entity)
        throws Exception;

    /**
         * Load an existing GrupoUsuario entity
         *
         */
    public GrupoUsuario getGrupoUsuario(Long grupoUsuarioCodigo)
        throws Exception;

    public List<GrupoUsuario> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<GrupoUsuario> findPageGrupoUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberGrupoUsuario() throws Exception;

    public List<GrupoUsuarioDTO> getDataGrupoUsuario()
        throws Exception;
    
    public List<GrupoUsuarioDTO> getDataGrupoUsuarioI()
            throws Exception;
}
