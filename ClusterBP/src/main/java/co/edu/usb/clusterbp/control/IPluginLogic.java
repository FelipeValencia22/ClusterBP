package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.Plugin;
import co.edu.usb.clusterbp.dto.PluginDTO;

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
public interface IPluginLogic {
    public List<Plugin> getPlugin() throws Exception;

    /**
         * Save an new Plugin entity
         */
    public void savePlugin(Plugin entity) throws Exception;

    /**
         * Delete an existing Plugin entity
         *
         */
    public void deletePlugin(Plugin entity) throws Exception;

    /**
        * Update an existing Plugin entity
        *
        */
    public void updatePlugin(Plugin entity) throws Exception;

    /**
         * Load an existing Plugin entity
         *
         */
    public Plugin getPlugin(Long pluginCodigo) throws Exception;

    public List<Plugin> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Plugin> findPagePlugin(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPlugin() throws Exception;

    public List<PluginDTO> getDataPlugin() throws Exception;
}
