package String;

import java.util.*;

/**
 * @author Qian
 * @create 2021-06-2410:23 下午
 */
public class WordLadder {
    public static void main(String[] args) {
        char[] chars = s.toCharArray();
        chars[0] = '1';
        System.out.println(s);
        System.out.println(new String(chars));
        System.out.println(ladderLength("hit","dot",
                new ArrayList<String>(){{add("hot");add("dot");}}));
    }
    static HashMap<String, ArrayList<String>> graph = new HashMap();
    static Set<String> isVisted = new HashSet();

    static public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for(String s: wordList){
            buildGraph(s);
        }
        if(!graph.containsKey(beginWord)){
            buildGraph(beginWord);
        }
        if(!graph.containsKey(endWord)){
            return 0;
        }
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        isVisted.add(beginWord);
        int depth = 1;
        int temp = 1;
        while(!queue.isEmpty()){
            int queueCount = temp;
            for(int i =0;i<queueCount;i++){
                String curString = queue.poll();
                if(graph.containsKey(curString)){
                    if(endWord.equals(curString)){
                        return depth;
                    }
                    ArrayList<String> list = graph.get(curString);
                    for(String s:list){
                        if(!isVisted.contains(s)){
                            isVisted.add(s);
                            queue.offer(s);
                            temp++;
                        }
                    }
                }
            }
            depth++;
        }
        return 0;
    }

    static void buildGraph(String s){
        for(int i = 0;i<s.length();i++){
            String alterS = s.substring(0, i)+"*"+s.substring(i+1);
            if(graph.containsKey(s)){
                graph.get(s).add(alterS);
            }else{
                graph.put(s,new ArrayList<String>(){{add(alterS);}});
            }
            // ArrayList<String> edgesTo = graph.getOrDefault(s, new ArrayList<String>());
            // edgesTo.add(alterS);
            // graph.set(alterS,edgesTo);

            if(graph.containsKey(alterS)){
                graph.get(alterS).add(s);
            }else{
                graph.put(alterS,new ArrayList<String>(){{add(s);}});
            }
            // ArrayList<String> edgesFrom = graph.getOrDefault(alterS, new ArrayList<String>());
            // edgesFrom.add(s);
            // graph.set(alterS,edgesFrom);
        }
    }
}
