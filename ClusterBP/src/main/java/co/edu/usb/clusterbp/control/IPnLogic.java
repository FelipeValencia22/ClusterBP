package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.Pn;
import co.edu.usb.clusterbp.dto.PnDTO;

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
public interface IPnLogic {
    public List<Pn> getPn() throws Exception;

    /**
         * Save an new Pn entity
         */
    public void savePn(Pn entity) throws Exception;

    /**
         * Delete an existing Pn entity
         *
         */
    public void deletePn(Pn entity) throws Exception;

    /**
        * Update an existing Pn entity
        *
        */
    public void updatePn(Pn entity) throws Exception;

    /**
         * Load an existing Pn entity
         *
         */
    public Pn getPn(Long pnCodigo) throws Exception;

    public List<Pn> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Pn> findPagePn(String sortColumnName, boolean sortAscending,
        int startRow, int maxResults) throws Exception;

    public Long findTotalNumberPn() throws Exception;

    public List<PnDTO> getDataPn() throws Exception;
}
