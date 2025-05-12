import collections
import hashlib

# construir o mapa de codificação baseado na frequência dos caracteres
def construir_codificacao(texto):
    # Conta quantas vezes cada caractere aparece
    frequencia = collections.Counter(texto)

    # Ordena os caracteres do mais frequente para o menos frequente
    caracteres_ordenados = [char for char, _ in frequencia.most_common()]

    # Atribui códigos binários fixos de 5 bits (por limitação simples)
    codificacao = {char: format(i, "05b") for i, char in enumerate(caracteres_ordenados)}

    return codificacao

# Codifica o texto usando o dicionário gerado
def compactar(texto, codificacao):
    return ''.join(codificacao[c] for c in texto)

# Transforma a string de bits em bytes, com padding (preenchimento extra para fechar o último byte)
def bits_para_bytes(bits):
    padding = 8 - (len(bits) % 8)
    bits += "0" * padding  # adiciona zeros ao final para fechar múltiplos de 8 bits
    return bytes([padding]) + int(bits, 2).to_bytes(len(bits) // 8, byteorder="big")

# Salva o arquivo compactado em binário junto com o cabeçalho (tabela de caracteres)
def salvar_arquivo_binario(nome_arquivo, binario, mapa_codificacao):
    with open(nome_arquivo, "wb") as f:
        # O cabeçalho armazena os caracteres na ordem da codificação, separados por |
        f.write(('|'.join(mapa_codificacao.keys()) + '\n').encode("utf-8"))
        # Depois escreve os dados compactados em binário
        f.write(binario)

def main():
    # Abre o arquivo de texto original
    with open("arquivo1.txt", "r", encoding="utf-8") as f:
        texto = f.read()

    # Gera a codificação baseada na frequência dos caracteres
    codificacao = construir_codificacao(texto)

    # Compacta o texto com os códigos
    bits = compactar(texto, codificacao)

    # Converte para binário
    binario = bits_para_bytes(bits)

    salvar_arquivo_binario("arquivo1.txt.squeezed", binario, codificacao)

    # Exibe o hash MD5 do texto original para comparação futura
    print("MD5 original:", hashlib.md5(texto.encode()).hexdigest())
    print("Tamanho original (caracteres):", len(texto))
    print("Bits após compressão:", len(bits))

if __name__ == "__main__":
    main()
