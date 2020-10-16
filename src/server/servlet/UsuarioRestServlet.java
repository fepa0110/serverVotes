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
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


import model.Usuario;

import stateless.UsuarioService;

import servlet.ResponseMessage;


@Path("/usuarios")
public class UsuarioRestServlet {
    @EJB
    UsuarioService usuarioService;

    private ObjectMapper mapper;

    public UsuarioRestServlet(){
        mapper = new ObjectMapper();
        mapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);

        // Le provee el formateador de fechas.
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        mapper.setDateFormat(df);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String create(String json) {
        Usuario usuario;
        String dataUsuario;

        try {
            usuario = mapper.readValue(json, Usuario.class);
            usuario = usuarioService.create(usuario);
            
            if(usuario == null){
                return ResponseMessage
                    .message(502, "El usuario ya existe");
            }
            
            dataUsuario = mapper.writeValueAsString(usuario);
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        } 
        catch (IOException e) {
            return ResponseMessage
                .message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }
        return ResponseMessage.message(200,"Usuario GENERADO correctamente",dataUsuario);
    }
    
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String autentificarUsuario(String json) throws IOException{
        Usuario usuario;
        String data;

        try {
            usuario = mapper.readValue(json, Usuario.class);
            Usuario usuarioAutentificado = usuarioService.autenticarUsuario(usuario);
            
            if(usuarioAutentificado == null){
                return ResponseMessage
                    .message(502, "Usuario o contraseña no validos.");
            }
            
            data = mapper.writeValueAsString(usuarioAutentificado);
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        } 
        catch (IOException e) {
            return ResponseMessage
                .message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }
        return ResponseMessage.message(200,"Usuario AUTENTIFICADO correctamente",data);
    }

    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public String findById(@PathParam("username") String username) throws IOException {
        String data;

        Usuario usuario = new Usuario();
        usuario.setUsername(username);

        usuario = usuarioService.findByUsername(usuario);
        usuario.setContrasenia(null);
        
        try { 
            data = mapper.writeValueAsString(usuario);
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        }

        return ResponseMessage.message(200,"Usuario "+username+" recuperado con éxito",data);
    }
}
