import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonFunction {

    private static void json2JsonObject() {

        String s = "{\"name\":{\"firstname\":\"fang\",\"lastname\":\"morty\"},\"age\":\"26\",\"hobby\":\"lol\"}";

        //还有个parse方法功能相同，不同的是parse转出来的对象类型是Object，需要手动强转成jsonObject
        JSONObject jsonObject = JSONObject.parseObject(s);
        System.out.println("json2JsonObject->" + jsonObject);
    }


    private static void json2JavaBean() {

        String s = "{\"name\":{\"firstname\":\"fang\",\"lastname\":\"morty\"},\"age\":\"26\",\"hobby\":\"lol\"}";
        Student student = JSONObject.parseObject(s, Student.class);
        System.out.println("json2JavaBean->" + student.getName().getFirstname());

    }

    private static void json2JsonArray() {

        String s = "[{\"name\":{\"firstname\":\"fang\",\"lastname\":\"morty\"},\"age\":\"26\",\"hobby\":\"lol\"}," +
                "{\"name\":{\"firstname\":\"yang\",\"lastname\":\"yang\"},\"age\":\"26\",\"hobby\":\"papa\"}]";
        JSONArray jsonArray = JSONObject.parseArray(s);

        for (int i = 0; i < jsonArray.size(); i++) {

            //JSONArray中的数据转换为String类型需要在外边加"";不然会报出类型强转异常！
            String array = jsonArray.get(i) + "";
            JSONObject jsonObject = JSONObject.parseObject(array);
            System.out.println("json2JsonArray->" + jsonObject.get("age"));

        }
    }

    private static void json2JavaBeanList(){

        String s = "[{\"name\":{\"firstname\":\"fang\",\"lastname\":\"morty\"},\"age\":\"26\",\"hobby\":\"lol\"}," +
                "{\"name\":{\"firstname\":\"yang\",\"lastname\":\"yang\"},\"age\":\"26\",\"hobby\":\"papa\"}]";

        List<Student> students = JSONObject.parseArray(s, Student.class);

        for (Student student : students) {
            System.out.println(student.getName().getFirstname());
        }
    }

    private static void javaBean2Json(){

        Name name = new Name("fang", "morty");
        Student student = new Student(name, "23", "lol");
        String s = JSONObject.toJSONString(student);
        System.out.println(s);
    }

    private static void javaBean2JsonObject(){

        Name name = new Name("fang", "morty");
        Student student = new Student(name, "23", "lol");
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(student);
        System.out.println(jsonObject.get("hobby"));

    }

    private static void json2ListInMap(){

        String s = "[{\"name\":{\"firstname\":\"fang\",\"lastname\":\"morty\"},\"age\":\"26\",\"hobby\":\"lol\"}," +
                "{\"name\":{\"firstname\":\"yang\",\"lastname\":\"yang\"},\"age\":\"26\",\"hobby\":\"papa\"}," +
                "{\"name\":{\"firstname\":\"li\",\"lastname\":\"pig\"},\"age\":\"25\",\"hobby\":\"lol\"}]";

        JSONArray jsonArray = JSONObject.parseArray(s);
        for (int i = 0; i < jsonArray.size(); i++) {

            String json = jsonArray.get(i) + "";
            Map map = JSONObject.parseObject(json, Map.class);
            System.out.println(map.get("name"));
        }
    }

    private static void mapToJsonObject(){

        //这里的value必须要设置成Object，不然在生成jsonObject时类型不匹配
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("name","fang");
        hashMap.put("age","20");
        JSONObject jsonObject = new JSONObject(hashMap);
        System.out.println(jsonObject.get("age"));
    }
    public static void main(String[] args) {

        json2JsonObject();
        json2JavaBean();
        json2JsonArray();

        json2JavaBeanList();
        javaBean2Json();
        javaBean2JsonObject();

        json2ListInMap();
        mapToJsonObject();

    }

}
