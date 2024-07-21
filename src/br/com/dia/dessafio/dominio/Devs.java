package br.com.dia.dessafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Devs {

    private String nome;

    private Set<Conteudo> conteudosIncritos = new LinkedHashSet<Conteudo>();

    private Set<Conteudo> conteudoConluidos = new LinkedHashSet<Conteudo>();

    public void increverBootcamp(Bootcamp bootcamp){
        conteudosIncritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscrito().add(this);
    }

    public  void progredir(){
      var  conteudo = this.conteudosIncritos.stream().findFirst();
      if (conteudo.isPresent()){
          this.conteudoConluidos.add(conteudo.get());
          this.conteudosIncritos.remove(conteudo.get());
      } else {
          System.err.println("Você não está matriculado em nenhum conteudo.");
      }
    }

    public double calcularTotalXP(){
        return   this.conteudoConluidos
                .stream()
                .mapToDouble(Conteudo::calcularXP)
                .sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosIncritos() {
        return conteudosIncritos;
    }

    public void setConteudosIncritos(Set<Conteudo> conteudosIncritos) {
        this.conteudosIncritos = conteudosIncritos;
    }

    public Set<Conteudo> getConteudoConluidos() {
        return conteudoConluidos;
    }

    public void setConteudoConluidos(Set<Conteudo> conteudoConluidos) {
        this.conteudoConluidos = conteudoConluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Devs devs = (Devs) o;
        return Objects.equals(nome, devs.nome) && Objects.equals(conteudosIncritos, devs.conteudosIncritos) && Objects.equals(conteudoConluidos, devs.conteudoConluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosIncritos, conteudoConluidos);
    }
}
