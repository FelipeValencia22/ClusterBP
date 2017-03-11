package co.edu.usb.presentation.businessDelegate;


import co.edu.usb.clusterbp.Pn;
import co.edu.usb.clusterbp.Repositorio;
import co.edu.usb.clusterbp.RepositorioPn;
import co.edu.usb.clusterbp.Rol;
import co.edu.usb.clusterbp.TipoArchivoPn;
import co.edu.usb.clusterbp.Usuario;
import co.edu.usb.clusterbp.UsuarioRol;
import co.edu.usb.clusterbp.control.IPnLogic;
import co.edu.usb.clusterbp.control.IRepositorioLogic;
import co.edu.usb.clusterbp.control.IRepositorioPnLogic;
import co.edu.usb.clusterbp.control.IRolLogic;
import co.edu.usb.clusterbp.control.ISeguridadLogica;
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
import co.edu.usb.clusterbp.dto.PnDTO;
import co.edu.usb.clusterbp.dto.RepositorioDTO;
import co.edu.usb.clusterbp.dto.RepositorioPnDTO;
import co.edu.usb.clusterbp.dto.RolDTO;
import co.edu.usb.clusterbp.dto.TipoArchivoPnDTO;
import co.edu.usb.clusterbp.dto.UsuarioDTO;
import co.edu.usb.clusterbp.dto.UsuarioRolDTO;
import co.edu.usb.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.sql.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
    private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);
    @Autowired
    private IPnLogic pnLogic;
    @Autowired
    private IRepositorioLogic repositorioLogic;
    @Autowired
    private IRepositorioPnLogic repositorioPnLogic;
    @Autowired
    private IRolLogic rolLogic;
    @Autowired
    private ITipoArchivoPnLogic tipoArchivoPnLogic;
    @Autowired
    private IUsuarioLogic usuarioLogic;
    @Autowired
    private IUsuarioRolLogic usuarioRolLogic;
    @Autowired
    private ISeguridadLogica seguridadLogica;

    public List<Pn> getPn() throws Exception {
        return pnLogic.getPn();
    }

    public void savePn(Pn entity) throws Exception {
        pnLogic.savePn(entity);
    }

    public void deletePn(Pn entity) throws Exception {
        pnLogic.deletePn(entity);
    }

    public void updatePn(Pn entity) throws Exception {
        pnLogic.updatePn(entity);
    }

    public Pn getPn(Long pnCodigo) throws Exception {
        Pn pn = null;

        try {
            pn = pnLogic.getPn(pnCodigo);
        } catch (Exception e) {
            throw e;
        }

        return pn;
    }

    public List<Pn> findByCriteriaInPn(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return pnLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Pn> findPagePn(String sortColumnName, boolean sortAscending,
        int startRow, int maxResults) throws Exception {
        return pnLogic.findPagePn(sortColumnName, sortAscending, startRow,
            maxResults);
    }

    public Long findTotalNumberPn() throws Exception {
        return pnLogic.findTotalNumberPn();
    }

    public List<PnDTO> getDataPn() throws Exception {
        return pnLogic.getDataPn();
    }
    
    public List<PnDTO> getDataPnI() throws Exception {
        return pnLogic.getDataPnI(); 
    }

    public List<Repositorio> getRepositorio() throws Exception {
        return repositorioLogic.getRepositorio();
    }

    public void saveRepositorio(Repositorio entity) throws Exception {
        repositorioLogic.saveRepositorio(entity);
    }

    public void deleteRepositorio(Repositorio entity) throws Exception {
        repositorioLogic.deleteRepositorio(entity);
    }

    public void updateRepositorio(Repositorio entity) throws Exception {
        repositorioLogic.updateRepositorio(entity);
    }

    public Repositorio getRepositorio(Long repositorioCodigo)
        throws Exception {
        Repositorio repositorio = null;

        try {
            repositorio = repositorioLogic.getRepositorio(repositorioCodigo);
        } catch (Exception e) {
            throw e;
        }

        return repositorio;
    }

    public List<Repositorio> findByCriteriaInRepositorio(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return repositorioLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Repositorio> findPageRepositorio(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return repositorioLogic.findPageRepositorio(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberRepositorio() throws Exception {
        return repositorioLogic.findTotalNumberRepositorio();
    }

    public List<RepositorioDTO> getDataRepositorio() throws Exception {
        return repositorioLogic.getDataRepositorio();
    }
    
    public List<RepositorioDTO> getDataRepositorioI() throws Exception {
        return repositorioLogic.getDataRepositorioI();
    }

    public List<RepositorioPn> getRepositorioPn() throws Exception {
        return repositorioPnLogic.getRepositorioPn();
    }

    public void saveRepositorioPn(RepositorioPn entity)
        throws Exception {
        repositorioPnLogic.saveRepositorioPn(entity);
    }

    public void deleteRepositorioPn(RepositorioPn entity)
        throws Exception {
        repositorioPnLogic.deleteRepositorioPn(entity);
    }

    public void updateRepositorioPn(RepositorioPn entity)
        throws Exception {
        repositorioPnLogic.updateRepositorioPn(entity);
    }

    public RepositorioPn getRepositorioPn(Long repositorioPnCodigo)
        throws Exception {
        RepositorioPn repositorioPn = null;

        try {
            repositorioPn = repositorioPnLogic.getRepositorioPn(repositorioPnCodigo);
        } catch (Exception e) {
            throw e;
        }

        return repositorioPn;
    }

    public List<RepositorioPn> findByCriteriaInRepositorioPn(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return repositorioPnLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<RepositorioPn> findPageRepositorioPn(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return repositorioPnLogic.findPageRepositorioPn(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberRepositorioPn() throws Exception {
        return repositorioPnLogic.findTotalNumberRepositorioPn();
    }

    public List<RepositorioPnDTO> getDataRepositorioPn()
        throws Exception {
        return repositorioPnLogic.getDataRepositorioPn();
    }

    public List<Rol> getRol() throws Exception {
        return rolLogic.getRol();
    }

    public void saveRol(Rol entity) throws Exception {
        rolLogic.saveRol(entity);
    }

    public void deleteRol(Rol entity) throws Exception {
        rolLogic.deleteRol(entity);
    }

    public void updateRol(Rol entity) throws Exception {
        rolLogic.updateRol(entity);
    }

    public Rol getRol(Long rolCodigo) throws Exception {
        Rol rol = null;

        try {
            rol = rolLogic.getRol(rolCodigo);
        } catch (Exception e) {
            throw e;
        }

        return rol;
    }

    public List<Rol> findByCriteriaInRol(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return rolLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Rol> findPageRol(String sortColumnName, boolean sortAscending,
        int startRow, int maxResults) throws Exception {
        return rolLogic.findPageRol(sortColumnName, sortAscending, startRow,
            maxResults);
    }

    public Long findTotalNumberRol() throws Exception {
        return rolLogic.findTotalNumberRol();
    }

    public List<RolDTO> getDataRol() throws Exception {
        return rolLogic.getDataRol();
    }

    public List<TipoArchivoPn> getTipoArchivoPn() throws Exception {
        return tipoArchivoPnLogic.getTipoArchivoPn();
    }

    public void saveTipoArchivoPn(TipoArchivoPn entity)
        throws Exception {
        tipoArchivoPnLogic.saveTipoArchivoPn(entity);
    }

    public void deleteTipoArchivoPn(TipoArchivoPn entity)
        throws Exception {
        tipoArchivoPnLogic.deleteTipoArchivoPn(entity);
    }

    public void updateTipoArchivoPn(TipoArchivoPn entity)
        throws Exception {
        tipoArchivoPnLogic.updateTipoArchivoPn(entity);
    }

    public TipoArchivoPn getTipoArchivoPn(Long tipoArchivoPnCodigo)
        throws Exception {
        TipoArchivoPn tipoArchivoPn = null;

        try {
            tipoArchivoPn = tipoArchivoPnLogic.getTipoArchivoPn(tipoArchivoPnCodigo);
        } catch (Exception e) {
            throw e;
        }

        return tipoArchivoPn;
    }

    public List<TipoArchivoPn> findByCriteriaInTipoArchivoPn(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tipoArchivoPnLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoArchivoPn> findPageTipoArchivoPn(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoArchivoPnLogic.findPageTipoArchivoPn(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoArchivoPn() throws Exception {
        return tipoArchivoPnLogic.findTotalNumberTipoArchivoPn();
    }

    public List<TipoArchivoPnDTO> getDataTipoArchivoPn()
        throws Exception {
        return tipoArchivoPnLogic.getDataTipoArchivoPn();
    }

    public List<Usuario> getUsuario() throws Exception {
        return usuarioLogic.getUsuario();
    }

    public void saveUsuario(Usuario entity) throws Exception {
        usuarioLogic.saveUsuario(entity);
    }

    public void deleteUsuario(Usuario entity) throws Exception {
        usuarioLogic.deleteUsuario(entity);
    }

    public void updateUsuario(Usuario entity) throws Exception {
        usuarioLogic.updateUsuario(entity);
    }

    public Usuario getUsuario(Long usuarioCodigo) throws Exception {
        Usuario usuario = null;

        try {
            usuario = usuarioLogic.getUsuario(usuarioCodigo);
        } catch (Exception e) {
            throw e;
        }

        return usuario;
    }

    public List<Usuario> findByCriteriaInUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return usuarioLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Usuario> findPageUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return usuarioLogic.findPageUsuario(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberUsuario() throws Exception {
        return usuarioLogic.findTotalNumberUsuario();
    }

    public List<UsuarioDTO> getDataUsuario() throws Exception {
        return usuarioLogic.getDataUsuario();
    }

    public List<UsuarioRol> getUsuarioRol() throws Exception {
        return usuarioRolLogic.getUsuarioRol();
    }

    public void saveUsuarioRol(UsuarioRol entity) throws Exception {
        usuarioRolLogic.saveUsuarioRol(entity);
    }

    public void deleteUsuarioRol(UsuarioRol entity) throws Exception {
        usuarioRolLogic.deleteUsuarioRol(entity);
    }

    public void updateUsuarioRol(UsuarioRol entity) throws Exception {
        usuarioRolLogic.updateUsuarioRol(entity);
    }

    public UsuarioRol getUsuarioRol(Long usuarioRolCodigo)
        throws Exception {
        UsuarioRol usuarioRol = null;

        try {
            usuarioRol = usuarioRolLogic.getUsuarioRol(usuarioRolCodigo);
        } catch (Exception e) {
            throw e;
        }

        return usuarioRol;
    }

    public List<UsuarioRol> findByCriteriaInUsuarioRol(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return usuarioRolLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<UsuarioRol> findPageUsuarioRol(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return usuarioRolLogic.findPageUsuarioRol(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberUsuarioRol() throws Exception {
        return usuarioRolLogic.findTotalNumberUsuarioRol();
    }

    public List<UsuarioRolDTO> getDataUsuarioRol() throws Exception {
        return usuarioRolLogic.getDataUsuarioRol();
    }

    //TODO: Consultas
    @Override
	public Usuario consultarUsuarioPorCorreo(String correo) {
		return usuarioLogic.consultarUsuarioPorCorreo(correo);
	}
    
    @Override
    public String consultarRolUsuarioPorCorreo(String correo) {
		return rolLogic.consultarRolUsuarioPorCorreo(correo);
	}

	@Override
	public Usuario autenticarUsuario(String correo, String clave) throws Exception {
		return seguridadLogica.autenticarUsuario(correo, clave);
	}

	@Override
	public Usuario correoDisponible(String correo) {
		return usuarioLogic.consultarCorreoDisponible(correo);
	}

	@Override
	public List<UsuarioDTO> getDataVtUsuario() throws Exception {
		return usuarioLogic.getDataUsuario();
	}

	@Override
	public List<UsuarioDTO> getDataVtUsuarioI() throws Exception{
		return usuarioLogic.getDataUsuarioI();
	}

	@Override
	public Rol consultarIdRolPorNombre(String nombre) {
		return rolLogic.consultarIdRolPorNombre(nombre);
	}
	
	@Override
	public String consultarRepositorioPorNombre(String nombre) {
		return repositorioLogic.consultarRepositorioPorNombre(nombre);
	}
	
	@Override
	public Usuario consultarUsuarioPorID(Long usuarioCodigo) {
		return usuarioLogic.consultarUsuarioPorID(usuarioCodigo);
	}

    
}
