# Aplicativo de Venda de Biscoitos 🍪

Este projeto implementa um aplicativo em Java para gerenciamento de vendas de biscoitos. O sistema permite criar, excluir e visualizar clientes, biscoitos e embalagens. Além disso, você pode registrar e gerenciar vendas, com opções de excluir ou visualizar as transações.

## 🎮 Funcionalidades
- **Clientes**: Criar, excluir e visualizar clientes.
- **Biscoitos**: Criar, excluir e visualizar biscoitos disponíveis para venda.
- **Embalagens**: Criar, excluir e visualizar embalagens de biscoitos.
- **Vendas**: Realizar vendas, visualizar vendas realizadas e excluir uma venda.

## 🛠️ Tecnologias Utilizadas
- **Linguagem:** Java
- **Bibliotecas:** `json-simple` para manipulação de arquivos JSON.

## 🚀 Como Executar o Projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/SeuUsuario/venda_biscoitos

2. Certifique-se de ter o JDK instalado. Para instalar o OpenJDK 21, siga os passos abaixo:

2. Certifique-se de ter o JDK instalado. Para instalar o OpenJDK 21 (ou superior) usando o Eclipse Temurin, siga os passos abaixo:
2.1. Certifique-se de que os pacotes necessários estão presentes:
   ```bash
    sudo apt install -y wget apt-transport-https gpg
   ```
2.2. Baixe e adicione a chave GPG do Eclipse Adoptium:
   ```bash
    wget -qO - https://packages.adoptium.net/artifactory/api/gpg/key/public | gpg --dearmor | sudo tee /etc/apt/trusted.gpg.d/adoptium.gpg > /dev/null
   ```
2.3. Configure o repositório apt do Eclipse Adoptium:
   ```bash
    echo "deb https://packages.adoptium.net/artifactory/deb $(awk -F= '/^VERSION_CODENAME/{print$2}' /etc/os-release) main" | sudo tee /etc/apt/sources.list.d/adoptium.list
   ```
Observação para usuários do Linux Mint: Substitua VERSION_CODENAME por UBUNTU_CODENAME na expressão acima.

2.4. Atualize a lista de pacotes:
   ```bash
    sudo apt update
   ```
2.5. Instale a versão desejada do Temurin JDK (exemplo com o Temurin 21):
   ```bash
    sudo apt install temurin-21-jdk
   ```
Nota: Para versões mais recentes do JDK, substitua temurin-21-jdk por temurin-17-jdk ou a versão que preferir.

4. Adicionando a biblioteca ao seu projeto no VSCode:
- Abra a pasta do seu projeto no VSCode.
- No painel lateral, encontre Java Projects e expanda.
- Em Referenced Libraries, clique com o botão direito e selecione Add External JARs.
- Selecione o arquivo json-simple-1.1.1.jar que você baixou no passo anterior para adicioná-lo ao seu projeto.

5. Execute o programa:
- Abra o arquivo Main.java no VSCode.
- No topo do arquivo, você verá um botão Run acima da classe public static void main(String[] args). Clique nesse botão para compilar e executar o programa.

📄 Estrutura do Arquivo JSON
O programa requer que o arquivo JSON tenha a seguinte estrutura básica:

   ```json
    {
        "auxiliar": []
    }
   ```
"auxiliar": O nome da chave pode variar dependendo da seção que você está manipulando. Por exemplo:

Para biscoitos, o arquivo será:

   ```json
    {
        "biscoito": []
    }
   ```
E para clientes, embalagens ou vendas, o formato será similar, alterando apenas a chave ("cliente","embalagem", "venda").

O conteúdo dentro do array [] vai variar conforme os dados registrados (cliente, biscoito, etc.).


## 📦 Dependências
Java Development Kit (JDK): Recomendado JDK 21 ou superior.
Biblioteca externa: json-simple para manipulação de JSON.

## 💡 Como Funciona
- **Leitura do Arquivo JSON:** O programa lê os dados de um arquivo JSON com a estrutura mencionada, permitindo a manipulação de clientes, biscoitos, embalagens e vendas.
- **Criação de Itens:** Permite adicionar novos clientes, biscoitos e embalagens ao sistema.
- **Exclusão de Itens:** Remove registros de clientes, biscoitos ou embalagens.
- **Venda de Biscoitos:** Registra uma venda associando um cliente, biscoito e embalagem.

## 🧑‍💻 Autor
Projeto desenvolvido por AdelsonJ.
