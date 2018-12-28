#language: pt
@login
Funcionalidade: Login
  Como usuário Pi
  Quero realizar login na aplicação web
  Para realizar minhas tarefas

  Cenario: Login com sucesso
    Dado que eu esteja na página de login da Pi
    Quando eu insiro meu e-mail cadastrado
    E minha senha
    E clico no botão de Login
    Então eu devo logar com sucesso na aplicação

    
    #Cenario: Login invalido
    #Dado que eu esteja na tela de login
    #Quando eu realizo a inserção de 
    #E senha
    #E tento realizar o login
    #Então eu não devo logar
    
    #Cenario: Perfil Suitability
    #Dado que eu esteja logado 
    #E não tenha preenchido meu perfil de Investidor 
    #Quando eu respondo a primeira pergunta com a resposta "<u	m>"
    #E respondo a segunda pergunta com a resposta "<dois>"
    #E respondo a terceira pergunta com a resposta "<tres>"
    #E respondo a quarta pergunta com a resposta "<quatro>"
    #E respondo a quinta pergunta com a resposta "<cinco>"
    #E respondo a sexta pergunta com a resposta "<seis>"
    #E respondo a sétima pergunta com a resposta "<sete>"
    #E respondo a oitava pergunta com a resposta "<oito>"
    #E respondo a nona pergunta com a resposta "<nove>"
    #Então eu devo ter o perfil "<investidor>"
    
    #Exemplos:
    #|um	|dois |tres|quatro|cinco|seis|sete|oito|nove|investidor		|
    #|A	|A		|A	 |A			|A		|A	 |A		|A	 |A		|conservador	|
    #|B	|B		|B	 |B			|B		|B	 |B		|B	 |B		|moderado 		|	
   	#|C	|C		|C	 |C			|C		|C	 |C		|C	 |C		|agressivo    |
   	
   	