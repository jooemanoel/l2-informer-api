package rest;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import persistence.dto.NpcDTO;
import persistence.models.Npc;
import services.NpcService;

@RequestScoped
@Path("/npc")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NpcResource {
  @Inject
  NpcService service;

  @GET
  @Operation(summary = "Listar NPC", description = "Retorna a lista de NPC")
  public List<NpcDTO> listar() {
    return service.listar();
  }

  @GET
  @Path("/{id}")
  @Operation(summary = "Listar NPC", description = "Retorna a lista de NPC")
  public Npc consultar(Integer id) {
    return service.buscarPorId(id);
  }
}
