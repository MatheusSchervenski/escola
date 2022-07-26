package com.escola.escola.controlle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.escola.escola.alunos.Aluno;
import com.escola.escola.repository.AlunoRepository;
import com.escola.escola.service.AlunoService;


@RestController
@RequestMapping("/Aluno")
public class AlunoControlle {

	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired
	private AlunoService alunoService;
	@Value("${database.url}")
	private String databaseUrl;
	
	@GetMapping
	public List<Aluno> obtertudo() {
		
		return this.alunoService.obtertudo();
		
	}
	@GetMapping("/teste")
	public ResponseEntity obterid(@RequestHeader org.springframework.http.HttpHeaders hearders) {

		return new ResponseEntity("clienteid "+hearders.get("teste50"),HttpStatus.OK);
	}
	@GetMapping("/{id}")
    public Aluno obter(@PathVariable String id) {
		return this.alunoService.obter(id);
    }
	
	@GetMapping(value = "/welcome")
	public ResponseEntity<String> teste() {
		 return new ResponseEntity<String>(databaseUrl,HttpStatus.OK);
	}
	@GetMapping(value = "/")
	public ResponseEntity nomes(@RequestParam (value="nome")String nome )  {
		

		return new ResponseEntity("ola :"+nome,HttpStatus.OK);
	}
	@GetMapping(value = "/buscarpornome")
	@ResponseBody
	public ResponseEntity<List<Aluno>> nome(@RequestParam (name ="nome") String nome)  {
		List<Aluno> aluno =alunoRepository.findByNome(nome);
		return new ResponseEntity<List<Aluno>>(aluno,HttpStatus.OK);
	
		
	}

	
	@PostMapping("/criar")
	public Aluno criar(@RequestBody Aluno aluno) {
		return this.alunoService.criar(aluno);
		
	}
	@PutMapping
	public Aluno alterar(@RequestBody Aluno aluno) {
		return this.alunoService.alterar(aluno);
		}
	@DeleteMapping
	public void deletar(@RequestBody Aluno aluno) {
		this.alunoService.deletar(aluno);
	}

}