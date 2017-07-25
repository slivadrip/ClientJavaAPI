package com.slivadrip.socialbooks.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.slivadrip.socialbooks.client.LivrosClient;
import com.slivadrip.socialbooks.client.domain.Livro;

public class Aplicacao {
 
	public static void main(String[] args) throws ParseException {
	
		LivrosClient cliente = new LivrosClient("http://localhost:8080", "adriano", "1234");
		
		List<Livro> listaLivros = cliente.listar();
		
		for(Livro livro : listaLivros){
			System.out.println("Livro : " + livro.getNome() );
		}
		
		Livro livro = new Livro();
		livro.setNome("Adriano the king BRAZIL");
		livro.setEditora("moderna");
		
		SimpleDateFormat publicacao = new SimpleDateFormat("dd/MM/yyyy");
		livro.setPublicacao(publicacao.parse("01/01/2017"));
		
		livro.setResumo("Este livro e bom");
		
		String  localizacao = cliente.salvar(livro);
		
		System.out.println("URI do livro salvo" + localizacao);
		
		Livro livroBuscado = cliente.buscar(localizacao);
		
		System.out.println("Livro Buscado: " + livroBuscado.getNome());

	}
}
