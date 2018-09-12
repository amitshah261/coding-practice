package ms;

/*
    Write a function, that, given a paragraph as input, outputs the paragraph with all the words reversed.
*/
public class ReverseAllWordsInSentence {

    private String reverseWords(String sentence) {
        String[] words = sentence.split(" ");
        for(int i = 0; i < words.length; i++){
            words[i] = reverseWord(words[i]);
        }
        StringBuilder result = new StringBuilder();
        for(String word : words){
            result.append(word + " ");
        }
        return result.toString();
    }

    private String reverseWord(String word) {
        int index = 0, lastIndex = word.length() - 1;
        char[] wordChars = word.toCharArray();
        while(index < word.length() / 2){
            char temp = wordChars[index];
            wordChars[index++] = wordChars[lastIndex];
            wordChars[lastIndex--] = temp;
        }
        return new String(wordChars);
    }

    public static void main(String[] args) {
        ReverseAllWordsInSentence rw = new ReverseAllWordsInSentence();
        String sentence = "This is one long sentence and the words in this sentence should be reversed";
        System.out.println(rw.reverseWords(sentence));
        sentence = "reversed desrever";
        System.out.println(rw.reverseWords(sentence));
        sentence = "madam";
        System.out.println(rw.reverseWords(sentence));
    }

}
