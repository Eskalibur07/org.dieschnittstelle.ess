package org.dieschnittstelle.ess.jrs;

import java.util.List;

import org.dieschnittstelle.ess.entities.GenericCRUDExecutor;
import org.dieschnittstelle.ess.entities.erp.AbstractProduct;
//import org.dieschnittstelle.ess.entities.erp.AbstractProduct;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

/*
 	JRS2: implementieren Sie hier die im Interface deklarierten Methoden
 */

public class ProductCRUDServiceImpl implements IProductCRUDService {

	@Context
	private ServletContext servletContext;

	private GenericCRUDExecutor<AbstractProduct> gce;

	private GenericCRUDExecutor<AbstractProduct> readExecFromServletContext(){
		return (GenericCRUDExecutor<AbstractProduct>) servletContext.getAttribute("productCRUD");
	}

	public ProductCRUDServiceImpl(@Context ServletContext servletContext) {
		this.gce = (GenericCRUDExecutor<AbstractProduct>) servletContext.getAttribute("productCRUD");
	}

	@Override
	public AbstractProduct createProduct(AbstractProduct prod) {
		// TODO Auto-generated method stub
		return (AbstractProduct) this.readExecFromServletContext().createObject(prod);
	}

	@Override
	public List<AbstractProduct> readAllProducts() {
		// TODO Auto-generated method stub
		return (List) this.readExecFromServletContext().readAllObjects();
		//return null;
	}

	@Override
	public AbstractProduct updateProduct(long id, AbstractProduct update) {
		// TODO Auto-generated method stub
		return (AbstractProduct) this.readExecFromServletContext().updateObject(update);
		//return null;
	}

	@Override
	public boolean deleteProduct(long id) {
		// TODO Auto-generated method stub
		return this.readExecFromServletContext().deleteObject(id);
		//return false;
	}

	@Override
	public AbstractProduct readProduct(long id) {
		// TODO Auto-generated method stub
		return (AbstractProduct) this.readExecFromServletContext().readObject(id);
		//return null;
	}

}
