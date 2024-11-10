package com.milena.screensounds.principal;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.milena.screensounds.model.Artista;
import com.milena.screensounds.model.Musica;
import com.milena.screensounds.model.TipoArtista;
import com.milena.screensounds.repository.ArtistaRepository;
import com.milena.screensounds.service.ConsultaChatGPT;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    Scanner leitor = new Scanner(System.in);
    private final ArtistaRepository repository;

    private String menu= """
                ********** Screen Sound Músicas **********
                
                1- Cadastrar artistas
                2- Cadastrar músicas
                3 - Listar músicas
                4- Buscar músicas por astistas
                5- Pesquisar dados sobre um artista
                
                9-Sair
                
                Digite a opção desejada: 
                """;

    public Principal(ArtistaRepository repository) {
        this.repository = repository;
    }

    public void exibeMenu() {

        var opcao = -1;

        while(opcao!=9){

            System.out.println(menu);
            opcao = leitor.nextInt();
            leitor.nextLine();

            switch(opcao){
                
                case 1:
                    cadastrarArtistas();
                    break;
                 
                case 2:
                    cadastrarMusicas();
                    break;
                    
                case 3:
                    listarMusicas();
                    break;
                    
                case 4:
                    buscarMusicaPorArtista();
                    break;
                    
                case 5:
                    pesquisarDadosDoArtista();
                    break;
                    
                case 9:
                    System.out.println("A aplicação foi finalizada...");
                    break;
                default:
                    System.out.println("A opção digitada é inválida. Tente novamente");
                    opcao=-1;
            }
        }
    }

    private void cadastrarArtistas() {
        var opcaoCadastro= "S";

        while ((opcaoCadastro.equalsIgnoreCase("S"))){
            System.out.println("Digite o nome do artista que deseja cadastrar: ");
            var nome= leitor.nextLine();


            System.out.println("Informe o tipo de artista: ");
            TipoArtista tipoArtista = TipoArtista.valueOf(leitor.nextLine().toUpperCase());

            Artista artista = new Artista(nome, tipoArtista);
            repository.save(artista);

            System.out.println("Cadastrar outro artista? (S/N)");
            opcaoCadastro = leitor.nextLine();
        }
    }

    private void cadastrarMusicas() {
        System.out.println("Informe o artista que deseja buscar: ");
        var nomeArtista = leitor.nextLine();

        Optional <Artista> artistaBuscado = repository.findByName(nomeArtista);

        if(artistaBuscado.isPresent()){
            System.out.println("Digite a música que deseja cadastrar: ");
            var nomeMusica = leitor.nextLine();

            Musica musica = new Musica(nomeMusica);
            musica.setArtista(artistaBuscado.get());
            artistaBuscado.get().getMusicas().add(musica);
            repository.save(artistaBuscado.get());
        }else{
            System.out.println("Artista não encontrado");
        }
    }

    private void listarMusicas() {
       List <Artista> artistas = repository.findAll();
        artistas.forEach(a->a.getMusicas().forEach(System.out::println));
    }

    private void buscarMusicaPorArtista() {
        System.out.println("Informe o artista que deseja buscar: ");
        var nomeArtista = leitor.nextLine();

        Optional<Artista> artistaBuscado = repository.findByName(nomeArtista);

        if (artistaBuscado.isPresent()) {

            if (!artistaBuscado.get().getMusicas().isEmpty()) {
                List<Musica> listaMusicas = repository.findMusicaByArtista(artistaBuscado.get().getNome());
                listaMusicas.forEach(System.out::println);
            } else {
                System.out.println("Não há músicas cadastradas para este artista");
            }
        } else {
            System.out.println("Artista não encontrado");
        }
    }
    private void pesquisarDadosDoArtista() {
        System.out.println("Informe o artista que deseja buscar: ");
        var nomeArtista = leitor.nextLine();

        Optional<Artista> artistaBuscado = repository.findByName(nomeArtista);

        if (artistaBuscado.isPresent()) {
            var resposta = ConsultaChatGPT.obterInformacao(nomeArtista);
            System.out.println(resposta.trim());
        }else {
            System.out.println("Artista não cadastrado");
        }

    }
}
