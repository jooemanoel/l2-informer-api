package services;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import persistence.dao.SkillDAO;
import persistence.dto.SkillDTO;
import persistence.models.Skill;

@ApplicationScoped
public class SkillService {
  @Inject
  SkillDAO dao;

  public List<Skill> listar() {
    return dao.listar();
  }

  public List<SkillDTO> listarIdName() {
    return dao.listarIdName();
  }

  public List<Skill> listarPorSkillId(Integer id) {
    return dao.listarPorSkillId(id);
  }
  public List<SkillDTO> listarIdNamePorSkillId(Integer id) {
    return dao.listarIdNamePorSkillId(id);
  }
}
