package services;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import persistence.dao.DroplistDAO;
import persistence.dto.DroplistDTO;
import persistence.models.Droplist;
import persistence.models.DroplistId;

@ApplicationScoped
public class DroplistService {
  @Inject
  DroplistDAO dao;

  public List<Droplist> listar() {
    return dao.listar();
  }

  public List<DroplistDTO> listarComNomes() {
    return dao.listarComNomes();
  }

  public Droplist buscarPorId(DroplistId droplistId) {
    return dao.buscar(droplistId);
  }

  public List<DroplistDTO> listarPorNpc(Integer mobId) {
    return dao.listarPorNpcComNomes(mobId);
  }

  public Integer excluir(DroplistId droplistId) {
    return dao.excluir(droplistId);
  }
}
