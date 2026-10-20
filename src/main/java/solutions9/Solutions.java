package solutions9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solutions {

    public static void main(String[] args) {
        Solutions solutions = new Solutions();
        String s = "(name)is(age)yearsold";
        List<List<String>> knowledge = List.of(List.of("name", "bob"),  List.of("age", "two"));
        String output = solutions.evaluate(s, knowledge);
        System.out.println(output);
    }
    public String evaluate(String s, List<List<String>> knowledge) {

        Map<String, String> knowledgeMap = buildKnowledgeMap(knowledge);

       return buildString(s, knowledgeMap);

    }

    private String buildString(String s, Map<String, String> knowledgeMap){

        StringBuilder sb = new StringBuilder();
        boolean inParens = false;
        StringBuilder key = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
               inParens = true;
               continue;
            }

            if(c == ')'){
                String keyString = key.toString();
                key = new StringBuilder();
                String value = knowledgeMap.getOrDefault(keyString, "?");
                sb.append(value);
                inParens = false;
                continue;
            }

            if(!inParens){
                sb.append(c);
            } else {
                key.append(c);
            }
        }
        return sb.toString();
    }

    private Map<String, String> buildKnowledgeMap(List<List<String>> knowledge){
        Map<String, String> map = new HashMap<>();
        for(List<String> knowledgePair: knowledge){
            map.put(knowledgePair.get(0), knowledgePair.get(1));
        }

        return map;
    }
}
