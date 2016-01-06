package com.levelup.lesson3;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;
import java.lang.reflect.*;
public class RefAPI {
/*
В этом классе создается объект AllCases,
в нем присваиваются новые значения полям,
затем эти модифицированные поля дампятся в файл.
Файл перед запуском программы надо уничтожать,
никаких проверок не производится (пример учебный)
*/
	public static void main (String[] args) throws IllegalAccessException, IOException {
		AllCases allcases = new AllCases();
		allcases.publicInt=5;
		allcases.protectedInt=12;
		allcases.aDouble=5678.12345;
		allcases.aBoolean=false;
		allcases.aByte=8;
		allcases.aChar='b';
		allcases.aFloat=56789.1f;
		allcases.aInt=5678;
		allcases.aLong=9876543210l;
		Class aclass = allcases.getClass();
		//файл в каталоге запуска программы для простоты
		FileWriter writer=new FileWriter("RefAPI.out",true);
		writer.write(aclass.getName());
		writer.append("\n");
		Field[] fields=aclass.getDeclaredFields();
		for(Field field : fields){
			field.setAccessible(true);
			writer.write(field.getName()+" = "+field.get (allcases));
			writer.append("\n");
		}
		writer.close();
	}
}
