package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.LogBusqueda;
import co.edu.usb.clusterbp.dto.LogBusquedaDTO;

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
public interface ILogBusquedaLogic {
    public List<LogBusqueda> getLogBusqueda() throws Exception;

    /**
         * Save an new LogBusqueda entity
         */
    public void saveLogBusqueda(LogBusqueda entity) throws Exception;

    /**
         * Delete an existing LogBusqueda entity
         *
         */
    public void deleteLogBusqueda(LogBusqueda entity) throws Exception;

    /**
        * Update an existing LogBusqueda entity
        *
        */
    public void updateLogBusqueda(LogBusqueda entity) throws Exception;

    /**
         * Load an existing LogBusqueda entity
         *
         */
    public LogBusqueda getLogBusqueda(Long logBusquedaCodigo)
        throws Exception;

    public List<LogBusqueda> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<LogBusqueda> findPageLogBusqueda(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberLogBusqueda() throws Exception;

    public List<LogBusquedaDTO> getDataLogBusqueda() throws Exception;
}
