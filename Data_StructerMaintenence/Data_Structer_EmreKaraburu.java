
package Data_StructerMaintenence;

import java.io.*;

//Emre Karaburu

public class Data_Structer_EmreKaraburu {

    public static void main(String[] args) throws IOException {
        FileProcessor file = new FileProcessor();
        // Create query and input files
        file.createQueryFile();
        file.createInputFile(); 
        
        DoublyLinkedList countries = new DoublyLinkedList(); 
        // Store country data from input file
        file.storeInput(countries);
        // Read and apply queries from the query
        file.readQuery(countries); 
        
        
        System.out.println("● " + "Query print_all");
        countries.printAllCountries();
    }
}