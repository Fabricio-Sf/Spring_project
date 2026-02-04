package me.Flayvor.CadastroSupremo.Supremos.Repository;

import me.Flayvor.CadastroSupremo.Supremos.Models.SupremeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Supremosrepository extends JpaRepository<SupremeModel, Long> {
    // O Long ali em cima deve ser o tipo do Atributo ID da sua classe Usuario
    // Basta declarar o método na interface e o Spring "cria" a lógica sozinho
    Optional<SupremeModel> findByEmail(String email);

}
