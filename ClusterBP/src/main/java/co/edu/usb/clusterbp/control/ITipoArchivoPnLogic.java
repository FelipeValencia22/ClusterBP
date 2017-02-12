package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.TipoArchivoPn;
import co.edu.usb.clusterbp.dto.TipoArchivoPnDTO;

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
public interface ITipoArchivoPnLogic {
    public List<TipoArchivoPn> getTipoArchivoPn() throws Exception;

    /**
         * Save an new TipoArchivoPn entity
         */
    public void saveTipoArchivoPn(TipoArchivoPn entity)
        throws Exception;

    /**
         * Delete an existing TipoArchivoPn entity
         *
         */
    public void deleteTipoArchivoPn(TipoArchivoPn entity)
        throws Exception;

    /**
        * Update an existing TipoArchivoPn entity
        *
        */
    public void updateTipoArchivoPn(TipoArchivoPn entity)
        throws Exception;

    /**
         * Load an existing TipoArchivoPn entity
         *
         */
    public TipoArchivoPn getTipoArchivoPn(Long tipoArchivoPnCodigo)
        throws Exception;

    public List<TipoArchivoPn> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoArchivoPn> findPageTipoArchivoPn(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoArchivoPn() throws Exception;

    public List<TipoArchivoPnDTO> getDataTipoArchivoPn()
        throws Exception;
}
