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
@Table(name="servico")
public class Servico implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="id_servico", nullable = false, unique = true)
    private Integer idServico;
    
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "servico_prestador")
    @JoinColumn(name = "id_prestador", referencedColumnName = "id_prestador")
    private Prestador prestador;
    
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "servico_republica")
    @JoinColumn(name = "id_republica", referencedColumnName = "id_republica")
    private Republica republica;
    
    @Column(name="descricao", nullable = false, length = 40)
    private String descricao;
    
    @DecimalMin("0")
    @Column(name="valor",precision=10, scale=2, nullable=false)
    private BigDecimal valor;
    
    @Column(name="status", nullable = false, length = 40)
    private String status;
    
    @Column(name="data_execucao")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataExecucao;
     
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

    public Servico() {
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
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
