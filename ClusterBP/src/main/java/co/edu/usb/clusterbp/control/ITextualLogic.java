package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.Textual;
import co.edu.usb.clusterbp.dto.TextualDTO;

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
public interface ITextualLogic {
    public List<Textual> getTextual() throws Exception;

    /**
         * Save an new Textual entity
         */
    public void saveTextual(Textual entity) throws Exception;

    /**
         * Delete an existing Textual entity
         *
         */
    public void deleteTextual(Textual entity) throws Exception;

    /**
        * Update an existing Textual entity
        *
        */
    public void updateTextual(Textual entity) throws Exception;

    /**
         * Load an existing Textual entity
         *
         */
    public Textual getTextual(Long textualCodigo) throws Exception;

    public List<Textual> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Textual> findPageTextual(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTextual() throws Exception;

    public List<TextualDTO> getDataTextual() throws Exception;
}
