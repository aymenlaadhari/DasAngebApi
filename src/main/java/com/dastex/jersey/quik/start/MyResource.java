package com.dastex.jersey.quik.start;

import com.dastex.jersey.quik.start.dao.DocDao;
import com.dastex.jersey.quik.start.dao.DocDaoInterface;
import com.dastex.jersey.quik.start.model.Artikel;
import com.dastex.jersey.quik.start.model.Bearbeiter;
import com.dastex.jersey.quik.start.model.Kunden;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
    private List<Kunden> kundens;
    private List<Artikel> allArtikels;
    private final DocDaoInterface daoInterface = new DocDao();
    

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "Json" media type.
     *
     * @return String that will be returned as a Json response.
     */
    
    @GET
    @Path("/artikels")
    @Produces(MediaType.APPLICATION_JSON)
    public String listArtikels() {
        allArtikels = daoInterface.getListArtikel();
        return jsonFormat(allArtikels);
    }

    @GET
    @Path("/artikel")
    @Consumes("text/plain")
    @Produces(MediaType.APPLICATION_JSON)
    public String getArtikel(@QueryParam("art_nummer") String art_nummer)
    {
        Artikel artikel = daoInterface.getSingelArtikle(art_nummer, "", "d", "1");
        return jsonFormat(artikel);
    }
    
    @GET
    @Path("/kundens")
    @Produces(MediaType.APPLICATION_JSON)
    public String listKunden()
    {
        kundens = daoInterface.getListKunden();
        return jsonFormat(kundens); 
    }
    
    @GET
    @Path("/kund")
    @Consumes("text/plain")
    @Produces(MediaType.APPLICATION_JSON)
    public String getKund(@QueryParam("kund_nummer") String kund_nummer)
    {
        Kunden kunden = daoInterface.getListKundenByCriteria(kund_nummer, "", "", "").get(0);
        return jsonFormat(kunden); 
    }
    
 
    @GET
    @Path("/bearbeiter")
    @Consumes("text/plain")
    @Produces(MediaType.APPLICATION_JSON)
    public String getBearbeiter(@QueryParam("login") String login)
    {
        Bearbeiter bearbeiter = daoInterface.getBearbeiterByCriteria(login);
        return jsonFormat(bearbeiter);
    }
    
    
     
     private String jsonFormat(Object object)
     {
        String feeds = null;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        feeds = gson.toJson(object);
        return feeds;
     }
}
