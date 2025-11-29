package com.acarb.repository;

import com.acarb.model.SolicitacaoServico;
import com.acarb.model.StatusSolicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SolicitacaoServicoRepository extends JpaRepository<SolicitacaoServico, Long> {

    // Método para buscar solicitações que ainda não foram atendidas
    List<SolicitacaoServico> findByStatus(StatusSolicitacao status);

    // Método para buscar solicitações de um motorista específico
    List<SolicitacaoServico> findByMotoristaIdMotorista(Long idMotorista);
}