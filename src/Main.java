import br.com.dia.dessafio.dominio.Bootcamp;
import br.com.dia.dessafio.dominio.Curso;
import br.com.dia.dessafio.dominio.Devs;
import br.com.dia.dessafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso = new Curso();
        curso.setTitulo("Curso Java");
        curso.setDescricao("Descricao curso Java");
        curso.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JavaScript");
        curso2.setDescricao("Descricao curso JavaScript");
        curso2.setCargaHoraria(10);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de java");
        mentoria.setDescricao("Descricao Mentoria de Java ");
        mentoria.setData(LocalDate.now());


        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Java Developers");
        bootcamp.setDescricao("Descricao Java Developers");
        bootcamp.getConteudos().add(curso);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Devs devs = new Devs();
        devs.setNome("ocilio");
        devs.increverBootcamp(bootcamp);
        System.out.println("Conteudo inscrito de ocilio " + devs.getConteudosIncritos());
        devs.progredir();
        devs.progredir();
        System.out.println("-----");
        System.out.println("Conteudo inscrito de ocilio " + devs.getConteudosIncritos());
        System.out.println("Conteudo concluidos de ocilio " + devs.getConteudoConluidos());
        System.out.println("XP " + devs.calcularTotalXP());

        System.out.println("---------------------------");

        Devs devs2 = new Devs();
        devs2.setNome("Joao");
        devs2.increverBootcamp(bootcamp);

        System.out.println("Conteudo inscrito de Joao " + devs2.getConteudosIncritos());
        devs2.progredir();
        devs2.progredir();
        devs2.progredir();
        System.out.println("-----");
        System.out.println("Conteudo inscrito de Joao " + devs2.getConteudosIncritos());
        System.out.println("Conteudo concluidos de Joao " + devs2.getConteudoConluidos());
        System.out.println("XP " + devs2.calcularTotalXP());
    }
}