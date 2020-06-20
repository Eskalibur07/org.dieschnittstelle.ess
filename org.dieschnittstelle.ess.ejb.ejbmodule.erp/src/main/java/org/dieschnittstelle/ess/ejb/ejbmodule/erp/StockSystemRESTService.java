package org.dieschnittstelle.ess.ejb.ejbmodule.erp;

import org.dieschnittstelle.ess.entities.erp.IndividualisedProductItem;

import javax.ejb.Remote;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

/**
 * TODO:
 * if you decide to expose the stock system functionality using REST services rather than remote EJB interfaces:
 * - declare the web api for this interface using JAX-RS
 * - implement the interface as an EJB of an appropriate type
 * - in the EJB, delegate method invocations to the corresponding methods of the StockSystem EJB
 * - let the StockSystemClient in the client project access the web api via this interface - see ShoppingCartClient for an example
 */
@Remote
@Path("/stocksystem")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface StockSystemRESTService {

	/**
	 * adds some units of a product to the stock of a point of sale
	 */
	@POST
	@Path("/{productId}/{pointOfSaleId}/{units}")
    void addToStock(@PathParam("productId") long productId, @PathParam("pointOfSaleId") long pointOfSaleId, @PathParam("units") int units);

	/**
	 * removes some units of a product from the stock of a point of sale
	 */
	@DELETE
	@Path("/{productId}/{pointOfSaleId}/{units}")
	void removeFromStock(@PathParam("productId") long productId, @PathParam("pointOfSaleId") long pointOfSaleId, @PathParam("units") int units);

	/**
	 * returns all products on stock of some pointOfSale
	 */
    List<IndividualisedProductItem> getProductsOnStock(long pointOfSaleId);

	/**
	 * returns all products on stock
	 */
    List<IndividualisedProductItem> getAllProductsOnStock();

	/**
	 * returns the units on stock for a product at some point of sale
	 */
    int getUnitsOnStock(long productId, long pointOfSaleId);

	/**
	 * returns the total number of units on stock for some product
	 */
    int getTotalUnitsOnStock(long productId);

	/**
	 * returns the points of sale where some product is available
	 */
    List<Long> getPointsOfSale(long productId);

}
