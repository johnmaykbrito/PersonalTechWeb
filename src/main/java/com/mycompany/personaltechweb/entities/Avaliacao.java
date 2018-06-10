package com.mycompany.personaltechweb.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "TB_AVALIACAO")
public class Avaliacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // usando @Prepersist
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_AVALIACAO", nullable = false, unique = false)
    private Date dataAvaliacao;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_ALUNO", referencedColumnName = "ID")
    private Aluno aluno;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name = "TXT_NOME_PT", length = 50, nullable = false)
    private String nome_personal;
    
    @OneToMany(mappedBy = "avaliacao", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = false)
    private List<RespostasAvaliacao> respostas;

    void addResposta(RespostasAvaliacao resposta) {
        if (respostas == null) {
            respostas = new ArrayList<>();
        }
        respostas.add(resposta);
        resposta.setAvaliacao(this);
    }

    void removeResposta(RespostasAvaliacao resposta) {
        if (respostas == null) {
            return;
        }
        respostas.remove(resposta);
    }

    public List<RespostasAvaliacao> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<RespostasAvaliacao> respostas) {
        for (RespostasAvaliacao resposta : respostas) {
            this.respostas.add(resposta);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_personal() {
        return nome_personal;
    }

    public void setNome_personal(String nome_personal) {
        this.nome_personal = nome_personal;
    }

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    @PrePersist
    private void setDataAvaliacao() {
        setDataAvaliacao(new Date());
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliacao)) {
            return false;
        }
        Avaliacao other = (Avaliacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personaltech.Avaliacao[ id=" + id + " ]";
    }

}
