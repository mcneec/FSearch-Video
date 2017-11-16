import java.util.*;
import java.util.Iterator;

//This class works best if transcribed audio is entered in order
public class WordSearch {
  public ArrayList<WordItem> wordArray; //Stores transcribed words in timeOrder

  //Initialize WordSearch class
  public WordSearch(){
    wordArray = new ArrayList<WordItem>();
  }

  //Adds an item to the ArrayList
  //@param word, timeStamp : respective data needed to create new WordItem Object
  //@return boolean : true on success, false on failure
  public boolean add(String word, int timeStamp){
    WordItem a = new WordItem(word, timeStamp);
    if(wordArray.contains(a)) //Checks if the object is already in the list. Don't add it if it isn't.
      return false;
    wordArray.add(a); //Adds word into list
    return true;
  }

  //Finds all objects that have matching words
  //@param String : the word to look for
  //@return ArrayList : All of the WordItem Objects Indexes that have a matching String
  private ArrayList<Integer> findWord(String word){
    ArrayList<Integer> result = new ArrayList<Integer>(); //Result will contain all objects with matching words
    Iterator<WordItem> litr = wordArray.iterator(); //Iterator for main ArrayList
    //WordItem element;
    while(litr.hasNext()){ //Iterates through all objects in list
      WordItem element = litr.next();
      if(element.word.compareToIgnoreCase(word) == 0) //Adds to result if words match
        result.add(wordArray.indexOf(element));
    }
    //A Test to see if proper Indexes are selected  are selected
    Iterator<Integer> litr0 = result.iterator();
    while (litr0.hasNext()){
      Integer element = litr0.next();
      //System.out.println(element);
    }
    return result;
  }

  //@param String : any number of words from 1 up to ...
  //@return ArrayList : Returns the timeStamp of all ocurrences of the given String(s)
  public ArrayList<Integer> findWords(String... words){
    ArrayList<Integer> result = new ArrayList<Integer>();
    ArrayList<Integer> indexes = findWord(words[0]);
    if(words.length > 1){
      for(int i = 1; i < words.length; i++){
        for(int j = 0; j < indexes.size(); j++){
          if(indexes.get(j) != null){
            if(wordArray.get(indexes.get(j) + 1).word.compareToIgnoreCase(words[i]) != 0)
              indexes.remove(indexes.get(j));
          }
        }
      }
    }

    Iterator<Integer> litr = indexes.iterator();
    Integer element;
    while(litr.hasNext()){
      Integer temp = litr.next();
      if(temp != null){
        //System.out.println(wordArray.get(litr.next()));
        element = wordArray.get(temp).timeStamp;
        System.out.println(element);
        result.add(element);
      }
    }
    return result;
  }

  public static void main(String args[]){
    WordSearch list = new WordSearch();
    list.add("hello", 12);
    list.add("today", 14);
    list.add("we", 18);
    list.add("hello", 19);
    list.add("today", 21);
    list.add("we", 180);

    list.findWords("hello");
    list.findWords("hello", "today");
    list.findWords("hello", "today", "we");
  }

}
