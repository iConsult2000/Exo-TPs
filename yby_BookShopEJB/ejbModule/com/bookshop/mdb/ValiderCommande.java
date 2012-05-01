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
	        @ActivationConfigProperty(
	            propertyName="destination", propertyValue="/queue/BookShopQueue"),
	        @ActivationConfigProperty(
	            propertyName="destinationType", propertyValue="javax.jms.Queue")
	    },  description = "BookShopValidate",name = "ValiderCommandeMDB",
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
    public void onMessage(Message message) {
    	System.out.println("Je suis rentré dans le MDB!!!");
    	  TextMessage msg = null;

    	    try {
    	        if (message instanceof TextMessage) {
    	            msg = (TextMessage) message;
    	            System.out.println
    	                ("MESSAGE BEAN: Message received: " + msg.getText());
    	        } else {
    	            System.out.println
    	                ("Message of wrong type: " 
    	                + message.getClass().getName());
    	        }
    	    } catch (JMSException e) {
    	        e.printStackTrace();
    	    } catch (Throwable te) {
    	        te.printStackTrace();
    	    }
        
    }
    
  
    

}
