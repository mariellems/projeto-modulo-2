package com.mari.sistema.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "atendimento")
@SequenceGenerator(name = "atendimento_seq", sequenceName = "atendimento_seq", allocationSize = 1)
public class Atendimento implements Entidade {
    
    @Id
    @Column(name = "ID_ATENDIMENTO")
    @GeneratedValue(generator = "atendimento_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "nome", length = 200)
    @NotNull(message = "{Atendimento.nome.NotNull}")
    private String nome;
    
    @Column(name = "telefone", length = 20)
    @NotNull(message = "{Atendimento.telefone.NotNull}")
    private String telefone;
    
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @Column(name = "SERVICO", length = 50)
    private String servico;
   
    @Column(name = "PRODUTO", length = 50)
    private String produto;
        
    @Digits(integer = 10, fraction = 5)
    @Column(name = "VL_TOTAL", precision = 15, scale = 5)
    private BigDecimal valorTotal;
    
    @Column(name = "opcao", length = 20)
    private String opcao;
    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

     public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
    
    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.telefone);
        hash = 67 * hash + Objects.hashCode(this.data);
        hash = 67 * hash + Objects.hashCode(this.servico);
        hash = 67 * hash + Objects.hashCode(this.produto);
        hash = 67 * hash + Objects.hashCode(this.opcao);
        hash = 67 * hash + Objects.hashCode(this.valorTotal);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Atendimento other = (Atendimento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.servico, other.servico)) {
            return false;
        }
        if (!Objects.equals(this.opcao, other.opcao)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return Objects.equals(this.valorTotal, other.valorTotal);
    }

    @Override
    public String toString() {
        return "Atendimento{" + "id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", data=" + data + ", servico=" + servico + ", produto=" + produto + ", valorTotal=" + valorTotal + ", opcao=" + opcao +'}';
    }
}
