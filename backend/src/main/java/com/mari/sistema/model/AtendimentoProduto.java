package com.mari.sistema.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ATENDIMENTOS_PRODUTOS")
@SequenceGenerator(name = "ATENDIMENTOS_PRODUTOS_SEQ", sequenceName = "ATENDIMENTOS_PRODUTOS_SEQ", allocationSize = 1)
public class AtendimentoProduto implements Entidade {
    
    @Id
    @Column(name = "ID_ATENDIMENTO_PRODUTO")
    @GeneratedValue(generator = "ATENDIMENTOS_PRODUTOS_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO")
    @NotNull(message = "{AtendimentoProduto.produto.NotNull}")
    private Produto produto;
    
    @Column(name = "PRECO", precision = 15, scale = 5)
    private BigDecimal preco;

    @NotNull(message = "{AtendimentoProduto.quantidade.NotNull}")
    @Digits(integer = 10, fraction = 5, message = "{AtendimentoProduto.quantidade.Digits}")
    @Column(name = "QUANTIDADE", precision = 15, scale = 5)
    private BigDecimal quantidade;

    @NotNull(message = "{AtendimentoProduto.valorTotal.NotNull}")
    @Digits(integer = 10, fraction = 5, message = "{AtendimentoProduto.valorTotal.Digits}")
    @Column(name = "VALOR_TOTAL", precision = 15, scale = 5)
    private BigDecimal valorTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
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
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.produto);
        hash = 29 * hash + Objects.hashCode(this.preco);
        hash = 29 * hash + Objects.hashCode(this.quantidade);
        hash = 29 * hash + Objects.hashCode(this.valorTotal);
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
        final AtendimentoProduto other = (AtendimentoProduto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.preco, other.preco)) {
            return false;
        }
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        if (!Objects.equals(this.valorTotal, other.valorTotal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AtendimentoProduto{" + "id=" + id + ", produto=" + produto + ", preco=" + preco + ", quantidade=" + quantidade + ", valorTotal=" + valorTotal + '}';
    }
    
}
