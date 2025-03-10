import AnimatedOptionsMenu from '@/components/AnimatedOptionsMenu';
import React from 'react'

const Dashboard = () => {
  return (
    <div className='w-full h-full bg-pink-50'>
      {/* Menu holder div */}
      <AnimatedOptionsMenu
        width={"100px"}
        height={"100px"}
        backgroundColor='blue'
        cp='fixed bottom-8 right-8'
      />
    </div>
  );
};

export default Dashboard;
