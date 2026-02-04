package me.Flayvor.CadastroSupremo.Missoes.Repository;

import me.Flayvor.CadastroSupremo.Missoes.Models.MissaoSuprema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissaoSupremaRepository extends JpaRepository<MissaoSuprema, Long> {
    // Com o relacionamento ManyToMany, consultas por supremo são feitas de forma diferente.
    // O método findBySupremoId foi removido para resolver o erro de inicialização.
}
