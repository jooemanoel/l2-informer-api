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
import persistence.dto.SkillDTO;
import persistence.models.Skill;
import services.SkillService;

@RequestScoped
@Path("/skill")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SkillResource {
@Inject
  SkillService service;

  @GET
  @Operation(summary = "Listar skill", description = "Retorna uma lista")
  public List<SkillDTO> listarIdName() {
    return service.listarIdName();
  }

  @GET
  @Path("/{id}")
  @Operation(summary = "Listar skill por skillId", description = "Retorna uma lista")
  public List<Skill> listarPorSkillId(Integer id) {
    return service.listarPorSkillId(id);
  }
}
