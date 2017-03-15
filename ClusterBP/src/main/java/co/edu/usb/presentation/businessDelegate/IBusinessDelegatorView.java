package co.edu.usb.presentation.businessDelegate;


import co.edu.usb.clusterbp.Estructural;
import co.edu.usb.clusterbp.Pn;
import co.edu.usb.clusterbp.Repositorio;
import co.edu.usb.clusterbp.RepositorioPn;
import co.edu.usb.clusterbp.Rol;
import co.edu.usb.clusterbp.Textual;
import co.edu.usb.clusterbp.TipoActividad;
import co.edu.usb.clusterbp.TipoArchivoPn;
import co.edu.usb.clusterbp.Usuario;
import co.edu.usb.clusterbp.UsuarioRol;
import co.edu.usb.clusterbp.control.IPnLogic;
import co.edu.usb.clusterbp.control.IRepositorioLogic;
import co.edu.usb.clusterbp.control.IRepositorioPnLogic;
import co.edu.usb.clusterbp.control.IRolLogic;
import co.edu.usb.clusterbp.control.ITipoArchivoPnLogic;
import co.edu.usb.clusterbp.control.IUsuarioLogic;
import co.edu.usb.clusterbp.control.IUsuarioRolLogic;
import co.edu.usb.clusterbp.control.PnLogic;
import co.edu.usb.clusterbp.control.RepositorioLogic;
import co.edu.usb.clusterbp.control.RepositorioPnLogic;
import co.edu.usb.clusterbp.control.RolLogic;
import co.edu.usb.clusterbp.control.TipoArchivoPnLogic;
import co.edu.usb.clusterbp.control.UsuarioLogic;
import co.edu.usb.clusterbp.control.UsuarioRolLogic;
import co.edu.usb.clusterbp.dto.EstructuralDTO;
import co.edu.usb.clusterbp.dto.PnDTO;
import co.edu.usb.clusterbp.dto.RepositorioDTO;
import co.edu.usb.clusterbp.dto.RepositorioPnDTO;
import co.edu.usb.clusterbp.dto.RolDTO;
import co.edu.usb.clusterbp.dto.TextualDTO;
import co.edu.usb.clusterbp.dto.TipoActividadDTO;
import co.edu.usb.clusterbp.dto.TipoArchivoPnDTO;
import co.edu.usb.clusterbp.dto.UsuarioDTO;
import co.edu.usb.clusterbp.dto.UsuarioRolDTO;

