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
public class RepositorioPnDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(RepositorioPnDTO.class);
    private String activo;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long repositorioPnCodigo;
    private Long usuCreador;
    private Long usuarioModificador;
    private Long pnCodigo_Pn;
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

    public Long getRepositorioPnCodigo() {
        return repositorioPnCodigo;
    }

    public void setRepositorioPnCodigo(Long repositorioPnCodigo) {
        this.repositorioPnCodigo = repositorioPnCodigo;
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

    public Long getPnCodigo_Pn() {
        return pnCodigo_Pn;
    }

    public void setPnCodigo_Pn(Long pnCodigo_Pn) {
        this.pnCodigo_Pn = pnCodigo_Pn;
    }

    public Long getRepositorioCodigo_Repositorio() {
        return repositorioCodigo_Repositorio;
    }

    public void setRepositorioCodigo_Repositorio(
        Long repositorioCodigo_Repositorio) {
        this.repositorioCodigo_Repositorio = repositorioCodigo_Repositorio;
    }
}
