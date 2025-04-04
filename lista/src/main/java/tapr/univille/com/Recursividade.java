package tapr.univille.com;

import java.io.File;

// faça um programa que peça um diretorio, imprima os nomes dos seus arquivos e os arquivos dos subdiretorios
// crie uma função recursiva

public class Recursividade {
  public static void main(String[] args) {
    String diretorio = "/Users/felipemourao/Desktop/Developer/TAPRJAVA/lista/src/main/java/tapr/univille/com";
    listarArquivos(diretorio);

    listarArquivosRecursivo(diretorio);
  }

  public static void listarArquivos(String diretorio) {
    File dir = new File(diretorio);
    if (dir.isDirectory()) {
      String[] arquivos = dir.list();
      if (arquivos != null) {
        for (String arquivo : arquivos) {
          System.out.println(arquivo);
        }
      }
    } else {
      System.out.println("O caminho fornecido não é um diretório.");
    }
  }

  public static void listarArquivosRecursivo(String diretorio) {
    File dir = new File(diretorio);
    if (dir.isDirectory()) {
      String[] arquivos = dir.list();
      if (arquivos != null) {
        for (String arquivo : arquivos) {
          File file = new File(diretorio + "/" + arquivo);
          System.out.println(file.getAbsolutePath());
          if (file.isDirectory()) {
            listarArquivosRecursivo(file.getAbsolutePath());
          }
        }
      }
    } else {
      System.out.println("O caminho fornecido não é um diretório.");
    }
  }
}
