package med.vol.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.domain.Paciente;
import med.vol.api.dto.paciente.DadosAtualizacaoPaciente;
import med.vol.api.dto.paciente.DadosCadastroPaciente;
import med.vol.api.dto.paciente.DadosListagemPaciente;
import med.vol.api.repository.PacienteRepository;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

	@Autowired
	private PacienteRepository repository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
		repository.save(new Paciente(dados));
	}

//    @GetMapping
//    public List<DadosListagemPaciente> listaPaciente(){
//    	return repository.findAll().stream().map(DadosListagemPaciente::new).toList();
//    }

	@GetMapping
	public Page<DadosListagemPaciente> listaPaciente(@PageableDefault(size = 5, sort = { "nome" }) Pageable pageable) {
		return repository.findAllByAtivoTrue(pageable).map(DadosListagemPaciente::new);
	}

	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
		var paciente = repository.getReferenceById(dados.id());
		paciente.atualizarInformacoes(dados);
	}
 
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		var paciente = repository.getReferenceById(id);
		paciente.excluir();
	}

}
