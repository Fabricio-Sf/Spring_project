package config;

import demo.model.Cargo;
import demo.model.Funcionario;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Qualifier("funcionarioJoao")
    public Funcionario bean1(){
        return new Funcionario("João", Cargo.GERENTE, 5000.0);
    }

    @Qualifier("funcionarioJose")
    public Funcionario bean2(){
        return new Funcionario("Jose", Cargo.GERENTE, 5000.0);
    }
}
