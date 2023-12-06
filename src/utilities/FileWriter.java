package utilities;

import java.io.BufferedWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.*;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.nio.file.Files;

public class FileWriter {
    private String nameOwner;
    private String addressOwner;
    private String nameClient;
    private String addressClient;
    private String addressHouse;
    private double priceHouse;

    public FileWriter(String nameOwner, String addressOwner, String nameClient, String addressClient, double priceHouse) {
        this.nameOwner = nameOwner;
        this.addressOwner = addressOwner;
        this.nameClient = nameClient;
        this.addressClient = addressClient;
        this.priceHouse = priceHouse;
    }

    public static void sendContract(String nameOwner, String addressOwner, String nameClient, String addressClient, double priceHouse){
        try {
            String PATH = "src/contracts";
            String archivePATH = "src/contracts/contract.txt";

            Path caminhoDiretorio = Paths.get(PATH);

            // Verifica se o diretório existe
            if (!Files.exists(caminhoDiretorio)) {
                    // Cria o diretório se não existir
                    Files.createDirectories(caminhoDiretorio);
                }

            String text = createContract(nameOwner, addressOwner, nameClient, addressClient, priceHouse);

            File archive = new File(archivePATH);

            java.io.FileWriter fileWriter = new java.io.FileWriter(archive);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(text);
            bufferedWriter.close();
            fileWriter.close();

            System.out.println("\nContrato enviado com sucesso, você tem o perido de três dias para nos retornar esse contrato assinado, assine o quanto antes!");
        } catch (IOException e) {
            System.err.println("Erro ao criar o arquivo: " + e.getMessage());
        }
    }
    private static String createContract(String nameOwner, String addressOwner, String nameClient, String addressClient, double priceHouse){
        // Obtem a data e o tempo atual
        LocalDateTime actualDateTime = LocalDateTime.now();

        //Cria um formato para a data e declara
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = actualDateTime.format(formatterDate);

        String formattedEndDate = actualDateTime.plusMonths(6).format(formatterDate);

        // Formatando a data e hora com formatted
        String formattedText = """
                CONTRATO DE LOCAÇÃO RESIDENCIAL
                                
                Este Contrato de Locação ("Contrato") é celebrado em %s, entre:
                                
                LOCADOR:
                %s
                %s
                                
                LOCATÁRIO:
                %s
                %s
                                
                OBJETO DO CONTRATO:
                O Locador concorda em alugar ao Locatário e o Locatário concorda em alugar do Locador a propriedade localizada em %s, doravante denominada "Imóvel", pelo período de 6 meses a partir de %s até %s.
                                
                VALOR DO ALUGUEL E CONDIÇÕES DE PAGAMENTO:
                O valor mensal do aluguel é de %.2f. O pagamento do aluguel será efetuado até o dia 03 de cada mês. O pagamento deve ser feito por PIX no endereço do Locador ou em outro local especificado pelo Locador.
                                
                DEPÓSITO DE SEGURANÇA:
                O Locatário concorda em fornecer um depósito de segurança no valor de %.2f, equivalente ao dobro do valor do aluguel proposto, no momento da assinatura deste contrato. Este depósito será devolvido ao Locatário no dia após o término do contrato, deduzidos os custos de reparos de danos causados pelo Locatário.
                                
                UTILIDADES E TAXAS:
                O Locatário será responsável por todas as despesas de serviços públicos, incluindo, mas não se limitando a, água, luz, gás e internet.
                                
                MANUTENÇÃO E REPAROS:
                O Locatário concorda em manter o Imóvel em condições adequadas de higiene e conservação. Custos de reparos resultantes de danos causados pelo Locatário serão de responsabilidade do Locatário.
                                
                TERMO DE RESCISÃO:
                Ambas as partes concordam que este contrato pode ser rescindido mediante aviso prévio de 180 dias.
                                              
                LEI APLICÁVEL:
                Este contrato será regido e interpretado de acordo com as leis do Brasil.
                                
                LOCAL E DATA DE ASSINATURA:
                                
                Nome do Locador (assinatura)
                %s
                
                Nome do Locatário (assinatura)
                - Assinar aqui
                                
                Data
                %s
                """;

        return formattedText.formatted(formattedDate, nameOwner, addressOwner, nameClient, addressClient, addressOwner, formattedDate, formattedEndDate, priceHouse, priceHouse*2, nameOwner, formattedDate);
    }
}
