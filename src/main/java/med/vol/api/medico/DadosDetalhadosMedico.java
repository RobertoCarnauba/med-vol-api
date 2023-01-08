package med.vol.api.medico;

import med.vol.api.endereco.Endereco;

public record DadosDetalhadosMedico(Long id,String nome, String email, String telefone, String crm, Especialidade especialidade, Endereco endereco) {

	public DadosDetalhadosMedico(Medico medico) {
		this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
	}

}