import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {

    public List<Pn> getPn() throws Exception;

    public void savePn(Pn entity) throws Exception;

    public void deletePn(Pn entity) throws Exception;

    public void updatePn(Pn entity) throws Exception;

    public Pn getPn(Long pnCodigo) throws Exception;

    public List<Pn> findByCriteriaInPn(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Pn> findPagePn(String sortColumnName, boolean sortAscending,
        int startRow, int maxResults) throws Exception;

    public Long findTotalNumberPn() throws Exception;

    public List<PnDTO> getDataPn() throws Exception;
    
    public List<PnDTO> getDataPnI() throws Exception;

    public List<Repositorio> getRepositorio() throws Exception;

    public void saveRepositorio(Repositorio entity) throws Exception;

    public void deleteRepositorio(Repositorio entity) throws Exception;

    public void updateRepositorio(Repositorio entity) throws Exception;

    public Repositorio getRepositorio(Long repositorioCodigo)
        throws Exception;

    public List<Repositorio> findByCriteriaInRepositorio(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Repositorio> findPageRepositorio(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberRepositorio() throws Exception;

    public List<RepositorioDTO> getDataRepositorio() throws Exception;
    
    public List<RepositorioDTO> getDataRepositorioI() throws Exception;

    public List<RepositorioPn> getRepositorioPn() throws Exception;

    public void saveRepositorioPn(RepositorioPn entity)
        throws Exception;

    public void deleteRepositorioPn(RepositorioPn entity)
        throws Exception;

    public void updateRepositorioPn(RepositorioPn entity)
        throws Exception;

    public RepositorioPn getRepositorioPn(Long repositorioPnCodigo)
        throws Exception;

    public List<RepositorioPn> findByCriteriaInRepositorioPn(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<RepositorioPn> findPageRepositorioPn(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberRepositorioPn() throws Exception;

    public List<RepositorioPnDTO> getDataRepositorioPn()
        throws Exception;

    public List<Rol> getRol() throws Exception;

    public void saveRol(Rol entity) throws Exception;

    public void deleteRol(Rol entity) throws Exception;

    public void updateRol(Rol entity) throws Exception;

    public Rol getRol(Long rolCodigo) throws Exception;

    public List<Rol> findByCriteriaInRol(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Rol> findPageRol(String sortColumnName, boolean sortAscending,
        int startRow, int maxResults) throws Exception;

    public Long findTotalNumberRol() throws Exception;

    public List<RolDTO> getDataRol() throws Exception;

    public List<TipoArchivoPn> getTipoArchivoPn() throws Exception;

    public void saveTipoArchivoPn(TipoArchivoPn entity)
        throws Exception;

    public void deleteTipoArchivoPn(TipoArchivoPn entity)
        throws Exception;

    public void updateTipoArchivoPn(TipoArchivoPn entity)
        throws Exception;

    public TipoArchivoPn getTipoArchivoPn(Long tipoArchivoPnCodigo)
        throws Exception;

    public List<TipoArchivoPn> findByCriteriaInTipoArchivoPn(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<TipoArchivoPn> findPageTipoArchivoPn(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoArchivoPn() throws Exception;

    public List<TipoArchivoPnDTO> getDataTipoArchivoPn()
        throws Exception;

    public List<Usuario> getUsuario() throws Exception;

    public void saveUsuario(Usuario entity) throws Exception;

    public void deleteUsuario(Usuario entity) throws Exception;

    public void updateUsuario(Usuario entity) throws Exception;

    public Usuario getUsuario(Long usuarioCodigo) throws Exception;

    public List<Usuario> findByCriteriaInUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Usuario> findPageUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuario() throws Exception;

    public List<UsuarioDTO> getDataUsuario() throws Exception;

    public List<UsuarioRol> getUsuarioRol() throws Exception;

    public void saveUsuarioRol(UsuarioRol entity) throws Exception;

    public void deleteUsuarioRol(UsuarioRol entity) throws Exception;

    public void updateUsuarioRol(UsuarioRol entity) throws Exception;

    public UsuarioRol getUsuarioRol(Long usuarioRolCodigo)
        throws Exception;

    public List<UsuarioRol> findByCriteriaInUsuarioRol(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<UsuarioRol> findPageUsuarioRol(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuarioRol() throws Exception;

    public List<UsuarioRolDTO> getDataUsuarioRol() throws Exception;
    
    public List<Estructural> getEstructural() throws Exception;

    public void saveEstructural(Estructural entity) throws Exception;

    public void deleteEstructural(Estructural entity) throws Exception;

    public void updateEstructural(Estructural entity) throws Exception;

    public Estructural getEstructural(Long estructuralCodigo)
        throws Exception;

    public List<Estructural> findByCriteriaInEstructural(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Estructural> findPageEstructural(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEstructural() throws Exception;

    public List<EstructuralDTO> getDataEstructural() throws Exception;

    
    public List<Textual> getTextual() throws Exception;

    public void saveTextual(Textual entity) throws Exception;

    public void deleteTextual(Textual entity) throws Exception;

    public void updateTextual(Textual entity) throws Exception;

    public Textual getTextual(Long textualCodigo) throws Exception;

    public List<Textual> findByCriteriaInTextual(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Textual> findPageTextual(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTextual() throws Exception;

    public List<TextualDTO> getDataTextual() throws Exception;

    public List<TipoActividad> getTipoActividad() throws Exception;

    public void saveTipoActividad(TipoActividad entity)
        throws Exception;

    public void deleteTipoActividad(TipoActividad entity)
        throws Exception;

    public void updateTipoActividad(TipoActividad entity)
        throws Exception;

    public TipoActividad getTipoActividad(Long tipoActividadCodigo)
        throws Exception;

    public List<TipoActividad> findByCriteriaInTipoActividad(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<TipoActividad> findPageTipoActividad(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoActividad() throws Exception;

    public List<TipoActividadDTO> getDataTipoActividad()
        throws Exception;


    //TODO: Metodos
    public Usuario autenticarUsuario(String correo, String clave) throws Exception;
    
    public List<UsuarioDTO> getDataVtUsuario() throws Exception;
    
    public List<UsuarioDTO> getDataVtUsuarioI() throws Exception;
    
    public String parserXPDL(FileUploadEvent event);
    
    //TODO: Consultas
    public Usuario consultarUsuarioPorCorreo(String correo);
    
    public String consultarRolUsuarioPorCorreo(String correo);
    
    public Usuario correoDisponible(String correo);
    
    public Rol consultarIdRolPorNombre(String nombre);
    
    public String consultarRepositorioPorNombre (String nombre);
    
    public Usuario consultarUsuarioPorID(Long usuarioCodigo);
    
    public Pn consultarPNPorNombre(String nombre);
}
