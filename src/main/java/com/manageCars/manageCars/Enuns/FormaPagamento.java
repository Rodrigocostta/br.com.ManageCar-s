package com.manageCars.manageCars.Enuns;

public enum FormaPagamento {

	/*LEMBRAR DE MECHER NA CLASSE DA ENTIDADE*/
	PIX(1), DINEHIRO(2), DEBITO(3), CREDITO(4);

	private int code2;

	private FormaPagamento(int code2) {
		this.code2 = code2;
	}

	public int getCode2() {
		return code2;
	}

	public static FormaPagamento valueOf(int code2) {
		for (FormaPagamento value : FormaPagamento.values()) {
			if (value.getCode2() == code2) {
				return value;
			}
		}

		throw new IllegalArgumentException("codigo invalido");
	}

}
