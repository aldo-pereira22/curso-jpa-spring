package com.dev22;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dev22.domain.Categoria;
import com.dev22.domain.Cidade;
import com.dev22.domain.Estado;
import com.dev22.domain.Produto;
import com.dev22.repositories.CategoriaRepository;
import com.dev22.repositories.CidadeRepository;
import com.dev22.repositories.EstadoRepository;
import com.dev22.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoJpaSpringApplication implements CommandLineRunner{

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoJpaSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

		
		Estado estado1 = new Estado(null, "Minas Gerais");
		Estado estado2 = new Estado(null, "Saão Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", estado1);
		Cidade c2 = new Cidade(null, "São Paulo", estado2);
		Cidade c3 = new Cidade(null, "Campinas", estado1);
		
		estado1.getCidades().addAll(Arrays.asList(c1));
		estado1.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
				
		
		
	}
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
