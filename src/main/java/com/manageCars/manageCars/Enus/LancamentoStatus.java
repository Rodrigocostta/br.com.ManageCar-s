package com.manageCars.manageCars.Enus;

public enum LancamentoStatus {

	GANHO(1), DESPESA(2), INVESTIMENTO(3);

	private int code;

	private LancamentoStatus(int code) {
		this.code = code;
	}

	
	public int getCode() {
		return code;
	}
	
	public static LancamentoStatus valueOf(int code) {
		for(LancamentoStatus value : LancamentoStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
	
		throw new IllegalArgumentException("codigo invalido");
	}
}
