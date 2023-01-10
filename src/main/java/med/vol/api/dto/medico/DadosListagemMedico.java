package med.vol.api.dto.medico;

import med.vol.api.domain.Especialidade;
import med.vol.api.domain.Medico;

public record DadosListagemMedico(Long id,String nome, String email, String telefone, String crm, Especialidade especialidade) {

	public DadosListagemMedico(Medico medico) {
		this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade());
	}

}
