package servlet;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;

import java.io.IOException;
import java.text.SimpleDateFormat;

import model.Duracion;
import model.Sala;

import stateless.DuracionService;
import stateless.SalaService;

import servlet.ResponseMessage;



@Path("/duraciones")
public class DuracionRestServlet {
    @EJB
    DuracionService duracionService;

    @EJB
    SalaService salaService;


    private ObjectMapper mapper;

    public DuracionRestServlet(){
        mapper = new ObjectMapper();
        mapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);

        // Le provee el formateador de fechas.
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        mapper.setDateFormat(df);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String findById(@PathParam("id") int salaId) throws IOException {
        String data;
        Duracion duracion;

        Sala sala = new Sala();
        sala.setId(salaId);

        duracion = duracionService.findById(sala);
        
        try { 
            data = mapper.writeValueAsString(duracion);
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        }

        return ResponseMessage.message(200,"Sala "+salaId+" recuperado con éxito",data);
    }

    @POST
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String create(@PathParam("id") int salaId, String json) {
        Duracion duracion;
        String dataDuracion;

        try {

            Sala sala = new Sala();
            sala.setId(salaId);
            duracion = mapper.readValue(json, Duracion.class);

            sala = salaService.findById(sala);
            if(sala != null){
                
                duracion.setSala(sala);
                duracion = duracionService.create(duracion);

            }else{
                return ResponseMessage
                .message(502, "No existe la sala solicitada");

            } 


            if(duracion == null){
                return ResponseMessage
                    .message(502, "La duracion ya existe");
            }
            
            dataDuracion = mapper.writeValueAsString(duracion);
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        } 
        catch (IOException e) {
            return ResponseMessage
                .message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }
        return ResponseMessage.message(200,"Duracion GENERADO correctamente",dataDuracion);
    }

    @POST
    @Path("/actualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String update(String json) {
        Duracion duracion;
        String data;

        try {
            duracion = mapper.readValue(json, Duracion.class);
            duracion = duracionService.update(duracion);
            data = mapper.writeValueAsString(duracion);
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        } 
        catch (IOException e) {
            return ResponseMessage
                .message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }
        return ResponseMessage.message(200,"La duracion de la sala a sido MODIFICADO correctamente",data);
    }

    
    



   
}

