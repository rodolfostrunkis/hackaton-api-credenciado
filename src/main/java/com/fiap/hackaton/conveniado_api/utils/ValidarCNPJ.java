package com.fiap.hackaton.conveniado_api.utils;

public class ValidarCNPJ {

    public static boolean isCNPJ(String cnpj) {

        cnpj = cnpj.replaceAll("[/\\.\\-\\s]", "");

        if (!cnpj.matches("\\d{14}")) {
            return false;
        }

        int[] peso = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        try {
            int soma = 0;
            for (int i = 0; i < 12; i++) {
                soma += (cnpj.charAt(i) - '0') * peso[i + 1];
            }

            int digito1 = 11 - (soma % 11);
            digito1 = (digito1 >= 10) ? 0 : digito1;

            soma = 0;
            for (int i = 0; i < 13; i++) {
                soma += (cnpj.charAt(i) - '0') * peso[i];
            }

            int digito2 = 11 - (soma % 11);
            digito2 = (digito2 >= 10) ? 0 : digito2;

            return (cnpj.charAt(12) - '0' == digito1) && (cnpj.charAt(13) - '0' == digito2);
        } catch (Exception e) {
            return false;
        }
    }
}
