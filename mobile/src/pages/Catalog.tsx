import React from 'react';
import {ScrollView } from 'react-native';
import { ProductCard } from '../components';
import productImg from '../assets/produto.png';
import { theme } from '../styles';

const products =[
    {
        id: 1,
        imgUrl: productImg,
        name: "Computador",
        price: 2279.0
    },
    {
        id: 2,
        imgUrl: productImg,
        name: "Computador",
        price: 2278.0
    },
    {
        id: 3,
        imgUrl: productImg,
        name: "Computador",
        price: 2277.0
    },
    {
        id: 4,
        imgUrl: productImg,
        name: "Computador",
        price: 2276.0
    },
    {
        id: 5,
        imgUrl: productImg,
        name: "Computador",
        price: 2276.0
    }
];

const Catalog: React.FC = ()=> {
    return(
        <ScrollView contentContainerStyle={theme.scrollContainer}>
            {
                products.map((product) =>(
                    <ProductCard {... product}/>
                ))
            } 

        </ScrollView>
    );
};

export default Catalog;