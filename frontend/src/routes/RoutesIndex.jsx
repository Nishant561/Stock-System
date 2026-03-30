import React from 'react'
import Login from '../pages/Login'
import { Route, Routes } from 'react-router'
import AuthLayout from '../layouts/AuthLayout'
import Signup from '../pages/Signup'

function RoutesIndex() {
  return (
    <>
        <Routes>
          <Route element={<AuthLayout/>}>
              { ["/", "/login"].map((path)=> (
                <Route key={path} path={path} element={<Login/>} />
            ) )}

            <Route path='/signup' element={<Signup/>} />
          </Route>
            
           

            


        </Routes>
    
    </>
  )
}

export default RoutesIndex