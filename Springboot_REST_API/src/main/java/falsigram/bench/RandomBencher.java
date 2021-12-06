package falsigram.bench;

import falsigram.processor.JSONProcessor;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomBencher extends Bencher {

    private float tmpText_gen;
    private float tmpToString;

    public RandomBencher() {

    }

    public String bench(String request) {
        JSONObject req = new JSONObject(request);

        List<String> poisCSV = new ArrayList<>();
        poisCSV.add("name;id;text_gen;toString;total");
        List<String> balzacCSV = new ArrayList<>();
        balzacCSV.add("name;id;text_gen;toString;total");
        List<String> zolaCSV = new ArrayList<>();
        zolaCSV.add("name;id;text_gen;toString;total");
        List<String> hugoCSV = new ArrayList<>();
        hugoCSV.add("name;id;text_gen;toString;total");
        List<String> proustCSV = new ArrayList<>();
        proustCSV.add("name;id;text_gen;toString;total");

        int nb = req.getInt("iterations");
        List<Integer> texts = new ArrayList<>();
        texts.add(0);
        texts.add(1);
        texts.add(2);
        texts.add(3);
        texts.add(4);

        String text;
        for (int batch = nb; batch > 0; --batch){
            Collections.shuffle(texts);
            for( Integer i : texts) {
                switch (i) {
                    case 0:
                        text = req.getString("pois");
                        new JSONProcessor("{ \"text\": \""+text+" \" }", this).processJSONRequest();
                        poisCSV.add("pois"+";"+Integer.valueOf(1000-batch)+";"+tmpText_gen+";"+tmpToString+";"+Float.valueOf(tmpText_gen+tmpToString));
                        break;
                    case 1:
                        text = req.getString("balzac");
                        new JSONProcessor("{ \"text\": \""+text+" \" }", this).processJSONRequest();
                        balzacCSV.add("balzac"+";"+Integer.valueOf(1000-batch)+";"+tmpText_gen+";"+tmpToString+";"+Float.valueOf(tmpText_gen+tmpToString));
                        break;
                    case 2:
                        text = req.getString("zola");
                        new JSONProcessor("{ \"text\": \""+text+" \" }", this).processJSONRequest();
                        zolaCSV.add("zola"+";"+Integer.valueOf(1000-batch)+";"+tmpText_gen+";"+tmpToString+";"+Float.valueOf(tmpText_gen+tmpToString));
                        break;
                    case 3:
                        text = req.getString("hugo");
                        new JSONProcessor("{ \"text\": \""+text+" \" }", this).processJSONRequest();
                        hugoCSV.add("hugo"+";"+Integer.valueOf(1000-batch)+";"+tmpText_gen+";"+tmpToString+";"+Float.valueOf(tmpText_gen+tmpToString));
                        break;
                    case 4 :
                        text = req.getString("proust");
                        new JSONProcessor("{ \"text\": \""+text+" \" }", this).processJSONRequest();
                        proustCSV.add("proust"+";"+Integer.valueOf(1000-batch)+";"+tmpText_gen+";"+tmpToString+";"+Float.valueOf(tmpText_gen+tmpToString));
                        break;
                }
            }
        }

        StringBuilder csv = new StringBuilder();
        csv.append("Pois : \n");
        for (String s : poisCSV) {
            csv.append(s);
            csv.append("\n");
        }
        csv.append("Balzac : \n");
        for (String s : balzacCSV) {
            csv.append(s);
            csv.append("\n");
        }
        csv.append("Zola : \n");
        for (String s : zolaCSV) {
            csv.append(s);
            csv.append("\n");
        }
        csv.append("Hugo : \n");
        for (String s : hugoCSV) {
            csv.append(s);
            csv.append("\n");
        }
        csv.append("Proust : \n");
        for (String s : proustCSV) {
            csv.append(s);
            csv.append("\n");
        }
        return csv.toString();
    }

    public void setTmpText_gen(float tmpText_gen) {
        this.tmpText_gen = tmpText_gen;
    }

    public void setTmpToString(float tmpToString) {
        this.tmpToString = tmpToString;
    }

}
