package br.com.sambamaniacos.model;

import br.com.sambamaniacos.bean.Pessoas;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerarPDF {
      
    private Phrase p3 = new Phrase("\nParabéns, você tem em mãos a Carteirinha Oficial Sambamaníacos.\n"
            + "                Com ela, receba descontos especiais na compra.\n"
            + "             dos produtos Sambamaníacos, e em nossos eventos\n"
            , new Font(Font.FontFamily.UNDEFINED,7.2f));
            
    private Font f = new Font(Font.getFamily("SansSerif"), 8, Font.BOLD);
    private Paragraph p4 = new Paragraph("\nwww.sambamaniacos.com             /sambamaniacos.oficial\n"
            + "                                    @sambamaniacos", f);
    //private Paragraph p5 = new Paragraph("/sambamaniacos.oficial", f);
    //private Paragraph p6 = new Paragraph("@sambamaniacos", f);
    
    public GerarPDF(Pessoas modelo) {
        
        Document doc = new Document();
        
        try{
            
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("documento2.pdf"));
            
            doc.open();
            
            Document document = new Document();

            doc.open();
            
            
            //1 Pessoa
            
            float llx = 32;
            float lly = 680-10;
            float urx = 275+10;
            float ury = 834;
            PdfContentByte canvas = writer.getDirectContent();
            ColumnText ct = new ColumnText(canvas);
            
            Rectangle rect1 = new Rectangle(llx, lly, urx, ury);
            rect1.setBorder(Rectangle.BOX);
            rect1.setBorderWidth(1);
            canvas.rectangle(rect1);
            
            Paragraph pessoa1 = new Paragraph("Nome: " + modelo.getNome(), new Font(Font.getFamily("TIMES_ROMAN"), 8, Font.BOLD));
            
            ct.setSimpleColumn(48f, 100f, 700f, 830f);
            ct.addElement(pessoa1);
            ct.addElement(p3);
            ct.addElement(p4);
            //ct.addElement(p5);
            //ct.addElement(p6);
            ct.go();
            
            BarcodeEAN codEAN = new BarcodeEAN();
            codEAN.setCodeType(Barcode.UPCA);
            codEAN.setCode(modelo.getCodigo());
            Image imageEAN = codEAN.createImageWithBarcode(canvas, null, null);
            Paragraph pcode = new Paragraph(new Chunk(imageEAN, 75+10, -105-5));

            doc.add(pcode);
            
            //Frente
            
            llx = 32;
            lly = 680-10;
            urx = 275+10;
            ury = lly-154-10; //28
            
            Rectangle rect2 = new Rectangle(llx, lly, urx, ury);
            rect2.setBorder(Rectangle.BOX);
            rect2.setBorderWidth(1);
            canvas.rectangle(rect2);
            
            try {

                Image img = Image.getInstance("C:\\Users\\User\\Documents\\NetBeansProjects\\Sambamaniacos\\src\\br\\com\\sambamaniacos\\imagem\\sem tarja.jpg");
                
                img.setAbsolutePosition(32, 670-154-10);
                
                doc.add(img);
                
                //verso
                
                Image img5 = Image.getInstance("C:\\Users\\User\\Documents\\NetBeansProjects\\Sambamaniacos\\src\\br\\com\\sambamaniacos\\imagem\\verso.jpg");
                
                img5.setAbsolutePosition(32, 670);
                
                doc.add(img5);
                
                doc.newPage();
                
            }
            
            catch(IOException ex) {
                ex.printStackTrace();
            }

        }
        catch(DocumentException | FileNotFoundException ex) {
            ex.printStackTrace();
        }
        finally {
            doc.close();
        }
        try {
            Desktop.getDesktop().open(new File("documento2.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(GerarPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public GerarPDF (Pessoas modelo, Pessoas modelo2) {
        
        Document doc = new Document();
        
        try{
            
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("documento2.pdf"));
            
            doc.open();
            
            Document document = new Document();

            doc.open();
            
            
            //1 Pessoa
            
            float llx = 32;
            float lly = 680-10;
            float urx = 275+10;
            float ury = 834;
            PdfContentByte canvas = writer.getDirectContent();
            ColumnText ct = new ColumnText(canvas);
            
            Rectangle rect1 = new Rectangle(llx, lly, urx, ury);
            rect1.setBorder(Rectangle.BOX);
            rect1.setBorderWidth(1);
            canvas.rectangle(rect1);
            
            Paragraph pessoa1 = new Paragraph("Nome: " + modelo.getNome(), new Font(Font.getFamily("TIMES_ROMAN"), 8, Font.BOLD));
            
            ct.setSimpleColumn(48f, 100f, 700f, 830f);
            ct.addElement(pessoa1);
            ct.addElement(p3);
            ct.addElement(p4);
            //ct.addElement(p5);
            //ct.addElement(p6);
            ct.go();
            
            BarcodeEAN codEAN = new BarcodeEAN();
            codEAN.setCodeType(Barcode.UPCA);
            codEAN.setCode(modelo.getCodigo());
            Image imageEAN = codEAN.createImageWithBarcode(canvas, null, null);
            Paragraph pcode = new Paragraph(new Chunk(imageEAN, 75+10, -105-5));

            doc.add(pcode);
            
            //Frente
            
            llx = 32;
            lly = 680-10;
            urx = 275+10;
            ury = lly-154-10; //28
            
            Rectangle rect2 = new Rectangle(llx, lly, urx, ury);
            rect2.setBorder(Rectangle.BOX);
            rect2.setBorderWidth(1);
            canvas.rectangle(rect2);
            
            //Pessoa 2
            
            llx = 538+20;
            lly = 834;
            urx = 295+10;
            ury = lly-164;
            
            Rectangle rect3 = new Rectangle(llx, lly, urx, ury);
            rect3.setBorder(Rectangle.BOX);
            rect3.setBorderWidth(1);
            canvas.rectangle(rect3);
            
            Paragraph pessoa2 = new Paragraph("Nome: " + modelo2.getNome(), new Font(Font.getFamily("TIMES_ROMAN"), 8, Font.BOLD));
            
            ct.setSimpleColumn(320.5f, 100f, 700f, 830f);
            ct.addElement(pessoa2);
            ct.addElement(p3);
            ct.addElement(p4);
            //ct.addElement(p5);
            //ct.addElement(p6);
            
            ct.go();
            
            BarcodeEAN codEAN2 = new BarcodeEAN();
            codEAN2.setCodeType(Barcode.UPCA);
            codEAN2.setCode(modelo2.getCodigo());
            Image imageEAN2 = codEAN2.createImageWithBarcode(canvas, null, null);
            Paragraph pcode2 = new Paragraph(new Chunk(imageEAN2, 337+10+11, -87-5));

            doc.add(pcode2);
            
            //Frente Pessoa 2
            
            llx = 538+20;
            lly = 680-10; //ury anterior
            urx = 295+10;
            ury = lly-154-10;
            
            Rectangle rect4 = new Rectangle(llx, lly, urx, ury);
            rect4.setBorder(Rectangle.BOX);
            rect4.setBorderWidth(1);
            canvas.rectangle(rect4);
            
            try {

                Image img = Image.getInstance("C:\\Users\\User\\Documents\\NetBeansProjects\\Sambamaniacos\\src\\br\\com\\sambamaniacos\\imagem\\sem tarja.jpg");
                Image img2 = Image.getInstance("C:\\Users\\User\\Documents\\NetBeansProjects\\Sambamaniacos\\src\\br\\com\\sambamaniacos\\imagem\\sem tarja.jpg");
                
                img.setAbsolutePosition(32, 670-154-10);
                img2.setAbsolutePosition(305, 670-154-10);
                
                doc.add(img);
                doc.add(img2);
                
                //verso
                
                Image img5 = Image.getInstance("C:\\Users\\User\\Documents\\NetBeansProjects\\Sambamaniacos\\src\\br\\com\\sambamaniacos\\imagem\\verso.jpg");
                Image img6 = Image.getInstance("C:\\Users\\User\\Documents\\NetBeansProjects\\Sambamaniacos\\src\\br\\com\\sambamaniacos\\imagem\\verso.jpg");
                
                img5.setAbsolutePosition(32, 670);
                img6.setAbsolutePosition(305, 670);
                
                doc.add(img5);
                doc.add(img6);
                
                doc.newPage();
                
                
            }
            catch(IOException ex) {
                ex.printStackTrace();
            }

        }
        catch(DocumentException | FileNotFoundException ex) {
            ex.printStackTrace();
        }
        finally {
            doc.close();
        }
        try {
            Desktop.getDesktop().open(new File("documento2.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(GerarPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public GerarPDF (Pessoas modelo, Pessoas modelo2, Pessoas modelo3) {
        
        Document doc = new Document();
        
        try{
            
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("documento2.pdf"));
            
            doc.open();
            
            Document document = new Document();

            doc.open();
            
            
            //1 Pessoa
            
            float llx = 32;
            float lly = 680-10;
            float urx = 275+10;
            float ury = 834;
            PdfContentByte canvas = writer.getDirectContent();
            ColumnText ct = new ColumnText(canvas);
            
            Rectangle rect1 = new Rectangle(llx, lly, urx, ury);
            rect1.setBorder(Rectangle.BOX);
            rect1.setBorderWidth(1);
            canvas.rectangle(rect1);
            
            Paragraph pessoa1 = new Paragraph("Nome: " + modelo.getNome(), new Font(Font.getFamily("TIMES_ROMAN"), 8, Font.BOLD));
            
            ct.setSimpleColumn(48f, 100f, 700f, 830f);
            ct.addElement(pessoa1);
            ct.addElement(p3);
            ct.addElement(p4);
            //ct.addElement(p5);
            //ct.addElement(p6);
            ct.go();
            
            BarcodeEAN codEAN = new BarcodeEAN();
            codEAN.setCodeType(Barcode.UPCA);
            codEAN.setCode(modelo.getCodigo());
            Image imageEAN = codEAN.createImageWithBarcode(canvas, null, null);
            Paragraph pcode = new Paragraph(new Chunk(imageEAN, 75+10, -105-5));

            doc.add(pcode);
            
            //Frente
            
            llx = 32;
            lly = 680-10;
            urx = 275+10;
            ury = lly-154-10; //28
            
            Rectangle rect2 = new Rectangle(llx, lly, urx, ury);
            rect2.setBorder(Rectangle.BOX);
            rect2.setBorderWidth(1);
            canvas.rectangle(rect2);
            
            //Pessoa 2
            
            llx = 538+20;
            lly = 834;
            urx = 295+10;
            ury = lly-164;
            
            Rectangle rect3 = new Rectangle(llx, lly, urx, ury);
            rect3.setBorder(Rectangle.BOX);
            rect3.setBorderWidth(1);
            canvas.rectangle(rect3);
            
            Paragraph pessoa2 = new Paragraph("Nome: " + modelo2.getNome(), new Font(Font.getFamily("TIMES_ROMAN"), 8, Font.BOLD));
            
            ct.setSimpleColumn(320.5f, 100f, 700f, 830f);
            ct.addElement(pessoa2);
            ct.addElement(p3);
            ct.addElement(p4);
            //ct.addElement(p5);
            //ct.addElement(p6);
            
            ct.go();
            
            BarcodeEAN codEAN2 = new BarcodeEAN();
            codEAN2.setCodeType(Barcode.UPCA);
            codEAN2.setCode(modelo2.getCodigo());
            Image imageEAN2 = codEAN2.createImageWithBarcode(canvas, null, null);
            Paragraph pcode2 = new Paragraph(new Chunk(imageEAN2, 337+10+11, -87-5));

            doc.add(pcode2);
            
            //Frente Pessoa 2
            
            llx = 538+20;
            lly = 680-10; //ury anterior
            urx = 295+10;
            ury = lly-154-10;
            
            Rectangle rect4 = new Rectangle(llx, lly, urx, ury);
            rect4.setBorder(Rectangle.BOX);
            rect4.setBorderWidth(1);
            canvas.rectangle(rect4);
            
            //Pessoa 3
            
            llx = 32;
            lly = 508-30; //-30 de espaço entre 1 e outro
            urx = 275+10;
            ury = lly-154-10;
            
            Rectangle rect5 = new Rectangle(llx, lly, urx, ury);
            rect5.setBorder(Rectangle.BOX);
            rect5.setBorderWidth(1);
            canvas.rectangle(rect5);
            
            Paragraph pessoa3 = new Paragraph("Nome: " + modelo3.getNome(), new Font(Font.getFamily("TIMES_ROMAN"), 8, Font.BOLD));
            
            ct.setSimpleColumn(48f, 100f, 700f, 503-30f);
            ct.addElement(pessoa3);
            ct.addElement(p3);
            ct.addElement(p4);
            //ct.addElement(p5);
            //ct.addElement(p6);
            ct.go();
            
            BarcodeEAN codEAN3 = new BarcodeEAN();
            codEAN3.setCodeType(Barcode.UPCA);
            codEAN3.setCode(modelo3.getCodigo());
            Image imageEAN3 = codEAN3.createImageWithBarcode(canvas, null, null);
            Paragraph pcode3 = new Paragraph(new Chunk(imageEAN3, 75+10, -396-35));

            doc.add(pcode3);
            
            //frente pessoa3
            
            llx = 32;
            lly = ury; //ury anterior
            urx = 275+10;
            ury = lly-154-10;
            
            Rectangle rect6 = new Rectangle(llx, lly, urx, ury);
            rect6.setBorder(Rectangle.BOX);
            rect6.setBorderWidth(1);
            canvas.rectangle(rect6);
            
            try {

                Image img = Image.getInstance("C:\\Users\\User\\Documents\\NetBeansProjects\\Sambamaniacos\\src\\br\\com\\sambamaniacos\\imagem\\sem tarja.jpg");
                Image img2 = Image.getInstance("C:\\Users\\User\\Documents\\NetBeansProjects\\Sambamaniacos\\src\\br\\com\\sambamaniacos\\imagem\\sem tarja.jpg");
                Image img3 = Image.getInstance("C:\\Users\\User\\Documents\\NetBeansProjects\\Sambamaniacos\\src\\br\\com\\sambamaniacos\\imagem\\sem tarja.jpg");
                
                img.setAbsolutePosition(32, 670-154-10);
                img2.setAbsolutePosition(305, 670-154-10);
                img3.setAbsolutePosition(32, 150);
                
                doc.add(img);
                doc.add(img2);
                doc.add(img3);
                
                //verso
                
                Image img5 = Image.getInstance("C:\\Users\\User\\Documents\\NetBeansProjects\\Sambamaniacos\\src\\br\\com\\sambamaniacos\\imagem\\verso.jpg");
                Image img6 = Image.getInstance("C:\\Users\\User\\Documents\\NetBeansProjects\\Sambamaniacos\\src\\br\\com\\sambamaniacos\\imagem\\verso.jpg");
                Image img7 = Image.getInstance("C:\\Users\\User\\Documents\\NetBeansProjects\\Sambamaniacos\\src\\br\\com\\sambamaniacos\\imagem\\verso.jpg");
                
                img5.setAbsolutePosition(32, 670);
                img6.setAbsolutePosition(305, 670);
                img7.setAbsolutePosition(32, 285+30);
                
                doc.add(img5);
                doc.add(img6);
                doc.add(img7);
                
                doc.newPage();
                
                
            }
            catch(IOException ex) {
                ex.printStackTrace();
            }
            

        }
        catch(DocumentException | FileNotFoundException ex) {
            ex.printStackTrace();
        }
        finally {
            doc.close();
        }
        try {
            Desktop.getDesktop().open(new File("documento2.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(GerarPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public GerarPDF (Pessoas modelo, Pessoas modelo2, Pessoas modelo3, Pessoas modelo4) {
        
        Document doc = new Document();
        
        try{
            
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("documento2.pdf"));
            
            doc.open();
            
            Document document = new Document();

            doc.open();
            
            
            //1 Pessoa
            
            float llx = 32;
            float lly = 680-10;
            float urx = 275+10;
            float ury = 834;
            PdfContentByte canvas = writer.getDirectContent();
            ColumnText ct = new ColumnText(canvas);
            
            Rectangle rect1 = new Rectangle(llx, lly, urx, ury);
            rect1.setBorder(Rectangle.BOX);
            rect1.setBorderWidth(1);
            canvas.rectangle(rect1);
            
            Paragraph pessoa1 = new Paragraph("Nome: " + modelo.getNome(), new Font(Font.getFamily("TIMES_ROMAN"), 8, Font.BOLD));
            
            ct.setSimpleColumn(48f, 100f, 700f, 830f);
            ct.addElement(pessoa1);
            ct.addElement(p3);
            ct.addElement(p4);
            //ct.addElement(p5);
            //ct.addElement(p6);
            ct.go();
            
            BarcodeEAN codEAN = new BarcodeEAN();
            codEAN.setCodeType(Barcode.UPCA);
            codEAN.setCode(modelo.getCodigo());
            Image imageEAN = codEAN.createImageWithBarcode(canvas, null, null);
            Paragraph pcode = new Paragraph(new Chunk(imageEAN, 75+10, -105-5));

            doc.add(pcode);
            
            //Frente
            
            llx = 32;
            lly = 680-10;
            urx = 275+10;
            ury = lly-154-10; //28
            
            Rectangle rect2 = new Rectangle(llx, lly, urx, ury);
            rect2.setBorder(Rectangle.BOX);
            rect2.setBorderWidth(1);
            canvas.rectangle(rect2);
            
            //Pessoa 2
            
            llx = 538+20;
            lly = 834;
            urx = 295+10;
            ury = lly-164;
            
            Rectangle rect3 = new Rectangle(llx, lly, urx, ury);
            rect3.setBorder(Rectangle.BOX);
            rect3.setBorderWidth(1);
            canvas.rectangle(rect3);
            
            Paragraph pessoa2 = new Paragraph("Nome: " + modelo2.getNome(), new Font(Font.getFamily("TIMES_ROMAN"), 8, Font.BOLD));
            
            ct.setSimpleColumn(320.5f, 100f, 700f, 830f);
            ct.addElement(pessoa2);
            ct.addElement(p3);
            ct.addElement(p4);
            //ct.addElement(p5);
            //ct.addElement(p6);
            
            ct.go();
            
            BarcodeEAN codEAN2 = new BarcodeEAN();
            codEAN2.setCodeType(Barcode.UPCA);
            codEAN2.setCode(modelo2.getCodigo());
            Image imageEAN2 = codEAN2.createImageWithBarcode(canvas, null, null);
            Paragraph pcode2 = new Paragraph(new Chunk(imageEAN2, 337+10+11, -87-5));

            doc.add(pcode2);
            
            //Frente Pessoa 2
            
            llx = 538+20;
            lly = 680-10; //ury anterior
            urx = 295+10;
            ury = lly-154-10;
            
            Rectangle rect4 = new Rectangle(llx, lly, urx, ury);
            rect4.setBorder(Rectangle.BOX);
            rect4.setBorderWidth(1);
            canvas.rectangle(rect4);
            
            //Pessoa 3
            
            llx = 32;
            lly = 508-30; //-30 de espaço entre 1 e outro
            urx = 275+10;
            ury = lly-154-10;
            
            Rectangle rect5 = new Rectangle(llx, lly, urx, ury);
            rect5.setBorder(Rectangle.BOX);
            rect5.setBorderWidth(1);
            canvas.rectangle(rect5);
            
            Paragraph pessoa3 = new Paragraph("Nome: " + modelo3.getNome(), new Font(Font.getFamily("TIMES_ROMAN"), 8, Font.BOLD));
            
            ct.setSimpleColumn(48f, 100f, 700f, 503-30f);
            ct.addElement(pessoa3);
            ct.addElement(p3);
            ct.addElement(p4);
            //ct.addElement(p5);
            //ct.addElement(p6);
            ct.go();
            
            BarcodeEAN codEAN3 = new BarcodeEAN();
            codEAN3.setCodeType(Barcode.UPCA);
            codEAN3.setCode(modelo3.getCodigo());
            Image imageEAN3 = codEAN3.createImageWithBarcode(canvas, null, null);
            Paragraph pcode3 = new Paragraph(new Chunk(imageEAN3, 75+10, -396-35));

            doc.add(pcode3);
            
            //frente pessoa3
            
            llx = 32;
            lly = ury; //ury anterior
            urx = 275+10;
            ury = lly-154-10;
            
            Rectangle rect6 = new Rectangle(llx, lly, urx, ury);
            rect6.setBorder(Rectangle.BOX);
            rect6.setBorderWidth(1);
            canvas.rectangle(rect6);
            
            //Pessoa 4
            
            llx = 538+20;
            lly = 508-30;
            urx = 295+10;
            ury = lly-154-10;
            
            Rectangle rect7 = new Rectangle(llx, lly, urx, ury);
            rect7.setBorder(Rectangle.BOX);
            rect7.setBorderWidth(1);
            canvas.rectangle(rect7);
            
            Paragraph pessoa4 = new Paragraph("Nome: " + modelo4.getNome(), new Font(Font.getFamily("TIMES_ROMAN"), 8, Font.BOLD));
            
            ct.setSimpleColumn(320.5f, 100f, 700f, 503-30f);
            ct.addElement(pessoa4);
            ct.addElement(p3);
            ct.addElement(p4);
            //ct.addElement(p5);
            //ct.addElement(p6);
            
            ct.go();
            
            BarcodeEAN codEAN4 = new BarcodeEAN();
            codEAN4.setCodeType(Barcode.UPCA);
            codEAN4.setCode(modelo4.getCodigo());
            Image imageEAN4 = codEAN4.createImageWithBarcode(canvas, null, null);
            Paragraph pcode4 = new Paragraph(new Chunk(imageEAN4, 337+10+11, -377-35));

            doc.add(pcode4);
            
            //Frente Pessoa 4
            
            llx = 538+20;
            lly = ury; //ury anterior
            urx = 295+10;
            ury = lly-154-10;
            
            Rectangle rect8 = new Rectangle(llx, lly, urx, ury);
            rect8.setBorder(Rectangle.BOX);
            rect8.setBorderWidth(1);
            canvas.rectangle(rect8);
            
            try {

                Image img = Image.getInstance("C:\\Users\\User\\Documents\\NetBeansProjects\\Sambamaniacos\\src\\br\\com\\sambamaniacos\\imagem\\sem tarja.jpg");
                Image img2 = Image.getInstance("C:\\Users\\User\\Documents\\NetBeansProjects\\Sambamaniacos\\src\\br\\com\\sambamaniacos\\imagem\\sem tarja.jpg");
                Image img3 = Image.getInstance("C:\\Users\\User\\Documents\\NetBeansProjects\\Sambamaniacos\\src\\br\\com\\sambamaniacos\\imagem\\sem tarja.jpg");
                Image img4 = Image.getInstance("C:\\Users\\User\\Documents\\NetBeansProjects\\Sambamaniacos\\src\\br\\com\\sambamaniacos\\imagem\\sem tarja.jpg");
                
                img.setAbsolutePosition(32, 670-154-10);
                img2.setAbsolutePosition(305, 670-154-10);
                img3.setAbsolutePosition(32, 150);
                img4.setAbsolutePosition(305, ury);
                
                doc.add(img);
                doc.add(img2);
                doc.add(img3);
                doc.add(img4);
                
                //verso
                
                Image img5 = Image.getInstance("C:\\Users\\User\\Documents\\NetBeansProjects\\Sambamaniacos\\src\\br\\com\\sambamaniacos\\imagem\\verso.jpg");
                Image img6 = Image.getInstance("C:\\Users\\User\\Documents\\NetBeansProjects\\Sambamaniacos\\src\\br\\com\\sambamaniacos\\imagem\\verso.jpg");
                Image img7 = Image.getInstance("C:\\Users\\User\\Documents\\NetBeansProjects\\Sambamaniacos\\src\\br\\com\\sambamaniacos\\imagem\\verso.jpg");
                Image img8 = Image.getInstance("C:\\Users\\User\\Documents\\NetBeansProjects\\Sambamaniacos\\src\\br\\com\\sambamaniacos\\imagem\\verso.jpg");
                
                img5.setAbsolutePosition(32, 670);
                img6.setAbsolutePosition(305, 670);
                img7.setAbsolutePosition(32, 285+30);
                img8.setAbsolutePosition(305, 315);
                
                doc.add(img5);
                doc.add(img6);
                doc.add(img7);
                doc.add(img8);
                
            }
            catch(IOException ex) {
                ex.printStackTrace();
            }
            

        }
        catch(DocumentException | FileNotFoundException ex) {
            ex.printStackTrace();
        }
        finally {
            doc.close();
        }
        try {
            Desktop.getDesktop().open(new File("documento2.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(GerarPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
}
