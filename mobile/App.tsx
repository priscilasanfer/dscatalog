import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import Routes from './src/routes';

/*
Quando a FlexDirection é row => o justifyContent alinha horizontalmente
Quando é column (padão) => o justifyContent alinha verticalmente

*/

const App: React.FC = () => {
  return (
    <NavigationContainer>
        <Routes/>
    </NavigationContainer>
  );
};

export default App;
