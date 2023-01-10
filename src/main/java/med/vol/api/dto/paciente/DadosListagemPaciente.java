package med.vol.api.dto.paciente;

import med.vol.api.domain.Endereco;
import med.vol.api.domain.Paciente;

public record DadosListagemPaciente(Long id, String nome, String email, String telefone, Endereco endereco) {
	
	public DadosListagemPaciente(Paciente paciente) {
		this(paciente.getId(), paciente.getNome(), paciente.getEmail(),paciente.getTelefone(), paciente.getEndereco());
	}

}
