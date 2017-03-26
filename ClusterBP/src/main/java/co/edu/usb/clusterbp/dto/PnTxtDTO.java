package co.edu.usb.clusterbp.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class PnTxtDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(PnTxtDTO.class);
    private Long pnTxtCodigo;
    private String texto;
    private Long pnCodigo_Pn;

    public Long getPnTxtCodigo() {
        return pnTxtCodigo;
    }

    public void setPnTxtCodigo(Long pnTxtCodigo) {
        this.pnTxtCodigo = pnTxtCodigo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getPnCodigo_Pn() {
        return pnCodigo_Pn;
    }

    public void setPnCodigo_Pn(Long pnCodigo_Pn) {
        this.pnCodigo_Pn = pnCodigo_Pn;
    }
}
