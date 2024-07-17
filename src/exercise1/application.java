package exercise1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) throws ParseException{
		List<Product> products = new ArrayList<>();
		String path = "C:\\workspaces\\ws-java\\archiveExercise\\.csv";
		String dirPath = "C:\\workspaces\\ws-java\\archiveExercise\\out";
		String dirFilePath = dirPath + "\\summary.csv";
		File filePath = new File(path);

		// Creating Directory
		File summary = new File(dirPath);
		if (summary.mkdir())
			System.out.println(summary + " Directory created succesfully!");
		else
			System.out.println(summary + "Error creating the directory!");

		// Reading the CSV file
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line = br.readLine();
			while (line != null) {
				String[] productsData = line.split(",");
				Product product = new Product(productsData[0],Double.parseDouble(productsData[1]),Integer.parseInt(productsData[2]));
				products.add(product);
				line = br.readLine();
			}

			// Writing to the summary CSV file
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(dirFilePath, true))) {
				for (Product product : products) {
					bw.write(product.toString());
					bw.newLine();
				}
				System.out.println(dirFilePath + " CREATED");
			} catch (IOException e) {
				System.out.println("Error writing to file: " + e.getMessage());
			}

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

	}

}
