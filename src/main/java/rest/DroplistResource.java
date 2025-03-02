package rest;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import persistence.dto.DroplistDTO;
import persistence.models.DroplistId;
import services.DroplistService;

@RequestScoped
@Path("/droplist")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DroplistResource {
  @Inject
  DroplistService service;

  @GET
  @Operation(summary = "Listar droplist", description = "Retorna uma lista")
  public List<DroplistDTO> listarComNomes() {
    return service.listarComNomes();
  }

  @DELETE
  @Operation(summary = "Excluir droplist", description = "Exclui")
  public Integer excluir(
      @QueryParam("mobId") Integer mobId,
      @QueryParam("itemId") Integer itemId,
      @QueryParam("category") Integer category) {
    DroplistId droplistId = new DroplistId(mobId, itemId, category);
    return service.excluir(droplistId);
  }

  @GET
  @Path("/npc/{id}")
  @Operation(summary = "Buscar droplist por Npc", description = "Retorna uma lista")
  public List<DroplistDTO> listarPorNpc(Integer id) {
    return service.listarPorNpc(id);
  }
}
