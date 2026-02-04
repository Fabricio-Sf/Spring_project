package me.Flayvor.CadastroSupremo.Missoes.dtos;

import lombok.Data;
import java.util.List;

@Data
public class AtribuirSupremosRequestDTO {
    private List<Long> supremoIds;
}
