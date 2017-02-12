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
public class RepositorioPluginDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RepositorioPluginDTO.class);
    private String activo;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long repositorioPluginCodigo;
    private Long usuCreador;
    private Long usuModificador;
    private Long pluginCodigo_Plugin;
    private Long repositorioCodigo_Repositorio;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
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

    public Long getRepositorioPluginCodigo() {
        return repositorioPluginCodigo;
    }

    public void setRepositorioPluginCodigo(Long repositorioPluginCodigo) {
        this.repositorioPluginCodigo = repositorioPluginCodigo;
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

    public Long getPluginCodigo_Plugin() {
        return pluginCodigo_Plugin;
    }

    public void setPluginCodigo_Plugin(Long pluginCodigo_Plugin) {
        this.pluginCodigo_Plugin = pluginCodigo_Plugin;
    }

    public Long getRepositorioCodigo_Repositorio() {
        return repositorioCodigo_Repositorio;
    }

    public void setRepositorioCodigo_Repositorio(
        Long repositorioCodigo_Repositorio) {
        this.repositorioCodigo_Repositorio = repositorioCodigo_Repositorio;
    }
}
