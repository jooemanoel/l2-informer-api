package persistence.dao;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import persistence.dto.NpcSkillDTO;
import persistence.models.NpcSkill;

@ApplicationScoped
public class NpcSkillDAO {
  @Inject
  EntityManager em;

  public List<NpcSkill> listar() {
    TypedQuery<NpcSkill> query = em.createNamedQuery(NpcSkill.LISTAR, NpcSkill.class);
    return query.getResultList();
  }

  public List<NpcSkill> listarPorNpc(Integer npcId) {
    TypedQuery<NpcSkill> query = em.createNamedQuery(NpcSkill.LISTAR_POR_NPC, NpcSkill.class);
    query.setParameter("npcid", npcId);
    return query.getResultList();
  }

  public List<NpcSkillDTO> listarPorNpcComNomes(Integer npcId) {
    TypedQuery<NpcSkillDTO> query = em.createNamedQuery(NpcSkill.LISTAR_POR_NPC_COM_NOMES, NpcSkillDTO.class);
    query.setParameter("npcid", npcId);
    return query.getResultList();
  }

  public NpcSkill buscar(NpcSkill.NpcSkillId id) {
    return em.find(NpcSkill.class, id);
  }

  @Transactional
  public Integer excluir(NpcSkill.NpcSkillId npcSkillId) {
    NpcSkill npcSkill = em.find(NpcSkill.class, npcSkillId);
    if (npcSkill != null)
      em.remove(npcSkill);
    return npcSkillId.getSkillid();
  }
}
