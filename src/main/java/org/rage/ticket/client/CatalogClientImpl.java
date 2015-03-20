package org.rage.ticket.client;


import org.rage.ticket.model.Catalog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * CatalogClientImpl represents ...
 *
 * @author hector.mendoza
 * @since 20/03/2015
 *
 */
@Component ("catalogClient")
public class CatalogClientImpl implements CatalogClient
{
   private transient RestTemplate restTemplate;
   private transient String       server;
   private transient String       applicationPath;
   private transient String       listPath;
   private transient String       getByIdPath;


   private String getUrl (final String operation)
   {
      return this.server + this.applicationPath + operation;
   }


   /**
    * Overrides getCatalogList
    *
    * @param name
    * @return response
    * @since 20/03/2015
    * @see org.rage.ticket.client.CatalogClient#getCatalogList(java.lang.String)
    */
   public List <Catalog> getCatalogList (final String name)
   {
      final Map <String, String> variables = new HashMap <String, String> ();
      variables.put ("name", name);
      final List response = restTemplate.getForObject (getUrl (listPath), List.class, variables);
      return response;
   }


   /**
    * Overrides getCatalogById
    *
    * @param name
    * @param id
    * @return response
    * @since 20/03/2015
    * @see org.rage.ticket.client.CatalogClient#getCatalogById(java.lang.String, java.lang.Integer)
    */
   public Catalog getCatalogById (final String name, final Integer id)
   {
      final Map <String, String> variables = new HashMap <String, String> ();
      variables.put ("name", name);
      final Catalog response = restTemplate.getForObject (getUrl (getByIdPath + "/" + id + "/"), Catalog.class,
            variables);
      return response;
   }



   /**
    * @param listPath the listPath to set
    */
   @Value ("#{systemProperties.catalogList}")
   public void setListPath (final String listPath)
   {
      this.listPath = listPath;
   }


   /**
    * @param getByIdPath the getByIdPath to set
    */
   @Value ("#{systemProperties.catalogGetById}")
   public void setGetByIdPath (final String getByIdPath)
   {
      this.getByIdPath = getByIdPath;
   }


   /**
    * @param server the server to set
    */
   @Value ("#{systemProperties.server}")
   public void setServer (final String server)
   {
      this.server = server;
   }


   /**
    * @param applicationPath the applicationPath to set
    */
   @Value ("#{systemProperties.catalogProject}")
   public void setApplicationPath (final String applicationPath)
   {
      this.applicationPath = applicationPath;
   }

}
