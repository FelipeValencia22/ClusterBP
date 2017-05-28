package co.edu.usb.dataaccess.dao;

import co.edu.usb.clusterbp.Pn;
import co.edu.usb.clusterbp.configuracion.PATH;
import co.edu.usb.dataaccess.api.HibernateDaoImpl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


import javax.annotation.Resource;


/**
 * A data access object (DAO) providing persistence and search support for
 * Pn entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Pn
 */
@Scope("singleton")
@Repository("PnDAO")
public class PnDAO extends HibernateDaoImpl<Pn, Long> implements IPnDAO {
    private static final Logger log = LoggerFactory.getLogger(PnDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IPnDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IPnDAO) ctx.getBean("PnDAO");
    }
  //Permite crear los  procesos XPDL en el servidor.
    public  String crearProceso(Pn XPDL ) throws IOException {

    		FileOutputStream out = new FileOutputStream(PATH.RUTA_REPOSITORIO_XPDL+XPDL.getNombre());
        	out.write(XPDL.getContenido().getBytes());
        	out.close();
        	
		return "Completado";
    }
    
    
    public  String crearDocumentoEstructura(String nombreXPDL,String contenidoEstructural) throws IOException {

		FileOutputStream out = new FileOutputStream(PATH.RUTA_REPOSITORIO_TXT+nombreXPDL.split(".xpdl")[0]+".txt");
		out.write(contenidoEstructural.getBytes());
    	out.close();
    	
	return "Completado";
}
    
    
    
    //Permite obtener todos los procesos xpdl 
    public  File[] obtenerProcesos() throws IOException {
        // Aquí la carpeta donde queremos buscar

        File folder = new File(PATH.RUTA_REPOSITORIO_XPDL);
        File[] listOfFiles = folder.listFiles(); 

    	return listOfFiles;
    }
    
    
    
}
