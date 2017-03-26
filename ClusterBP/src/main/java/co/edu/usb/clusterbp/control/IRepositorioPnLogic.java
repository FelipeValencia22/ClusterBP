package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.RepositorioPn;
import co.edu.usb.clusterbp.dto.RepositorioPnDTO;
import java.util.List;

/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IRepositorioPnLogic {
    public List<RepositorioPn> getRepositorioPn() throws Exception;

    /**
         * Save an new RepositorioPn entity
         */
    public void saveRepositorioPn(RepositorioPn entity)
        throws Exception;

    /**
         * Delete an existing RepositorioPn entity
         *
         */
    public void deleteRepositorioPn(RepositorioPn entity)
        throws Exception;

    /**
        * Update an existing RepositorioPn entity
        *
        */
    public void updateRepositorioPn(RepositorioPn entity)
        throws Exception;

    /**
         * Load an existing RepositorioPn entity
         *
         */
    public RepositorioPn getRepositorioPn(Long repositorioPnCodigo)
        throws Exception;

    public List<RepositorioPn> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<RepositorioPn> findPageRepositorioPn(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberRepositorioPn() throws Exception;

    public List<RepositorioPnDTO> getDataRepositorioPn()
        throws Exception;
}
