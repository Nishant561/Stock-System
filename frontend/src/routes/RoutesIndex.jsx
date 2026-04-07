import React from 'react'
import Login from '../pages/Login'
import { Route, Routes } from 'react-router'
import AuthLayout from '../layouts/AuthLayout'
import Signup from '../pages/Signup'
import DashboardLayout from '../layouts/DashboardLayout'
import Dashboard from '../pages/Dashboard'
import Profile from '../pages/Profile'

function RoutesIndex() {

  const isAuthenticated = false;
  return (
    <>
        <Routes>
          <Route element={<AuthLayout/>}>
              { ["/", "/login"].map((path)=> (
                <Route key={path} path={path} element={<Login/>} />
            ) )}

            <Route path='/signup' element={<Signup/>} />
          </Route>
            
           <Route element={<DashboardLayout isAuthenticated={isAuthenticated} />}>
              <Route index path='/dashboard' element={<Dashboard/>} />
              <Route index path='/profile' element={<Profile/>} />
              
              

           </Route>

            


        </Routes>
    
    </>
  )
}

export default RoutesIndex