import java.util.*;
import java.util.Iterator;

public class WordSearch {
  public ArrayList<WordItem> wordArray; //Stores transcribed words in timeOrder

  //Initialize WordSearch class
  public WordSearch(){
    wordArray = new ArrayList<WordItem>();
  }

  //Adds an item to the ArrayList
  //@param word, timeStamp : respective data needed to create new WordItem Object
  //@return boolean : true on success, false on failure
  public boolean add(String word, long timeStamp){
    WordItem a = new WordItem(word, timeStamp);
    if(wordArray.contains(a)) //Checks if the object is already in the list. Don't add it if it isn't.
      return false;
    wordArray.add(a); //Adds word into list
    return true;
  }

  //Finds all objects that have matching words
  //@param String : the word to look for
  //@return ArrayList : All of the WordItem Objects that have a matching String
  public ArrayList<WordItem> getWords(String word){
    ArrayList<WordItem> result = new ArrayList<WordItem>(); //Result will contain all objects with matching words
    Iterator<WordItem> litr = wordArray.iterator(); //Iterator for main ArrayList
    WordItem element;
    while(litr.hasNext()){ //Iterates through all objects in list
      element = litr.next();
      if(element.word.compareToIgnoreCase(word) == 0) //Adds to result if words match
        result.add(element);
    }
    //A Test to see if proper objects are selected
    litr = result.iterator();
    while (litr.hasNext()){
      element = litr.next();
      System.out.println(element);
    }
    return result;
  }

  public static void main(String args[]){
    WordSearch list = new WordSearch();
    System.out.println(list.add("pizza", 12));
    System.out.println(list.add("piza", 18));
    System.out.println(list.add("pizza", 109));

    list.getWords("PizzA");
  }

}
