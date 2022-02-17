import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

import Home from '@/pages/home';
import Buy from '@/pages/buy';
import Load from '@/pages/load';
import NotFound from '@/pages/notfound';

import Navbar from '@/components/Navbar';

export default function Routes() {
  return (
    <Router>
      <Navbar></Navbar>
      <div className='mt-10'>
        <Switch>
          <Route exact path='/' component={Home} />
          <Route exact path='/buy' component={Buy} />
          <Route exact path='/load' component={Load} />
          <Route exact path='*' component={NotFound} />
        </Switch>
      </div>
    </Router>
  );
}
