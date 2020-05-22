package org.dieschnittstelle.ess.basics;


import org.dieschnittstelle.ess.basics.annotations.AnnotatedStockItemBuilder;
import org.dieschnittstelle.ess.basics.annotations.DisplayAs;
import org.dieschnittstelle.ess.basics.annotations.StockItemProxyImpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.dieschnittstelle.ess.utils.Utils.show;

public class ShowAnnotations {

	public static void main(String[] args) {
		// we initialise the collection
		StockItemCollection collection = new StockItemCollection(
				"stockitems_annotations.xml", new AnnotatedStockItemBuilder());
		// we load the contents into the collection
		collection.load();

		for (IStockItem consumable : collection.getStockItems()) {

			showAttributes(((StockItemProxyImpl)consumable).getProxiedObject());
		}

		// we initialise a consumer
		Consumer consumer = new Consumer();
		// ... and let them consume
		consumer.doShopping(collection.getStockItems());
	}

	/*
	 * UE BAS2 
	 */
	private static void showAttributes(Object consumable) {
		String a = consumable.getClass().getSimpleName();
		try {
			for (Field field : consumable.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				if(!field.isAnnotationPresent(DisplayAs.class)) {
					a += " " + field.getName() + ": " + field.get(consumable) + ",";
				}else{
					a += " " + field.getName() + ": " + field.getAnnotation(DisplayAs.class).value() + ",";
				}
			}
		}catch (Exception e){
			Logger.getLogger(ShowAnnotations.class.getName()).log(Level.WARNING, e.getMessage());
		}
		a = a.substring(0, a.lastIndexOf(","));
		a = "{"+a+"}";
		show(a);
	}
}