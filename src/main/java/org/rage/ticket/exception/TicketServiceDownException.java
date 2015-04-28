package org.rage.ticket.exception;


/**
 * TicketServiceDownException
 *
 * @since 20/03/2015
 *
 */
public class TicketServiceDownException extends TicketBaseException
{

   /**
    * Constructs an instance of TicketServiceDownException object.
    *
    * @param errorMessage
    */
   public TicketServiceDownException (final String errorMessage)
   {
      super (errorMessage);

   }


   /**
    * Constructs an instance of TicketServiceDownException object.
    * 
    * @param errorMessage
    * @param exception
    */
   public TicketServiceDownException (final String errorMessage, final Throwable exception)
   {
      super (errorMessage, exception);

   }

   /** long for serialVersionUID */
   private static final long serialVersionUID = 1L;

}
