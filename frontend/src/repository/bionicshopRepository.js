import axios from '../custom-axios/axios';

const BionicShopService = {
    fetchPeople: () => {
        return axios.personAxios.get("/people");
    },
    fetchRoles: () => {
        return axios.roleAxios.get("/roles");
    },
    fetchStaff: () => {
        return axios.roleAxios.get("/staff");
    },
    deletePerson: (id) => {
        return axios.personAxios.delete(`/people/delete/${id}`);
    },
    addPerson: (personName, personSurname, personAge, personPhoneNumber, personAddress, rating, purchases) => {
        return axios.personAxios.post("/people/add", {
            "personName" : personName,
            "personSurname" : personSurname,
            "personAge" : personAge,
            "personPhoneNumber" : personPhoneNumber,
            "personAddress" : personAddress,
            "rating" : rating,
            "purchases" : purchases
        });
    },
    editPerson: (personName, personSurname, personAge, personPhoneNumber, personAddress, rating, purchases) => {
        return axios.personAxios.put(`/people/edit/${id}`, {
            "personName" : personName,
            "personSurname" : personSurname,
            "personAge" : personAge,
            "personPhoneNumber" : personPhoneNumber,
            "personAddress" : personAddress,
            "rating" : rating,
            "purchases" : purchases
        });
    },
    getPerson: (id) => {
        return axios.personAxios.get(`/people/${id}`);
    },
    deleteStaff: (id) => {
        return axios.roleAxios.delete(`/staff/delete/${id}`);
    },
    addStaff: (name, surname, position, ratingDescription, number_suggestions) => {
        return axios.roleAxios.post("/staff/add", {
            "name" : name,
            "surname" : surname,
            "position" : position,
            "ratingDescription" : ratingDescription,
            "number_suggestions" : number_suggestions
        });
    },
    editStaff: (name, surname, position, ratingDescription, number_suggestions) => {
        return axios.roleAxios.put(`/staff/edit/${id}`, {
            "name" : name,
            "surname" : surname,
            "position" : position,
            "ratingDescription" : ratingDescription,
            "number_suggestions" : number_suggestions
        });
    },
    getStaff: (id) => {
        return axios.roleAxios.get(`/staff/${id}`);
    },
    deleteRole: (id) => {
        return axios.roleAxios.delete(`/roles/delete/${id}`);
    },
    addRole: (personId, specialBonus, status, roleState) => {
        return axios.roleAxios.post("/roles/add", {
            "personId" : personId,
            "specialBonus" : specialBonus,
            "status" : status,
            "roleState" : roleState
        });
    },
    editRole: (personId, specialBonus, status, roleState) => {
        return axios.roleAxios.put(`/roles/edit/${id}`, {
            "personId" : personId,
            "specialBonus" : specialBonus,
            "status" : status,
            "roleState" : roleState
        });
    },
    getRole: (id) => {
        return axios.roleAxios.get(`/roles/${id}`);
    }
};

export default BionicShopService;
