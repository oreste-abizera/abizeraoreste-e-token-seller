import React, { useState } from 'react';
import './index.css';
import { Link } from 'react-router-dom';
import axios from 'axios';

const ENDPOINT = 'http://localhost:8883';

export default function Buy() {
  const [meterNumber, setmeterNumber] = useState('');
  const [money, setmoney] = useState('');

  const changemeterNumber = (e) => {
    setmeterNumber(e.target.value);
  };
  const changemoney = (e) => {
    setmoney(e.target.value);
  };

  const buyElectricity = async (e) => {
    e.preventDefault();
    const dataToSend = {
      meterNumber,
      amountOfMoney: parseInt(money),
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
      <h4>Buy Electricity</h4>
      <form onSubmit={buyElectricity} className='mb-4'>
        <input
          type='text'
          placeholder='Meter Number'
          required
          value={meterNumber}
          onInput={changemeterNumber}
        ></input>
        <input
          type='number'
          placeholder='Amount Of Money'
          required
          value={money}
          onInput={changemoney}
        ></input>

        <input type='submit' value='Buy'></input>
      </form>
      <Link to='/'>
        <h4>Return to Home</h4>
      </Link>
    </div>
  );
}
