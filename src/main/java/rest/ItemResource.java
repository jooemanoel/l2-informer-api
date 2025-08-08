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
import persistence.models.Item;
import services.ItemService;

@RequestScoped
@Path("/item")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {
  @Inject
  ItemService service;

  @GET
  @Operation(summary = "Listar item", description = "Retorna uma lista")
  public List<Item> listar() {
    return service.listar();
  }

  @GET
  @Path("/{id}")
  @Operation(summary = "Buscar item", description = "Retorna um item")
  public Item consultar(Long id) {
    return service.buscarPorId(id);
  }
}
