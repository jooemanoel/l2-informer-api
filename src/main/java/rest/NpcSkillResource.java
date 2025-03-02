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
import persistence.dto.NpcSkillDTO;
import persistence.models.NpcSkill;
import services.NpcSkillService;

@RequestScoped
@Path("/npcskill")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NpcSkillResource {
  @Inject
  NpcSkillService service;

  @GET
  @Operation(summary = "Listar NpcSkill", description = "Retorna uma lista")
  public List<NpcSkill> listar() {
    return service.listar();
  }

  @DELETE
  @Operation(summary = "Excluir NpcSkill", description = "Exclui uma skill de um npc")
  public Integer excluir(@QueryParam("npcid") Integer mobId,
      @QueryParam("skillid") Integer skillId,
      @QueryParam("level") Integer category) {
    NpcSkill.NpcSkillId npcSkillId = new NpcSkill.NpcSkillId(mobId, skillId, category);
    return service.excluir(npcSkillId);
  }

  @GET
  @Path("/{npcId}")
  @Operation(summary = "Buscar NpcSkill", description = "Retorna uma lista")
  public List<NpcSkillDTO> listarPorNpcComNomes(Integer npcId) {
    return service.listarPorNpcComNomes(npcId);
  }
}
