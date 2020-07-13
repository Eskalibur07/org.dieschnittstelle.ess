package org.dieschnittstelle.ess.ejb.client.shopping;

import org.apache.logging.log4j.Logger;
import org.dieschnittstelle.ess.ejb.client.ejbclients.EJBProxyFactory;
import org.dieschnittstelle.ess.ejb.client.ejbclients.ShoppingCartClient;
import org.dieschnittstelle.ess.ejb.ejbmodule.crm.ShoppingException;
import org.dieschnittstelle.ess.ejb.ejbmodule.crm.shopping.PurchaseShoppingCartService;
import org.dieschnittstelle.ess.entities.crm.AbstractTouchpoint;
import org.dieschnittstelle.ess.entities.crm.Customer;
import org.dieschnittstelle.ess.entities.crm.ShoppingCartItem;
import org.dieschnittstelle.ess.entities.erp.AbstractProduct;
import org.dieschnittstelle.ess.entities.erp.Campaign;

public class ShoppingSessionClient implements ShoppingBusinessDelegate {

	protected static Logger logger = org.apache.logging.log4j.LogManager
			.getLogger(ShoppingSessionClient.class);


	private AbstractTouchpoint touchpoint;

	private Customer customer;

	private ShoppingCartClient shoppingCartClient;

	private PurchaseShoppingCartService purchaseShoppingCartService;
		/*
		 * TODO use a proxy for the ShoppingSessionFacadeRemote interface
		 */

	// Sioki -ShoppingSessionFacadeClient - PurchaseClient olmali

	public ShoppingSessionClient() {
		try {
			this.shoppingCartClient = new ShoppingCartClient();
			this.purchaseShoppingCartService = EJBProxyFactory
					.getInstance()
					.getProxy(PurchaseShoppingCartService.class, "",true);
			/* TODO: instantiate the proxy using the EJBProxyFactory (see the other client classes) */
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	/* TODO: implement the following methods using the proxy */

	@Override
	public void setTouchpoint(AbstractTouchpoint touchpoint) {
		this.touchpoint = touchpoint;
	}

	@Override
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public void addProduct(AbstractProduct product, int units) {
		ShoppingCartItem item = new ShoppingCartItem(product.getId(), units);
		if (product instanceof Campaign) {
			item.setCampaign(true);
		}
		this.shoppingCartClient.addItem(item);
	}

	@Override
	public void purchase() throws ShoppingException {
		// SIOKI - getshoppingCartId() yi görmüyor - 11.07 EJB+JPA 1 32.min
		// ESS 10 PAT-2 Demo PAT1-teil1 53:34
		this.purchaseShoppingCartService
				.purchase(shoppingCartClient.getShoppingCartEntityId(), touchpoint.getId(), customer.getId());
	}

}
