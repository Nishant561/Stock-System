import React from 'react'
import LoginForm from '../components/LoginForm'
import LoginFooter from '../components/LoginFooter'
import { Outlet } from 'react-router';
import LoginImage from '../components/LoginImage';

function AuthLayout() {
  return (
    <>
        <div className="bg-black text-white h-screen w-full">
        <div className="login-container h-full flex">
          <LoginImage />

          <div className="login-credentials-container w-1/2 h-full flex-col justify-between  flex items-center pt-24">

            <Outlet/>
            

            <LoginFooter />
          </div>
        </div>
      </div>
    
    
    </>
  )
}

export default AuthLayout;