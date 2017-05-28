package co.edu.usb.dataaccess.dao;

import java.io.File;
import java.io.IOException;

import co.edu.usb.clusterbp.Pn;
import co.edu.usb.clusterbp.PnTxt;
import co.edu.usb.clusterbp.dto.PnDTO;
import co.edu.usb.dataaccess.api.Dao;

/**
* Interface for   PnDAO.
*
*/
public interface IPnDAO extends Dao<Pn, Long> {
	 public String crearProceso(Pn XPDL ) throws IOException;
	 public  File[] obtenerProcesos() throws IOException;
	 public  String crearDocumentoEstructura(String nombreXPDL,String contenidoEstructural) throws IOException;
}
