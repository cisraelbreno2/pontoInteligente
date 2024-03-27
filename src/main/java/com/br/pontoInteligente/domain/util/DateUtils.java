package com.br.pontoInteligente.domain.util;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {

    public static String formatarDataHora(LocalDateTime dataHora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        return dataHora.format(formatter);
    }
    public static LocalDate parse(String dataString) {

        if(dataString == null || dataString.isEmpty()){
            throw new IllegalArgumentException("Data não pode ser nula ou vazia");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[dd/MM/yyyy][dd-MM-yyyy]");

        try {
            return LocalDate.parse(dataString, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Erro ao converter a data: " + e.getMessage());
        }
    }

    public static String formatarHora(LocalDateTime dataHora) {
        LocalTime hora = dataHora.toLocalTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return hora.format(formatter);
    }

    public static String formatarData(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateTime.format(formatter);
    }

    public static String formatarData(LocalDate dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateTime.format(formatter);
    }

    public static String formatarMinutos(long minutos) {
        long horas = minutos / 60;
        long minutosRestantes = minutos % 60;
        return LocalTime.of((int) horas, (int) minutosRestantes).toString();
    }

    public static long calcularDiferencaSegundos(LocalDateTime dataInicial, LocalDateTime dataFinal) {
        Duration duration = Duration.between(dataInicial, dataFinal);
        return duration.getSeconds();
    }


    public static String formatarSegundos(long segundos) {
        long horas = segundos / 3600;
        long minutos = (segundos % 3600) / 60;
        long segundosRestantes = segundos % 60;

        return String.format("%02d:%02d:%02d", horas, minutos, segundosRestantes);
    }
}
