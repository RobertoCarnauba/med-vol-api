package med.vol.api.medico;

import io.micrometer.common.lang.NonNull;
import med.vol.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
		@NonNull
		Long id, String nome, String telefone, DadosEndereco endereco  ) {

}
