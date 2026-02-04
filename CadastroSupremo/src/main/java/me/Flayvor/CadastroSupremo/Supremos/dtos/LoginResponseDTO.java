package me.Flayvor.CadastroSupremo.Supremos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {
    private String message;
    // No futuro, você pode adicionar o token JWT aqui.
    // private String token;
}
