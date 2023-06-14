import java.util.Scanner;

public class ValidatorCPF {
    public static boolean validarCPF(String cpf) {
        // Remover caracteres especiais do CPF
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verificar se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verificar se todos os dígitos são iguais (caso especial)
        boolean todosDigitosIguais = true;
        for (int i = 1; i < 11; i++) {
            if (cpf.charAt(i) != cpf.charAt(i-1)) {
                todosDigitosIguais = false;
                break;
            }
        }

        // Calcular o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            int digito = Character.getNumericValue(cpf.charAt(i));
            soma += (10 - i) * digito;
        }
        int primeiroDigitoVerificador = 11 - (soma % 11);
        if (primeiroDigitoVerificador >= 10) {
            primeiroDigitoVerificador = 0;
        }

        // Verificar o primeiro dígito verificador
        if (Character.getNumericValue(cpf.charAt(9)) != primeiroDigitoVerificador) {
            return false;
        }

        // Calcular o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            int digito = Character.getNumericValue(cpf.charAt(i));
            soma += (11 - i) * digito;
        }
        int segundoDigitoVerificador = 11 - (soma % 11);
        if (segundoDigitoVerificador >= 10) {
            segundoDigitoVerificador = 0;
        }

        // Verificar o segundo dígito verificador
        if (Character.getNumericValue(cpf.charAt(10)) != segundoDigitoVerificador) {
            return false;
        }

        // CPF válido
        return true;
    }
}
