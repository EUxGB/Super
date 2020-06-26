import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import java.awt.print.PrinterJob;
import java.io.File;

public class PrinterDefault {

    public static void main(String[] args) throws Exception {

        String filename = "C:\\Users\\zaokz\\Downloads\\1.pdf";
        PDDocument document = PDDocument.load(new File(filename));

        //takes standard printer defined by OS
        PrintService myPrintService = PrintServiceLookup.lookupDefaultPrintService();

        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPageable(new PDFPageable(document));
        job.setPrintService(myPrintService);
        job.print();

    }

    private static PrintService findPrintService(String printerName) {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        for (PrintService printService : printServices) {
            if (printService.getName().trim().equals(printerName)) {
                return printService;
            }
        }
        return null;
    }

}