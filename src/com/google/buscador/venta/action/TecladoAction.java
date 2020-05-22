package com.google.buscador.venta.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.google.buscador.venta.bean.TecladoBean;
import com.google.buscador.venta.bean.CategoriaBean;
import com.google.buscador.venta.service.TecladoServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

@ParentPackage("dawi")
public class TecladoAction extends ActionSupport{


	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private List<CategoriaBean> lstCategoria;
	
	@Getter @Setter
	private TecladoBean teclado;
	
	// Acceder a Session en Struts
	private Map<String, Object> session = ActionContext.getContext().getSession();

	
	
	@Action(value = "/cargaCategoria", results = { @Result(name = "salida", type = "json") })
	public String metodo01() {
		TecladoServiceImpl service = new TecladoServiceImpl();
		try {
			lstCategoria = service.listaCategoria();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "salida";
	}
	   // Para que no se inserte al hacer F5 se tiene que enviar por sendRedirec
		// Es como se copiara la ruta en el Browser
		// para eso el Struts tiene un type="redirect"

		@Action(value = "/registraTecla", results = {@Result(name = "salida", location = "/registraTeclado.jsp", type = "redirect") })
		public String metodo02() {
			TecladoServiceImpl service = new TecladoServiceImpl();
			try {
				int s = service.insertaTeclado(teclado);
				if (s > 0) {
					session.put("MENSAJE", "Registro exitoso");
				} else {
					session.put("MENSAJE", "Registro erróneo");
				}
			} catch (Exception e) {
				e.printStackTrace();
				session.put("MENSAJE", "Registro erróneo");
			}

			return "salida";
		}
	
}



