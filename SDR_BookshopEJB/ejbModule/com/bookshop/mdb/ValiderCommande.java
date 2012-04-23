package com.bookshop.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: ValiderCommande
 *
 */
@MessageDriven(
	    activationConfig = {
	    		@ActivationConfigProperty(propertyName="Listener", propertyValue="BSCListener"),
	        @ActivationConfigProperty(
	            propertyName="ConnectionFactoryJndiName", propertyValue="BSCFactory"),
	        @ActivationConfigProperty(
	            propertyName="destination", propertyValue="queue/BookShopQueue"),
	        @ActivationConfigProperty(
	            propertyName="destinationType", propertyValue="javax.jms.Queue")
	    },  description = "BookShopValidate",name = "EJB MDB BookShop",
		mappedName = "/queue/BookShopQueue")


public class ValiderCommande implements MessageListener {

	
	
	
    /**
     * Default constructor. 
     */
    public ValiderCommande() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message msg) {
    	boolean quit = false;
    	try {
			String msgText;
			if (msg instanceof TextMessage) {
				msgText = ((TextMessage) msg).getText();
			} else {
				msgText = msg.toString();
			}
			System.out.println("\n\t ligne$ " + msgText);
			if (msgText.equalsIgnoreCase("quit")) {
				synchronized (this) {
					quit = true;
					this.notifyAll(); // Notify main thread to quit
				}
			}
		} catch (JMSException jmse) {
			jmse.printStackTrace();
		}
    	
        
        
        
    }

}
