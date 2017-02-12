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
public class PnDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PnDTO.class);
    private String activo;
    private byte[] archivo;
    private String descripcion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long pnCodigo;
    private String titulo;
    private Long usuCreador;
    private Long usuModificador;
    private Long tipoArchivoPnCodigo_TipoArchivoPn;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Long getPnCodigo() {
        return pnCodigo;
    }

    public void setPnCodigo(Long pnCodigo) {
        this.pnCodigo = pnCodigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public Long getTipoArchivoPnCodigo_TipoArchivoPn() {
        return tipoArchivoPnCodigo_TipoArchivoPn;
    }

    public void setTipoArchivoPnCodigo_TipoArchivoPn(
        Long tipoArchivoPnCodigo_TipoArchivoPn) {
        this.tipoArchivoPnCodigo_TipoArchivoPn = tipoArchivoPnCodigo_TipoArchivoPn;
    }
}
