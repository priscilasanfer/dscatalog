import React from 'react';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import {Home, Catalog, ProductDetails} from '../pages'

const Stack = createNativeStackNavigator()


const Routes: React.FC =()=>{
return (
    <Stack.Navigator>
        <Stack.Screen options={{
            headerTitleAlign: "center"
        }} name= "Home" component={Home}/>
        <Stack.Screen options={{
            headerTitleAlign: "center"
        }} name= "Catalog" component={Catalog}/>
        <Stack.Screen options={{
            headerTitleAlign: "center"
        }} name= "ProductDetails" component={ProductDetails}/>
    </Stack.Navigator>  
);
}

export default Routes