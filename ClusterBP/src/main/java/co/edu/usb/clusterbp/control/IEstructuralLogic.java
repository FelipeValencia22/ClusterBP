package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.Estructural;
import co.edu.usb.clusterbp.dto.EstructuralDTO;

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
public interface IEstructuralLogic {
    public List<Estructural> getEstructural() throws Exception;

    /**
         * Save an new Estructural entity
         */
    public void saveEstructural(Estructural entity) throws Exception;

    /**
         * Delete an existing Estructural entity
         *
         */
    public void deleteEstructural(Estructural entity) throws Exception;

    /**
        * Update an existing Estructural entity
        *
        */
    public void updateEstructural(Estructural entity) throws Exception;

    /**
         * Load an existing Estructural entity
         *
         */
    public Estructural getEstructural(Long estructuralCodigo)
        throws Exception;

    public List<Estructural> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Estructural> findPageEstructural(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEstructural() throws Exception;

    public List<EstructuralDTO> getDataEstructural() throws Exception;
}
