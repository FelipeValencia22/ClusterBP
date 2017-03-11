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
public class TextualDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TextualDTO.class);
    private String actividad;
    private String descripcion;
    private String id;
    private String nombre;
    private Long textualCodigo;
    private Long pnCodigo_Pn;

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTextualCodigo() {
        return textualCodigo;
    }

    public void setTextualCodigo(Long textualCodigo) {
        this.textualCodigo = textualCodigo;
    }

    public Long getPnCodigo_Pn() {
        return pnCodigo_Pn;
    }

    public void setPnCodigo_Pn(Long pnCodigo_Pn) {
        this.pnCodigo_Pn = pnCodigo_Pn;
    }
}
