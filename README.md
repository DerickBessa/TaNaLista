<div align="center">

# 📋✅ TáNaLista

### *Tá na lista? Então pode entrar.*

[![React Native](https://img.shields.io/badge/React_Native-Expo-61DAFB?style=for-the-badge&logo=react&logoColor=white)](https://reactnative.dev)
[![TypeScript](https://img.shields.io/badge/TypeScript-5.x-3178C6?style=for-the-badge&logo=typescript&logoColor=white)](https://typescriptlang.org)
[![Node.js](https://img.shields.io/badge/Node.js-Express-339933?style=for-the-badge&logo=node.js&logoColor=white)](https://nodejs.org)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Prisma-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)](https://postgresql.org)

> **TáNaLista** é uma solução completa de gestão de acesso e controle de convidados para eventos de qualquer porte — do evento intimista ao festival lotado.
> Criado para **eliminar filas, fraudes e confusão**, o sistema une QR Code, biometria e validação em tempo real, garantindo segurança para o organizador e uma experiência fluida para o convidado.

🚧 **Status: Em desenvolvimento ativo**

</div>

---

## 🎯 O Problema que Resolve

Eventos têm um problema clássico: a portaria vira um gargalo. Lista em papel, convidado sem QR Code, internet caindo, organizador perdido — tudo isso causa fila, estresse e entradas não autorizadas.

O TáNaLista resolve isso com um sistema inteligente que **não para**, mesmo offline.

---

## ✨ Funcionalidades

### 🔐 Segurança e Acesso
- **Check-in por QR Code** — entrada rápida e sem contato
- **Validação biométrica** — facial ou digital diretamente no dispositivo
- **Confirmação em tempo real** — ADM valida dados pessoais no ato da entrada
- **Modo Offline (Anti-Zebra 🦓)** — validação por RG ou biometria no celular do organizador, mesmo sem internet

### 👑 Perspectiva do Organizador
- Gestão de equipe com delegação de líderes e ADMs
- Controle total da lista — adicionar, remover, aprovar convidados
- Configuração inteligente: limite de lotação, controle de acompanhantes, pre-sets por porte
- Painel de monitoramento em tempo real com scroll ao vivo de entradas
- Integração com **Google Maps** e **Google Calendar**
- Liberação antecipada automática (1h antes do evento)

### 👤 Perspectiva do Convidado
- Acesso via código ou link compartilhado
- Gestão de acompanhantes com aprovação do organizador
- Chat privado e FAQ automático com o organizador
- **Geolocalização inteligente** — botão "Cheguei" só libera quando o convidado estiver no local

### 🔔 Sistema Inteligente
- Notificações push para confirmações, alterações e solicitações
- Filtros de lista: quem entrou / quem ainda não chegou
- Logs de acesso e histórico completo de entradas
- Prevenção contra duplicidade e fraudes

---

## 🏗️ Arquitetura

```
┌─────────────────────────────────────┐
│         React Native (Expo)         │
│   Guest View  │  Organizer View     │
└──────────────┬──────────────────────┘
               │ REST API
┌──────────────▼──────────────────────┐
│         Node.js + Express           │
│   Auth │ Events │ Guests │ Access   │
└──────────────┬──────────────────────┘
               │ Prisma ORM
┌──────────────▼──────────────────────┐
│            PostgreSQL               │
│  Users │ Events │ Guests │ Logs     │
└─────────────────────────────────────┘
```

---

## 🛠️ Tech Stack

| Camada | Tecnologia |
|---|---|
| Mobile Frontend | React Native (Expo) + TypeScript |
| Backend | Node.js + Express |
| ORM | Prisma |
| Banco de Dados | PostgreSQL |
| Autenticação | JWT + bcrypt |
| Biometria | Local device biometric API |
| Mapas | Google Maps API |
| Calendário | Google Calendar API |

---

## 📂 Estrutura do Projeto

```plaintext
├── frontend/                  # React Native (Expo)
│   ├── src/
│   │   ├── assets/            # Logos e ícones
│   │   ├── components/        # QR Scanner, botões biométricos
│   │   ├── screens/
│   │   │   ├── admin/         # Gestão, lista, pre-sets
│   │   │   └── guest/         # Convite, chat, cadastro
│   │   ├── services/          # Maps, Auth, Biometria
│   │   ├── store/             # Gerenciamento de estado
│   │   ├── hooks/             # Hooks reutilizáveis
│   │   └── routes/            # Rotas e guards de acesso
│
└── backend/                   # Node.js + Express
    ├── src/
    │   ├── routes/            # Endpoints REST
    │   ├── controllers/       # Lógica de negócio
    │   ├── middlewares/       # Auth, validação
    │   └── prisma/            # Schema e migrations
```

---

## ⚙️ Getting Started

### Prerequisites
- Node.js 18+
- PostgreSQL
- Expo CLI

### Backend

```bash
cd backend
npm install
cp .env.example .env   # configure DATABASE_URL e JWT_SECRET
npx prisma migrate dev
npm run dev
```

### Frontend

```bash
cd frontend
npm install
npx expo start
```

---

## ⚠️ Contingência — O Sistema que Não Para

Pensado para o mundo real, onde a internet falha e o evento **não pode parar**.

Se o convidado estiver sem celular ou sem internet:

1. Organizador busca o nome na lista
2. Convidado valida identidade por **biometria no celular do ADM** ou **documento físico (RG)**

✔️ Entrada liberada com segurança  
✔️ Evento continua normalmente  
✔️ Zero gargalo na portaria  

---

## 🔭 Próximas Implementações

- [ ] Dashboard com métricas em tempo real
- [ ] Reconhecimento facial avançado
- [ ] Integração com catracas físicas
- [ ] Relatórios pós-evento exportáveis
- [ ] Modo white-label para empresas

---

## 🧠 Filosofia do Produto

> **Tecnologia só é boa quando some.**  
> O usuário não precisa pensar — apenas usar.

Se tá na lista, entra.  
Se não tá, o sistema mostra o motivo.  
Sem discussão, sem estresse.

---

## 🤝 Contributing

Contribuições são muito bem-vindas!

```bash
# 1. Fork o projeto
# 2. Crie sua branch
git checkout -b feature/minha-feature

# 3. Commit suas alterações
git commit -m "feat: minha feature"

# 4. Abra um Pull Request 🚀
```

---

## 📄 License

This project is licensed under the **MIT License**.

---

<div align="center">

Developed by <a href="https://github.com/DerickBessa"><strong>Derick Bessa</strong></a>

**📋 Tá na lista? Então pode entrar. ✅**

</div>
