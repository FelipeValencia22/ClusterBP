package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.GrupoRepositorio;
import co.edu.usb.clusterbp.dto.GrupoRepositorioDTO;

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
public interface IGrupoRepositorioLogic {
    public List<GrupoRepositorio> getGrupoRepositorio()
        throws Exception;

    /**
         * Save an new GrupoRepositorio entity
         */
    public void saveGrupoRepositorio(GrupoRepositorio entity)
        throws Exception;

    /**
         * Delete an existing GrupoRepositorio entity
         *
         */
    public void deleteGrupoRepositorio(GrupoRepositorio entity)
        throws Exception;

    /**
        * Update an existing GrupoRepositorio entity
        *
        */
    public void updateGrupoRepositorio(GrupoRepositorio entity)
        throws Exception;

    /**
         * Load an existing GrupoRepositorio entity
         *
         */
    public GrupoRepositorio getGrupoRepositorio(Long grupoRepositorioCodigo)
        throws Exception;

    public List<GrupoRepositorio> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<GrupoRepositorio> findPageGrupoRepositorio(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberGrupoRepositorio() throws Exception;

    public List<GrupoRepositorioDTO> getDataGrupoRepositorio()
        throws Exception;
}
