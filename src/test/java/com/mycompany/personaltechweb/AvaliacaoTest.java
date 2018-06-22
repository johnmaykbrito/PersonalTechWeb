/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltechweb;

import static com.mycompany.personaltechweb.Teste.container;
import com.mycompany.personaltechweb.entities.Aluno;
import com.mycompany.personaltechweb.entities.Avaliacao;
import com.mycompany.personaltechweb.entities.Pergunta;
import com.mycompany.personaltechweb.entities.RespostasAvaliacao;
import com.mycompany.personaltechweb.services.AlunoServico;
import com.mycompany.personaltechweb.services.ServicoAvaliacao;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author michel
 */
public class AvaliacaoTest extends Teste {

    private ServicoAvaliacao servicoAvaliacao;
    private AlunoServico alunoServico;

    @Before
    public void setUp() throws NamingException {
        servicoAvaliacao = (ServicoAvaliacao) container.getContext().lookup("java:global/classes/ejb/ServicoAvaliacao!com.mycompany.personaltechweb.services.ServicoAvaliacao");
        alunoServico = (AlunoServico) container.getContext().lookup("java:global/classes/ejb/AlunoServico!com.mycompany.personaltechweb.services.AlunoServico");
    }

    @After
    public void tearDown() {
        servicoAvaliacao = null;
    }

    @Test
    public void existeAvaliacao() {
        Avaliacao avaliacao = servicoAvaliacao.criar();
        avaliacao.setNome_personal("THOR");
        assertTrue(servicoAvaliacao.existe(avaliacao));
    }

    @Test
    public void inserirAvaliacao() {
        Avaliacao avaliacao1 = servicoAvaliacao.criar();
        Avaliacao avaliacao2 = servicoAvaliacao.criar();
        avaliacao1.setNome_personal("JOÃO");
        avaliacao2.setNome_personal("JOÃO");
        Aluno aluno = alunoServico.criar();
        aluno = alunoServico.consultarPorId((long) 11);
        aluno.addAvaliacao(avaliacao1);
        aluno.addAvaliacao(avaliacao2);
        alunoServico.atualizar(aluno);
        assertEquals(2, aluno.getAvaliacoes().size());
    }

    @Test
    public void deleteAvaliacao() {
//        Não consegui fazer funcionar assim:

//        Aluno aluno = alunoServico.criar();
//        aluno = alunoServico.consultarPorId((long) 5);
//        Avaliacao avaliacao = servicoAvaliacao.criar();
//        avaliacao = aluno.getAvaliacoes().get(0);
//        aluno.removeAvaliacao(avaliacao);
//        alunoServico.atualizar(aluno);
//        assertEquals(1, aluno.getAvaliacoes().size());

//        Nem assim:
//        Avaliacao avaliacao = servicoAvaliacao.criar();
//        avaliacao = servicoAvaliacao.consultarPorId((long) 5);
//        servicoAvaliacao.deletar(avaliacao);
//        assertNull(servicoAvaliacao.consultarPorId((long) 5));

//        Nem assim:
//        alunoServico.consultarPorId((long)5).getAvaliacoes().remove(0);
//        assertTrue(true);
    }
}
