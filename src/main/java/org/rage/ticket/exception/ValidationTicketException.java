package org.rage.ticket.exception;


/**
 * ValidationTicketException
 *
 * @version $Id$
 * @since 20/02/2015
 *
 */
public class ValidationTicketException extends TicketBaseException
{

   /** long for serialVersionUID */
   private static final long serialVersionUID = 1L;


   /**
    * Constructs an instance of ValidationTicketException object.
    *
    * @param errorMessage
    */
   public ValidationTicketException (final String errorMessage)
   {
      super (errorMessage);

   }

}
