package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.PluginModeloBusqueda;
import co.edu.usb.clusterbp.dto.PluginModeloBusquedaDTO;

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
public interface IPluginModeloBusquedaLogic {
    public List<PluginModeloBusqueda> getPluginModeloBusqueda()
        throws Exception;

    /**
         * Save an new PluginModeloBusqueda entity
         */
    public void savePluginModeloBusqueda(PluginModeloBusqueda entity)
        throws Exception;

    /**
         * Delete an existing PluginModeloBusqueda entity
         *
         */
    public void deletePluginModeloBusqueda(PluginModeloBusqueda entity)
        throws Exception;

    /**
        * Update an existing PluginModeloBusqueda entity
        *
        */
    public void updatePluginModeloBusqueda(PluginModeloBusqueda entity)
        throws Exception;

    /**
         * Load an existing PluginModeloBusqueda entity
         *
         */
    public PluginModeloBusqueda getPluginModeloBusqueda(
        Long pluginModeloBusquedaCodigo) throws Exception;

    public List<PluginModeloBusqueda> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<PluginModeloBusqueda> findPagePluginModeloBusqueda(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberPluginModeloBusqueda() throws Exception;

    public List<PluginModeloBusquedaDTO> getDataPluginModeloBusqueda()
        throws Exception;
}
