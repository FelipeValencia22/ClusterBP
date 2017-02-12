package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.ModeloBusqueda;
import co.edu.usb.clusterbp.dto.ModeloBusquedaDTO;

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
public interface IModeloBusquedaLogic {
    public List<ModeloBusqueda> getModeloBusqueda() throws Exception;

    /**
         * Save an new ModeloBusqueda entity
         */
    public void saveModeloBusqueda(ModeloBusqueda entity)
        throws Exception;

    /**
         * Delete an existing ModeloBusqueda entity
         *
         */
    public void deleteModeloBusqueda(ModeloBusqueda entity)
        throws Exception;

    /**
        * Update an existing ModeloBusqueda entity
        *
        */
    public void updateModeloBusqueda(ModeloBusqueda entity)
        throws Exception;

    /**
         * Load an existing ModeloBusqueda entity
         *
         */
    public ModeloBusqueda getModeloBusqueda(Long modeloBusquedaCodigo)
        throws Exception;

    public List<ModeloBusqueda> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<ModeloBusqueda> findPageModeloBusqueda(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberModeloBusqueda() throws Exception;

    public List<ModeloBusquedaDTO> getDataModeloBusqueda()
        throws Exception;
}
