'use client'

import Image from "next/image";
import Link from "next/link";

const NavHeader = () => {
  return (
    <nav className="flex-between fixed 
      z-50 w-full 
      px-6 py-4 lg:px-10 
      bg-white">

      <Link
        className="flex-center flex-row gap-2"
        href="">
        <Image
          src=""
          width={32}
          height={32}
          alt="rih logo"
          className=""
        />
        <p>Logo goes here</p>
      </Link>

      <div className="flex flex-row items-center gap-6">
        <Link
          className="text-[20px] text-primary font-bold"
          href="/">
          <p>Home</p>
        </Link>

        <Link
          className="text-[20px] text-primary font-bold"
          href="/dashboard">
          <p>Dashboard</p>
        </Link>

        <Link
          className="text-[20px] text-primary font-bold"
          href="">
          <p>Statistics</p>
        </Link>

      </div>
    </nav>
  );
};

export default NavHeader;
