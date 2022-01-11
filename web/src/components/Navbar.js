import React from 'react'
import { Link } from 'react-router-dom'

export const PublicNavbar = () => (
  <nav style={{ display:"flex", flexDirection: "row" }}>
    <Link className="logo-page" to="/"><img className="logo-page" src="../logo.png" alt="Logo" width={60} height={60} /></Link>
    <section>
      <Link to="/">Home</Link>
      <Link to="/questions">Questions</Link>
    </section>
  </nav>
)

export const PrivateNavbar = () => (
  <nav style={{ display:"flex", flexDirection: "row" }}>
    <Link className="logo-page" to="/"><img className="logo-page" src="../logo.png" alt="Logo" width={60} height={60} /></Link>
    <section>
      <Link to="/">Home</Link>
      <Link to="/questions">Questions</Link>
      <Link to="/new">New</Link>
      <Link to="/list">List</Link>
      <Link to="/profile">Profile</Link>
    </section>
  </nav>
)
