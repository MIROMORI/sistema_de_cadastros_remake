package sistema_de_cadastros;

import java.io.*;
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
                //chama a função que cadastra usuarios
                cadastrarUsuario();
                break;
            case 2:
                //chama a função que lista todos os usuarios cadastrados
                break;
            case 3:
                //chama a função que cadastra uma nova pergunta no formulario
                adicionarPergunta();
                break;
            case 4:
                //chama a função que deleta uma pergunta do formulario
                break;
            case 5:
                //chama a função que pesquisa usuario por nome idade ou email
                break;
        }
    }
    private void cadastrarUsuario() {
        String path = "C:\\Users\\Mat\\Desktop\\MeusProjetos\\projetos-java\\sistema_de_cadastros_remake\\formulario.txt";
        File file = new File(path);
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

    private void printarPerguntas(){
        String path = "C:\\Users\\Mat\\Desktop\\MeusProjetos\\projetos-java\\sistema_de_cadastros_remake\\formulario.txt";
        //mostrar perguntas na tela
        File file = new File(path);
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
}



