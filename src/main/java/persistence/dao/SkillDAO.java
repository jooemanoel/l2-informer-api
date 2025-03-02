package persistence.dao;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import persistence.dto.SkillDTO;
import persistence.models.Skill;
import persistence.models.SkillId;

@ApplicationScoped
public class SkillDAO {
  @Inject
  EntityManager em;

  public List<Skill> listar() {
    TypedQuery<Skill> query = em.createNamedQuery(Skill.LISTAR, Skill.class);
    return query.getResultList();
  }

  public List<SkillDTO> listarIdName() {
    TypedQuery<SkillDTO> query = em.createNamedQuery(Skill.LISTAR_ID_NAME, SkillDTO.class);
    return query.getResultList();
  }

  public List<Skill> listarPorSkillId(Integer skillId) {
    TypedQuery<Skill> query = em.createNamedQuery(Skill.LISTAR_POR_ID, Skill.class);
    query.setParameter("id", skillId);
    return query.getResultList();
  }

  public List<SkillDTO> listarIdNamePorSkillId(Integer skillId) {
    TypedQuery<SkillDTO> query = em.createNamedQuery(Skill.LISTAR_ID_NAME_POR_ID, SkillDTO.class);
    query.setParameter("id", skillId);
    return query.getResultList();
  }

  public Skill buscar(SkillId id) {
    return em.find(Skill.class, id);
  }
}
