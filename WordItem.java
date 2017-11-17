public class WordItem {
  String word;
  long timeStamp;

  public WordItem(String word, long timeStamp){
    this.word = word;
    this.timeStamp = timeStamp;
  }

  public String toString(){
    return "Word: " + word + " Time Stamp: " + timeStamp;
  }
}
