class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < words.length)
        {
            int j = i;
            int linel = 0;
            while(j < words.length && linel + words[j].length() + (j - i) <= maxWidth)
            {

                linel += words[j].length();
                j++;
            }
            int numW = j - i;
            int sa = maxWidth - linel;

            StringBuilder line = new StringBuilder();

            if (j == words.length || numW == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) line.append(" ");
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } 
            else {
                int spaceE = sa / (numW - 1);
                int e = sa % (numW - 1);

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        int spacesToA = spaceE + (e-- > 0 ? 1 : 0);
                        for (int s = 0; s < spacesToA; s++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
        }
    }
