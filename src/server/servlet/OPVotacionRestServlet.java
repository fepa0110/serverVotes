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
import java.util.ArrayList;
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

@Path("/opVotaciones")
public class OPVotacionRestServlet {
    @EJB
    OPVotacionService opVotacionService;
    @EJB
    SalaService salaService;

    private ObjectMapper mapper;

    public OPVotacionRestServlet(){
        mapper = new ObjectMapper();
    }
 
    @POST
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String create(@PathParam("id") int sala_id, String json) {
        OPVotacion opVotacion;
        List<OPVotacion> listOPvotacion = new ArrayList<>();
        Sala sala;
        String data;

        try {
            sala = new Sala();
            sala.setId(sala_id);
            sala = salaService.findById(sala);
            listOPvotacion = sala.getOpVotacion();
            opVotacion = mapper.readValue(json, OPVotacion.class);
            listOPvotacion.add(opVotacion);
            sala.setOpVotacion(listOPvotacion);
            salaService.update(sala);
            //opVotacion = opVotacionService.create(opVotacion, sala_id);
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
    @Path("/{id_sala}/{id_opVt}")
    public String remove(@PathParam("id_sala") int sala_id, @PathParam("id_opVt") int opVt_id) {
        List<OPVotacion> listOPvotacion = new ArrayList<>();
        Sala sala;

            sala = new Sala();
            sala.setId(sala_id);
            sala = salaService.findById(sala);
            listOPvotacion = sala.getOpVotacion();
            for (int i = 0; i < listOPvotacion.size(); i++ ){
                if (listOPvotacion.get(i).getId() == opVt_id){
                    listOPvotacion.remove(i);
                }
            }
            sala.setOpVotacion(listOPvotacion);
            salaService.update(sala);

        //opVotacionService.remove(id);
        return ResponseMessage.message(200,"Se eliminó correctamente la Opcion de Votacion");
    }

}
