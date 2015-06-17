package org.rage.ticket.util;


import org.rage.ticket.model.CommonBase;
import org.rage.ticket.model.Ticket;


/**
 * ErrorHandlerHelper
 *
 * @version $Id$
 * @since 20/02/2015
 *
 */
public final class ErrorHandlerHelper
{

   /**
    * Represents setErorMessages
    *
    * @param ticket
    * @param exception
    * @return ticket
    * @since 20/02/2015
    *
    */
   public static Ticket handleErrorMessages (final Ticket ticket, final Exception exception)
   {
      Ticket ticketWithError = ticket;
      if (ticketWithError == null)
      {
         ticketWithError = new Ticket ();
      }
      ticketWithError.setErrorMessage (exception.getMessage ());
      ticketWithError.setValid (Boolean.FALSE);
      return ticketWithError;
   }


   /**
    * Represents setErorMessages
    *
    * @param base
    * @param exception
    * @since 20/02/2015
    *
    */
   public static void handleErrorMessages (final CommonBase base, final Exception exception)
   {
      base.setErrorMessage (exception.getMessage ());
      base.setValid (Boolean.FALSE);
   }
}
