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
public class VersionRepDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(VersionRepDTO.class);
    private String descripcionCambio;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String nombre;
    private Long usuCreador;
    private Long usuModificador;
    private Long versionRepCodigo;
    private Long repositorioCodigo_Repositorio;

    public String getDescripcionCambio() {
        return descripcionCambio;
    }

    public void setDescripcionCambio(String descripcionCambio) {
        this.descripcionCambio = descripcionCambio;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Long getVersionRepCodigo() {
        return versionRepCodigo;
    }

    public void setVersionRepCodigo(Long versionRepCodigo) {
        this.versionRepCodigo = versionRepCodigo;
    }

    public Long getRepositorioCodigo_Repositorio() {
        return repositorioCodigo_Repositorio;
    }

    public void setRepositorioCodigo_Repositorio(
        Long repositorioCodigo_Repositorio) {
        this.repositorioCodigo_Repositorio = repositorioCodigo_Repositorio;
    }
}
