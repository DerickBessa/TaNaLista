import { Redirect } from "expo-router";

export default function Index() {
  // Por padrão, redireciona para a tela de login
  // Adicionar lógica aqui para verificar se o usuário já está logado
  return <Redirect href="/login" />;
}
