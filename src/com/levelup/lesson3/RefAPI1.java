package com.levelup.lesson3;

import java.io.*;
import java.lang.reflect.Field;

/**
 * Created by lsp on 05.01.16.
 */
public class RefAPI1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        BufferedReader reader= new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("RefAPI.out")));
        //Создаем класс из первой строчки файла
        Class aclass=Class.forName(reader.readLine());
        //создаем объект этого класса
        Object obj=aclass.newInstance();
        //Чтобы иметь доступ к полям объекта,
        //надо знать об этих полях на этапе компиляции,
        //лично я вижу только такой способ, на месте AllCases
        //может быть нереализованный интерфейс или суперкласс
        AllCases allCases=(AllCases) obj;
        String line;
        //Изменяем примитивные поля на те, что записаны в файле
        while((line=reader.readLine())!=null) {
            String[] values = line.split(" ");
            Field field=aclass.getDeclaredField(values[0]);
            field.setAccessible(true);
            switch (field.getType().getName()){
                case "int":
                    field.setInt(allCases,Integer.parseInt(values[2]));
                    break;
                case "byte":
                    field.setByte(allCases, Byte.parseByte(values[2]));
                    break;
                case "short":
                    field.setShort(allCases,Short.parseShort(values[2]));
                    break;
                case "long":
                    field.setLong(allCases,Long.parseLong(values[2]));
                    break;
                case "float":
                    field.setFloat(allCases,Float.parseFloat(values[2]));
                    break;
                case "double":
                    field.setDouble(allCases,Double.parseDouble(values[2]));
                    break;
                case "char":
                    field.setChar(allCases,values[2].charAt(0));
                    break;
                case "boolean":
                    field.setBoolean(allCases, Boolean.parseBoolean(values[2]));
                    break;
            }
        }
        //выводим
        Field[] fields=aclass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName()+" = "+field.get (allCases));
        }
    }
}
