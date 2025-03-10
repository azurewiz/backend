"use client"
import { useAuth } from "@/context/AuthContext";

export default function SignIn() {
  const { login } = useAuth();

  const handleLogin = () => {
    login({ username: "JohnDoe" }); // Mock login
  };

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100">
      <div className="bg-white p-6 rounded shadow-md">
        <h1 className="text-xl font-bold mb-4">Sign In</h1>
        <button onClick={handleLogin} className="px-4 py-2 bg-blue-500 text-white rounded">
          Sign In
        </button>
      </div>
    </div>
  );
}

