import axios from 'axios';

export const api = axios.create({

    baseURL: 'http://192.168.15.8:8080',
    //baseURL: 'https://deploy-dscatalog.herokuapp.com',
});