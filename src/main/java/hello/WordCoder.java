package hello;

import org.springframework.web.bind.annotation.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

@RestController
public class WordCoder {
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(
            value = "/compile",
            method = RequestMethod.POST,
            consumes = "text/plain")
    public String compileCode(@RequestBody String code) {
        try {
            WordContentExtractorInterface contentExtractor = new WordContentExtractor();
          //  String code = contentExtractor.extractContentFromWordFile(new BufferedInputStream(new FileInputStream("/Users/ShannonYap/Downloads/HelloWorld.docx")));
            JavaCompilerInterface compiler = new JavaCompiler();
            String className = extractClassNameFromCode(code);
            String compilerOutput = compiler.generateCompilerOutput(code, className);
            return compilerOutput;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "There was nothing to run!";
    }

    public static String extractClassNameFromCode(String code) {
        code = code.replaceAll("\\s+","");
        code = code.replace("publicclass", "");
        String[] codeChunk = code.split("\\{");
        return codeChunk[0];
    }
}

