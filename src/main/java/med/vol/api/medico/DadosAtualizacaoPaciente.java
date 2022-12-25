package med.vol.api.medico;

import io.micrometer.common.lang.NonNull;
import med.vol.api.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(@NonNull
		Long id, String nome,String email, String telefone, DadosEndereco endereco) {

}
