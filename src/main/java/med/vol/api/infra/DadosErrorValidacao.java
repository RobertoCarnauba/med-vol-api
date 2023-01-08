package med.vol.api.infra;

import org.springframework.validation.FieldError;

public record DadosErrorValidacao(String campo, String mensagem) {

	public DadosErrorValidacao(FieldError erro) {
		this(erro.getField(), erro.getDefaultMessage());
	}
}
