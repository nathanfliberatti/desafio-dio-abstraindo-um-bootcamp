package dominio;

import exceptions.DevAlreadyEnrolledException;
import exceptions.DevNotEnrolledException;
import exceptions.NoSubscribedContentException;

import java.util.*;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        if (bootcamp.getDevsInscritos().contains(this)) {
            throw new DevAlreadyEnrolledException(String.format("Dev %s já está inscrito no bootcamp\n", this.nome));
        }
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {

        if (this.conteudosInscritos == null || this.conteudosInscritos.isEmpty()) {
            throw new NoSubscribedContentException(this.nome);
        }

        boolean estaIncritoEmAlgumBootcamp = Bootcamp.getTodosBootcamps()
                .stream()
                .anyMatch(b -> b.getDevsInscritos().contains(this));

        if (!estaIncritoEmAlgumBootcamp) {
            throw new DevNotEnrolledException(this.nome);
        }

        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        conteudo.ifPresent(c -> {
            this.conteudosConcluidos.add(c);
            this.conteudosInscritos.remove(c);
        });
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Dev dev)) return false;
        return Objects.equals(nome, dev.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}