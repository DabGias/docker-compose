# ⚠ ATENÇÃO ⚠

OS COMANDOS DDL E DML SÃO EXECUTADOS AUTOMATICAMENTE PELA API,
OU SEJA, A PRÓPRIA API CRIA AS TABELAS E AS PREENCHE COM 3 INSERÇÕES CADA.
CASO PRECISE DE MAIS DETALHES VISITE O REPOSITÓRIO E ACESSE
O PATH: build_maven\projeto_java\api_simulado\src\main\java\br\com\fiap\config\DatabaseSeeder.java 

# COMANDOS:

Antes de iniciar o processo de criação do docker-compose, como dito no vídeo, é necessário
configurar o arquivo pg_hba.conf. Para isso criei um container (docker pull postgres) e em
seguida crio um container com a imagem e com as devidas variáveis de ambiente
(docker run -itd -e POSTGRES_USER=guest -e POSTGRES_PASSWORD=senha_guest -p 5432:5432 --name postgresql postgres)
depois disso acesso o container no modo interativo (docker exec -it postgresql bash)
procuro o arquivo (bash# find / -name pg_hba.conf), copio e colo a primeira localização/path 
(ou anoto a localização/path) e saio do container, copio o arquivo para a máquina host (docker cp postgresql:/var/lib/postgresql/data/pg_hba.conf .)
altero a parte de METHOD para md5 e salvo o arquivo para que ele seja usuado no build do Dockerfile.

Se quiser evitar essa dor de cabeça/passo desnecessário apenas copie o conteúdo do arquivo no repositório
e crie esse aquivo (pg_hba.conf) na sua máquina, sempre lembrando de especificar corretamente o path no Dockerfile.

Depois só precisei construir o network e os containers (docker-compose up -d --build).
