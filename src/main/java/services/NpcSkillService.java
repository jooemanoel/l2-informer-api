package services;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import persistence.dao.NpcSkillDAO;
import persistence.dto.NpcSkillDTO;
import persistence.models.NpcSkill;

@ApplicationScoped
public class NpcSkillService {
  @Inject
  NpcSkillDAO dao;

  public List<NpcSkill> listar() {
    return dao.listar();
  }

  public List<NpcSkillDTO> listarPorNpcComNomes(Integer npcId) {
    return dao.listarPorNpcComNomes(npcId);
  }

  public NpcSkill buscarPorId(NpcSkill.NpcSkillId id) {
    return dao.buscar(id);
  }

  public Integer excluir(NpcSkill.NpcSkillId id) {
    return dao.excluir(id);
  }
}
