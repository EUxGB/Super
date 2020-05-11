package MyApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterJob;
import java.io.*;
import java.util.List;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPrintable;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class MyGUI extends JFrame {
    public String pathDir = "E:\\Kill";
    JButton button1 = new JButton("Выбрать папку");
    JButton button2 = new JButton("Преобразовать файлы в pdf");
    JButton button3 = new JButton("Cформировать опись");
//    Label input = new Label(pathDir);
//    JTextField input = new JTextField(pathDir, 10);

    public MyGUI() {

        super("PinTech");

        this.setBounds(100, 100, 600
                , 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));

        container.add(button1);
        container.add(button2);
        container.add(button3);

        ButtonGroup buttonGroup = new ButtonGroup();

        button3.addActionListener(new Button3Event());
        button1.addActionListener(new Button1Event());

    }

    public class Button1Event implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int response;
            File file;
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();




                if (file.isFile()) {
                    System.out.println("It is no file");

                } else{
                    pathDir = file.getAbsolutePath();
                    System.out.println(pathDir);

                }




            }
        }
    }

//    public class Button2Event implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            File path = new File(pathDir);
//            File[] files = path.listFiles();
//
//            PrinterJob printerJob = PrinterJob.getPrinterJob();
//
//
//            for (File file : files) {
//                PDFPrinter pdfPrinter = new PDFprinter;
//                System.out.println(file.getName());
//
//            }
//            //Instantiate a new workbook with excel file path
//
//
//            if (fileType.equals(".xls")) {
//                try {
//                    my_xls_workbook = new HSSFWorkbook(filecontent);
//                    my_worksheet = my_xls_workbook.getSheetAt(0);
//                    rowIterator = my_worksheet.iterator();
//                    maxColumn = my_worksheet.getRow(0).getLastCellNum();
//                } catch (IOException ex) {
//                    Logger.getLogger(PdfConversion.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//
//
//
//
//            Workbook workbook = new Workbook();
//            // Open an excel file
//            InputStream fileStream = this.getResourceStream("xlsx/Employee absence schedule.xlsx");
//            workbook.open(fileStream);
//
//            //save to an pdf file
//            workbook.save("ConvertExcelToPDF.pdf");
//        }
//    }
    public class Button3Event implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            //Получаем список файлов мз директории
            File path = new File(pathDir);
            File[] files = path.listFiles();

            //Создаем Эксель файл
            HSSFWorkbook myExcel = new HSSFWorkbook();
            //Создаем в файле лист
            HSSFSheet sheet = myExcel.createSheet();


            int rowNum = 0; //счетчик для строк
            Row row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue("Опись");
            row = sheet.createRow(++rowNum);
            row.createCell(0).setCellValue("№ п/п");
            row.createCell(1).setCellValue("Наименование документа");
            row.createCell(2).setCellValue("Кол-во страниц");

            //Зполняем файл";
            String nameFileOfDir = "";
            int i = 1;
            int pages = 0;

            PDDocument document;

            for (File s : files) {
               // pages = 111111;
                try {
                    document = PDDocument.load(s);
                    assert document != null;
                    pages = document.getNumberOfPages();
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //удяляем расширение файла в наименовании файла
                nameFileOfDir = s.getName();
                int p=s.getName().lastIndexOf('.');
                if (p>0) {
                    nameFileOfDir=nameFileOfDir.substring(0,p);
                }
                if (nameFileOfDir.equals("opis")) continue;
                row = sheet.createRow(++rowNum);
                row.createCell(0).setCellValue(i++);
                row.createCell(1).setCellValue(nameFileOfDir);
                row.createCell(2).setCellValue(pages);

               //Записываем в файл

            }
            try (FileOutputStream fileOutputStream = new FileOutputStream(new File(pathDir+"\\opis.xls"))) {
                myExcel.write(fileOutputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Файл записан успешно");
        }
    }



}
