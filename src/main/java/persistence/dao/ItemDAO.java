package persistence.dao;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import persistence.models.Item;

@ApplicationScoped
public class ItemDAO {

  @Inject
  EntityManager em;

  public List<Item> listar() {
    TypedQuery<Item> query = em.createNamedQuery(Item.LISTAR, Item.class);
    return query.getResultList();
  }

  public Item buscar(Long id) {
    return em.find(Item.class, id);
  }
}
