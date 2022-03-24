import React, { useState } from 'react';
import './index.css';
import { Link } from 'react-router-dom';
import axios from 'axios';

const ENDPOINT = 'http://localhost:8883';

export default function Buy() {
  const [meterNumber, setmeterNumber] = useState('');
  const [money, setmoney] = useState('');
  const [message, setmessage] = useState('');

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
      let response = await axios.post(`${ENDPOINT}/tokens/save`, dataToSend);
      if (response) {
        if (response.data?.success) {
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
      <h4 className='buy-electricity'>Buy Electricity</h4>
      <form onSubmit={buyElectricity} className='mb-4'>
        <input
          type='text'
          placeholder='Meter Number'
          required
          value={meterNumber}
          onInput={changemeterNumber}
          id='meter_number'
        ></input>
        <input
          type='number'
          placeholder='Amount Of Money'
          required
          value={money}
          onInput={changemoney}
          id='amountOfMoney'
        ></input>

        {message && <p>{message}</p>}

        <input type='submit' value='Buy' id='buy'></input>
      </form>
      <Link to='/'>
        <h4 id='returnToHome'>Return to Home</h4>
      </Link>
    </div>
  );
}
