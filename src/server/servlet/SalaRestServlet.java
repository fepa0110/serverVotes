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

import model.Sala;

import stateless.SalaService;

import servlet.ResponseMessage;

@Path("/salas")
public class SalaRestServlet {
    @EJB
    SalaService salaService;

    private ObjectMapper mapper;

    public SalaRestServlet(){
        mapper = new ObjectMapper();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String findAll() throws IOException{

            // Se modifica este método para que utilice el servicio
        List<Sala> salas = salaService.findAll();

        // Se contruye el resultado en base a lo recuperado desde la capa de negocio.
        String data;

        try {  
            data = mapper.writeValueAsString(salas);
        } 
        catch (IOException e) {
            return ResponseMessage
            .message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }

        return ResponseMessage.message(200,"Salas recuperadas con éxito",data);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String findById(@PathParam("id") int salaId) throws IOException {
        String data;

        Sala sala = new Sala();
        sala.setId(salaId);

        sala = salaService.findById(sala);
        
        try { 
            data = mapper.writeValueAsString(sala);
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        }

        return ResponseMessage.message(200,"Sala "+salaId+" recuperado con éxito",data);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String create(String json) {
        Sala sala;
        String data;

        try {
            sala = mapper.readValue(json, Sala.class);
            sala = salaService.create(sala);
            if(sala.equals(null)){
                return ResponseMessage
                    .message(502, "La sala ya existe");
            }
            data = mapper.writeValueAsString(sala);
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        } 
        catch (IOException e) {
            return ResponseMessage
                .message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }
        return ResponseMessage.message(200,"Sala GENERADA correctamente",data);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String update(String json) {
        Sala sala;
        String data;

        try {
            sala = mapper.readValue(json, Sala.class);
            sala = salaService.update(sala);
            data = mapper.writeValueAsString(sala);
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        } 
        catch (IOException e) {
            return ResponseMessage
                .message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }
        return ResponseMessage.message(200,"Sala MODIFICADO correctamente",data);
    }

    @DELETE
    @Path("/{id}")
    public String remove(@PathParam("id") int id) {
        salaService.remove(id);
        return ResponseMessage.message(200,"Se eliminó correctamente el tipo de equipo");
    }

    @GET
    @Path("/search/{search}")
    @Produces(MediaType.APPLICATION_JSON)
    public String search(@PathParam("search") String search) {

        // Se modifica este método para que utilice el servicio
        Collection<Sala> salas = salaService.search(search);

        if (salas == null || salas.isEmpty()){
            return ResponseMessage.message(505, "No existe tipo de equipo para la búsqueda indicada: " + search);
        }

        String data;
        try {

        data = mapper.writeValueAsString(salas);

        } catch (IOException e) {
        return ResponseMessage.message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }

        return ResponseMessage.message(200, "Se recuperaron los tipo de equipos buscados", data);
    }
}
