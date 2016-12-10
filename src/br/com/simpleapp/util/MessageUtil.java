/**
 * 
 */
package br.com.simpleapp.util;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * @author delan
 *
 */
@RequestScoped
public class MessageUtil {

	private FacesContext facesContext = FacesContext.getCurrentInstance();

	public void msgInfo(String msg) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
		facesContext.addMessage(null, facesMessage);
	}

	public void msgWarning(String msg) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, null);
		facesContext.addMessage(null, facesMessage);
	}

	public void msgFatalError(String msg) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, null);
		facesContext.addMessage(null, facesMessage);
	}

	public void msgError(String msg) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
		facesContext.addMessage(null, facesMessage);
	}

	public FacesContext getFacesContext() {
		return facesContext;
	}
}
