package sistema_de_cadastros;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    private int quantidadeDePerguntas = getQuantidadeDePerguntas();
    //Constructor
    public Menu(){
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        //Show and validate options
        while(option <= 0 || option > 5) {
            System.out.println("1 - Cadastrar usuário" +
                    "\n2 - Listar todos os usuários cadastrados" +
                    "\n3 - Cadastrar nova pergunta no formulário" +
                    "\n4 - Deletar pergunta no formulário" +
                    "\n5 - Pesquisar usuário por nome, idade ou email");
            option = scanner.nextInt();
            if(option <= 0 || option > 5){
                System.out.println("A opção selecionada não é válida, tente novamente");
            }
        }

        //Executar ação baseada na opção escolhida
        switch (option){
            case 1:
                cadastrarUsuario();
                break;
            case 2:
                //chama a função que lista todos os usuarios cadastrados
                break;
            case 3:
                adicionarPergunta();
                break;
            case 4:
                //chama a função que deleta uma pergunta do formulario
                apagarPergunta();
                break;
            case 5:
                //chama a função que pesquisa usuario por nome idade ou email
                break;
        }
    }
    private void cadastrarUsuario(){
        Scanner scanner = new Scanner(System.in);
        String nome  = "";
        String linha = "";
        int numeroPergunta = 1;
        try(FileReader fileReader = new FileReader("formulario.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader)){
            linha = bufferedReader.readLine();
            System.out.println("Cadastrando usuário...");
            System.out.println(linha + ": ");
            nome = scanner.nextLine();
            File file = new File("C:\\Users\\Mat\\Desktop\\git\\sistema_de_cadastros_remake\\src\\cadastros\\" + nome.toLowerCase().trim().replace(" ", "_") + ".txt");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(numeroPergunta + " - " + nome);
            bufferedWriter.newLine();
            numeroPergunta++;
            while(linha != null){
                linha = bufferedReader.readLine();
                if (linha != null) {
                    System.out.println(linha + ": ");
                    bufferedWriter.write(numeroPergunta + " - " + scanner.nextLine());
                    bufferedWriter.newLine();
                    numeroPergunta++;
                }
            }
            fileWriter.flush();
            bufferedWriter.flush();
            fileWriter.close();
            bufferedWriter.close();
            }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void printarPerguntas(){
        //mostrar perguntas na tela
        File file = new File("formulario.txt");
        try(FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String linha = "";
            while(linha !=  null){
                System.out.println(linha);
                linha = bufferedReader.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //adicionar perguntas
    private void adicionarPergunta(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pergunta: ");
        quantidadeDePerguntas ++;
        String pergunta = (quantidadeDePerguntas) +" - " + scanner.nextLine();
        try(FileWriter fileWriter = new FileWriter("formulario.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            bufferedWriter.newLine();
            bufferedWriter.write(pergunta);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private int getQuantidadeDePerguntas(){
        int quantidadeDePerguntas = 0;
        try(FileReader fileReader = new FileReader("formulario.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader)){
            while(bufferedReader.readLine() != null){
                quantidadeDePerguntas++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return quantidadeDePerguntas;
    }

    private void apagarPergunta(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("#################################################################");
        System.out.println("Digite o número da pergunta para apaga-la do formulário");
        printarPerguntas();
        System.out.println("Apagar pergunta de número: ");
        int perguntaDeletada = scanner.nextInt();
        if(perguntaDeletada <= 0 || perguntaDeletada > quantidadeDePerguntas){
            throw new RuntimeException("Valor inválido");
        }
        if(perguntaDeletada >= 1 && perguntaDeletada <= 4){
            throw new RuntimeException("As perguntas de 1 a 4 são fixas no formulário e nao podem ser deletadas");
        }
        else{

        }
    }
}



