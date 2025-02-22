/**
 *
 * This class allows to process the JSON request
 *
 * @author Pascal Flores
 *
 */

package falsigram.processor;

import falsigram.bench.Bencher;
import falsigram.bench.SequenceBencher;
import falsigram.bench.SequenceBencher;
import org.json.JSONObject;
import falsigram.text.core.Text;
import falsigram.text.utils.*;
import java.time.Duration;
import java.util.List;


public class JSONProcessor {

    private JSONObject request;
    private Text text;
    private Bencher b;

    /**
     * @param stringRequest
     */
    public JSONProcessor(String stringRequest, Bencher b){
        this.b = b;
        this.request = new JSONObject(stringRequest);
        long sT = System.nanoTime();
        text = new Text(request.getString("text"));
        float dT = (System.nanoTime()-sT)/1000000f;
        this.b.setTmpText_gen(dT);
    }

    /**
     *
     * Analyses the JSON request given in the object constructor
     * and calls the appropriate methods
     *
     * @return String
     */
    public String processJSONRequest() {
        /*JSONObject instruction;
        float occurrence;
        for (int i = 0; i < request.getJSONArray("instructions").length(); ++i) {
            instruction = request.getJSONArray("instructions").getJSONObject(i);
            occurrence = instruction.getFloat("occurrence");
            if (occurrence != 0){
                switch (instruction.getString("name").charAt(0)){
                    case 'i' :
                        switch (instruction.getString("name")){
                            case "insertLetters" :
                                this.text = Inserter.insertLetters(this.text, occurrence);
                                break;
                            case "insertSpaces" :
                                this.text = Inserter.insertSpaces(this.text, occurrence);
                                break;
                            case "insertAccents" :
                                this.text = Inserter.insertAccents(this.text, occurrence);
                                break;
                            case "insertNearKeyboardKeyLetters" :
                                this.text = Inserter.insertNearKeyboardKeyLetters(this.text, occurrence);
                                break;
                            default :
                                break;
                        }
                        break;
                    case 'r' :
                        switch (instruction.getString("name")){
                            case "replaceLetters" :
                                this.text = Replacer.replaceLetters(this.text, occurrence);
                                break;
                            case "replaceAccents" :
                                this.text = Replacer.replaceAccents(this.text, occurrence);
                                break;
                            case "replacePunctuations" :
                                this.text = Replacer.replacePunctuations(this.text, occurrence);
                                break;
                            case "replaceAHomophones" :
                                this.text = Replacer.replaceAHomophones(this.text, occurrence);
                                break;
                            case "replaceEtHomophones" :
                                this.text = Replacer.replaceEtHomophones(this.text, occurrence);
                                break;
                            case "replaceSaHomophones" :
                                this.text = Replacer.replaceSaHomophones(this.text, occurrence);
                                break;
                            case "replaceSeHomophones" :
                                this.text = Replacer.replaceSeHomophones(this.text, occurrence);
                                break;
                            case "replaceSaitHomophones" :
                                this.text = Replacer.replaceSaitHomophones(this.text, occurrence);
                                break;
                            case "replaceDansHomophones" :
                                this.text = Replacer.replaceDansHomophones(this.text, occurrence);
                                break;
                            case "replaceLaHomophones" :
                                this.text = Replacer.replaceLaHomophones(this.text, occurrence);
                                break;
                            case "replaceMaisHomophones" :
                                this.text = Replacer.replaceMaisHomophones(this.text, occurrence);
                                break;
                            case "replaceOnHomophones" :
                                this.text = Replacer.replaceOnHomophones(this.text, occurrence);
                                break;
                            case "replaceOuHomophones" :
                                this.text = Replacer.replaceOuHomophones(this.text, occurrence);
                                break;
                            case "replacePeuHomophones" :
                                this.text = Replacer.replacePeuHomophones(this.text, occurrence);
                                break;
                            default :
                                break;
                        }
                        break;
                    case 'd' :
                        switch (instruction.getString("name")) {
                            case "deleteLetters" :
                                this.text = Deleter.deleteLetters(this.text, occurrence);
                                break;
                            case "deleteSpaces" :
                                this.text = Deleter.deleteSpaces(this.text, occurrence);
                                break;
                            case "deleteAccents" :
                                this.text = Deleter.deleteAccents(this.text, occurrence);
                                break;
                            case "deletePunctuations" :
                                this.text = Deleter.deletePunctuations(this.text, occurrence);
                            default :
                                break;
                        }
                        break;
                    case 's' :
                        switch (instruction.getString("name")) {
                            case "swapCharsInWord" :
                                this.text = Swapper.swapCharsInWord(this.text, occurrence);
                                break;
                            case "swapContiguousCharsInWord" :
                                this.text = Swapper.swapContiguousInWord(this.text, occurrence);
                                break;
                            case "swapWordsInSentence" :
                                this.text = Swapper.swapWordsInSentence(this.text, occurrence);
                                break;
                            case "swapContiguousWordsInSentence" :
                                this.text = Swapper.swapContiguousWordsInSentence(this.text, occurrence);
                            default :
                                break;
                        }
                        break;
                }
            }
        }*/
        long sT = System.nanoTime();
        String ret = this.text.toString();
        this.b.setTmpToString((System.nanoTime()-sT)/1000000f);
        return ret;
    }
}
