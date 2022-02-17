import React, { useState } from 'react';
import './index.css';
import axios from 'axios';
import { Link } from 'react-router-dom';

const ENDPOINT = 'http://localhost:8883';

export default function Load() {
  const [tokenNumber, settokenNumber] = useState('');

  const changetokenNumber = (e) => {
    settokenNumber(e.target.value);
  };

  const loadElectricity = async (e) => {
    e.preventDefault();
    const dataToSend = {
      tokenNumber,
    };
    try {
      let response = await axios.post(`${ENDPOINT}/transactions`, dataToSend);
      if (response) {
        if (response.data?.success) {
          route('/');
        } else {
          alert('error occured...');
        }
      } else {
        alert('Server unreachable...');
      }
    } catch (error) {
      alert('Error occured');
    }
  };
  return (
    <div class='createPage'>
      <h4>Load Electricity</h4>
      <form onSubmit={loadElectricity} className='mb-4'>
        <input
          type='text'
          placeholder='Token Number'
          required
          value={tokenNumber}
          onInput={changetokenNumber}
        ></input>

        <input type='submit' value='Load'></input>
      </form>
      <Link to='/'>
        <h4>Return to Home</h4>
      </Link>
    </div>
  );
}
