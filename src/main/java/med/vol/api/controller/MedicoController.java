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
import med.vol.api.medico.DadosAtualizacaoMedico;
import med.vol.api.medico.DadosCadastroMedico;
import med.vol.api.medico.DadosListagemMedico;
import med.vol.api.medico.Medico;
import med.vol.api.medico.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private MedicoRepository repository;

	@PostMapping
	@Transactional
	public void cadastraMedico(@RequestBody @Valid DadosCadastroMedico dados) {
		repository.save(new Medico(dados));
	}

	@GetMapping
	public Page<DadosListagemMedico> listaMedicos(@PageableDefault(size = 10, sort = { "nome" }) Pageable pageable) {
		return repository.findAllByAtivoTrue(pageable).map(DadosListagemMedico::new);
	}

	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
		var medico = repository.getReferenceById(dados.id());
		medico.atualizarInformacoes(dados);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		var medico = repository.getReferenceById(id);
		medico.excluir();
	}

}
