public class WordItem {
  String word;
  int timeStamp;

  public WordItem(String word, int timeStamp){
    this.word = word;
    this.timeStamp = timeStamp;
  }

  public String toString(){
    return "Word: " + word + " Time Stamp: " + timeStamp;
  }
}
