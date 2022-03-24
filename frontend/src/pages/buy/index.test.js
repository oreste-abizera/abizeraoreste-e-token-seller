import React from 'react';
import Enzyme, { shallow } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import Buy from './index';

Enzyme.configure({ adapter: new Adapter() });

describe('Test Case for Buy Electricity Page', () => {
  test('Validate Buy Electricity Label render', () => {
    const wrapper = shallow(<Buy />);
    const buyElectricity = wrapper.find('.buy-electricity');
    expect(buyElectricity).toHaveLength(1);
    expect(buyElectricity.text() == 'Buy Electricity');
  });
});

describe('Test Case for Buy Electricity Page', () => {
  test('Validate Return To Home Render render', () => {
    const wrapper = shallow(<Buy />);
    const createElement = wrapper.find('#returnToHome');
    expect(createElement).toHaveLength(1);
  });
});

describe('Test Case for Buy Electricity Page', () => {
  test('Validate Form fields', () => {
    const wrapper = shallow(<Buy />);
    wrapper
      .find('#meter_number')
      .simulate('change', { target: { name: 'name', value: '123456' } });
    wrapper
      .find('#amountOfMoney')
      .simulate('change', { target: { name: 'name', value: 100 } });
  });
});

describe('Test case for Create Component', () => {
  let props = {
    history: {
      push: () => {},
    },
  };

  test('Validate click event of Buy', () => {
    const wrapper = shallow(<Buy {...props} />);
    let buyBtn = wrapper.find('#buy');
    expect(buyBtn).toHaveLength(1);
    buyBtn.simulate('click');
  });
});
