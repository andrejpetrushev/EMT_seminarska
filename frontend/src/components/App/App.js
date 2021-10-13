import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import Staff from '../Staff/staff';
import Roles from '../Roles/roles';
import People from '../People/PersonList/people';
import Header from '../Header/header';
import PersonAdd from '../People/PersonAdd/personAdd';
import BionicShopService from "../../repository/bionicshopRepository";
import PersonEdit from "../People/PersonEdit/personEdit";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            staff: [],
            people: [],
            roles: [],
            selectedPerson: {}
        }
    }

    render() {
        return (
            <Router>
                <Header/>
                <main>
                    <div className="container">
                        <Route path={"/staff"} exact render={() =>
                            <Staff staff={this.state.staff}/>}/>
                        <Route path={"/roles"} exact render={() =>
                            <Roles roles={this.state.roles}/>}/>
                        <Route path={"/people/add"} exact render={() =>
                            <PersonAdd roles={this.state.roles}
                                        staff={this.state.staff}
                                        onAddPerson={this.addPerson}/>}/>
                        <Route path={"/people/edit/:id"} exact render={() =>
                            <PersonEdit roles={this.state.roles}
                                         staff={this.state.staff}
                                         onEditPerson={this.editPerson}
                                         person={this.state.selectedPerson}/>}/>
                        <Route path={"/people"} exact render={() =>
                            <People people={this.state.people}
                                      onDelete={this.deletePerson}
                                      onEdit={this.getPerson}/>}/>
                        <Redirect to={"/people"}/>
                    </div>
                </main>
            </Router>
        );
    }

    componentDidMount() {
        this.loadStaff();
        this.loadRoles();
        this.loadPeople();
    }

    loadStaff = () => {
        BionicShopService.fetchStaff()
            .then((data) => {
                this.setState({
                    staff: data.data
                })
            });
    };

    loadPeople = () => {
        BionicShopService.fetchPeople()
            .then((data) => {
                this.setState({
                    people: data.data
                })
            });
    };

    loadRoles = () => {
        BionicShopService.fetchRoles()
            .then((data) => {
                this.setState({
                    roles: data.data
                })
            });
    };

    deletePerson = (id) => {
        BionicShopService.deletePerson(id)
            .then(() => {
                this.loadPeople();
            });
    };

    addPerson = (personName, personSurname, personAge, personPhoneNumber, personAddress, rating, purchases) => {
        BionicShopService.addPerson(personName, personSurname, personAge, personPhoneNumber, personAddress, rating, purchasesr)
            .then(() => {
                this.loadPeople();
            });
    };

    getPerson = (id) => {
        BionicShopService.getPerson(id)
            .then((data) => {
                this.setState({
                    selectedPerson: data.data
                })
            })
    };

    editPerson = (id, personName, personSurname, personAge, personPhoneNumber, personAddress, rating, purchases) => {
        BionicShopService.editPerson(id, personName, personSurname, personAge, personPhoneNumber, personAddress, rating, purchases)
            .then(() => {
                this.loadPeople();
            });
    }
}

export default App;
