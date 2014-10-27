package amazon;

import java.util.*;

/**
 * Created by ray on 10/14/14.
 */
/*
Given that we have:
lines = {“This is a good world”, “You are a good man”, “Have a nice evening”}
and we need to locate the line that contains all the inputted keywords.
int find_line(char**  keywords, int nWords)
then,
find_line({“good”, “a”, “man”},3) -> 1
Please implement find_line(). Also analyse the time complexity.
 */
public class InvertedIndex {

    public static Map<String, List<Integer>> index = new HashMap<String, List<Integer>>();

    public static void buildIndex(String line, int linenumber){
        String[] list = line.split("\\W+");
        for (String _word:list) {
            String word = _word.toLowerCase();
            List<Integer> indexlist = index.get(word);
            if (indexlist == null){
                indexlist = new LinkedList<Integer>();
                index.put(word, indexlist);
            }
            indexlist.add(linenumber);
        }
    }

    // the algorithm is find intersection between lists.
    // count the linenumber  in a int array, if the count equal to the word number, mean find the result
    public static List<Integer> find(String[] words, int count, int linenumber){
        int[] counter = new int[linenumber];
        for(String word: words){
            List<Integer> list= index.get(word);
            for (Integer i:list){
                counter[i]++;
            }
        }
        //return the result list
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == count){
                result.add(i);
            }
        }
        return result;
    }
    /*
    using Retain
    int a[] = {3, 10, 4, 2, 8};
    int[] b = {10, 4, 12, 3, 23, 1, 8};
    List<Integer> aList =  Arrays.asList(a);
    List<Integer> bList =  Arrays.asList(b);
    aList.retainAll(bList);
    System.out.println(" a intersection b "+aList);
    int[] c = aList.toArray(new int[0]);
    */
    public static List<Integer> find2(String[] words, int count, int linenumber){
        if (words.length == 0){
            return null;
        }
        List<Integer> list1 = index.get(words[0]);
        for (int i = 1; i < words.length; i++) {
            List<Integer> list2 = index.get(words[i]);
            list1.retainAll(list2);

        }
        return list1;
    }

    public static void main(String[] args){
        String[] lines = new String[]{"This is a good world" , "You are a good man", "Have a nice evening"};
        for (int i = 0; i < lines.length; i++) {
            buildIndex(lines[i], i);

        }
//        System.out.print(Arrays.toString(index.values().toArray()));
        for (String key : index.keySet()) {
            System.out.println("word= "+ key + " and index list= " + index.get(key));
        }
        List<Integer> result = find(new String[]{"good", "a"}, 2, 3);
        if (result != null){
            for (Integer i:result){
                System.out.println("Result:"+i);
            }
        }
    }


}
