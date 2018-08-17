package br.com.receita.domain.enums;

public enum Medida {
	
	MILILITROS(1, "Mililitros"),
	LITROS(2, "Litros"),
	GRAMAS(3, "Gramas"),
	QUILOS(4, "Quilos");
	
	private int codigo;
	private String descricao;
	
	Medida(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Medida toEnum(Integer codigo) {
		
		if(codigo == null)
		{
			return null;
		}
		
		for(Medida medida: Medida.values())
		{
			if(codigo.equals(medida.getCodigo()))
			{
				return medida;
			}
		}
		
		throw new IllegalArgumentException("Código inválido" + codigo);
	}
}
