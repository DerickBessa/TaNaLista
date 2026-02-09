import { StyleSheet, Text, TouchableOpacity, View } from "react-native";
import { Ionicons } from "@expo/vector-icons";
import { useTheme } from "../../contexts/ThemeContext";

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

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: "center",
    paddingTop: 60,
  },
  themeButton: {
    position: "absolute",
    top: 50,
    right: 16,
    width: 44,
    height: 44,
    borderRadius: 22,
    justifyContent: "center",
    alignItems: "center",
    shadowColor: "#000",
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.1,
    shadowRadius: 4,
    elevation: 3,
  },
  avatarContainer: {
    marginBottom: 16,
  },
  avatar: {
    width: 100,
    height: 100,
    borderRadius: 50,
    justifyContent: "center",
    alignItems: "center",
  },
  avatarText: {
    fontSize: 40,
    fontWeight: "bold",
    color: "#fff",
  },
  name: {
    fontSize: 24,
    fontWeight: "bold",
    marginBottom: 4,
  },
  email: {
    fontSize: 16,
    marginBottom: 32,
  },
  infoContainer: {
    flexDirection: "row",
    gap: 60,
  },
  infoItem: {
    alignItems: "center",
  },
  infoLabel: {
    fontSize: 14,
    marginTop: 4,
  },
  infoValue: {
    fontSize: 28,
    fontWeight: "bold",
  },
});
