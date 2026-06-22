/**
   1189. Maximum Number of Balloons

   Given a string text, you want to use the characters of text to form as many
   instances of the word "balloon" as possible.

   You can use each character in text at most once. Return the maximum number
   of instances that can be formed.

   Example 1:
   Input: text = "nlaebolko"
   Output: 1

   Example 2:
   Input: text = "loonbalxballpoon"
   Output: 2

   Example 3:
   Input: text = "leetcode"
   Output: 0
*/
class MaximumNumberOfBalloons {
    private static int maxNumberOfBalloons(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        for (char ch : text.toCharArray()) {
            switch (ch) {
            case 'b': b++; break;
            case 'a': a++; break;
            case 'l': l++; break;
            case 'o': o++; break;
            case 'n': n++; break;
            }
        }
        l = l / 2;
        o = o / 2;
        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
    public static void main(String[] args) {
        Log.info(maxNumberOfBalloons("nlaebolko")); // 1
        Log.info(maxNumberOfBalloons("loonbalxballpoon")); // 2
        Log.info(maxNumberOfBalloons("leetcode")); // 0
        Log.info(maxNumberOfBalloons("krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw")); // 10
        Log.info(maxNumberOfBalloons("mbetypbpefxvviadqaodrbjeoacfomepmzymiudltgnvnpbowwmjgpzzhtiismearuwocsgbiimiqqzaozgeizikrlxmupfzjzmlfttqqbpfblqfkecsdfbsceqjhubfxksivrfwvukapxmuciybfhzlmpeamdxziptxregymqtmgcsujmugissgnlbhxbcxxeoumcqyulvahuianbaaxgzrtmshjguqdaxvxndzoqvwmcjfhpevavnrciqbymnlylbrfkkiceienoarfrzzxtuaqapaeqeqolozadmtgjyhfqzpuaskjuawxqkdqyjqcmbxtvshzrquvegcuyuckznspmrxvqdassidcmrajedsnuuumfwqzvasljlyvfefktiqgvzvdzojtjegsyhbepdkuwvgrfscezvswywmdavpxlekbrlkfnbyvlobazmvgulxrfdranuhomkrlpbfeagfxxxuhjuqhbkhznixquxrxngwimdxdhqbdaouitsvcdmbwxbbaomkgxsqwnexbjjyhtxvkjfqkrrxjghvzqsattubphryqxxdyjkihfnzvjhohnhdlfwoqiwtmwzfgcyhyqtcketvgnbchcxvnhcsoosirfqgdgcsitegzlxdfijzmxnvhrulmgvoqfpzesootscnxenokmmozmoxpaverydbsnimwacjqhrtxkqtvghjyushoctxphxzztukgmnoeycqaeukymvwxcsyvvctflqjhtcvjtxncuvhkptkjnzaetwbzkwnseovewuhpkaxiphdicgacszzdturzgjkzwgkmzzavykancvvzaafgzjhcyicorrblmhsnnkhfkujttbkuuedhwguuaapojmnjdfytdhrepjwcddzsoeutlbbljlikghxefgbqenwamanikmynjcupqpdjnhldaixwygcvsgdkzszmsptqqnroflgozblygtiyaxudwmooiviqcosjfksnevultrf")); // 14
        // Log.info('b' - 'a');
        // Log.info('a' - 'a');
        // Log.info('l' - 'a');
        // Log.info('o' - 'a');
        // Log.info('n' - 'a');
    }
}
/**
    private static int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for (char ch : text.toCharArray()) {
            freq[ch - 'a']++;
        }
        // Log.info(freq);
        int f = Integer.MAX_VALUE;
        int d = Integer.MAX_VALUE;

        f = Math.min(f, freq[1]);   // b
        f = Math.min(f, freq[0]);   // a
        f = Math.min(f, freq[13]);  // n

        d = Math.min(d, freq[11]);  // l
        d = Math.min(d, freq[14]);  // n

        Log.info("f = " + f);
        Log.info("d = " + d);

        if (d >= (f * 2)) return f;
        // if (d < f) return 0;

        int ans = Integer.MIN_VALUE;
        while (d >= 0) {
            Log.info("d / 2 = " + d / 2);
            ans = Math.max(ans, (d/2));
            Log.info("ans = " + ans);
            d--;
        }
        return ans;
    }
*/
