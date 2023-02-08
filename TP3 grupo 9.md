# Características de bons projetos. 

###### Trabalho 3: Técnicas de programação para plataformas emergentes.

| Aluno | Matrícula |
| -- | -- |
|  Ariel Vieira Lima Serafim     | 17/0006328 |
| Felipe Boccardi Silva Agustini | 18/0119818 |
| Igor Queiroz Lima              | 18/0122258 |
| Lucas Gomes Lopes              | 17/0080102 |
| Lucas Gabriel Bezerra          | 18/0125770 |
| Pedro Henrique Carvalho Campos | 19/0036435 |

### Modularidade:
A modularidade define o nível com que um software pode ser dividido em módulos menores, que são responsáveis por uma tarefa específica. Podemos dividir em modularidade em dois aspectos, alta coesão e baixo acoplamento. Quando dois módulos ou objetos possuem baixo acoplamento, eles podem interagir, mas tem pouca informação sobre o funcionamento um do outro, isto é, a dependência entre eles ocorre no nível de interface, então modificações na implementação interna dos módulos não afetam módulos externos. Alta coesão se refere à medida que um módulo é capaz de seguir o princípio S.O.L.I.D de Responsabilidade única (single responsability), que pode ser definido como: *“uma classe só deve ter um motivo para mudar”.*

#### Maus cheiros associados.
- Método longo: Um método muito longo pode indicar uma quebra da característica de modularidade, pois é comum que um método muito grande esteja realizando mais de uma tarefa, o que quebra o princípio de responsabilidade única.
- Código duplicado: Código duplicado pode ser um indicativo de uma tarefa que deveria estar modularizada em uma classe ou método, mas não está, então várias classes ou métodos têm que implementar a mesma tarefa várias vezes.
- Classe grande: Uma classe muito grande pode indicar, assim como o método longo, a quebra do princípio de responsabilidade única, e consequentemente a quebra da característica de modularidade.
- Biblioteca de classes incompleta:  Assim como podemos ter uma classe com mais funções(responsabilidades) do que deveria, podemos ter uma classe que não implementa de forma plena todas as responsabilidades coerentes à sua função, o que quebra o conceito de alta coesão, pois se torna necessário importar funcionalidades externas para completar a classe.
- Intimidade inapropriada: Isso indica que as classes dependem não de interfaces, mas da implementação de fato umas das outras, o que quebra o conceito de baixo acoplamento, e consequentemente a característica de modularidade.

#### Refatorações recomendadas.
- Extrair método.
- Substituir método por método objeto.
- Extrair classe.
- Extrair subclasse.
- Mudar associação bidirecional para unidirecional.
- Mover método.
- Introduzir método estrangeiro.


### Portabilidade:

Segundo Goodliffe, não necessariamente um bom design deve ser portátil, há diversas maneiras de manter o código sem dependências de uma plataforma, porém não se deve comprometer o código por uma necessidade de portabilidade desnecessária, o design do projeto deve ser suficiente para necessidade real de portabilidade.

No entanto, é comum que seu código nunca seja planejado para rodar em nenhuma outra plataforma e entre numa etapa do desenvolvimento que exigia inesperadamente funcionar em uma nova, sendo mais fácil adaptar um programa antigo do que escrever um novo.  Com tudo isso e ainda não havendo tempo suficiente para refatorar ou redesenhar o suporte multiplataforma. O resultado é uma bagunça de código cujo design foi irremediavelmente distorcido, cheio de construções #ifdef NEW\_PLATFORM.

É necessário cuidado com a estrutura da parte do código que depende da plataforma. Para que no futuro não afete o desempenho ou a clareza (às vezes até melhora a clareza). Uma abordagem comum é criar uma camada de abstração de plataforma (pode ser um simples verniz de algumas funções de interface do sistema operacional). Você pode implementar essa camada de maneira diferente em cada plataforma.

#### Maus cheiros associados.
- Código com muitas declarações IF: Para adaptação de um nova plataforma o código pode acabar contendo vários casos de “#ifdef NEW\_PLATFORM”.
- Necessidade de elementos específicos do ambiente: A utilização de binários e arquivos de texto específicos da plataforma de maneira direta.

