## Disassembler

Em um "assembler", um programa escrito em linguagem de montagem(texto) 
é convertido para binário (linguagem de máquina) para ser executado na CPU. 
Em um "disassembler", o processo inverso é feito: o código binário do programa 
em linguagem de máquina é convertido novamente para linguagem de montagem. 

O software desenvolvido em Java suporta todas as instruções da 
arquitetura ISA MARIE. Cada instrução tem 2 bytes(16 bits) de 
tamanho, os 4 primeiros bits são o opcode(operação) e os outros 
12 bits são o endereço da instrução...

### Exemplo de execução:

O valor "0xDA00" (2 bytes), equivalente a uma instrução MARIE. Em seguida, 
decodifica-se a instrução separando o campo "opcode" e o campo "endereço" 
dessa instrução. O campo opcode tem o valor "0xD" e o campo endereço tem 
o valor "0xA00". Após isso, deve-se imprimir na tela "loadi A00". 

Caso a instrução não utilize o campo de endereço imprimi somente o mnemônico 
equivalente ao opcode. O arquivo de valor "0x7000" (2 bytes), equivalente 
a uma instrução MARIE. Em seguida, decodifica-se a instrução separando o 
campo "opcode" e o campo "endereço" dessa instrução. O campo opcode tem o 
valor "0x7" e o campo endereço tem o valor "0x000". Após isso, imprimi na 
tela "halt", pois essa instrução não faz uso do parâmetro de endereço.
