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
        Request();     
        processionJson();      
        getResultSting();      
    }
    public static void Request() {
        String string = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        System.out.println(string);
        string = string
                .replace("{", "")
                .replace("}", "")
                .replaceAll("\"", "")
                .replaceAll(":", "=" );

        String [] ArrStr = string.split(", ");
        StringBuilder sb = new StringBuilder("");
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
    }

    public static String getResultSting() {
        String s = ".3 + 1.56 = ";
        double a = Double.parseDouble(s.substring(0, 3));
        double b = Double.valueOf(s.substring(5, 9));
        s += Double.toString(a + b);
        System.out.println(s);
        return s;
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
