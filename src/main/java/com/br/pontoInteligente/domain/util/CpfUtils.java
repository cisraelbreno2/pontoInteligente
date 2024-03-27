package com.br.pontoInteligente.domain.util;

public class CpfUtils {


    public static boolean validar(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        boolean todosDigitosIguais = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(i - 1)) {
                todosDigitosIguais = false;
                break;
            }
        }
        if (todosDigitosIguais) {
            return false;
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int resto = soma % 11;
        int primeiroDigitoVerificador = (resto < 2) ? 0 : 11 - resto;
        if (Character.getNumericValue(cpf.charAt(9)) != primeiroDigitoVerificador) {
            return false;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        resto = soma % 11;
        int segundoDigitoVerificador = (resto < 2) ? 0 : 11 - resto;
        return Character.getNumericValue(cpf.charAt(10)) == segundoDigitoVerificador;
    }
}
