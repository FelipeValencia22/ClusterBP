package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.Repositorio;
import co.edu.usb.clusterbp.dto.RepositorioDTO;
import java.util.List;

/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IRepositorioLogic {
    public List<Repositorio> getRepositorio() throws Exception;

    /**
         * Save an new Repositorio entity
         */
    public void saveRepositorio(Repositorio entity) throws Exception;

    /**
         * Delete an existing Repositorio entity
         *
         */
    public void deleteRepositorio(Repositorio entity) throws Exception;

    /**
        * Update an existing Repositorio entity
        *
        */
    public void updateRepositorio(Repositorio entity) throws Exception;

    /**
         * Load an existing Repositorio entity
         *
         */
    public Repositorio getRepositorio(Long repositorioCodigo)
        throws Exception;

    public List<Repositorio> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Repositorio> findPageRepositorio(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberRepositorio() throws Exception;

    public List<RepositorioDTO> getDataRepositorio() throws Exception;
    
    public List<RepositorioDTO> getDataRepositorioI() throws Exception;
    
  //TODO: Consultas
  	public String consultarRepositorioPorNombre (String nombre);
}
