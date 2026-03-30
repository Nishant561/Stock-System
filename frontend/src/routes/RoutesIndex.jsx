import React from 'react'
import Login from '../pages/Login'
import { Route, Routes } from 'react-router'

function RoutesIndex() {
  return (
    <>
        <Routes>
            
           { ["/", "/login"].map((path)=> (
                <Route key={path} path={path} element={<Login/>} />
            ) )}

            


        </Routes>
    
    </>
  )
}

export default RoutesIndex