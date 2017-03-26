package co.edu.usb.clusterbp.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Date;


/**
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class UsuarioRolDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(UsuarioRolDTO.class);
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long usuCreador;
    private Long usuarioModificador;
    private Long usuarioRolCodigo;
    private Long rolCodigo_Rol;
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

    public Long getUsuCreador() {
        return usuCreador;
    }

    public void setUsuCreador(Long usuCreador) {
        this.usuCreador = usuCreador;
    }

    public Long getUsuarioModificador() {
        return usuarioModificador;
    }

    public void setUsuarioModificador(Long usuarioModificador) {
        this.usuarioModificador = usuarioModificador;
    }

    public Long getUsuarioRolCodigo() {
        return usuarioRolCodigo;
    }

    public void setUsuarioRolCodigo(Long usuarioRolCodigo) {
        this.usuarioRolCodigo = usuarioRolCodigo;
    }

    public Long getRolCodigo_Rol() {
        return rolCodigo_Rol;
    }

    public void setRolCodigo_Rol(Long rolCodigo_Rol) {
        this.rolCodigo_Rol = rolCodigo_Rol;
    }

    public Long getUsuarioCodigo_Usuario() {
        return usuarioCodigo_Usuario;
    }

    public void setUsuarioCodigo_Usuario(Long usuarioCodigo_Usuario) {
        this.usuarioCodigo_Usuario = usuarioCodigo_Usuario;
    }
}
