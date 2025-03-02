package services;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import persistence.dao.NpcDAO;
import persistence.dto.NpcDTO;
import persistence.models.Npc;

@ApplicationScoped
public class NpcService {
    @Inject
    NpcDAO dao;

    public List<NpcDTO> listar() {
        return dao.listarIdName();
    }

    public Npc buscarPorId(Integer id) {
        return dao.buscar(id);
    }
}
