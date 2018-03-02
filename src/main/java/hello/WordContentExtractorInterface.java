package hello;

import java.io.BufferedInputStream;

public interface WordContentExtractorInterface {
    public String extractContentFromWordFile(BufferedInputStream bufferedInputStream) throws Exception;
}

