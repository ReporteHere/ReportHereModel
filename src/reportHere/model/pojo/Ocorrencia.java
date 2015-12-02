/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.model.pojo;

import reportHere.model.base.BasePOJO;

public class Ocorrencia extends BasePOJO{

        private String assunto;
        private String descricao;
        private String nome;
        private String email;
        private Boolean anonimo;
        private Long protocolo;
        private String senha;
        private Boolean  finalizado;
        private Perfil perfil;
        private TipoOcorrencia tipoOcorrencia;

    /**
     * @return the assunto
     */
    public String getAssunto() {
        return assunto;
    }

    /**
     * @param assunto the assunto to set
     */
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the anonimo
     */
    public Boolean getAnonimo() {
        return anonimo;
    }

    /**
     * @param anonimo the anonimo to set
     */
    public void setAnonimo(Boolean anonimo) {
        this.anonimo = anonimo;
    }

    /**
     * @return the protocolo
     */
    public Long getProtocolo() {
        return protocolo;
    }

    /**
     * @param protocolo the protocolo to set
     */
    public void setProtocolo(Long protocolo) {
        this.protocolo = protocolo;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the perfil
     */
    public Perfil getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the tipoOcorrencia
     */
    public TipoOcorrencia getTipoOcorrencia() {
        return tipoOcorrencia;
    }

    /**
     * @param tipoOcorrencia the tipoOcorrencia to set
     */
    public void setTipoOcorrencia(TipoOcorrencia tipoOcorrencia) {
        this.tipoOcorrencia = tipoOcorrencia;
    }

    /**
     * @return the finalizado
     */
    public Boolean getFinalizado() {
        return finalizado;
    }

    /**
     * @param finalizado the finalizado to set
     */
    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }
}
