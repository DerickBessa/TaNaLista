import { StyleSheet, Text, View } from "react-native";
import { useTheme } from "../../contexts/ThemeContext";

export default function HomeScreen() {
  const { colors } = useTheme();

  return (
    <View style={[styles.container, { backgroundColor: colors.background }]}>
      <Text style={[styles.title, { color: colors.text }]}>TaNaLista</Text>
      <Text style={[styles.subtitle, { color: colors.textSecondary }]}>
        Bem-vindo!
      </Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  },
  title: {
    fontSize: 32,
    fontWeight: "bold",
    marginBottom: 8,
  },
  subtitle: {
    fontSize: 18,
  },
});
