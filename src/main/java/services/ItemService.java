package services;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import persistence.dao.ItemDAO;
import persistence.models.Item;

@ApplicationScoped
public class ItemService {
  @Inject
  ItemDAO dao;

  public List<Item> listar() {
    return dao.listar();
  }

  public Item buscarPorId(Long id) {
    return dao.buscar(id);
  }
}
