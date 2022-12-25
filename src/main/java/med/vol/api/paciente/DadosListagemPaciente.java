package med.vol.api.paciente;

import med.vol.api.endereco.Endereco;

public record DadosListagemPaciente(Long id, String nome, String email, String telefone, Endereco endereco) {
	
	public DadosListagemPaciente(Paciente paciente) {
		this(paciente.getId(), paciente.getNome(), paciente.getEmail(),paciente.getTelefone(), paciente.getEndereco());
	}

}
