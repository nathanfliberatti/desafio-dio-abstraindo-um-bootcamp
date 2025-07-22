import dominio.Bootcamp;
import dominio.Curso;
import dominio.Dev;
import dominio.Mentoria;
import exceptions.DevAlreadyEnrolledException;
import exceptions.DevNotEnrolledException;
import exceptions.NoSubscribedContentException;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devJoao = new Dev();
        devJoao.setNome("João");

        try {
            devJoao.inscreverBootcamp(bootcamp);
        } catch (DevAlreadyEnrolledException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.printf("Conteúdos inscritos de %s: %s\n", devJoao.getNome(), devJoao.getConteudosInscritos());

        try {
            devJoao.progredir();
            System.out.printf("Dev %s progrediu com sucesso\n", devJoao.getNome());
        } catch (NoSubscribedContentException | DevNotEnrolledException ex) {
            System.out.println("Erro ao progredir: " + ex.getMessage());
        }

        try {
            devJoao.progredir();
            System.out.printf("Dev %s progrediu com sucesso\n", devJoao.getNome());
        } catch (NoSubscribedContentException | DevNotEnrolledException ex) {
            System.out.println("Erro ao progredir: " + ex.getMessage());
        }

        try {
            devJoao.progredir();
            System.out.printf("Dev %s progrediu com sucesso\n", devJoao.getNome());
        } catch (NoSubscribedContentException | DevNotEnrolledException ex) {
            System.out.println("Erro ao progredir: " + ex.getMessage());
        }

        try {
            devJoao.progredir();
            System.out.printf("Dev %s progrediu com sucesso\n", devJoao.getNome());
        } catch (NoSubscribedContentException | DevNotEnrolledException ex) {
            System.out.println("Erro ao progredir: " + ex.getMessage());
        }

        System.out.println("=============");
        System.out.printf("Conteúdos inscritos de %s: %s\n", devJoao.getNome(), devJoao.getConteudosInscritos());
        System.out.printf("Conteúdos concluídos de %s: %s\n", devJoao.getNome(), devJoao.getConteudosConcluidos());
        System.out.printf("XP total de %s: %s\n", devJoao.getNome(), devJoao.calcularTotalXp());

        System.out.println("=============");

        Dev devMaria = new Dev();
        devMaria.setNome("Maria");

        try {
            devMaria.inscreverBootcamp(bootcamp);
        } catch (DevAlreadyEnrolledException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.printf("Conteúdos inscritos de %s: %s\n", devMaria.getNome(), devMaria.getConteudosInscritos());

        try {
            devMaria.progredir();
        } catch (NoSubscribedContentException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("=============");
        System.out.printf("Conteúdos inscritos de %s: %s\n", devMaria.getNome(), devMaria.getConteudosInscritos());
        System.out.printf("Conteúdos concluídos de %s: %s\n", devMaria.getNome(), devMaria.getConteudosConcluidos());
        System.out.printf("XP total de %s: %s\n", devMaria.getNome(), devMaria.calcularTotalXp());

    }

}
