package exercise1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "C:\\workspaces\\ws-java\\archiveExercise\\.csv";
		List<Product> products = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] productData = line.split(",");
				Product product = new Product(productData[0], Double.parseDouble(productData[1]),Integer.parseInt(productData[2]));
				products.add(product);
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		String outDirPath = "C:\\workspaces\\ws-java\\archiveExercise\\out";
		File outFile = new File(outDirPath);
		outFile.mkdir();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outDirPath + "\\summary.csv", true))) {
			for (Product product : products) {
				bw.write(product.toString());
				bw.newLine();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
