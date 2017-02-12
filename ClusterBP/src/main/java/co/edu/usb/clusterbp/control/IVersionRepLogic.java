package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.VersionRep;
import co.edu.usb.clusterbp.dto.VersionRepDTO;

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
public interface IVersionRepLogic {
    public List<VersionRep> getVersionRep() throws Exception;

    /**
         * Save an new VersionRep entity
         */
    public void saveVersionRep(VersionRep entity) throws Exception;

    /**
         * Delete an existing VersionRep entity
         *
         */
    public void deleteVersionRep(VersionRep entity) throws Exception;

    /**
        * Update an existing VersionRep entity
        *
        */
    public void updateVersionRep(VersionRep entity) throws Exception;

    /**
         * Load an existing VersionRep entity
         *
         */
    public VersionRep getVersionRep(Long versionRepCodigo)
        throws Exception;

    public List<VersionRep> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<VersionRep> findPageVersionRep(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberVersionRep() throws Exception;

    public List<VersionRepDTO> getDataVersionRep() throws Exception;
}
