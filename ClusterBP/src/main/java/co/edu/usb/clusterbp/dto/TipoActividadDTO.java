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
public class TipoActividadDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoActividadDTO.class);
    private String nombre;
    private Long tipoActividadCodigo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTipoActividadCodigo() {
        return tipoActividadCodigo;
    }

    public void setTipoActividadCodigo(Long tipoActividadCodigo) {
        this.tipoActividadCodigo = tipoActividadCodigo;
    }
}
