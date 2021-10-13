import React from 'react';
import {useHistory} from 'react-router-dom';

const PersonEdit = (props) => {

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        personName: "",
        personSurname: "",
        personAge: 0,
        personPhoneNumber: 0,
        personAddress: "",
        rating: 0,
        purchases: 0
    });

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    };

    const onFormSubmit = (e) => {
        e.preventDefault();
        const personName = formData.personName !== "" ? formData.personName : props.person.personName;
        const personSurname = formData.personSurname !== 0 ? formData.personSurname : props.person.personSurname;
        const personAge = formData.personAge !== 0 ? formData.personAge : props.person.personAge;
        const personPhoneNumber = formData.personPhoneNumber !== 0 ? formData.personPhoneNumber : props.person.personPhoneNumber;
        const personAddress = formData.personAddress !== 0 ? formData.personAddress : props.person.personAddress;
        const rating = formData.rating !== 0 ? formData.rating : props.person.rating;
        const purchases = formData.purchases !== 0 ? formData.purchases : props.person.purchases;
        const role = formData.role !== 0 ? formData.role : props.person.role.id;
        const staff = formData.staff !== 0 ? formData.staff : props.person.staff.id;

        props.onEditPerson(props.person.id, personName, personSurname, personAge, personPhoneNumber, personAddress, rating, purchases);
        history.push("/people");
    };

    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Person name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               placeholder={props.person.personName}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="surname">Person surname</label>
                        <input type="text"
                               className="form-control"
                               id="surname"
                               name="surname"
                               placeholder={props.person.personSurname}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                    <label htmlFor="age">Person age</label>
                    <input type="text"
                           className="form-control"
                           id="age"
                           name="age"
                           placeholder={props.person.personAge}
                           onChange={handleChange}
                    />
                    </div>
                    <div className="form-group">
                        <label htmlFor="phone number">Person phone number</label>
                        <input type="text"
                               className="form-control"
                               id="phone number"
                               name="phone number"
                               placeholder={props.person.personPhoneNumber}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                    <label htmlFor="address">Person address</label>
                    <input type="text"
                           className="form-control"
                           id="address"
                           name="address"
                           placeholder={props.person.personAddress}
                           onChange={handleChange}
                    />
                    </div>
                    <div className="form-group">
                        <label htmlFor="rating">Rating</label>
                        <input type="text"
                               className="form-control"
                               id="rating"
                               name="rating"
                               placeholder={props.person.rating}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="purchases">Purchases</label>
                        <input type="text"
                               className="form-control"
                               id="purchases"
                               name="purchases"
                               placeholder={props.person.purchases}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Role</label>
                        <select name="role" className="form-control" onChange={handleChange}>
                            {props.roles.map((term) => {
                                if(props.person.role !== undefined &&
                                    props.person.role.id === term.id)
                                    return <option selected={props.person.role.id} value={term.id}>{term.roleState}</option>
                                else return <option value={term.id}>{term.roleState}</option>
                            })}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Staff</label>
                        <select name="staff" className="form-control" onChange={handleChange}>
                            {props.staff.map((term) => {
                                if(props.person.staff !== undefined &&
                                    props.person.staff.id === term.id)
                                    return <option selected={props.person.staff.id} value={term.id}>{term.name}</option>
                                else return <option value={term.id}>{term.name}</option>
                            })}
                        </select>
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
};

export default PersonEdit;
