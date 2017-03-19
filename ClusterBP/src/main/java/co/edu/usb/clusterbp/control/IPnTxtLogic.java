package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.Pn;
import co.edu.usb.clusterbp.PnTxt;
import co.edu.usb.clusterbp.dto.PnTxtDTO;

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
public interface IPnTxtLogic {
    public List<PnTxt> getPnTxt() throws Exception;

    /**
         * Save an new PnTxt entity
         */
    public void savePnTxt(PnTxt entity) throws Exception;

    /**
         * Delete an existing PnTxt entity
         *
         */
    public void deletePnTxt(PnTxt entity) throws Exception;

    /**
        * Update an existing PnTxt entity
        *
        */
    public void updatePnTxt(PnTxt entity) throws Exception;

    /**
         * Load an existing PnTxt entity
         *
         */
    public PnTxt getPnTxt(Long pnTxtCodigo) throws Exception;

    public List<PnTxt> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<PnTxt> findPagePnTxt(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPnTxt() throws Exception;

    public List<PnTxtDTO> getDataPnTxt() throws Exception;
    
    //TODO: Metodos
    public String crearTxt(String texto, Pn pn) throws Exception;
    public String createDirectory();
}
