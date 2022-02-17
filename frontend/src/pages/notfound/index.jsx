import React from 'react';
import './index.css';

export default function NotFound() {
  return (
    <div class='notfound'>
      <h1>Error 404</h1>
      <p>That page doesn&apos;t exist.</p>
      <Link to='/'>
        <h4>Back to Home</h4>
      </Link>
    </div>
  );
}
