# 📋✅ TáNaLista

> **Tá na lista? Então pode entrar.**  
O **TáNaLista** é uma solução completa de **gestão de acesso e controle de convidados** para eventos de pequeno, médio e grande porte.  
Criado para **eliminar filas, fraudes e confusão**, o sistema une **QR Code, biometria e validação em tempo real**, garantindo segurança para o organizador e uma experiência fluida para o convidado.

---

## 🎯 Propósito do Projeto

O TáNaLista nasceu com um objetivo simples e poderoso:  
**garantir que só entra quem realmente foi convidado — sem dor de cabeça.**

Seja um evento pequeno ou uma grande produção, o sistema se adapta, não cai e não deixa ninguém na mão.

---

## 🎨 Identidade Visual

- **Cor Primária:** Branco `#FFFFFF`
- **Cor Secundária:** Verde Escuro `#053314`  
  > Transmite segurança, organização e confiança.

---

## 🚀 Funcionalidades Principais

### 🔐 Segurança e Acesso
- **Check-in Inteligente**
  - Entrada via **QR Code**
  - Entrada via **Biometria (Digital ou Facial)**
- **Validação em Tempo Real**
  - O ADM pode confirmar dados pessoais no ato da entrada
- **Modo Offline (Anti-Zebra 🦓)**
  - Verificação via **documento físico (RG)**
  - Validação biométrica diretamente no celular do organizador
  - Ideal para locais sem internet

---

### 👑 Perspectiva do Organizador (Dono do Evento)

- **Gestão de Equipe**
  - Delegação de líderes e outros ADMs
- **Controle Total da Lista**
  - Adicionar/remover convidados manualmente
  - Aprovar solicitações de entrada
- **Configuração Inteligente do Evento**
  - Limite de lotação
  - Controle de acompanhantes
  - Pre-sets para eventos:
    - Pequeno porte
    - Grande porte
- **Integrações**
  - Google Maps (localização do evento)
  - Google Calendário
- **Painel de Monitoramento em Tempo Real**
  - Scroll ao vivo mostrando quem já entrou
  - Visualização clara e objetiva

---

### 👤 Perspectiva do Convidado

- **Solicitação de Ingresso**
  - Acesso via **código** ou **link compartilhado**
- **Gestão de Acompanhantes**
  - Solicitação sujeita à aprovação do organizador
- **Comunicação Integrada**
  - Chat privado
  - Respostas automáticas (FAQ)
  - Contato direto com o organizador
- **Geolocalização Inteligente**
  - Botão **"Cheguei"**
  - Só libera quando o convidado estiver no local do evento

---

## 🛠️ Comportamentos Inteligentes do Sistema

- 🔔 **Notificações Push**
  - Confirmação de entrada
  - Alterações no evento
  - Solicitações pendentes
- 🔍 **Filtros de Lista**
  - Quem já entrou
  - Quem ainda não utilizou o QR Code
- ⏱️ **Liberação Antecipada Automática**
  - 1 hora antes do evento
  - Staff já pode validar entradas

---

## 📂 Estrutura do Projeto

```plaintext
├── src
│   ├── assets          # Logos e ícones (Verde #053314)
│   ├── components      # QR Scanner, Botões Biométricos
│   ├── screens
│   │   ├── admin       # Gestão, Lista, Pre-sets
│   │   └── guest       # Convite, Chat, Cadastro
│   └── services        # Maps, Auth Google, Biometria
│
├── utils # Helpers, validações, formatadores
├── store # Gerenciamento de estado (auth, evento, convidados)
├── hooks # Hooks reutilizáveis
├── routes # Rotas e guards de acesso
└── config # Variáveis de ambiente e configs globais


Perfeito 👍 você tem razão — vou **continuar exatamente no mesmo formato Markdown**, sem quebrar bloco nem misturar `plaintext`.

Segue a **continuação correta do README**, a partir de onde você parou:

---

│
├── utils               # Helpers, validações, formatadores
├── store               # Gerenciamento de estado (auth, evento, convidados)
├── hooks               # Hooks reutilizáveis
├── routes              # Rotas e guards de acesso
└── config              # Variáveis de ambiente e configs globais

```

---

## ⚠️ Casos de Contingência (Sistema que NÃO PARA)

Pensado para o mundo real — onde a internet falha, o celular descarrega e o evento **não pode parar**.

Se o convidado estiver **sem celular ou sem internet**:

1. O organizador busca o nome do convidado na lista
2. O convidado valida sua identidade por:
   - **Biometria** no celular do ADM **OU**
   - **Documento físico (RG)** para conferência manual

✔️ Entrada liberada com segurança  
✔️ Evento continua normalmente  
✔️ Zero gargalo na portaria  

---

## 🔒 Segurança em Primeiro Lugar

- Autenticação por perfil (ADM, Staff, Convidado)
- Biometria aplicada no dispositivo
- QR Codes com validação única
- Logs de acesso e histórico de entradas
- Prevenção contra duplicidade e fraudes

---

## 📈 Escalabilidade e Flexibilidade

O **TáNaLista** foi projetado para crescer junto com o evento:

- Eventos privados
- Festas e confraternizações
- Congressos e feiras
- Shows e festivais
- Eventos corporativos

Do evento intimista ao evento lotado.

---

## 🧠 Filosofia do Produto

> **Tecnologia só é boa quando some.**  
O usuário não precisa pensar — apenas usar.

Se tá na lista, entra.  
Se não tá, o sistema mostra o motivo.  
Sem discussão, sem estresse.

---

## 📌 Status do Projeto

🚧 **Em desenvolvimento / Projeto de aprendizado**

Foco em:
- Arquitetura escalável
- Boas práticas de código
- Experiência real de eventos
- Segurança e confiabilidade

---

## 🤝 Contribuindo

Contribuições são muito bem-vindas!

Você pode ajudar com:
- Novas funcionalidades
- Otimização de performance
- Melhorias de UX/UI
- Correções e refatorações

1. Faça um fork do projeto  
2. Crie uma branch (`feature/minha-feature`)  
3. Commit suas alterações  
4. Abra um Pull Request 🚀  

---

## 🧪 Futuras Implementações

- Dashboard com métricas em tempo real
- Reconhecimento facial avançado
- Integração com catracas físicas
- Relatórios pós-evento
- Modo white-label para empresas

---

## 📋 Tá na lista?

Então pode entrar. ✅  

-------------------------
