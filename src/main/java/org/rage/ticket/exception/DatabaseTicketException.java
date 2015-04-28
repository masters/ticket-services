package org.rage.ticket.exception;


/**
 * DatabaseTicketException
 *
 * @version $Id$
 * @since 20/02/2015
 *
 */
public class DatabaseTicketException extends TicketBaseException
{

   /** long for serialVersionUID */
   private static final long serialVersionUID = 1L;


   /**
    * Constructs an instance of DatabaseTicketException object.
    *
    * @param errorMessage
    */
   public DatabaseTicketException (final String errorMessage)
   {
      super (errorMessage);

   }

}
