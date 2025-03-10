import NavHeader from "@/components/NavHeader";
import { ReactNode } from "react";

const RootLayout = (
  { children }: Readonly<{ children: ReactNode }>
) => {
  return (
    <main className="relative">
      <>
        <NavHeader />
      </>
      <div className="flex">

        <section className="flex min-h-screen flex-1 flex-col">
          <div className="w-full h-full">{children}</div>
        </section>
      </div>
    </main>
  );
};

export default RootLayout;
