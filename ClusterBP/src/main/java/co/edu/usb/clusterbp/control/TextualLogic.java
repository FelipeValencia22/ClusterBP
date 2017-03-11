package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.*;
import co.edu.usb.clusterbp.dto.TextualDTO;
import co.edu.usb.dataaccess.dao.*;
import co.edu.usb.exceptions.*;
import co.edu.usb.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("TextualLogic")
public class TextualLogic implements ITextualLogic {
    private static final Logger log = LoggerFactory.getLogger(TextualLogic.class);

    /**
     * DAO injected by Spring that manages Textual entities
     *
     */
    @Autowired
    private ITextualDAO textualDAO;

    /**
    * Logic injected by Spring that manages Pn entities
    *
    */
    @Autowired
    IPnLogic logicPn1;

    @Transactional(readOnly = true)
    public List<Textual> getTextual() throws Exception {
        log.debug("finding all Textual instances");

        List<Textual> list = new ArrayList<Textual>();

        try {
            list = textualDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Textual failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Textual");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveTextual(Textual entity) throws Exception {
        log.debug("saving Textual instance");

        try {

            if (entity.getActividad() == null) {
                throw new ZMessManager().new EmptyFieldException("actividad");
            }

            if ((entity.getActividad() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getActividad(), 255) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "actividad");
            }

            if (entity.getId() == null) {
                throw new ZMessManager().new EmptyFieldException("id");
            }

            if ((entity.getId() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getId(), 255) == false)) {
                throw new ZMessManager().new NotValidFormatException("id");
            }

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        255) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }

            textualDAO.save(entity);

            log.debug("save Textual successful");
        } catch (Exception e) {
            log.error("save Textual failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteTextual(Textual entity) throws Exception {
        log.debug("deleting Textual instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Textual");
        }

        if (entity.getTextualCodigo() == null) {
            throw new ZMessManager().new EmptyFieldException("textualCodigo");
        }

        try {
            textualDAO.delete(entity);

            log.debug("delete Textual successful");
        } catch (Exception e) {
            log.error("delete Textual failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateTextual(Textual entity) throws Exception {
        log.debug("updating Textual instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Textual");
            }

            if (entity.getPn() == null) {
                throw new ZMessManager().new ForeignException("pn");
            }

            if (entity.getActividad() == null) {
                throw new ZMessManager().new EmptyFieldException("actividad");
            }

            if ((entity.getActividad() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getActividad(), 255) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "actividad");
            }

            if ((entity.getDescripcion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDescripcion(), 255) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "descripcion");
            }

            if (entity.getId() == null) {
                throw new ZMessManager().new EmptyFieldException("id");
            }

            if ((entity.getId() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getId(), 255) == false)) {
                throw new ZMessManager().new NotValidFormatException("id");
            }

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        255) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }

            if (entity.getTextualCodigo() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "textualCodigo");
            }

            if (entity.getPn().getPnCodigo() == null) {
                throw new ZMessManager().new EmptyFieldException("pnCodigo_Pn");
            }

            textualDAO.update(entity);

            log.debug("update Textual successful");
        } catch (Exception e) {
            log.error("update Textual failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<TextualDTO> getDataTextual() throws Exception {
        try {
            List<Textual> textual = textualDAO.findAll();

            List<TextualDTO> textualDTO = new ArrayList<TextualDTO>();

            for (Textual textualTmp : textual) {
                TextualDTO textualDTO2 = new TextualDTO();

                textualDTO2.setTextualCodigo(textualTmp.getTextualCodigo());
                textualDTO2.setActividad((textualTmp.getActividad() != null)
                    ? textualTmp.getActividad() : null);
                textualDTO2.setDescripcion((textualTmp.getDescripcion() != null)
                    ? textualTmp.getDescripcion() : null);
                textualDTO2.setId((textualTmp.getId() != null)
                    ? textualTmp.getId() : null);
                textualDTO2.setNombre((textualTmp.getNombre() != null)
                    ? textualTmp.getNombre() : null);
                textualDTO2.setPnCodigo_Pn((textualTmp.getPn().getPnCodigo() != null)
                    ? textualTmp.getPn().getPnCodigo() : null);
                textualDTO.add(textualDTO2);
            }

            return textualDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Textual getTextual(Long textualCodigo) throws Exception {
        log.debug("getting Textual instance");

        Textual entity = null;

        try {
            entity = textualDAO.findById(textualCodigo);
        } catch (Exception e) {
            log.error("get Textual failed", e);
            throw new ZMessManager().new FindingException("Textual");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Textual> findPageTextual(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Textual> entity = null;

        try {
            entity = textualDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Textual Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberTextual() throws Exception {
        Long entity = null;

        try {
            entity = textualDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Textual Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<Textual> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Textual> list = new ArrayList<Textual>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between \'" + value +
                        "\' and \'" + value2 + "\')")
                        : (tempWhere + " AND (model." + variable +
                        " between \'" + value + "\' and \'" + value2 + "\')");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = textualDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
