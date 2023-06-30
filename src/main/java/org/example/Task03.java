package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

//Анна=4
//        Елена=5
//        Марина=6
//        Владимир=?
//        Константин=?
//        Иван=4
//        Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив
//        (либо HashMap).
//        В отдельном методе нужно будет пройти по структуре данных.
//        Если сохранено значение ?, заменить его на соответствующее число.
//        Если на каком-то месте встречается символ, отличный от числа или ?,
//        бросить подходящее исключение.
//        Записать в тот же файл данные с замененными символами ?
public class Task03 {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> names = read("C:\\repo\\Java\\Seminars\\Seminar19\\untitled\\names.txt");
        write(names, "C:\\repo\\Java\\Seminars\\Seminar19\\untitled\\names.txt");

    }

    public static Map<String, Integer> read(String path) throws IOException {
        Map<String, Integer> names = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("=");
                Integer num = 0;
                if (values[1].equals("?")) {
                    num = values[0].length();
                } else {
                    num = Integer.parseInt(values[1]);
                }
                names.put(values[0], num);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new IOException(e);
        }

        return names;
    }

    public static void write(Map<String, Integer> names, String path) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        try {
            StringBuilder sb = new StringBuilder();
            for (String s : names.keySet()) {
                sb.append(s).append("=").append(names.get(s)).append("\n");
            }
            bw.write(sb.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new IOException(e);
        } finally {
            bw.close();
        }
    }
}
