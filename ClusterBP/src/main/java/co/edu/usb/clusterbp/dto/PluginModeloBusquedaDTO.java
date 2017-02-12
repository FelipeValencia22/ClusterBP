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
public class PluginModeloBusquedaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PluginModeloBusquedaDTO.class);
    private String activo;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long pluginModeloBusquedaCodigo;
    private Long usuCreador;
    private Long usuModificador;
    private Long modeloBusquedaCodigo_ModeloBusqueda;
    private Long pluginCodigo_Plugin;

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

    public Long getPluginModeloBusquedaCodigo() {
        return pluginModeloBusquedaCodigo;
    }

    public void setPluginModeloBusquedaCodigo(Long pluginModeloBusquedaCodigo) {
        this.pluginModeloBusquedaCodigo = pluginModeloBusquedaCodigo;
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

    public Long getModeloBusquedaCodigo_ModeloBusqueda() {
        return modeloBusquedaCodigo_ModeloBusqueda;
    }

    public void setModeloBusquedaCodigo_ModeloBusqueda(
        Long modeloBusquedaCodigo_ModeloBusqueda) {
        this.modeloBusquedaCodigo_ModeloBusqueda = modeloBusquedaCodigo_ModeloBusqueda;
    }

    public Long getPluginCodigo_Plugin() {
        return pluginCodigo_Plugin;
    }

    public void setPluginCodigo_Plugin(Long pluginCodigo_Plugin) {
        this.pluginCodigo_Plugin = pluginCodigo_Plugin;
    }
}
