import React, { useState } from 'react';
import './index.css';
import axios from 'axios';

const ENDPOINT = 'http://localhost:8883';

export default function Home() {
  const [message, setmessage] = useState('');
  const [meterNumber, setmeterNumber] = useState('');

  const changemeterNumber = (e) => {
    setmeterNumber(e.target.value);
  };

  const checkStatus = async (e) => {
    e.preventDefault();
    const dataToSend = {
      meterNumber,
    };
    try {
      let response = await axios.post(`${ENDPOINT}/transactions`, dataToSend);
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
      <h4 className='meterStatus'>Check Meter Status</h4>
      <form onSubmit={checkStatus} className='mb-4'>
        <input
          type='text'
          placeholder='Meter Number'
          required
          value={meterNumber}
          onInput={changemeterNumber}
        ></input>

        <input type='submit' value='Check'></input>
      </form>
    </div>
  );
}
