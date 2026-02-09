import React, { createContext, useContext, useState, useEffect } from "react";
import { useColorScheme } from "react-native";

type ThemeContextType = {
  isDarkMode: boolean;
  toggleTheme: () => void;
  colors: {
    background: string;
    text: string;
    textSecondary: string;
    primary: string;
    card: string;
    avatarBg: string;
    border: string;
  };
};

const ThemeContext = createContext<ThemeContextType | undefined>(undefined);

export function ThemeProvider({ children }: { children: React.ReactNode }) {
  const systemColorScheme = useColorScheme();
  const [isDarkMode, setIsDarkMode] = useState(systemColorScheme === "dark");

  useEffect(() => {
    setIsDarkMode(systemColorScheme === "dark");
  }, [systemColorScheme]);

  const toggleTheme = () => {
    setIsDarkMode(!isDarkMode);
  };

  const colors = {
    background: isDarkMode ? "#1a1a1a" : "#fff",
    text: isDarkMode ? "#fff" : "#000",
    textSecondary: isDarkMode ? "#aaa" : "#666",
    primary: isDarkMode ? "#0a5c36" : "#05331E",
    card: isDarkMode ? "#2a2a2a" : "#f5f5f5",
    avatarBg: isDarkMode ? "#0a5c36" : "#05331E",
    border: isDarkMode ? "#333" : "#e0e0e0",
  };

  return (
    <ThemeContext.Provider value={{ isDarkMode, toggleTheme, colors }}>
      {children}
    </ThemeContext.Provider>
  );
}

export function useTheme() {
  const context = useContext(ThemeContext);
  if (context === undefined) {
    throw new Error("useTheme must be used within a ThemeProvider");
  }
  return context;
}
