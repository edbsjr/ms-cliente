# 👥 Microsserviço de Cliente (`ms-cliente`)

Este microsserviço é responsável pela gestão da identidade civil e dados cadastrais dos clientes dentro do ecossistema do Banco Digital. Ele gerencia perfis de Pessoas Físicas (CPF) e Jurídicas (CNPJ), garantindo a integridade dos dados e a autonomia das informações de contato.

Construído sob os princípios da **Arquitetura Hexagonal**, o serviço foca em alta manutenibilidade e desacoplamento, utilizando **Kafka** para integração de eventos e **Redis** para otimização de performance.

### 🎯 Principais Responsabilidades
* **Gestão de Perfis:** Cadastro e manutenção de dados de PF e PJ.
* **Ciclo de Vida:** Controle de status do cliente (Pendente, Ativo, Bloqueado, Cancelado).
* **Consistência Eventual:** Criação de perfis automatizada via consumo de eventos do `ms-autenticacao`.
* **Alta Disponibilidade:** Leitura otimizada de perfis através de camadas de cache.

### 📈 Gestão e Planejamento
Para garantir a transparência do desenvolvimento e o rastreio de melhorias, toda a documentação de Levantamento de Requisitos e o detalhamento das Sprints estão centralizados nas Issues deste repositório.

Acompanhe o Roadmap: Você pode visualizar o progresso técnico, as definições de domínio e as metas de cada etapa clicando no link: [Issues](https://github.com/edbsjr/ms-cliente/issues)
