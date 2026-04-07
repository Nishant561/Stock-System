import React from 'react'
import { Navigate, Outlet } from 'react-router'

function DashboardLayout({isAuthenticated}) {
    if (!isAuthenticated) return <Navigate to={"/login"} replace/>
  return (
    <div>
        <Outlet/>

    </div>
  )
}

export default DashboardLayout