import { ReactNode } from "react";

const HomeLayout = (
  { children }: Readonly<{ children: ReactNode }>
) => {
  return (
    <main>
      {children}
    </main>
  );
};

export default HomeLayout;
