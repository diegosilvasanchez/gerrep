package br.com.gerrep.controller;

import br.com.gerrep.conversores.ConverterSHA1;
import br.com.gerrep.dao.HibernateDAO;
import br.com.gerrep.dao.InterfaceDAO;
import br.com.gerrep.entities.Aluno;
import br.com.gerrep.entities.Endereco;
import br.com.gerrep.entities.Pessoa;
import br.com.gerrep.entities.Republica;
import br.com.gerrep.util.FacesContextUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "mbAluno")
@SessionScoped
public class MbAluno implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String confereSenha;
    private Pessoa pessoa = new Pessoa();
    private Aluno aluno = new Aluno();
    private Republica republica = new Republica();
    private Endereco endereco = new Endereco();
    private List<Aluno> alunos;    

    public MbAluno() {
        aluno = new Aluno();
        pessoa = new Pessoa();
        endereco = new Endereco();
        republica = new Republica();
    }
    
    private InterfaceDAO<Aluno> alunoDAO(){
        InterfaceDAO<Aluno> alunoDAO = new HibernateDAO<Aluno>(Aluno.class, FacesContextUtil.getRequestSession());
        return alunoDAO;
    }  
    
    private InterfaceDAO<Pessoa> pessoaDAO(){
        InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<Pessoa>(Pessoa.class, FacesContextUtil.getRequestSession());
        return pessoaDAO;
    }  
    
    private InterfaceDAO<Endereco> enderecoDAO(){
        InterfaceDAO<Endereco> enderecoDAO = new HibernateDAO<Endereco>(Endereco.class, FacesContextUtil.getRequestSession());
        return enderecoDAO;
    }
    
    public String editAluno(){
        return "/restrict/cadastraraluno.faces";
    }
    
     public String redirectAlunos(){
        alunos = alunoDAO().getEntities();
        return "/restrict/consultaraluno.faces";
    }
    
    public String addAluno(){
        if (aluno.getIdAluno() == null || aluno.getIdAluno() == 0) {
            aluno.setPessoa(pessoa);
            alunoDAO().save(aluno);
           // insertAluno();
        }
        
        limpaAluno();
        return null;
    }

    private void insertAluno() {        
        aluno.getPessoa().setSenha(ConverterSHA1.cipher(aluno.getPessoa().getSenha()));
        if(aluno.getPessoa().getSenha() != null && aluno.getPessoa().getSenha().equals(ConverterSHA1.cipher(confereSenha))) {
            aluno.getPessoa().setPermissao("ROLE_ADMIN");            
            aluno.getPessoa().setDataCriacao(new Date());
            pessoaDAO().save(aluno.getPessoa());
          //  endereco.setPessoa(aluno.getPessoa());
          //  enderecoDAO().save(endereco);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação Efetuada com Sucesso", ""));
        }    
    }

    private void updateAluno() {
        alunoDAO().update(aluno);
       // enderecoDAO().update(endereco);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização Efetuada com Sucesso", ""));
    }
    
    public void deleteAluno() {
        pessoaDAO().remove(pessoa);
      //  enderecoDAO().remove(endereco);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão Efetuada com Sucesso", ""));
    }
  
    public String limpaAluno() {
        aluno = new Aluno();
      //  endereco = new Endereco();
        return editAluno();
    }    
    
     public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Aluno> getAlunos() {
        alunos = alunoDAO().getEntities();
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    } 

    public String getConfereSenha() {
        return confereSenha;
    }

    public void setConfereSenha(String confereSenha) {
        this.confereSenha = confereSenha;
    }    
}

