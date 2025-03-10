import React from "react";

interface ButtonProps {
  label: string;
  href?: string;
  onClick?: () => void;
  icon?: React.ReactNode;
  variant?: "primary" | "secondary" | "danger";
  className?: string;
}

const Button = (
  { label, href, onClick, icon, variant = "primary", className }:
    ButtonProps
) => {
  const baseStyles = "fixed items-center space-x-2 px-4 py-2 rounded-md transition-all";

  const variantStyles = {
    primary: "bg-blue-500 text-white hover:bg-blue-700",
    secondary: "bg-gray-300 text-black hover:bg-gray-500",
    danger: "",
  }
};

export default Button;
