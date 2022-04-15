# Introdução à redes de computadore - T2
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Jean-Lucca_PUCRS-Error-detection-algorithms&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=Jean-Lucca_PUCRS-Error-detection-algorithms)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Jean-Lucca_PUCRS-Error-detection-algorithms&metric=coverage)](https://sonarcloud.io/summary/new_code?id=Jean-Lucca_PUCRS-Error-detection-algorithms)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=Jean-Lucca_PUCRS-Error-detection-algorithms&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=Jean-Lucca_PUCRS-Error-detection-algorithms)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=Jean-Lucca_PUCRS-Error-detection-algorithms&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=Jean-Lucca_PUCRS-Error-detection-algorithms)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=Jean-Lucca_PUCRS-Error-detection-algorithms&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=Jean-Lucca_PUCRS-Error-detection-algorithms)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=Jean-Lucca_PUCRS-Error-detection-algorithms&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=Jean-Lucca_PUCRS-Error-detection-algorithms)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=Jean-Lucca_PUCRS-Error-detection-algorithms&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=Jean-Lucca_PUCRS-Error-detection-algorithms)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=Jean-Lucca_PUCRS-Error-detection-algorithms&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=Jean-Lucca_PUCRS-Error-detection-algorithms)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=Jean-Lucca_PUCRS-Error-detection-algorithms&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=Jean-Lucca_PUCRS-Error-detection-algorithms)

Descrição

O objetivo do trabalho consiste em implementar codificadores e decodificadores para detecção e correção de erros usando as técnicas de redundância de bloco, CRC e código de Hamming. Os codificadores e decodificadores deverão ser executados em linha de comando recebendo parâmetros de entrada e apresentando o resultado na saída padrão do terminal (OBS. NÃO devem ser utilizados menus, entradas/saídas por arquivos, ou interface gráfica). Os detalhes sobre a entrada e saída para cada técnica estão apresentados abaixo:

    Redundância de bloco

    Codificador: <string em ASCII> => <string codificada em formato hexadecimal>

    Decodificador: <código em hexadecimal> => <string em ASCII> ou "ERRO"

    CRC

    Codificador: <string em ASCII> <polinômio gerador de ordem 5 expresso em binário> => <string codificada em formato hexadecimal>

    Decodificador: <string codificada em formato hexadecimal> <polinômio gerador de ordem 5 expresso em binário> => <string em ASCII> e/ou "ERRO" 
    (OBS. os caracteres sem erro devem ser apresentados e devem ser indicados os caracteres que tiveram erro na transmissão)

    Código de Hamming

    Codificador: <string em ASCII> => <string codificada em formato hexadecimal>

    Decodificador: <código em hexadecimal> => <string em ASCII> 
    (OBS. os caracteres que apresentarem erro deverão ser corrigidos e sua correção indicada na saída)

Exemplos

Redundância de bloco (BCC)

bcc_encoder redes
E4CAC9CAE7CA

bcc_decoder E4CAC9CAE7CA
redes

bcc_decoder E4CAC9CAE7CB
ERRO

CRC

crc_encoder redes 10101
72365964C659736

crc_decoder 72365964C659736 10101
redes

crc_decoder 72365A64C659737 10101
r_de_
ERRO nos caracteres: 2, 5

crc_encoder pucrs 10011
70875763872E73D

crc_decoder 70875763872E73D 10011
pucrs

crc_decoder 70875663872E73D 10011
p_crs
ERRO nos caracteres: 2

Código de Hamming

ham_encoder redes
79962C62B62C79E

ham_decoder 79962C62B62C79E
redes

ham_decoder 79961C62B62C69E
rbdes
ERRO no caractere 2 -> Correção: b
ERRO no caractere 5 -> Correção: s
