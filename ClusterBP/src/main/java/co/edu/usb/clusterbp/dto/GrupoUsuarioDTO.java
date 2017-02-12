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
public class GrupoUsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GrupoUsuarioDTO.class);
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long grupoUsuarioCodigo;
    private Long usuCreador;
    private Long usuModificador;
    private Long grupoCodigo_Grupo;
    private Long usuarioCodigo_Usuario;

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

    public Long getGrupoUsuarioCodigo() {
        return grupoUsuarioCodigo;
    }

    public void setGrupoUsuarioCodigo(Long grupoUsuarioCodigo) {
        this.grupoUsuarioCodigo = grupoUsuarioCodigo;
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

    public Long getGrupoCodigo_Grupo() {
        return grupoCodigo_Grupo;
    }

    public void setGrupoCodigo_Grupo(Long grupoCodigo_Grupo) {
        this.grupoCodigo_Grupo = grupoCodigo_Grupo;
    }

    public Long getUsuarioCodigo_Usuario() {
        return usuarioCodigo_Usuario;
    }

    public void setUsuarioCodigo_Usuario(Long usuarioCodigo_Usuario) {
        this.usuarioCodigo_Usuario = usuarioCodigo_Usuario;
    }
}
