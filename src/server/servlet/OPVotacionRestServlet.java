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
import model.Usuario;
import model.OPVotacion;

import stateless.SalaService;
import stateless.OPVotacionService;

import servlet.ResponseMessage;

@Path("/opVotacion")
public class OPVotacionRestServlet {
    @EJB
    OPVotacionService opVotacionService;

    private ObjectMapper mapper;

    public OPVotacionRestServlet(){
        mapper = new ObjectMapper();
    }
 
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String create(String json) {
        OPVotacion opVotacion;
        String data;

        try {
            opVotacion = mapper.readValue(json, OPVotacion.class);
            opVotacion = opVotacionService.create(opVotacion);
            data = mapper.writeValueAsString(opVotacion);
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        } 
        catch (IOException e) {
            return ResponseMessage
                .message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }
        return ResponseMessage.message(200,"opVotacion GENERADA correctamente",data);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String update(String json) {
        OPVotacion opVotacion;
        String data;

        try {
            opVotacion = mapper.readValue(json, OPVotacion.class);
            opVotacion = opVotacionService.update(opVotacion);
            data = mapper.writeValueAsString(opVotacion);
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        } 
        catch (IOException e) {
            return ResponseMessage
                .message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }
        return ResponseMessage.message(200,"opVotacion MODIFICADO correctamente",data);
    }

    @DELETE
    @Path("/{id}")
    public String remove(@PathParam("id") int id) {
        opVotacionService.remove(id);
        return ResponseMessage.message(200,"Se eliminó correctamente el tipo de equipo");
    }

}
