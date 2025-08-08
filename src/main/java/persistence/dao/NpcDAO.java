package persistence.dao;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import persistence.dto.NpcDTO;
import persistence.models.Npc;

@ApplicationScoped
public class NpcDAO {

  @Inject
  EntityManager em;

  public List<Npc> listar() {
    TypedQuery<Npc> query = em.createNamedQuery(Npc.LISTAR, Npc.class);
    return query.getResultList();
  }

  public Npc buscar(Integer id) {
    return em.find(Npc.class, id);
  }

  public List<NpcDTO> listarIdName() {
    TypedQuery<NpcDTO> query = em.createNamedQuery(Npc.LISTAR_ID_NAME, NpcDTO.class);
    return query.getResultList();
  }
}
