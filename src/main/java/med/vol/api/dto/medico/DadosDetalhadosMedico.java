package med.vol.api.dto.medico;

import med.vol.api.domain.Endereco;
import med.vol.api.domain.Especialidade;
import med.vol.api.domain.Medico;

public record DadosDetalhadosMedico(Long id,String nome, String email, String telefone, String crm, Especialidade especialidade, Endereco endereco) {

	public DadosDetalhadosMedico(Medico medico) {
		this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
	}

}
