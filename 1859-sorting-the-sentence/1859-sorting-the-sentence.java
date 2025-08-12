class Solution {
    public String sortSentence(String s) {
            // Split the shuffled sentence into words
        String[] words = s.split(" ");
        String[] originalWords = new String[words.length];
        // Process each word to extract the original word and its position
        for (String word : words) {
            // The last character is the position (1-indexed)
            int position = Character.getNumericValue(word.charAt(word.length() - 1)) - 1; // Convert to 0-indexed
            String originalWord = word.substring(0, word.length() - 1); // Get the original word
            originalWords[position] = originalWord; // Place it in the correct position
        }
        // Join the original words to form the reconstructed sentence
        return String.join(" ", originalWords);
    }
    
    }
