import java.io.File;
import java.io.IOException;
import java.util.*;

public class CTPHashing {

    public static void main(String[] args){
        findRepeats();
        anagram();
        huffman();
    }

    public static void findRepeats(){
        try {
            Scanner s = new Scanner(new File("repeating_input001.txt"));
            String sentence = s.nextLine();
            String[] words = sentence.split("\\s|\\t|,|:|;|-|\\.");
            HashMap<String, Integer> map = new HashMap<>();
            for(String word : words){
                if(map.containsKey(word)){
                    System.out.println("First repeating word is : " + word);
                    break;
                } else {
                    map.put(word, 1);
                }
            }
        } catch(IOException ioe) {

        }
    }

    public static void anagram(){
        try{
            Scanner s = new Scanner(new File("anagram_input001.txt"));
            ArrayList<String> words = new ArrayList<>(100);

            while(s.hasNext()){
                words.add(s.next());
            }

            for(String word : words){
                int counter = 0;
                int mid = word.length()/2;
                String left = word.substring(0, mid);
                String right = word.substring(mid, word.length());
                int firstSize, secondSize;
                firstSize = secondSize = 0;
                HashMap<Character, Integer> first = new HashMap<>();
                HashMap<Character, Integer> second = new HashMap<>();

                for(int i = 0; i < left.length(); i++){
                    Character c = left.charAt(i);
                    if(first.containsKey(c)){
                        first.put(c, first.get(c)+1);
                    } else {
                        first.put(c, 1);
                    }
                }

                for(int freq : first.values()){
                    firstSize+=freq;
                }

                for(int k = 0; k < right.length(); k++) {
                    Character c = right.charAt(k);

                    if (second.containsKey(c)) {
                        second.put(c, second.get(c) + 1);
                    } else {
                        second.put(c, 1);
                    }
                }

                for(int freq : second.values()){
                    secondSize+=freq;
                }

                if(firstSize > secondSize || firstSize < secondSize){
                    counter = -1;
                } else {
                    for(int k = 0; k < right.length(); k++){
                        Character c = right.charAt(k);
                        if(first.containsKey(c) && first.get(c) != 0){
                            first.put(c, first.get(c)-1);
                        } else {
                            counter++;
                        }
                    }
                }
                System.out.println(counter);
            }
        } catch(IOException ioe){

        }
    }

    public static void huffman(){
        try{
            Scanner s = new Scanner(new File("huffman_input001.txt"));
            HashMap<String, String> map = new HashMap<>();
            ArrayList<String> lines = new ArrayList<>();
            int numChars = Integer.parseInt(s.nextLine());
            int longestLen = 0;

            while(numChars > 0){
                String line = s.nextLine();
                char firstChar = line.charAt(0);
                if(firstChar == ' '){
                    map.put(line.trim(), " ");
                } else {
                    String[] words = line.split(" ");
                    if(longestLen < words[1].length()){ longestLen = words[1].length(); }
                    if(words.length > 1){
                        map.put(words[1], words[0]);
                    }
                }
                numChars--;
            }

            while(s.hasNext()){
                lines.add(s.nextLine());
            }

            StringBuilder decodedString = new StringBuilder();
            for(String line : lines){
                for(int i = 0; i < line.length(); i++){
                    String part;
                        part = line.substring(i, i+longestLen-1);
                        if(map.get(part) != null){
                            decodedString.append(map.get(part));
                            i+=longestLen-2;
                        } else {
                            part = line.substring(i, i+longestLen);
                            if(map.get(part).equals("[newline]")){
                                decodedString.append("\n");
                            } else {
                                decodedString.append(map.get(part));
                            }
                            i+=longestLen-1;
                        }
                }
                System.out.println(decodedString);
            }
        } catch(IOException ioe){

        }
    }

}
