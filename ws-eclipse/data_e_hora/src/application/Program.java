package application;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Program {

	public static void main(String[] args) {

		//Formas de instanciar data e hora
		
		LocalDate d01 = LocalDate.now();
		System.out.println(d01);
		
		LocalDateTime d02 = LocalDateTime.now();
		System.out.println(d02);
		
		Instant d03 = Instant.now();
		System.out.println(d03);
		
		LocalDate d04 = LocalDate.parse("2022-07-20");
		System.out.println(d04);
		
		LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
		System.out.println(d05);
		
		Instant d06 = Instant.parse("2022-07-20T01:30:26Z");
		System.out.println(d06);
		
		Instant d07 = Instant.parse("2022-07-20T01:30:26-03:00");
		System.out.println(d07);
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate d08 = LocalDate.parse("20/07/2022", fmt1);
		System.out.println(d08.toString());
		
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime d09 = LocalDateTime.parse("20/07/2022 01:30", fmt2);
		System.out.println(d09);
		
		LocalDate d10 = LocalDate.of(2022, 07, 20);
		System.out.println(d10.toString());
		
		LocalDateTime d11 = LocalDateTime.of(2022, 07, 20, 1, 30);
		System.out.println(d11.toString()); 

		//formatação e conversão de datas
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(d04.format(fmt3));
		System.out.println(fmt3.format(d04));
		System.out.println(d04.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		DateTimeFormatter fmt4 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		System.out.println(d05.format(fmt3));
		System.out.println(d05.format(fmt4));
		
		//quando for instant tem que informar o fusohorário
		DateTimeFormatter fmt5 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault()); 
		System.out.println(fmt5.format(d06)); //como está usando o default vai converter para gmt-3:00
		
		
		DateTimeFormatter fmt6 = DateTimeFormatter.ISO_DATE_TIME;
		System.out.println(d05.format(fmt6));
		
		DateTimeFormatter fmt7 = DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.systemDefault());
		System.out.println(fmt7.format(d06)); //como está usando o default vai converter para gmt-3:00
		
		//convertendo data hora global para local 
		LocalDateTime r1 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
		System.out.println("r1= " + r1);
		
		LocalDateTime r2 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));
		System.out.println("r2= " + r2);
		
		//obter dados de uma data local
		System.out.println(d04.getDayOfMonth());
		System.out.println(d04.getMonthValue());
		System.out.println(d04.getYear());
		System.out.println(d05.getHour());
		System.out.println(d05.getMinute());
		System.out.println(d05.getSecond());
		
		//Calculos com data e hora
		System.out.println(d04);
		
		LocalDate menosUmaSemana = d04.minusDays(7);
		System.out.println(menosUmaSemana);
		
		LocalDate proximaSemana = d04.plusDays(7);
		System.out.println(proximaSemana);
	
		System.out.println(d05);
		
		LocalDateTime menosUmaHora = d05.minusHours(1);
		System.out.println(menosUmaHora);
		
		LocalDateTime maisUmaHora = d05.plusHours(1);
		System.out.println(maisUmaHora);
	
		
		//diferença entre duas datas
		Duration t1 = Duration.between(d05.minusDays(7).minusHours(3), d05);
		System.out.println(t1.toDays());
		
		//pra usar LocalDate precisa converter para LocalDateTime, assim 
		Duration t2 = Duration.between(d04.minusDays(7).atTime(0,0), d04.atTime(0,0));
		System.out.println(t2.toDays());
				
		Duration t3 = Duration.between(d04.minusDays(7).atStartOfDay(), d04.atStartOfDay());
		System.out.println(t3.toDays());
		
		
		
				
	}

}
