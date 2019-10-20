package String;

import java.util.*;

/**
 * @author Vincent
 * @Date 2019-08-17
 */
public class LastSubstringLexicographicalOrder {
    public static void main(String[] args) {
        String s = "kyimafghqcewvbnundlqhtimrzaiaiozrncagisusewebxkozcbqmpfsnclyhnpoccjoupbdxxxnnbjbvrxauszpmsetltlpzgwsptdpevrlgyqdfbgenwfeebczhjhnpmvghlqvnlvfskhoxkhzcyazogcdutqmgkcpesojblnyiaibcdqhnriotwpdvkthgbochasedhckzjtzecyrjwlrjnfeyfpaehddvyjapcaalsaiullozhlmesgwyrqoxyzpstquqsztlcxbdyyovaywmooussgthltojjcopuvotkqkhlzayymxnxdbgcyeqzckiosnxvhlxayhsmmqawjzepzezodwvzclmdjhysijdsogkvacklhmnjalpoynobsqeyuhuyjxrhpidjhakgqjdbedufvjwdajletfzerxenixxivnkpgptzfksjjjgjiiusglgqixhccoaoxoztgidivfvlwgeaemzrdrjpmcwmaibyhnaiesdanstsmjkiahtspcxopuqevajtfouvfheadkmogrwitniekkubywtaglofvkfasklciwomsugmnxpyhfyvyaifyrfeorleviywkgcturuadyrcdwgqwajgvuwvnrqudgoqzwgbkmwfjhbckfdxzkzzokjuhlnhcbpauxkcydzpjfhqncdqejryelozadcnqipgqbcklwpbgzdwlamvdixjzjaboyupgchwjwkvjgprbkuywufxarlifgytbslqrpbquykukzodkhjkgwzmvqxmvaehpcbbvioxdoawsbvmfbceyzurlhxawdicnsdhflwoaioeehoghixiwsbxbqvctmpdfauvzduxrqxesmgmnnddotyynucsdalgrxzddndqmmealzaxlvhnkimvmgsiiitpmfhgcmobpqnnlezewxyzmouiyftaeceqrxjrakjeydobatmydbbgjxpwizkafsjrphqcntwzyjmuryojfcogrx";
        String t = "pgtrdjdpscrwjifnrcttyruighgygsuvlhxpckkeahrupvnhlnpulyogsbktcuxnmnbmgadksxdjunqvmzyujynwzevtstjvzkddxjjmbgxfueteeuktvcbvypbdnzostbwxmxdwomguuymexfrrwuvuglgwmmwpkrqrpuzvjujksdwopsqlsrfgyzhymfgejuwhyvoqoxluvsdnmkglypoozrcgnzchpurezauixujddjjawqiaasvhrhfbhsqutgskudpcbqkkrcagrtalnsecxmlbiysgabvjbwpfufiwqdsnwbutashtejpmcypfztbgzuxwfcpkwdzhvfxbtvdvdaufjpqgfgxufhsopvwmgekcjejdlgxtdghmyzvopqkdzpuudyunnafvaeyshluuujkqncyigweelxmvgiaegonqmouaxwaqxhnnvaeuppsritdsymdwonbooswiolhbacpnehyvbhekxqxuvpnaxrfgeyixmurlgszqrotqynvtlbpjhhwdkbneiutmwutiyqegkxsrgldqvziysvihgbplhiumonlzlfzbuavbygmltdnfwjbspfpmzkfryjjpswihwixmbeodfpnmytccdvjnctzkxuqrvgjehodfdhpconhfpnatzzxyqkzjttgnwvxcfwyhlajvuhjonbpkvbbahlbybvvnhrwnnpnagtnnqcewzdzsxjgfoqbipohzsgpmyhqgvvnffjumirbhpbfletvcglthgwdvkgczucreovnfpbugyzuugqodpgsylfwyjucfnxjbghurnrkkuwsjfxeoxyzvltwhzyuechbfwstfovqgxngcwsmqsbzasrfrdvjcgedacvviihnzlijbaotpkvzmfejtfsnljthmzfhsrtieqlfhuatdwhcvsoxyphqsoxaqiqjcbuldswtjsukvcoowyfgmixswlyvkllvdtnerfisymrwgtfleupfxxswdlhvioeilstdlqfckoxpohcgnfannhbeeyzthhmszdphsbhjhxbwmjcknyrcsxgxcgnrvqnrlpqqwilhradmbowdvpusmombllpjikbuokakqzovmtmanaavururxjjxvrdnwabfwchkscmmmyixmjtogqgowbqlymnjcalxkmolmhyalvaftbcsidbmyfxshzdbwsfkvlnunvxzadljqngnnhjmlhfpmwnhvvwaokxxyfslhgggpjnhkyzdqgjdsrtaohqaryixzpyrkjumnphvfpsldrcjhxqjisogvybchagdnoezpvehagcqxarruqncmjifvxxvpbsygkzttmnykeptvbxmjsewbppcciomuyuowzbankzklnnxmnxiztfpfcnddaghyuxgaxmgphspocmpcucxkazeakifbsvnatqcvbeywbxsocgyxiawvmljwmokhbpzvijuckbqrjsdtntlriqgyjznvkkeoszsqsonjlsmxhawqqbdwixvnyemiypirwnoyhvfhbbbkcuyuuepobvrspotbbuvtmpykalufsvizvcelblhokldaymsgqasbobwyxnmcqvzqyldgmimsolloudxkjmiyekaiierxwwflmanqkovzxewrrfipzrclqvedftsuswanhfbcmjigxuxaguasfjypjjrgddnwnrfoazbvezxopumretyqfzqyosmvqjpqnuodylrkucrbhtrljryryewvfbnfwjldgjidvucotlvnsvqyjqwfmqhydttjaapqfdmvcytqpcjkqqrhwfiimbvlkvnvtghrggkjppaduhqpdneeejpqrxbnnenvobcgreldbnzpzrwxvkscywgekcnqnkgngokryvfgthpeggwroimsrwwvfmburaaqrzcmtctfxgrlhzbgixfkdjuerowuvtkmawtsrjzucrniwyzeauuizmfdlufwzqotupmykssvwaqljbiegvbonhqaekpeknpvkzgerjljgridlosexgtjkxnnjcqiahuvwvewsjmxbdhsemaoqsfsgxwghtskfxxxtohbqkascghktyxjeznuhguhvkhkhrgxvfjvktljkvmvkrikybfhjrleqxrwvyevynaprnumwpoazwmbevifrcbcckwmhcqrzgyywxlvxjmckmrfitvkelvoubqmflpmuhlwcjtcokvourxueatywmbsgbtcqzmekogznpbqsahgubnsfzfrvlgqvdsqcjptjkztcwbdciaivtwzavpzxgnbtscpzmffbwzezpijzcxnehhecsdyxabdupyqrfxywcikihubgfwrllhdmampqzewshiumisbuabzuthodmfjczwvwwbxbtadhhqqyqdzrfgzlbtlrtayrflxuehrxmggtbglsijmqiozpaydqxcewzizkdauybxbxhekppdxwnrwuchqotbsvatsxallqoatgdlarcoakioexnkugtpdldgzwnjmrdxtaheygwqmesdtinktgfxwsdibsyqyqdypwpzxucwefnzhfwjcnecbhtpuhcmvnyczwlozxlnsiizeteykfiitgyfqjbsoxvtumabgjhaquojutgxzqniiiisqhixjpcnhvopknagkmbuyqbbhlgaqhrnedonfsinfpywjvncbefkdwiidrmjtfunjhbcyvwnbiffildglmcspbmumhyewizqgfwuvbqawruppyjfkmthxpocpbduzqvecdapdjmiuvzduavdasropcdfmrzdfwkisetbznqubivoqkzvxhiuxowfmrsuevnllosjzzeajuxvvayugkzolddxbhyetzqkrxeyomyjidrculppuxxyuswfzkawloetbximriowohrduwpecmczgurxippfecsdrpybwjhbutwgqqrzckigaqevdazolffbffhpmklobchtddrbaqwfddkizyyhpowbgjiswezvhljhcjmetduxyawxjlzthhuplzwidbcbckqxmnitrniupkrqmzxdyctxgaagizoxgpjcedyuewibyalsvlshpngreerfzrqfloevdearlhcdwmxyjoqozxljgbgnccdefycdrqseaqsybwkvzeeccvkpmvpumlhjhsbaenzpbswpcgnxcvkdwllgwubibjaoiadzndfcodoaczxlugycuhdnkcvxjfzptwutlocwctpdfzfkygjrqxavotfrdlmazcfyjsrffzpnzfmuywpjkgywelrhiejhzeuagmlnefnmpscwcpjlcwbkgqwmohylgekxctqmitgtialbugksfirpemtpeixcypilupvlyppqalshwfeeqsqvjorfmpixdzlbiuxmshemapxjrmxhzkrquumpoiqzdgqldzfqohqyfhjeucjsuvjqtlyopxvgauncwthkcuxrtnsobcpkohuygbgltmgogainwmgebuiesejbwgajeaxhbegysmgfhiqdbpgbzsirzjntnfcvjlrqrstbxgznqzzzlxmkwbpvocrzeyquurrjnoblqeohyqfjhmsakicpazwvbvoouiytydwerlxzffwljqtqcwzytmdbpfloyfoixpqivuatqunngyazxvxdnyxhuahilvwnnmhimgxyvtopgsspwzubozebxefsmvsccyiykpoldfmmrnaywhbkcpgjvhuoclwxkxlbszuasmhynflhldmkkecgxjliseppoqrieqwtjkqidksvxctztcpjgedhsgnarqwyliuwbioarpurqdgubcowdepthbqxrtaxzatwzzoxbyuvinokysodoumpztnvcwtsbicuvtvqxszfdpcfdofzkcyqtojcywcsbijvsgitjbdpmqowvvdtllgdbdotqmkgklpizyltljyfdvmluinspznkutjlhwsfudbwiyrmisaqgjlhcneqnoeqrmsztwdkhjqorbfxpkzkihjpgdggwbajszidcvufnjyqxwwxglawjvneegoxztrcyjqlduczzhgdlesnaeyialxfhtcgwkxjcdsllpqwurenryothdqzdbjmppjyvwzxobkvlrxjytmpklararqdqjjnblxaliqhjvtbzysfkbhroccnlwnslpsvkarenxfezocpdocgamvufzcfjkxijwybwgbfmnnwuuunsoupaxbylxggremxxakntirsqjwkyxkldqokrlwevrvoovoekhesvxmbnycclrdhrzzbovalhtnzdhfuyatdgeyazstiovogkiuuvsjvvofvrfwyoxydkgkvhporcxccrlcecgqakknogwyemwcfmokuflsskyevbdkmmumftzcpdonagopprxcmwwuarqxbxglrnprstubwfjmxpwdsribxcglhhzthhajimjawanewsqmwifzndqwojclkdilkisapeegpeixshskpfdnsbmfjiojelllsvuquupkwvnkgfdwreabvhyswnsnsdofccebjqmawlkqbzcrxqcvargeqvruhgypqcfbltnhswzjbjayqglgsyttnvpxrjbbotzcmoscbykzxoqoqkooycfiviewtmpyzzpicglhsydafzdzresxjeqhahsukeprzooumbltzxhmqktoypcjenuqqlkpwtvyscfcxcodnokzxpcjlimqmeltiipawblteiyaftlvefhrglstuwupkfvjzhrlvejljfahcenhnsqmmcfpnbtwrkukzncabvgyvvfqhsairahkulbejckkoapagatvkhceqswlpzijcwddrooijdcircayscwmordpckluyryrguednmhzleeklgggqujqeobgesjdbpuueenraljjecjxssdosskkbhrnykrfvumazfcjalcttxewlxiwtsojrmeakgzkwympgkdrshbiaamlwwwvacewcjgaruzmcpblpgqdyykxjyybhwwgowlcsliiitgffqdfprvrrf";
        System.out.println(lastSubstring("leetcode"));
        System.out.println(lastSubstring("abab"));
        System.out.println(lastSubstring(t));
    }

//    public static String lastSubstring(String s) {
//        String last = "";
//        for (int i = 0; i < s.length() - 1; i++) {
//            if ((s.charAt(i) - 'a') <= (s.charAt(i + 1) - 'a')) continue;
//            for (int j = i + 1; j <= s.length(); j++) {
//                if (last.compareTo(s.substring(i, j)) < 0) {
//                    last = s.substring(i, j);
//                }
//            }
//        }
//        return last;
//    }

    public static String lastSubstring(String s) {
        String max = "";
        char maxChar = s.charAt(0);
        int maxCount = 0;

        for (char c : s.toCharArray()) {
            if (c > maxChar) {
                maxChar = c;
                maxCount = 1;
            } else if (c == maxChar) maxCount++;
        }
        if (maxCount == s.length()) return s;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == maxChar) {
                String temp = s.substring(i);
                if (max.compareTo(temp) < 0) max = temp;
            }
        }
        return max;
    }
}
