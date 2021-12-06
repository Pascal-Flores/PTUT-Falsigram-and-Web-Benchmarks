package falsigram.controller;
import falsigram.bench.RandomBencher;
import falsigram.bench.SequenceBencher;
import falsigram.processor.JSONProcessor;
import org.springframework.web.bind.annotation.*;

@RestController
public class JSONController {

    @PostMapping(value="/Bench")
    public String CSVBenchExecutor(
            @RequestBody String request
    ) {
        SequenceBencher b = new SequenceBencher();
        return b.bench(request);
    }

    @PostMapping(value="/RandomBench")
    public String CSVRandomBenchExecutor(
            @RequestBody String request
    ) {
        RandomBencher b = new RandomBencher();
        return b.bench(request);
    }

}
