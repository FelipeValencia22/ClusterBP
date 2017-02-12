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
public class LogBusquedaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(LogBusquedaDTO.class);
    private String activo;
    private String descLog;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long logBusquedaCodigo;
    private Long usuCreador;
    private Long usuModificador;
    private Long repositorioCodigo_Repositorio;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getDescLog() {
        return descLog;
    }

    public void setDescLog(String descLog) {
        this.descLog = descLog;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Long getLogBusquedaCodigo() {
        return logBusquedaCodigo;
    }

    public void setLogBusquedaCodigo(Long logBusquedaCodigo) {
        this.logBusquedaCodigo = logBusquedaCodigo;
    }

    public Long getUsuCreador() {
        return usuCreador;
    }

    public void setUsuCreador(Long usuCreador) {
        this.usuCreador = usuCreador;
    }

    public Long getUsuModificador() {
        return usuModificador;
    }

    public void setUsuModificador(Long usuModificador) {
        this.usuModificador = usuModificador;
    }

    public Long getRepositorioCodigo_Repositorio() {
        return repositorioCodigo_Repositorio;
    }

    public void setRepositorioCodigo_Repositorio(
        Long repositorioCodigo_Repositorio) {
        this.repositorioCodigo_Repositorio = repositorioCodigo_Repositorio;
    }
}
