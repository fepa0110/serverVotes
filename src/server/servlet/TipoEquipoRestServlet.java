package servlet;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import java.util.List;
import java.util.logging.Logger;
import java.util.Collection;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import model.TipoEquipo;

import stateless.TipoEquipoService;

import servlet.ResponseMessage;

@Path("/tipoEquipos")
public class TipoEquipoRestServlet {
    @EJB
    TipoEquipoService tipoEquipoService;

    private ObjectMapper mapper;

    public TipoEquipoRestServlet(){
        mapper = new ObjectMapper();
    }

    /* @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String findAll(@DefaultValue("1") @QueryParam("page") Integer page,
        @DefaultValue("10") @QueryParam("cant") Integer cant) throws IOException{

            // Se modifica este método para que utilice el servicio
        ResultsPage<TipoEquipo> resultsPage = tipoEquipoService.findByPage(page, cant);

        // Se contruye el resultado en base a lo recuperado desde la capa de negocio.
        String data;

        try {  
            data = mapper.writeValueAsString(resultsPage);
        } 
        catch (IOException e) {
            return ResponseMessage
            .message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }

        return ResponseMessage.message(200,"Tipos de equipo recuperados con éxito",data);
    }*/

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String findById(@PathParam("id") int tipoEquipoId) throws IOException {
        String data;

        TipoEquipo tipoEquipo = new TipoEquipo();
        tipoEquipo.setId(tipoEquipoId);

        tipoEquipo = tipoEquipoService.findById(tipoEquipo);
        
        try { 
            data = mapper.writeValueAsString(tipoEquipo);
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        }

        return ResponseMessage.message(200,"Tipo de equipo "+tipoEquipoId+" recuperado con éxito",data);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String create(String json) {
        TipoEquipo tipoEquipo;
        String data;

        try {
            tipoEquipo = mapper.readValue(json, TipoEquipo.class);
            tipoEquipo = tipoEquipoService.create(tipoEquipo);
            data = mapper.writeValueAsString(tipoEquipo);
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        } 
        catch (IOException e) {
            return ResponseMessage
                .message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }
        return ResponseMessage.message(200,"Tipo de equipo GENERADO correctamente",data);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String update(String json) {
        TipoEquipo tipoEquipo;
        String data;

        try {
            tipoEquipo = mapper.readValue(json, TipoEquipo.class);
            tipoEquipo = tipoEquipoService.update(tipoEquipo);
            data = mapper.writeValueAsString(tipoEquipo);
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        } 
        catch (IOException e) {
            return ResponseMessage
                .message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }
        return ResponseMessage.message(200,"Tipo de equipo MODIFICADO correctamente",data);
    }

    @DELETE
    @Path("/{id}")
    public String remove(@PathParam("id") int id) {
        tipoEquipoService.remove(id);
        return ResponseMessage.message(200,"Se eliminó correctamente el tipo de equipo");
    }

    @GET
    @Path("/search/{search}")
    @Produces(MediaType.APPLICATION_JSON)
    public String search(@PathParam("search") String search) {

        // Se modifica este método para que utilice el servicio
        Collection<TipoEquipo> tipoEquipos = tipoEquipoService.search(search);

        if (tipoEquipos == null || tipoEquipos.isEmpty()){
            return ResponseMessage.message(505, "No existe tipo de equipo para la búsqueda indicada: " + search);
        }

        String data;
        try {

        data = mapper.writeValueAsString(tipoEquipos);

        } catch (IOException e) {
        return ResponseMessage.message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }

        return ResponseMessage.message(200, "Se recuperaron los tipo de equipos buscados", data);
    }
}
