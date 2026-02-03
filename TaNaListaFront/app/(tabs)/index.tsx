import { StyleSheet, Text, View } from "react-native";

export default function HomeScreen() {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>TaNaLista</Text>
      <Text style={styles.subtitle}>Bem-vindo!</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "#fff",
  },
  title: {
    fontSize: 32,
    fontWeight: "bold",
    marginBottom: 8,
  },
  subtitle: {
    fontSize: 18,
    color: "#666",
  },
});
