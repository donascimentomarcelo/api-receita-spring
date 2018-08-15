package br.com.receita.domain.enums;

public enum Medida {
	
	LITROS(1, "Litros"),
	MILILITROS(2, "Mililitros"),
	GRAMAS(3, "Gramas");
	
	private int codigo;
	private String descricao;
	
	private Medida(int codigo, String descricao) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Medida toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		
		for (Medida medida: Medida.values()) {
			if (codigo.equals(medida.getCodigo())) {
				return medida;
			}
		}
		
		throw new IllegalArgumentException("Código inválido" + codigo);
	}
	
	
}
