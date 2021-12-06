package falsigram.bench;

import falsigram.processor.JSONProcessor;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SequenceBencher extends Bencher {
    
    private float tmpText_gen;
    private float tmpToString;
    
    public SequenceBencher() {
    }

    public String bench(String request) {
        JSONObject req = new JSONObject(request);
        String text = req.getString("text");
        int nb = req.getInt("iterations");
        List<String> l = new ArrayList<>();
        l.add("name;id;text_gen;toString;total");
        
        for (int i=0; i< nb; ++i) {
            new JSONProcessor("{ \"text\": \""+text+" \" }", this).processJSONRequest();
            l.add(text.substring(0,10)+";"+i+";"+tmpText_gen+";"+tmpToString+";"+Float.valueOf(tmpText_gen+tmpToString));
        }
        StringBuilder csv = new StringBuilder();
        for (String s : l) {
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
