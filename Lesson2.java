// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

// Дополнительные задания

// Дана json-строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

// *Сравнить время выполнения замены символа "а" на "А" любой строки содержащей >1000 символов средствами String и StringBuilder.
// *Дана строка: ".3 + 1.56 = " подсчитать результат и добавить к строке.

// public class Lesson2 {
//     public static void main(String[] args) {
//         StringBuilder
//     }
// }
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Lesson2 {
    public static void main(String[] args) throws IOException {
        getRequest1();
        getRequest2();       
        processionJson();
        replacingChar();       
        getResultSting();      
    }
    public static void getRequest1() {
        String str = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        System.out.println(str);
        str = str
                .replace("{", "")
                .replace("}", "")
                .replaceAll("\"", "")
                .replaceAll(":", "=" );

        String [] ArrStr = str.split(", ");
        StringBuilder sb = new StringBuilder("");
//
        for (int i = 0; i < ArrStr.length; i++) {
            String [] ArrStrTemp = ArrStr[i]
                    .replace("[", "")
                    .replace("]", "")
                    .split("=");
            if(ArrStrTemp[0].equals("null")
                    || ArrStrTemp[1].equals("null")) {
                sb.append("");
            } else {
                sb.append(ArrStr[i]);
                sb.append(" AND ");
            }
        }
        sb.delete(sb.length()-5, sb.length()-1);
        System.out.println("Задание 1 (1-й вариант): ");
        System.out.println(sb.toString());
        System.out.println("/n");
    }

    public static void getRequest2() {
        String sqlStr = "select * from students where ";
        // создаем и инициализируем карту
        Map<String, String> map = new HashMap<String, String>();
        // добавляем ключ/ значение
        map.put("name", "Ivanov");
        map.put("country", "Russia");
        map.put("city", "Moscow");
        map.put("age", null);
//        System.out.println(map.toString());

        StringBuilder builder = new StringBuilder();

        for (Map.Entry entry : map.entrySet()) {  // перебор коллекции элементов из Map.Entry
            if (entry.getKey() == null || entry.getValue() == null) {
                continue;
            }
            builder.append(entry.getKey()).append(" = '").append(entry.getValue()).append("' and ");
        }
        if (builder.charAt(builder.length() - 1) == ' ') ;
        {  // если завершается не <'>, то удаляем 5 значений с конца <' end '>
            builder.delete(builder.length() - 5, builder.length());  //
        }
        String result = builder.toString();
        System.out.println("Задание 1 (2-й вариант): ");
        System.out.println(result);              // вывод части запроса where
        System.out.println(sqlStr.concat(result));  // вывод полного запроса
        System.out.println("================================");
    }



    //* Задание 4: Дана строка: ".3 + 1.56 = " подсчитать результат и добавить к строке
    public static String getResultSting() {
        String s = ".3 + 1.56 = ";
        double a = Double.parseDouble(s.substring(0, 3));
        double b = Double.valueOf(s.substring(5, 9));
        s += Double.toString(a + b);
        System.out.println(s);
        return s;
    }


    //    Задание 3:   Сравнить время выполнения замены символа "а" на "А" любой строки содержащей >1000
    //    символов средствами String и StringBuilder.
    private static void replacingChar() {
        String str = "Банальные, но неопровержимые выводы, а также сделанные на базе интернет-аналитики" +
                " выводы освещают чрезвычайно интересные особенности картины в целом, однако конкретные" +
                " выводы, разумеется, представлены в исключительно положительном свете." +
                " Однозначно, акционеры крупнейших компаний, превозмогая сложившуюся непростую экономическую" +
                " ситуацию, превращены в посмешище, хотя само их существование приносит несомненную пользу" +
                " обществу! Значимость этих проблем настолько очевидна, что реализация намеченных плановых" +
                " заданий влечет за собой процесс внедрения и модернизации экономической целесообразности" +
                " принимаемых решений. Но семантический разбор внешних противодействий создаёт предпосылки" +
                " для существующих финансовых и административных условий. Повседневная практика показывает," +
                " что повышение уровня гражданского сознания однозначно определяет каждого участника как" +
                " способного принимать собственные решения касаемо модели развития. В частности, укрепление" +
                " и развитие внутренней структуры создаёт необходимость включения в производственный план" +
                " целого ряда внеочередных мероприятий с учётом комплекса первоочередных требований." +
                " Мы вынуждены отталкиваться от того, что постоянное информационно-пропагандистское обеспечение" +
                " нашей деятельности требует от нас анализа укрепления моральных ценностей.";  // 1289 символов
        StringBuilder builder = new StringBuilder(str);

        long start = System.currentTimeMillis();
        for (int i = 0; i < str.length(); i++) {
            str = str.replace('а','А');
        }
//        System.out.println(str);
        System.out.println("String time = " + (System.currentTimeMillis() - start));
//
        start = System.currentTimeMillis();
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == 'а') {
                builder.setCharAt(i, 'А');
            }
        }
//        System.out.println(builder.toString());

        System.out.println("StringBuilder time = " + (System.currentTimeMillis() - start));

    }

    public static void processionJson() throws IOException {
        BufferedReader buf = new BufferedReader(new FileReader("file.json"));
        String st = buf.readLine();
        String jsonFile = "";
        while (st != null) {
            jsonFile += st;
            st = buf.readLine();
        }
        System.out.println("Исходная строка " + jsonFile);
        jsonFile = jsonFile
                .replace("{", "")
                .replace("}", "")
                .replace("[", "")
                .replace("]", "")
                .replaceAll("\"", "");
        getString(jsonFile);
    }

    public static void getString(String str){
        String [] arr = str.split(",");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String[] arrNew = arr[i].split(":");
            if (arrNew[0].equals("Фамилия")) {
                builder.append("Студент ");
                builder.append(arrNew[1]);
            } else if (arrNew[0].equals("Оценка")) {
                builder.append(" получил ");
                builder.append(arrNew[1]);
            } else if (arrNew[0].equals("Предмет")) {
                builder.append(" по предмету ");
                builder.append(arrNew[1]);
                builder.append(".\n");
            }
        }
        System.out.println("Результат: " + builder );
    }
}
