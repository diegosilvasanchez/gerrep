package br.com.gerrep.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.DecimalMin;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="despesa")
public class Despesa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="id_despesa", nullable = false, unique = true)
    private Integer idDespesa;
        
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "despesa_republica")
    @JoinColumn(name = "id_republica", referencedColumnName = "id_republica")
    private Republica republica;
    
    @Column(name="descricao", nullable = false, length = 40)
    private String descricao;
    
    @DecimalMin("0")
    @Column(name="valor",precision=10, scale=2, nullable=false)
    private BigDecimal valor;
    
    @Column(name="tipo_frequencia", nullable = false, length = 40)
    private String tipoFrequencia;
    
    @Column(name="status", nullable = false, length = 40)
    private String status;
    
    @Column(name="data_execucao")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataExecucao;
    
    @Column(name="data_vencimento")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataVencimento;
     
    @Column(name="ativo")
    private Integer ativo;
    
    @Column(name="data_criacao")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataCriacao;
    
    @Column(name="usuario_criacao", length = 80)
    private String usuarioCriacao;
    
    @Column(name="data_modificacao")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataModificacao;
    
    @Column(name="usuario_modificacao", length = 80)
    private String usuarioModificacao;

    public Despesa() {
    }

    public Integer getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(Integer idDespesa) {
        this.idDespesa = idDespesa;
    }

    public Republica getRepublica() {
        return republica;
    }

    public void setRepublica(Republica republica) {
        this.republica = republica;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipoFrequencia() {
        return tipoFrequencia;
    }

    public void setTipoFrequencia(String tipoFrequencia) {
        this.tipoFrequencia = tipoFrequencia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataExecucao() {
        return dataExecucao;
    }

    public void setDataExecucao(Date dataExecucao) {
        this.dataExecucao = dataExecucao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getUsuarioCriacao() {
        return usuarioCriacao;
    }

    public void setUsuarioCriacao(String usuarioCriacao) {
        this.usuarioCriacao = usuarioCriacao;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public String getUsuarioModificacao() {
        return usuarioModificacao;
    }

    public void setUsuarioModificacao(String usuarioModificacao) {
        this.usuarioModificacao = usuarioModificacao;
    }    
}
