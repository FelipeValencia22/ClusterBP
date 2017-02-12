package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.RepositorioPlugin;
import co.edu.usb.clusterbp.dto.RepositorioPluginDTO;

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
public interface IRepositorioPluginLogic {
    public List<RepositorioPlugin> getRepositorioPlugin()
        throws Exception;

    /**
         * Save an new RepositorioPlugin entity
         */
    public void saveRepositorioPlugin(RepositorioPlugin entity)
        throws Exception;

    /**
         * Delete an existing RepositorioPlugin entity
         *
         */
    public void deleteRepositorioPlugin(RepositorioPlugin entity)
        throws Exception;

    /**
        * Update an existing RepositorioPlugin entity
        *
        */
    public void updateRepositorioPlugin(RepositorioPlugin entity)
        throws Exception;

    /**
         * Load an existing RepositorioPlugin entity
         *
         */
    public RepositorioPlugin getRepositorioPlugin(Long repositorioPluginCodigo)
        throws Exception;

    public List<RepositorioPlugin> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<RepositorioPlugin> findPageRepositorioPlugin(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberRepositorioPlugin() throws Exception;

    public List<RepositorioPluginDTO> getDataRepositorioPlugin()
        throws Exception;
}
