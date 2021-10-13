import axios from "axios";

const personAxios = axios.create({
    baseURL: 'http://localhost:9090/api',
    headers: {
        'Access-Control-Allow-Origin' : '*'
    }
});

const roleAxios = axios.create({
    baseURL: 'http://localhost:9091/api',
    headers: {
        'Access-Control-Allow-Origin' : '*'
    }
});

export default {
    personAxios,
    roleAxios
};
