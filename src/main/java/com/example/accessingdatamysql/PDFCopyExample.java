package com.example.accessingdatamysql;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

public class PDFCopyExample {

    public static void main(String[] args) {
        String sourcePdfFilePath = "source.pdf"; // Replace with the path to your source PDF file
        String destinationPdfFilePath = "destination.pdf"; // Replace with the path for the destination PDF file

        try {
            // Load the source PDF document
            PDDocument sourceDocument = PDDocument.load(new File(sourcePdfFilePath));

            // Create a new PDF document for the destination
            PDDocument destinationDocument = new PDDocument();

            // Copy each page from the source to the destination
            for (int pageIndex = 0; pageIndex < sourceDocument.getNumberOfPages(); pageIndex++) {
                destinationDocument.addPage(sourceDocument.getPage(pageIndex));
            }

            // Save the destination PDF document to a file
            destinationDocument.save(destinationPdfFilePath);

            // Close the documents
            sourceDocument.close();
            destinationDocument.close();

            System.out.println("PDF copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