#### Refatorações recomendadas:
- Camada de compatibilidade: Cria-se uma camada de abstração da plataforma, às vezes pode se tratar apenas de tratamento visuais entre as plataformas.


### Simplicidade:
Segundo Goodliffe, a simplicidade é a característica mais importante de um código bem escrito. Um código pode ser considerado simples quando é de fácil entendimento, coerente, consistente e fácil de implementar.

Um design simples de código não é obrigatoriamente fácil de implementar. Para que isso seja possível, o programador deve avaliar o problema e, cautelosamente, definir o quão pouco código é necessário e, então, escrever apenas isso. Além disso, pode ser necessário realizar diversas refatorações para atingir um design simples para o código.

#### Maus cheiros associados:
- Método longo: Quanto maior for o método, mais difícil é de entendê-lo. Isso, portanto, quebra a característica de simplicidade do código.
- Longa lista de parâmetros: Listas de parâmetros longas não seguem o princípio de simplicidade do código, pois se tornam inconsistentes e são difíceis de entender e de usar.

#### Refatorações recomendadas:
- Extrair método: Operação que pode ser utilizada para diminuir o tamanho de um método longo.
- Substituir parâmetro por método: Operação para diminuir o tamanho de uma longa lista de parâmetros. Consiste em realizar uma chamada a um objeto que possua o dado ao invés de passar o dado como parâmetro.

### Boa documentação:
A documentação é parte fundamental de um código. Uma boa documentação permite a realização da manutenção e atualização do código de maneira mais fácil por facilitar a compreensão do código, tanto para aqueles que o desenvolveram como também para novos desenvolvedores. Portanto, a documentação, quando bem feita, minimiza o gasto de tempo e dinheiro para o projeto.

Uma boa documentação não é composta apenas de artefatos gerados, mas também é parte integrante do código, como um código bem escrito e legível, com bons nomes de variáveis, comentários pertinentes e bom fluxo de execução.

#### Maus cheiros associados:
A característica de boa documentação está relacionada a maus cheiros de comentários em excesso, documentação desatualizada, informação incorreta, ausência de informações e até variáveis com nomes não significativos. Estes maus cheiros tendem a acontecer quando a documentação não recebe a atenção adequada, quando ocorre uma mudança nos requisitos e a documentação não recebe as mudanças necessárias ou até por uma má comunicação entre as equipes do projeto. 

#### Refatorações recomendadas:
- Sempre que surgir a necessidade de escrever um comentário, primeiro deve-se tentar refatorar o código, para que não se tenha comentários desnecessários. Por exemplo: se um comentário explica um bloco de código, talvez deva-se tentar extrair um método deste bloco. 


### Ausência de duplicidades

Goodliffe destaca que um código bem projetado não contém duplicação; ele nunca precisa se repetir. A duplicação é inimiga de um projeto elegante e simples. O autor diz também que o código redundante desnecessário leva a um programa frágil: se houver duas partes de código semelhantes que diferem em pequenos detalhes, você pode corrigir um bug em um e esquecer de corrigir o mesmo bug no outro. Isso claramente compromete a segurança do código.

A maior parte da duplicação vem através do uso da funcionalidade de copiar e colar - copiando código no editor. Pode surgir de maneira mais sutil através da reinvenção de rodas por programadores que não entendem o sistema inteiro.


#### Maus cheiros associados:
- Fragmentos condicionais duplicados: condições duplicadas em diferentes partes do código, geralmente indicando que um método ou classe separada deve ser criada.

- Grupos de dados: um grupo de campos de dados que ocorrem juntos com frequência, muitas vezes indicando que os campos devem ser combinados em um objeto.

- Código Duplicado: Linhas duplicadas de código que fazem a mesma coisa, indicando que o código deve ser refatorado em uma única função ou método reutilizável.

- Método Longo: Um método muito longo e difícil de entender, geralmente indicando que deve ser dividido em métodos menores e mais gerenciáveis.


#### Refatorações recomendadas:

- Extrair método: quando a mesma expressão encontra-se em dois métodos na mesma classe. 
- Extrair método / puxar para cima: quando a mesma expressão está em classes irmãs. 
- Extrair método / método template: extrair comportamento comum de dois métodos e implementar a variabilidade em subclasses.
- Substituir algoritmo: em casos de substituir algoritmo por um mais claro.
