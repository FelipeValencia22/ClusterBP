package co.edu.usb.clusterbp.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class EstructuralDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(EstructuralDTO.class);
    private Long estructuralCodigo;
    private String fromActividad;
    private String fromId;
    private String id;
    private String toActividad;
    private String toId;
    private Long pnCodigo_Pn;

    public Long getEstructuralCodigo() {
        return estructuralCodigo;
    }

    public void setEstructuralCodigo(Long estructuralCodigo) {
        this.estructuralCodigo = estructuralCodigo;
    }

    public String getFromActividad() {
        return fromActividad;
    }

    public void setFromActividad(String fromActividad) {
        this.fromActividad = fromActividad;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToActividad() {
        return toActividad;
    }

    public void setToActividad(String toActividad) {
        this.toActividad = toActividad;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public Long getPnCodigo_Pn() {
        return pnCodigo_Pn;
    }

    public void setPnCodigo_Pn(Long pnCodigo_Pn) {
        this.pnCodigo_Pn = pnCodigo_Pn;
    }
}
