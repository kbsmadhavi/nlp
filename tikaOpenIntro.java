import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.Span;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

    public class tikaOpenIntro {

    public String Tokens[];

    public static void main(String[] args) throws IOException, SAXException,
            TikaException {

        tikaOpenIntro toi = new tikaOpenIntro();
        Tika tikaNew = new Tika();
        String strResume = tikaNew.parseToString(new File("C:\\Users\\Admin\\Downloads\\madhavi2015-Jul.docx"));
        String input = "      Madhavi Padakanti\n\t9591990898 (M)\n\tkbsmadhavi@yahoo.com\n\nBangalore	is my native place.To obtain a challenging position that will leverage my significant research and development experiences, Software Development & Management contributing to support the company’s growth, profitability, and success. I have held many management, R&D leadership and development positions in a wide variety of areas over the years including Internet & web services, mobile applications, location based services, social community services, credit card payments, mobile payments and telecommunications.\n\nSpecialties: People leadership, strategic planning and execution, engineering management,project management\n\nSUMMARY\n\n* 17 years of experience in product creation, building web/mobile solutions in financial, payment transactions, location and social domains.\n* Experienced in leading engineering teams. Leadership capabilities in hiring, building and mentoring teams.\n* Proficient in delivering products from concept to production, coordinating with cross-functional teams like sales, product management, QA and deployment.\n Eight years of experience in USA, 9+ years of experience in India with multiple site management including China, Srilanka in production grade enterprise applications.\n* Established, managed and motivated cross functional teams and maintained high levels of performance standards to consistently achieve targets.\n* Managed the productive relationships with internal departments and also external partners/vendors including Deals and You, Delight circle, GETIT, Airtel and Tata Docomo for collaborated development.\n* Have extensive experience in analyzing business requirements and strategies with product management teams.\n* Have extensive knowledge in Distributed technologies and in defining Enterprise Architecture following SDLC, Agile methodologies.\nHONORS/AWARDS\n.";
        System.out.println(strResume);
        String cnt;

        cnt="Madhavi dsjflsdjfls";
        //  cnt="Madhavi";
                toi.tokenization(input);

        String names = toi.namefind(toi.Tokens);
        String org = toi.orgfind(toi.Tokens);

                System.out.println("person name is : "+names);
        System.out.println("organization name is: "+org);

    }
        public String namefind(String cnt[]) {
        InputStream is;
        TokenNameFinderModel tnf;
        NameFinderME nf;
        String sd = "";
        try {
            is = new FileInputStream(
                    "e:\\nlp\\citiesSentOut.bin");
            tnf = new TokenNameFinderModel(is);
            nf = new NameFinderME(tnf);

            Span sp[] = nf.find(cnt);

            String a[] = Span.spansToStrings(sp, cnt);
            StringBuilder fd = new StringBuilder();
            int l = a.length;

            for (int j = 0; j < l; j++) {
                fd = fd.append(a[j] + "\n");

            }
            sd = fd.toString();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (InvalidFormatException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return sd;
    }

    public String orgfind(String cnt[]) {
        InputStream is;
        TokenNameFinderModel tnf;
        NameFinderME nf;
        String sd = "";
        try {
            is = new FileInputStream(
                    "resources/en-ner-organization.bin");
            tnf = new TokenNameFinderModel(is);
            nf = new NameFinderME(tnf);
            Span sp[] = nf.find(cnt);
            String a[] = Span.spansToStrings(sp, cnt);
            StringBuilder fd = new StringBuilder();
            int l = a.length;

            for (int j = 0; j < l; j++) {
                fd = fd.append(a[j] + "\n");

            }

            sd = fd.toString();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (InvalidFormatException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return sd;

    }


    public void tokenization(String tokens) {

        InputStream is;
        TokenizerModel tm;

        try {
            is = new FileInputStream("resources/en-token.bin");
            tm = new TokenizerModel(is);
            Tokenizer tz = new TokenizerME(tm);
            Tokens = tz.tokenize(tokens);
            // System.out.println(Tokens[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}