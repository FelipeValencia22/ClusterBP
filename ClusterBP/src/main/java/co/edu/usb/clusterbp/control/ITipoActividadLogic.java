package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.TipoActividad;
import co.edu.usb.clusterbp.dto.TipoActividadDTO;
import java.util.List;
/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ITipoActividadLogic {
    public List<TipoActividad> getTipoActividad() throws Exception;

    /**
         * Save an new TipoActividad entity
         */
    public void saveTipoActividad(TipoActividad entity)
        throws Exception;

    /**
         * Delete an existing TipoActividad entity
         *
         */
    public void deleteTipoActividad(TipoActividad entity)
        throws Exception;

    /**
        * Update an existing TipoActividad entity
        *
        */
    public void updateTipoActividad(TipoActividad entity)
        throws Exception;

    /**
         * Load an existing TipoActividad entity
         *
         */
    public TipoActividad getTipoActividad(Long tipoActividadCodigo)
        throws Exception;

    public List<TipoActividad> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoActividad> findPageTipoActividad(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoActividad() throws Exception;

    public List<TipoActividadDTO> getDataTipoActividad()
        throws Exception;
}
