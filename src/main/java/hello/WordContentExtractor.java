package hello;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.BufferedInputStream;

public class WordContentExtractor implements WordContentExtractorInterface {

    public String extractContentFromWordFile(BufferedInputStream bufferedInputStream) throws Exception {
        String fileContent = "";
        if (FileMagic.valueOf(bufferedInputStream) == FileMagic.OLE2) {
            WordExtractor ex = new WordExtractor(bufferedInputStream);
            fileContent = ex.getText();
            ex.close();
        } else if(FileMagic.valueOf(bufferedInputStream) == FileMagic.OOXML) {
            XWPFDocument doc = new XWPFDocument(bufferedInputStream);
            XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
            fileContent = extractor.getText();
            extractor.close();
        }
        return fileContent;
    }
}

