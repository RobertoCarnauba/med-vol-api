package med.vol.api.dto.paciente;

import io.micrometer.common.lang.NonNull;
import med.vol.api.dto.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(@NonNull
		Long id, String nome,String email, String telefone, DadosEndereco endereco) {

}
