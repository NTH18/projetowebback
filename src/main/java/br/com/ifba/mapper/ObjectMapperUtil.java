package br.com.ifba.mapper; // Pacote onde a classe de utilitário está localizada

// Importa a classe ObjectMapper do Jackson para conversão de objetos
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtil { // Classe utilitária para realizar a conversão de objetos

    // Cria uma instância estática do ObjectMapper, que será usada para as conversões
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // Método genérico que converte um objeto de um tipo para outro
    public static <T> T convert(Object source, Class<T> targetClass) {
        // Usa o ObjectMapper para converter o objeto 'source' para o tipo de destino 'targetClass'
        return MAPPER.convertValue(source, targetClass);
    }
}
