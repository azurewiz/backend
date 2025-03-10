'use client'

import { useState } from "react";

interface AnimatedOptionsMenuType {
  width?: string;
  height?: string;
  backgroundColor?: string;
  cp?: string;
}

const menuItems = [

];

const AnimatedOptionsMenu = (
  { width, height, backgroundColor, cp }: AnimatedOptionsMenuType) => {
  const [isClicked, setIsClicked] = useState<boolean>(true);
  return (
    <div
      style={{
        width: width || "100px",
        height: height || "100px",
        backgroundColor: backgroundColor || "blue"
      }}
      className={`rounded-full transition-all duration-500 hover:h-40 ${cp}`}
    >

    </div>
  );
}

export default AnimatedOptionsMenu;
