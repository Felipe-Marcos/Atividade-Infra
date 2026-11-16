# Lab 10 – CI/CD (API simples) — Roteiro
<RA> = seu RA | <USER> = usuário Docker Hub

## GitHub
1. Crie o repo (sem README), `git init && git add . && git commit -m "feat: api lab10" && git branch -M main && git remote add origin <url> && git push -u origin main`
2. Settings > Secrets and variables > Actions: secrets DOCKERHUB_USERNAME e DOCKERHUB_TOKEN (Docker Hub > Account Settings > Security > New Access Token, Read & Write); variável RA = seu RA.
   (o primeiro push roda o CI; sem os secrets o job Docker falha, então configure antes do push)

## EC2 (nome: ec2-publica-<RA>)
1. Ubuntu 22.04, IP público, Security Group: portas 22 e 8080.
2. `sudo apt update && sudo apt install -y docker.io && sudo usermod -aG docker $(whoami) && newgrp docker && docker run hello-world`
3. Settings > Actions > Runners > New self-hosted runner (Linux x64): rode os comandos na EC2; no fim `nohup ./run.sh > output.log 2>&1 &`
4. Re-execute o CI/CD (Actions > Run workflow ou novo push) para o CD rodar com o runner online.

## Testes
http://IP-EC2:8080/api/ola · /api/versao · /api/tarefas · /actuator/health

## Evidências (com data/hora do SO e seu nome no console AWS)
1. Repo GitHub (workflows + Dockerfile)
2. Actions: CI verde (build, testes, docker)
3. Docker Hub: lab10-api-<RA> com tag latest
4. Console AWS: EC2 ec2-publica-<RA>, IP público, running, seu nome visível
5. Terminal da EC2: `docker ps`
6. Navegador: http://IP-EC2:8080/actuator/health e /api/ola
7. Actions: CD verde (self-hosted)
