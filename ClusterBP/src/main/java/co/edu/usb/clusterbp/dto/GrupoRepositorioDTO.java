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
public class GrupoRepositorioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GrupoRepositorioDTO.class);
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long grupoRepositorioCodigo;
    private Long usuCreador;
    private Long usuModificador;
    private Long grupoCodigo_Grupo;
    private Long repositorioCodigo_Repositorio;

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

    public Long getGrupoRepositorioCodigo() {
        return grupoRepositorioCodigo;
    }

    public void setGrupoRepositorioCodigo(Long grupoRepositorioCodigo) {
        this.grupoRepositorioCodigo = grupoRepositorioCodigo;
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

    public Long getRepositorioCodigo_Repositorio() {
        return repositorioCodigo_Repositorio;
    }

    public void setRepositorioCodigo_Repositorio(
        Long repositorioCodigo_Repositorio) {
        this.repositorioCodigo_Repositorio = repositorioCodigo_Repositorio;
    }
}
