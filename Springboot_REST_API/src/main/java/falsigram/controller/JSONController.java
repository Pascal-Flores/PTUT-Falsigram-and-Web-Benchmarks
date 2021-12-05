package falsigram.controller;
import falsigram.bench.Bencher;
import falsigram.processor.JSONProcessor;
import org.springframework.web.bind.annotation.*;

@RestController
public class JSONController {

    @PostMapping(value="/Bench")
    public String CSVBenchExecutor(
            @RequestBody String request
    ) {
        Bencher b = new Bencher();
        return b.bench(request);
    }

}
