import { Ionicons } from "@expo/vector-icons";
import { Text, TouchableOpacity, View } from "react-native";
import { useTheme } from "../../contexts/ThemeContext";
import { styles } from "../../styles/profile.styles";

export default function ProfileScreen() {
  const { isDarkMode, toggleTheme, colors } = useTheme();

  return (
    <View style={[styles.container, { backgroundColor: colors.background }]}>
      <TouchableOpacity
        style={[styles.themeButton, { backgroundColor: colors.card }]}
        onPress={toggleTheme}
        activeOpacity={0.7}
      >
        <Ionicons
          name={isDarkMode ? "sunny" : "moon"}
          size={22}
          color={isDarkMode ? "#f5f5f5" : "#05331E"}
        />
      </TouchableOpacity>
      <View style={styles.avatarContainer}>
        <View style={[styles.avatar, { backgroundColor: colors.avatarBg }]}>
          <Text style={styles.avatarText}>U</Text>
        </View>
      </View>

      <Text style={[styles.name, { color: colors.text }]}>Usuário Demo</Text>
      <Text style={[styles.email, { color: colors.textSecondary }]}>
        usuario@email.com
      </Text>

      <View style={styles.infoContainer}>
        <View style={styles.infoItem}>
          <Text style={[styles.infoValue, { color: colors.primary }]}>0</Text>
          <Text style={[styles.infoLabel, { color: colors.textSecondary }]}>
            Eventos
          </Text>
        </View>
      </View>
    </View>
  );
}
