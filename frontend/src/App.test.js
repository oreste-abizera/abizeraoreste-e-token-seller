import React from 'react';
import Enzyme, { shallow } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import App from './App';

Enzyme.configure({ adapter: new Adapter() });

describe('Test Case App Page', () => {
  test('Test cases', () => {
    const wrapper = shallow(<App />);
  });
});
