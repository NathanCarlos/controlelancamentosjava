package br.com.etechoracio.nathan.view;


import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * Escopo personalizado Spring para JSF 2.0.
 * 
 * @author Rogério de Morais
 *
 */
public class ViewScoped implements Scope {

	public Object get(String name, ObjectFactory<?> objectFactory) {
		Map<String, Object> viewMap = FacesContext.getCurrentInstance()
				.getViewRoot().getViewMap();
		if (viewMap.containsKey(name)) {
			return viewMap.get(name);
		} else {
			Object object = objectFactory.getObject();
			viewMap.put(name, object);
			return object;
		}
	}

	public String getConversationId() {
		return null;
	}

	public void registerDestructionCallback(String arg0, Runnable arg1) {
	}

	public Object remove(String name) {
		return FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(name);
	}

	public Object resolveContextualObject(String arg0) {
		return null;
	}

}
