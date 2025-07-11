package persistence.dao;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import persistence.dto.DroplistDTO;
import persistence.models.Droplist;
import persistence.models.DroplistId;

@ApplicationScoped
public class DroplistDAO {
  @Inject
  EntityManager em;

  public List<Droplist> listar() {
    TypedQuery<Droplist> query = em.createNamedQuery(Droplist.LISTAR, Droplist.class);
    return query.getResultList();
  }

  public List<DroplistDTO> listarComNomes() {
    TypedQuery<DroplistDTO> query = em.createNamedQuery(Droplist.LISTAR_COM_NOMES, DroplistDTO.class);
    return query.getResultList();
  }

  public List<Droplist> listarPorNpc(Integer mobId) {
    TypedQuery<Droplist> query = em.createNamedQuery(Droplist.LISTAR_POR_NPC, Droplist.class);
    query.setParameter("mobId", mobId);
    return query.getResultList();
  }

  public List<DroplistDTO> listarPorNpcComNomes(Integer mobId) {
    TypedQuery<DroplistDTO> query = em.createNamedQuery(Droplist.LISTAR_POR_NPC_COM_NOMES, DroplistDTO.class);
    query.setParameter("mobId", mobId);
    return query.getResultList();
  }

  public List<DroplistDTO> listarPorItemComNomes(Integer itemId) {
    TypedQuery<DroplistDTO> query = em.createNamedQuery(Droplist.LISTAR_POR_ITEM_COM_NOMES, DroplistDTO.class);
    query.setParameter("itemId", itemId);
    return query.getResultList();
  }

  public Droplist buscar(DroplistId droplistId) {
    return em.find(Droplist.class, droplistId);
  }

  @Transactional
  public Integer excluir(DroplistId droplistId) {
    Droplist droplist = em.find(Droplist.class, droplistId);
    if (droplist != null)
      em.remove(droplist);
    return droplistId.getItemId();
  }
}
