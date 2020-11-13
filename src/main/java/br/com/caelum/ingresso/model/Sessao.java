package br.com.caelum.ingresso.model;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalTime horario;

    @ManyToOne
    private Sala sala;

    @ManyToOne
    private Filme filme;


    public Sessao( LocalTime horario, Sala sala, Filme filme) {
        this.horario = horario;
        this.sala = sala;
        this.filme = filme;
    }

    /**
     * @deprecated hibernate only
     * **/
    public Sessao(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }
}
