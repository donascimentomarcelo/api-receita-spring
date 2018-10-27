package br.com.receita.domain.enums;

/**
 * @Author Marcelo Nascimento
 * @Date 25 de out de 2018
 * @Project receita
 * @Package br.com.receita.domain.enums
 * @Desc Define o grau que cada avaliacao receberá.
 */
public enum Grau {
	
	EXCELENTE(1, "Excelente"),
	BOM(2, "Bom"),
	MEDIO(3, "Médio"),
	RUIM(4, "Médio"),
	PESSIMO(5, "Péssimo");
	
	private int codigo;
	private String descricao;
	
	Grau(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Grau toEnum(Integer codigo) {
		
		if(codigo == null)
		{
			return null;
		}
		
		for(Grau grau: Grau.values())
		{
			if(codigo.equals(grau.getCodigo()))
			{
				return grau;
			}
		}
		
		throw new IllegalArgumentException("Código inválido" + codigo);
	}
}
