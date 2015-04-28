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
   public static Ticket handleErrorMessages (Ticket ticket, final Exception exception)
   {
      if (ticket == null)
      {
         ticket = new Ticket ();
      }
      ticket.setErrorMessage (exception.getMessage ());
      ticket.setValid (Boolean.FALSE);
      return ticket;
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
