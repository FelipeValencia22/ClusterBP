package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.Historial;
import co.edu.usb.clusterbp.dto.HistorialDTO;

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
public interface IHistorialLogic {
    public List<Historial> getHistorial() throws Exception;

    /**
         * Save an new Historial entity
         */
    public void saveHistorial(Historial entity) throws Exception;

    /**
         * Delete an existing Historial entity
         *
         */
    public void deleteHistorial(Historial entity) throws Exception;

    /**
        * Update an existing Historial entity
        *
        */
    public void updateHistorial(Historial entity) throws Exception;

    /**
         * Load an existing Historial entity
         *
         */
    public Historial getHistorial(Long historialCodigo)
        throws Exception;

    public List<Historial> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Historial> findPageHistorial(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberHistorial() throws Exception;

    public List<HistorialDTO> getDataHistorial() throws Exception;
}
