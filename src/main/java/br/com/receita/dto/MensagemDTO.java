package br.com.receita.dto;

/**
 * @Author Marcelo Nascimento
 * @Date 3 de nov de 2018
 * @Project receita
 * @Package br.com.receita.dto
 * @Desc 
 */
public class MensagemDTO {
	
	private Integer comentario_id;
	private Integer usuario_id;
	private Integer receita_id;
	private String nome;
	private String resposta;
	
	public MensagemDTO() {
		super();
	}

	public MensagemDTO(Integer comentario_id, Integer usuario_id, Integer receita_id, String nome, String resposta) {
		super();
		this.comentario_id = comentario_id;
		this.usuario_id = usuario_id;
		this.receita_id = receita_id;
		this.resposta = resposta;
		this.nome = nome;
	}

	public Integer getComentario_id() {
		return comentario_id;
	}

	public void setComentario_id(Integer comentario_id) {
		this.comentario_id = comentario_id;
	}

	public Integer getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Integer usuario_id) {
		this.usuario_id = usuario_id;
	}

	public Integer getReceita_id() {
		return receita_id;
	}

	public void setReceita_id(Integer receita_id) {
		this.receita_id = receita_id;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
