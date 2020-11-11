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
import java.util.logging.Logger;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import model.Sala;
import model.Usuario;
import model.OPVotacion;
import model.Votante;
import model.VotanteDni;
import model.EstadoSala;

import stateless.UsuarioService;
import stateless.SalaService;
import stateless.VotanteService;
import stateless.VotanteDniService;
import stateless.OPVotacionService;

import servlet.ResponseMessage;

@Path("/salas")
public class SalaRestServlet {
    @EJB
    SalaService salaService;

    @EJB
    VotanteService votanteService;

    @EJB
    VotanteDniService votanteDniService;

    @EJB
    UsuarioService usuarioService;

    @EJB
    OPVotacionService opVotacionService;

    public Logger logger = Logger.getLogger(getClass().getName());

    private ObjectMapper mapper;

    public SalaRestServlet(){
        mapper = new ObjectMapper();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String findAll() throws IOException{       

            // Se modifica este método para que utilice el servicio
        List<Sala> salas = salaService.findAll();
        for(Sala sala : salas){
            sala.getUsuarios().setUbicacion(null);
        }

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

    @GET
    @Path("/userVotante/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByVotante(@PathParam("username") String username) throws IOException {
        String data;
        String data2;
        String data3;

        Usuario usuario = new Usuario();
        usuario.setUsername(username);

        List<Sala> salas = salaService.findByUserVotante(usuario);
//        usuario = usuarioService.findByUsername(usuario);
//        List<Sala> salas2 = salaService.findByUserVotanteDni(usuario);
        
        try { 
            data = mapper.writeValueAsString(salas);
//            data2 = mapper.writeValueAsString(salas2);
//            data3 = data +","+ data2;
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        }

        return ResponseMessage.message(200,"Salas recuperadas con éxito",data);
    }

    @GET
    @Path("/userVotanteDni/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByVotanteDni(@PathParam("username") String username) throws IOException {
        String data;

        Usuario usuario = new Usuario();
        usuario.setUsername(username);

        usuario = usuarioService.findByUsername(usuario);
        List<Sala> salas = salaService.findByUserVotanteDni(usuario);
        
        try { 
            data = mapper.writeValueAsString(salas);
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        }

        return ResponseMessage.message(200,"Salas recuperadas con éxito",data);
    }

    @GET
    @Path("/user/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public String findAll(@PathParam("username") String username) throws IOException{
        Usuario usuario = new Usuario();
        usuario.setUsername(username);

        // Se modifica este método para que utilice el servicio
        List<Sala> salas = salaService.findByUsername(usuario);

        // Se contruye el resultado en base a lo recuperado desde la capa de negocio.
        String data;

        try {  
            data = mapper.writeValueAsString(salas);
        } 
        catch (IOException e) {
            return ResponseMessage
            .message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }

        return ResponseMessage.message(200,"Salas creadas por "+username+" recuperadas con éxito",data);
    }

    @POST
    @Path("/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String create(String json, @PathParam("username") String username) {
        Sala sala;
        String data;

        try {
            Usuario usuario = new Usuario();
            usuario.setUsername(username);

            sala = mapper.readValue(json, Sala.class);
            sala = salaService.create(sala,usuario);

            if(sala == null){
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

    @POST
    @Path("/addByUsername/{idSala}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addVotantesByUsername(String json, @PathParam("idSala") int idSala) {
        Sala sala;
        String data;

        try {
            List<Usuario> usuarios = mapper.readValue(json, new TypeReference<List<Usuario>>(){});
            logger.info("Lista de usuarios parseada: ");
            for (Usuario user : usuarios){
                logger.info("Usuario recibido: "+user.getUsername());
            }

            sala = new Sala();
            sala.setId(idSala);

            List<Votante> votantesAgregados = votanteService.addVotantesByUsername(usuarios, sala);
            
            data = mapper.writeValueAsString(votantesAgregados);
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        } 
        catch (IOException e) {
            return ResponseMessage
                .message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }
        return ResponseMessage.message(200,"Votantes AGREGADOS correctamente",data);
    }

    @POST
    @Path("/addByDni/{idSala}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addVotantesByDni(String json, @PathParam("idSala") int idSala) {
        Sala sala;
        String data;

        try {
            List<Usuario> usuarios = mapper.readValue(json, new TypeReference<List<Usuario>>(){});
            logger.info("Lista de usuarios parseada: ");
            for (Usuario user : usuarios){
                logger.info("Usuario recibido: "+user.getUsername());
            }

            sala = new Sala();
            sala.setId(idSala);

            List<VotanteDni> votantesAgregados = votanteDniService.addVotantesByDni(usuarios, sala);
            
            data = mapper.writeValueAsString(votantesAgregados);
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        } 
        catch (IOException e) {
            return ResponseMessage
                .message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }
        return ResponseMessage.message(200,"Votantes AGREGADOS correctamente",data);
    }

    
    @GET
    @Path("/addByDni/{idSala}")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByDniSala(@PathParam("idSala") int salaId) throws IOException{
        Sala sala = new Sala();
        sala.setId(salaId);

        // Se modifica este método para que utilice el servicio
        List<VotanteDni> votantes = votanteDniService.findBySala(sala);

        // Se contruye el resultado en base a lo recuperado desde la capa de negocio.
        String data;

        try {  
            data = mapper.writeValueAsString(votantes);
        } 
        catch (IOException e) {
            return ResponseMessage
            .message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }

        return ResponseMessage.message(200,"Votantes DNI recuperad@s con éxito",data);
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
        return ResponseMessage.message(200,"Sala eliminada correctamente");
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
    
    @POST
    @Path("/contrasenia/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String create(@PathParam("id") int sala_id, String json) {
        Sala sala;
        Sala sala2;
        String data;

        try {
            sala = mapper.readValue(json, Sala.class);
            sala.setId(sala_id);
            sala2 = salaService.findById(sala);
            sala2.setContrasenia(sala.getContrasenia());
            salaService.update(sala2);
            data = mapper.writeValueAsString(sala2);
        } 
        catch (JsonProcessingException e) {
            return ResponseMessage
                .message(502, "No se pudo dar formato a la salida", e.getMessage());
        } 
        catch (IOException e) {
            return ResponseMessage
                .message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }
        return ResponseMessage.message(200,"contraseña guardada correctamente",data);
    }

    @GET    
    @Path("/finalizar/{idSala}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String finalizar(@PathParam("idSala") int idSala) {
        Sala sala;
        String data;

        sala = new Sala();
        sala.setId(idSala);

        try {
            sala = salaService.finalizar(sala);
            data = mapper.writeValueAsString(sala);
        } 
        catch (IOException e) {
            return ResponseMessage
                .message(501, "Formato incorrecto en datos de entrada", e.getMessage());
        }
        return ResponseMessage.message(200,"Sala FINALIZADA correctamente",data);
    }

    @PUT
    @Path("/estadoSala/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateEstado(@PathParam("id") int sala_id, String json) {
        Sala sala;
        String data;
        Sala sala2;

        try {
            sala = new Sala();
            sala.setId(sala_id);
            sala = salaService.findById(sala);
            sala2 = mapper.readValue(json, Sala.class);
            sala.setEstado(sala2.getEstado());
            salaService.update(sala);
            //opVotacion = opVotacionService.create(opVotacion, sala_id);
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

        return ResponseMessage.message(200,"Estado GENERADO correctamente",data);
    }


    @PUT
    @Path("/addVotacion/{id}/{userName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String votacion(@PathParam("id") int sala_id,@PathParam("userName") String userName, String json) {
        OPVotacion opVotacion;
        Sala sala;
        Usuario usuario;
        Votante votante;
        VotanteDni votanteDni;
        String data;

        try {
            opVotacion = mapper.readValue(json, OPVotacion.class);
            opVotacion = opVotacionService.update(opVotacion);
            
            sala = new Sala();
            sala.setId(sala_id);
            sala = salaService.findById(sala);

            usuario = new Usuario();
            usuario.setUsername(userName);
            usuario = usuarioService.findByUsername(usuario);

            votante = votanteService.findByVotante(sala, usuario);
            if(votante != null){
                votante.setVoto(true);
                votante = votanteService.update(votante);
            }

            votanteDni = votanteDniService.findByVotante(sala, usuario);
            if(votanteDni != null){ 
                votanteDni.setVoto(true);
                votanteDni = votanteDniService.update(votanteDni);
            }
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
        return ResponseMessage.message(200,"Votacion agregada correctamente",data);
    }

}
