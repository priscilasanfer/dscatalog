import React, {useState} from 'react';
import {ScrollView } from 'react-native';
import { ProductCard, SearchInput } from '../components';
import productImg from '../assets/produto.png';
import { theme } from '../styles';

const products =[
    {
        id: 1,
        imgUrl: productImg,
        name: "Agenda",
        price: 22.0
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
        name: "Picotador de papel",
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
    const [search, setSearch] = useState("");
    const data = search.length > 0 ? 
    products.filter(product => product.name.toLowerCase().includes(search.toLowerCase())) : products
    return(
        <ScrollView contentContainerStyle={theme.scrollContainer}>
            <SearchInput placeholder="Nome do Produto" search setSearch={setSearch} />
            
            {
                data.map((product) =>(
                    <ProductCard {... product}/>
                ))
            } 

        </ScrollView>
    );
};

export default Catalog;