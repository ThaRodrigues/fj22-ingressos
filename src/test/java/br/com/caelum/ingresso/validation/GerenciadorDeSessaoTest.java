package br.com.caelum.ingresso.validation;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.validacao.GerenciadorDeSessao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

public class GerenciadorDeSessaoTest {

    private Filme rogueOne;
    private Sala sala3D;
    private Sessao sessaoDasDez;
    private Sessao sessaoDasTreze;
    private Sessao getSessaoDasDezoito;

    @Before
    public void preparaSessoes(){
        this.rogueOne = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI");
        this.sala3D = new Sala("Sala 3D");
        this.sessaoDasDez = new Sessao(LocalTime.parse("10:00:00"), sala3D, rogueOne);
        this.sessaoDasTreze = new Sessao(LocalTime.parse("13:00:00"), sala3D, rogueOne);
        this.getSessaoDasDezoito = new Sessao(LocalTime.parse("18:00:00"), sala3D, rogueOne);
    }

    @Test
    public void deveAdicionarSeListaDaSessaoEstiverVazia(){
        List<Sessao> sessoes = Collections.emptyList();
        GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoes);
        Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI");
        filme.setDuracao(120);
        LocalTime horario = LocalTime.parse("10:00:00");
        Sala sala = new Sala("");

        Sessao sessao = new Sessao(horario, sala, filme);

        Boolean cabe = gerenciador.cabe(sessao);

        Assert.assertTrue(cabe);

    }

}
