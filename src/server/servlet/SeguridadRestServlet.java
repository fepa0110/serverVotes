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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

import java.io.IOException;
import java.text.SimpleDateFormat;

import model.Seguridad;
import model.Usuario;

import stateless.SeguridadService;
import stateless.UsuarioService;

import servlet.ResponseMessage;



@Path("/seguridad")
public class SeguridadRestServlet {
    @EJB
    SeguridadService seguridadService;

    @EJB
    UsuarioService usuarioService;

    private ObjectMapper mapper;

    public SeguridadRestServlet(){
        mapper = new ObjectMapper();
    }

    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public String findById(@PathParam("username") String username) throws IOException {
        String data;

        Usuario usuario = new Usuario();
        usuario.setUsername(username);

        List<Seguridad> segu = seguridadService.findById(usuario);
        
        try { 
            data = mapper.writeValueAsString(segu);
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        }

        return ResponseMessage.message(200,"Seguridad recuperada con éxito",data);
    }

    @POST
    @Path("/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String create(@PathParam("username") String username, String json) {
        Seguridad seguridad;
        String data;

        try {

            Usuario usuario = new Usuario();
            usuario.setUsername(username);

            seguridad = mapper.readValue(json, Seguridad.class);

            usuario = usuarioService.findByUsername(usuario);
            if(usuario != null){
                
                seguridad.setUsuario(usuario);
                seguridad = seguridadService.create(seguridad);

            }else{
                return ResponseMessage
                .message(502, "No existe el usuario solicitado");

            } 


            if(seguridad == null){
                return ResponseMessage
                    .message(502, "La seguridad del usuario ya existe");
            }
            
            data = mapper.writeValueAsString(seguridad);
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        } 
        catch (IOException e) {
            return ResponseMessage
                .message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }
        return ResponseMessage.message(200,"Duracion GENERADO correctamente",data);
    }

    @PUT
    @Path("/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@PathParam("username") String username, String json) {
        Seguridad seguridad;
        String data;

        try {
            Usuario usuario = new Usuario();
            usuario.setUsername(username);
            usuario = usuarioService.findByUsername(usuario);
            seguridad = mapper.readValue(json, Seguridad.class);
            seguridad.setUsuario(usuario);
            seguridad = seguridadService.update(seguridad);
            data = mapper.writeValueAsString(seguridad);
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        } 
        catch (IOException e) {
            return ResponseMessage
                .message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }
        return ResponseMessage.message(200,"La seguridad de la sala a sido MODIFICADO correctamente",data);
    }

    @DELETE
    @Path("/{id}")
    public String remove(@PathParam("id") int id) {
        seguridadService.remove(id);
        return ResponseMessage.message(200,"Seguridad eliminada correctamente");
    }

}