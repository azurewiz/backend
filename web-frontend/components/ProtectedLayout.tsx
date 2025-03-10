"use client";
import { useAuth } from "@/context/AuthContext";
import { usePathname, useRouter } from "next/navigation";
import { useEffect } from "react";

const ProtectedLayout = ({ children }: { children: React.ReactNode }) => {
  const { user } = useAuth(); // ✅ Ensuring this runs only on client
  const router = useRouter();
  const pathname = usePathname();

  const isAuthPage = pathname.startsWith("/sign-in");

  useEffect(() => {
    if (!user && !isAuthPage) {
      router.push("/sign-in");
    }
  }, [user, router, isAuthPage]);

  return user || isAuthPage ? children : null;
};

export default ProtectedLayout;

