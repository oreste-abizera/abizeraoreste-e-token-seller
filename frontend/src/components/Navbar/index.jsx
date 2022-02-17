import React from "react"
import { Link } from 'react-router-dom';
import './index.css';

export default function Navbar() {
  return (
    <header class='header'>
      <h1>E-Tokens Seller</h1>
      <nav>
        <Link activeClassName='active' to='/'>
          Meter Status
        </Link>
        <Link activeClassName='active' to='/buy'>
          Buy Electricity
        </Link>
        <Link activeClassName='active' to='/load'>
          Load Electricity
        </Link>
      </nav>
    </header>
  );
}
