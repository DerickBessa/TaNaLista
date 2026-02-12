import { Text, View } from "react-native";
import { useTheme } from "../../contexts/ThemeContext";
import { styles } from "../../styles/home.styles";

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
